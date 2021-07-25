package alex;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Klass {

    private String id;
    private String name;
    private Student student;

    public void test() {
        System.out.println("Klass id:"+id);
        System.out.println("Klass name:"+name);
        System.out.println("time:"+new Date());
        student.test();
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
