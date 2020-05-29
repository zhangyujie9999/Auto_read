package cource.auto_read;

import cource.auto_read.Database.StuServiceimpl;
import javabean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class StuController {
    @Autowired
    private StuServiceimpl stuService;
    @RequestMapping("/getstu")
    public String getstu(Model model){
        List<Student> students = stuService.getStuList();
        model.addAttribute("stu",students.get(0).getName());
        return "getstu";
    }
    @RequestMapping("/addstu")
    public String addstu(Student student){
        stuService.addStu(student);
        return "addstu";
    }

}
