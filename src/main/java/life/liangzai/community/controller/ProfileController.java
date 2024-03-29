package life.liangzai.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-09 06:04
 **/
@Controller
public class ProfileController {
    
    @GetMapping("/profile/{action}")
    public String profile(
            @PathVariable(name = "action") String action,
            Model model
    ) {
        
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }
        return "profile";
    }
}
