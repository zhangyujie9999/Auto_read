package cource.auto_read.Database;

import javabean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StuServiceimpl implements StuService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> getStuList() {
        List<Student> students = studentMapper.getStuList();
        return students;
    }
    @Override
    public void addStu(Student student) {
        studentMapper.addStu(student);
    }

}
