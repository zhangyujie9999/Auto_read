package cource.auto_read;

import javabean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StuController {
    @Autowired
    private StuServiceimpl stuService;
    @RequestMapping("/stu")
    public String check(Model model){
        List<Student> students = stuService.getStuList();
        model.addAttribute("stu",students.get(0).getName());
        return "stu";
    }
}
