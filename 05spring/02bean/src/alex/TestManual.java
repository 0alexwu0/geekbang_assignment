package alex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ManualConfig.class)
public class TestManual {

    public void run(){
        System.out.println("Run TestManual");
        ApplicationContext context = new AnnotationConfigApplicationContext(ManualConfig.class);
        TestBean bean = (TestBean)context.getBean("testBean");
        bean.test();
    }
}
