package life.liangzai.community.dto;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-04 07:19
 **/
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
