package life.liangzai.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-03 23:53
 **/
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){ return "index";}
}
