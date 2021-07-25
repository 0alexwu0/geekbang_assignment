package alex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext {

    public void run() {
        System.out.println("Run TestContext");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");

        TestBean bean = (TestBean)context.getBean("testBean");
        bean.test();
    }
}
