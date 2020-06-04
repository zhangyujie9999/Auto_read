package cource.auto_read.Database;

import javabean.StuGrade;
import javabean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
public class StuGradeServiceimpl implements StuGradeService{
    @Autowired
    private StuGradeMapper stu_grademapper;

    @Override
    public void addGrade(StuGrade s_grade){
        stu_grademapper.addGrade(s_grade);
    }

    @Override
    public void updateGrde(StuGrade s_grade){
        stu_grademapper.updateGrde(s_grade);
    }

    @Override
    public List<StuGrade> selectGradebyID(int stu_ID){
        List<StuGrade> s_grade = stu_grademapper.selectGradebyID(stu_ID);
        return s_grade;
    }

    @Override
    public List<StuGrade> selectAllGrade(){
        List<StuGrade> s_grade = stu_grademapper.selectAllGrade();
        return s_grade;
    }

}
