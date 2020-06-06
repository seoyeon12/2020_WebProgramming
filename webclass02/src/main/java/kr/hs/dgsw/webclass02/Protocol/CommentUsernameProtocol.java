package kr.hs.dgsw.webclass02.Protocol;

import kr.hs.dgsw.webclass02.Domain.Comment;
import lombok.Data;

@Data
public class CommentUsernameProtocol extends Comment {
    private String username;
    // comment 정보와 유저이름 정보를 합쳐주는 로직
    public CommentUsernameProtocol(Comment c, String username) {
        super(c);
        this.username = username;
    }
}