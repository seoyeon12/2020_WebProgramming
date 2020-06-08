package kr.hs.dgsw.webblog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

// id, userId, title, content, pictures, created, modified

@Entity // DB 테이블 맵핑
@Data //DATA
@NoArgsConstructor // 파라미터 없는 기본 생성자
public class Post {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment == 자동 값 생성 (옵션 : IDENTITY)=> 기본키 생성을 DBMS에 위임
    private Long id;

    // DB 테이블 컬럼 맵핑
    @Column(nullable = false) // null 허용 X
    private Long userId;
    @Column(nullable = false) // null 허용 X
    private String title;
    // null 허용 X, DB 칼럼 정보 "TEXT"로 직접 지정
    @Column(nullable = false, columnDefinition = "TEXT") 
    private String content;

    //1:N 관계,릴레이션 관계 표시
    // (entity 변경전략, 데이터 읽기전략(미리읽기 or 요청 시 읽기), Entity변경시 DB변경 전략 결정/DB레이어에서 처리), 기본은 false
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) 
    private List<Attachment> pictures;

    @CreationTimestamp // "시간"을 만든다.(호출된 한 번만 업데이트)
    @Column(updatable = false,nullable = false) // 호출된 한 번만 업데이트, null 허용 X
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime created;

    @UpdateTimestamp // "시간"을 업데이크한다.
    @Column(nullable = false) // null 허용 X
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime modified;

    public Post(Long userId, String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}