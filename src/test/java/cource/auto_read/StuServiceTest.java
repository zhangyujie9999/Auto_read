package cource.auto_read;

import cource.auto_read.Database.StuServiceimpl;
import javabean.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StuServiceTest {
    @Autowired
    private StuServiceimpl stuService;
    @Test
    public List<Student> check(){
        return stuService.getStuList();
    }
}