package Algorithm;

import javabean.Answer;
import javabean.StuAnswer;

public interface CompareAnswer {
    public double compare(StuAnswer stuAnswer, Answer answer);//返回置信度
}
