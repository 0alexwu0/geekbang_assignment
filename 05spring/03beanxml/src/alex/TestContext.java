package alex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext {

    public void run() {
        System.out.println("Run TestContext");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");
        School bean = (School)context.getBean("school1");
        bean.test();
    }
}
