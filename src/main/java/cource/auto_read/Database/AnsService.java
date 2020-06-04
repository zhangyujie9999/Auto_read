package cource.auto_read.Database;

import javabean.Answer;
import javabean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnsService {
    /**
     * 修改答案
     */
    void updateAnswer(Answer answer);
//    void updateAnswer(int ID,String answer,double grade);

    /**
     * 查找答案
     */
//    List<Answer> findAnswer(int ID);

    List<Answer> getAnsList();

}
