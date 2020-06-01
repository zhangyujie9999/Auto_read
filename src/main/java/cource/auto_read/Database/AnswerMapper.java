package cource.auto_read.Database;

import javabean.Answer;
import javabean.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnswerMapper {
    @Update("update Answer set  "
            + "answer = #{answer},  "
            + "grade  = #{grade}    "
            + "where ID = #{ID} ")
    void updateAnswer(Answer answer);

    @Select("Select * from Answer where ID=#{ID}")
    List<Answer> findAnswer(int ID);
    @Select("select * from Answer order by ID")
    List<Answer> getAnsList();
}
