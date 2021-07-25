package alex;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBeanAuto {

    @Autowired
    public TestBeanAuto(){

    }

    public void test() {
        System.out.println("now bean test");
        System.out.println("time:"+new Date());
    }
}
