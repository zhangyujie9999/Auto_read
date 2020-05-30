package Algorithm;

import javabean.Answer;
import javabean.StuAnswer;

class CompareAnswerTest {

    @org.junit.jupiter.api.Test
    void compare() {
        StuAnswer stuAnswer=new StuAnswer();
        Answer answer=new Answer();
        stuAnswer.setAnswer("Google发布的 GFS、MapReduce 和 BigTable 三篇论文对大数据的发展起到重要作用");
        answer.setAnswer("Google发布的三篇论文对大数据的发展起到重要作用");
        CompareAnswerimpl compareAnswerimpl=new CompareAnswerimpl();
        double score=compareAnswerimpl.compare(stuAnswer,answer);
        System.out.println(score);


    }
}