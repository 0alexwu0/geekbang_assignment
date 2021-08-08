package com.alex.demo.db;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.alex.demo.db.Read) " +
            "&& (execution(* com.alex.demo.service..*.select*(..)) " +
            "|| execution(* com.alex.demo.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.alex.demo.db.Read) " +
            "|| execution(* com.alex.demo.service..*.insert*(..)) " +
            "|| execution(* com.alex.demo.service..*.add*(..)) " +
            "|| execution(* com.alex.demo.service..*.update*(..)) " +
            "|| execution(* com.alex.demo.service..*.edit*(..)) " +
            "|| execution(* com.alex.demo.service..*.delete*(..)) " +
            "|| execution(* com.alex.demo.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.read();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.write();
    }
}
