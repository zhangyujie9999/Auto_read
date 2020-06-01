package cource.auto_read.Database;

import javabean.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class AnsServiceimpl implements AnsService {
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public void updateAnswer(Answer answer) {
        answerMapper.updateAnswer(answer);
    }

    @Override
    public List<Answer> findAnswer(int ID) {
        List<Answer> ans=answerMapper.findAnswer(ID);
        return ans;
    }


}