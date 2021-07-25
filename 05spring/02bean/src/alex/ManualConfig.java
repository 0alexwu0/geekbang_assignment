package alex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("alex")
public class ManualConfig {

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }
}
