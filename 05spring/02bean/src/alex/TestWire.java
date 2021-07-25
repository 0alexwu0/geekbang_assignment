package alex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestWire {

    @Autowired
    private TestBeanAuto bean;

    public TestBeanAuto getBean(){
        return bean;
    }

    public void run(){
        System.out.println("Run TestWire");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        TestWire test = context.getBean(TestWire.class);
        test.getBean().test();
    }
}
