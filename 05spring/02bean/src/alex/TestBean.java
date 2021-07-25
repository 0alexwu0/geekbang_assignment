package alex;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

    public void test() {
        System.out.println("now bean test");
        System.out.println("time:"+new Date());
    }
}
