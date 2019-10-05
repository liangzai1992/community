package life.liangzai.community.dto;

import lombok.Data;

/**
 * @program: community
 * @description:
 * @author: LiangZai
 * @create: 2019-10-04 02:58
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
