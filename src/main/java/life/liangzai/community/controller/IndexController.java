package life.liangzai.community.controller;

import life.liangzai.community.dto.PaginationDTO;
import life.liangzai.community.mapper.UserMapper;
import life.liangzai.community.model.User;
import life.liangzai.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-03 23:53
 **/
@Controller
public class IndexController {
    
    @Autowired(required = false)
    private UserMapper userMapper;
    
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findBytoken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        
        
        PaginationDTO pagination = questionService.List(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
