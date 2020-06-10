package cource.auto_read;

import Algorithm.Unzip;
import cource.auto_read.Database.AnsServiceimpl;
import javabean.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FileController {
    @Autowired
    AnsServiceimpl ansService;
    private static final String UPLOADED_FOLDER = "E:\\coding\\auto_read\\";
    @RequestMapping("")
    public String update(){
        return "update";
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
        } catch (IOException e) {
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
    public String result(){
        return "result";
    }
    @RequestMapping("/fail2update")
    public String fail2update(){
        return "update";
    }
    @RequestMapping("/answer2update")
    public String answer2update(){
        return "update";
    }
    @RequestMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }
}
