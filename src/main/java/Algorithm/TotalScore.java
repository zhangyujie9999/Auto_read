package Algorithm;

import javabean.Answer;
import javabean.StuAnswer;

import java.math.BigDecimal;
import java.util.List;

//把学生的成绩和标准答案对比返回学生的分数和这个分数的置信度的接口，输入是学生的答案和标准答案和学生的姓名和学号输出就是这个学生的分数
public class TotalScore {
    public double ComputeTotalScore(String id, String name, List<StuAnswer> stuAnswer, List<Answer> answer){
        double totalscore=0.0;
        CompareAnswerimpl compareAnswerimpl=new CompareAnswerimpl();
        for(int i=0;i<10;i++){
            if((stuAnswer.get(i).getAnswer()==answer.get(i).getAnswer())&&stuAnswer.get(i).getAnswer()!=null){
                totalscore+=Double.valueOf(answer.get(i).getGrade());
            }
        }
       for(int i=10;i<20;i++){
            if (stuAnswer.get(i).getAnswer()==answer.get(i).getAnswer()&&stuAnswer.get(i).getAnswer()!=null){
                totalscore+=Double.valueOf(answer.get(i).getGrade());
            }
        }
        for (int i=20;i<30;i++){
            if (stuAnswer.get(i).getAnswer()==answer.get(i).getAnswer()&&stuAnswer.get(i).getAnswer()!=null){
                totalscore+=Double.valueOf(answer.get(i).getGrade());
            }
        }
        for(int i = 30;i<35;i++){
            if (stuAnswer.get(i).getAnswer()!=null){
                totalscore+=compareAnswerimpl.compare(stuAnswer.get(i),answer.get(i))*Double.valueOf(answer.get(i).getGrade());
            }
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.exit(0);//退出程序
            }
        }

        BigDecimal bg = new BigDecimal(totalscore);
        double total = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return  total;
    }
}
