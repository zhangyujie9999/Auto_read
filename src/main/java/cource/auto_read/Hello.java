package cource.auto_read;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello{
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/hi")
    public String hi(Model model){
        model.addAttribute("msg",  "dadadadadadadadadada");
        return "hi";
    }
}
