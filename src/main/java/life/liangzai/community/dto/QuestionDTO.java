package life.liangzai.community.dto;

import life.liangzai.community.model.User;
import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-06 07:54
 **/
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
