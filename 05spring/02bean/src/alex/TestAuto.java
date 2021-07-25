package alex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ComponentScan("alex")
@ContextConfiguration(classes = AutoConfig.class)
public class TestAuto {

    public void run(){
        System.out.println("Run TestAuto");
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        TestBean bean = (TestBean)context.getBean("testBean");
        bean.test();
    }
}
