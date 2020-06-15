package cource.auto_read;

import Algorithm.WebOcr;
import cource.auto_read.Database.AnsServiceimpl;
import cource.auto_read.Database.StuGradeServiceimpl;
import javabean.Answer;
import javabean.StuAnswer;
import javabean.StuGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
@Controller
public class AnswerController {
    @Autowired
    AnsServiceimpl ansService;
    @Autowired
    StuGradeServiceimpl stuGradeService;
    @RequestMapping("/answer")
    public String answer(Model model){
        List<Answer> answers = ansService.getAnsList();
        model.addAttribute("answers",answers);
        return "answer";
    }
    @PostMapping("/backanswer")
    public String backanswer(@RequestParam("answer") List<String> answer, @RequestParam("score") List<String> score, @RequestParam("key") List<String> key, Model model){
        System.out.println("test");

        int ID = 1;
        for(int i = 0;i<40;i++)
        {
            String type = "选择题";
            String ans = answer.get(i);
            String grade = score.get(0);
            ansService.updateAnswer(new Answer(ID,type,ans,grade));
            ID++;
        }
        for(int i = 40;i<60;i++)
        {
            String type = "判断题";
            String ans = answer.get(i);
            String grade = score.get(1);
            ansService.updateAnswer(new Answer(ID,type,ans,grade));
            ID++;
        }
        for(int i = 60;i<80;i++)
        {
            String type = "填空题";
            String ans = answer.get(i);
            String grade = score.get(2);
            ansService.updateAnswer(new Answer(ID,type,ans,grade));
            ID++;
        }
        for(int i = 80;i<answer.size();i++)
        {
            String type = "简答题";
            String ans = answer.get(i);
            String grade = score.get(3);
            ansService.updateAnswer(new Answer(ID,type,ans,grade));
            ID++;
        }
        List<Answer> answers = ansService.getAnsList();
        model.addAttribute("answers",answers);
        return "answer";
    }

    @RequestMapping("/result2stu_answer")
    public String stu_answer(Model model, String stuid) throws IOException, ParseException {
        WebOcr webOcr = new WebOcr();
        StuGrade nowstu = stuGradeService.selectGradebyID(stuid);
        List<StuAnswer> stuAnswers = webOcr.read(nowstu.getPath());
        List<Answer> answers = ansService.getAnsList();
        for(int i = 0;i<stuAnswers.size();i++) {
            answers.get(i).setAnswer(stuAnswers.get(i).getAnswer());
        }
        model.addAttribute("path",nowstu.getPath() + "jpeg");
        model.addAttribute("stuid","/backanswer?stuid="+stuid);
        model.addAttribute("stu_answer",answers);
        return "stu_answer";
    }
    @RequestMapping("/backanswer")
    public String backanswer(String stuid){
        stuGradeService.selectGradebyID(stuid);
        return "result";
    }
}
