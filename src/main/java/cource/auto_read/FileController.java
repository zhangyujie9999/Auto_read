package cource.auto_read;

import Algorithm.Read_allpic;
import Algorithm.TotalScore;
import Algorithm.Unzip;
import Algorithm.WebOcr;
import cource.auto_read.Database.AnsServiceimpl;
import cource.auto_read.Database.StuGradeService;
import cource.auto_read.Database.StuGradeServiceimpl;
import cource.auto_read.Database.StuServiceimpl;
import javabean.StuAnswer;
import javabean.StuGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class FileController {
    @Autowired
    AnsServiceimpl ansService;
    @Autowired
    StuGradeServiceimpl stuGradeService;
    private static final String UPLOADED_FOLDER = "target/classes/static/up/";
    @RequestMapping("")
    public String update(){
        return "homepage";
    }
//    ----------

    @RequestMapping("/uploadFile")
    public Object batchImport(@RequestParam("filename") MultipartFile file, String account) throws IOException {
        Map map = new HashMap();
        int flag = 0;
        //判断文件是否为空
        if(file==null){
            map.put("flag",flag);
            map.put("msg","文件为空！");
            return map;
        }
        //获取文件名
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        //批量导入
        map.put("flag",1);
        map.put("msg","成功插入条数据！");
        return map;
    }

//    ---------

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws InterruptedException {
        System.out.println(file);
//        Thread.sleep(5000);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            Unzip.unZip(UPLOADED_FOLDER + file.getOriginalFilename());
            String dirname = file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4);
            List<String> piclist = Read_allpic.all_pic(UPLOADED_FOLDER + dirname);
            System.out.println("aaa");
            WebOcr webOcr = new WebOcr();
            stuGradeService.delete();
            for (int i = 0;i<piclist.size();i++){
                List<StuAnswer> stuAnswers = webOcr.read(piclist.get(i));
                List<Double> scores = TotalScore.ComputeTotalScore(stuAnswers, ansService.getAnsList());
                String[] split = piclist.get(i).split("/");
                String ss = split[split.length - 1];
                Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+");
                Matcher m = p.matcher(ss);
                List <String> news = new ArrayList<>();
                while ( m.find() ) {
                    System.out.println(m.group());
                    news.add(m.group());
                }
                stuGradeService.addGrade(new StuGrade(news.get(1), news.get(0),scores.get(0), 0.0,
                        scores.get(1), scores.get(2), scores.get(3), scores.get(4), piclist.get(i)));
                System.out.println("");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return "redirect:";
    }
    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(MultipartException.class)
        public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
            redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
            return "redirect:";
        }
    }
    @RequestMapping("/result")
    public String result(Model model){
        List<StuGrade> stuGrades = stuGradeService.selectAllGrade();
        model.addAttribute("stuGrades", stuGrades);
        return "result";
    }
    @RequestMapping("/back2result")
    public String back2result(Model model, @RequestParam("answer") List<String> answer, String path){
        List<StuAnswer> stuAnswers = new ArrayList<>();
        for(int i = 0;i<answer.size();i++){
            stuAnswers.add(new StuAnswer(i, "", answer.get(i)));
        }
        String[] ss = path.split("/");
        String[] nn = ss[3].split("\\.");
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+");
        Matcher m = p.matcher(nn[0]);
        List <String> news = new ArrayList<>();
        while ( m.find() ) {
            System.out.println(m.group());
            news.add(m.group());
        }
        List <Double> scores = TotalScore.ComputeTotalScore(stuAnswers, ansService.getAnsList());
        stuGradeService.updateGrade(new StuGrade(news.get(1), news.get(0), scores.get(0), 0.0,
                scores.get(1), scores.get(2), scores.get(3), scores.get(4), "target/classes/static/" + ss[1] + "/" + ss[2] + "/" + ss[3]));
        List<StuGrade> stuGrades = stuGradeService.selectAllGrade();
        model.addAttribute("stuGrades", stuGrades);
        return "result";
    }
    @RequestMapping("/fail2update")
    public String fail2update(){
        return "homepage";
    }
    @RequestMapping("/answer2update")
    public String answer2update(){
        return "homepage";
    }
    @RequestMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }

//    @RequestMapping("/result2stu_answer")
//    public String result2stu_answer(){
//        return "stu_answer";
//    }

}
