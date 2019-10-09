package life.liangzai.community.service;

import life.liangzai.community.dto.PaginationDTO;
import life.liangzai.community.dto.QuestionDTO;
import life.liangzai.community.mapper.QuestionMapper;
import life.liangzai.community.mapper.UserMapper;
import life.liangzai.community.model.Question;
import life.liangzai.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-06 07:57
 */
@Service
public class QuestionService {
    
    @Autowired(required = false)
    private QuestionMapper questionMapper;
    
    @Autowired(required = false)
    private UserMapper userMapper;
    
    public PaginationDTO List(Integer page, Integer size) {
        
        // size*(page -1 )
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setQuestion(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        
        Integer offset = size * (page - 1);
        
        List<Question> questions = questionMapper.List(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        
        paginationDTO.setQuestions(questionDTOList);
        
        return paginationDTO;
    }
}
