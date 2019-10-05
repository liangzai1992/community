package life.liangzai.community.model;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-05 17:26
 **/
@Data
public class Question {
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
}
