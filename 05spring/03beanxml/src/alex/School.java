package alex;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class School {

    private String id;
    private String name;
    private Klass klass;

    public void test() {
        System.out.println("School id:"+id);
        System.out.println("School name:"+name);
        System.out.println("time:"+new Date());
        klass.test();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
