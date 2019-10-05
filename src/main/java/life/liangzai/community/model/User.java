package life.liangzai.community.model;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-04 15:31
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}

