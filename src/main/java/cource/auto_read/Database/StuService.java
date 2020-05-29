package cource.auto_read.Database;

import javabean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StuService {
    List<Student> getStuList();
    void addStu(Student student);
}
