package Algorithm;

import javabean.Answer;
import javabean.StuAnswer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//把学生的成绩和标准答案对比返回学生的分数和这个分数的置信度的接口，输入是学生的答案和标准答案和学生的姓名和学号输出就是这个学生的分数
public class TotalScore {
    public static List<Double> ComputeTotalScore(List<StuAnswer> stuAnswer, List<Answer> answer){
        List<Double> totalscore = new ArrayList<>();
        CompareAnswerimpl compareAnswerimpl=new CompareAnswerimpl();
        double [] score = new double[6];
        for(int i=0;i<40;i++){
            if((stuAnswer.get(i).getAnswer().equals(answer.get(i).getAnswer()))&&stuAnswer.get(i).getAnswer()!=null){
                score[0]+=Double.valueOf(answer.get(i).getGrade());
            }
        }
        totalscore.add(score[0]);
       for(int i=40;i<60;i++){
            if ((stuAnswer.get(i).getAnswer().equals(answer.get(i).getAnswer()))&&stuAnswer.get(i).getAnswer()!=null){
                score[1]+=Double.valueOf(answer.get(i).getGrade());
            }
        }
        totalscore.add(score[1]);
        for (int i=60;i<70;i++){
            if ((stuAnswer.get(i).getAnswer().equals(answer.get(i).getAnswer()))&&stuAnswer.get(i).getAnswer()!=null){
                score[2]+=Double.valueOf(answer.get(i).getGrade());
            }
        }
        totalscore.add(score[2]);
        for(int i = 70;i<75;i++){
            if (stuAnswer.get(i).getAnswer()!=null){
                score[3]+=compareAnswerimpl.compare(stuAnswer.get(i),answer.get(i))*Double.valueOf(answer.get(i).getGrade());
            }
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.exit(0);//退出程序
            }
        }
        totalscore.add(score[3]);
        totalscore.add(totalscore.get(0) + totalscore.get(1) + totalscore.get(2) + totalscore.get(3));
        return totalscore;
        //BigDecimal bg = new BigDecimal(totalscore);
        //double total = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //return  total;
    }
}
