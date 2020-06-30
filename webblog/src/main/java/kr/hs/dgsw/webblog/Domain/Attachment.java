package kr.hs.dgsw.webblog.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//id, storedPath, postId

@Entity // DB 테이블 맵핑
@Data //DATA(setter/getter...)
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //// auto_increment == 자동 값 생성 (옵션 : IDENTITY)=> 기본키 생성을 DBMS에 위임
    private Long id;
    private String storedPath;
    private Long postId;
}