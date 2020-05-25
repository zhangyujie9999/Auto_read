package cource.auto_read;

import javabean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface StudentMapper {
    @Select("select * from Student order by ID")
    List<Student> getStuList();
    @Insert("insert into Student(ID,name,age) values(#{ID},#{name},#{age})")
    void addStu(Student student);

}
