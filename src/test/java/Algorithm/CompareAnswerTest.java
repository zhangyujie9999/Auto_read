package Algorithm;

import javabean.Answer;
import javabean.StuAnswer;

class CompareAnswerTest {

    @org.junit.jupiter.api.Test
    void compare() {
        StuAnswer stuAnswer=new StuAnswer(1,"aaa","原豆腐干山豆根发射点风格是则");
        Answer answer=new Answer(1,"v","原则","1");
        CompareAnswerimpl compareAnswerimpl=new CompareAnswerimpl();
        double score=compareAnswerimpl.compare(stuAnswer,answer);
        System.out.println(score);


    }
}