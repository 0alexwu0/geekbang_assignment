package alex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext2 {

    public void run() {
        System.out.println("Run TestContext");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");

        TestBean bean = (TestBean)context.getBean("TestBean1");
        bean.test();
    }
}
