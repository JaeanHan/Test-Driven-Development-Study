package memberManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping({"/", "index"})
    public String getIndex() {
        return "index";
    }
}