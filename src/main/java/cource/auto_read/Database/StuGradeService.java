package cource.auto_read.Database;

import javabean.StuGrade;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StuGradeService {
    /*
     保存学生成绩至数据库
    * */
    void addGrade(StuGrade s_grade);

    /*
     修改学生成绩
    * */
    void updateGrade(StuGrade s_grade);

    /*
    返回指定学生成绩
    * */
    StuGrade selectGradebyID(String stu_ID);

    /*
    返回所有学生成绩
    * */
    List<StuGrade> selectAllGrade();

    void delete();
}
