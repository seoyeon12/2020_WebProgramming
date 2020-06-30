package kr.hs.dgsw.webblog.Domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.NoArgsConstructor;

// id, account, password, name, email, phone, profilePath, created, modified

@Entity // DB 테이블 맵핑
@Data //DATA(setter/getter...)
@NoArgsConstructor // 파라미터 없는 기본 생성자
public class User {
    @Id // PK
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment == 자동 값 생성 (옵션 : IDENTITY)=> 기본키 생성을 DBMS에 위임
    private long id;

    // DB 테이블 컬럼 맵핑
    @Column(nullable = false, unique = true, length = 20) // null허용 X ,유니크 값, 최대길이 20
    private String account; //(id)

    @Column(nullable = false) // null 허용 X
    // 접근제어 또는 JSON 변환 시에 사용할 이름
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
    private String password;

    public void setPassword(String password){ // password 암호화 과정
        try {
            //MessageDigest 해시함수, 단반향함수, 원본 복원 불가, ("알고리즘 이름")
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(), 0 , password.getBytes().length);
            this.password = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
        }
    }

    @Column(nullable = false) // null 허용 X
    private String name;

    @Column(nullable = true) // null 허용
    private String email;

    @Column(nullable = true) // null 허용
    private String phone;

    // 접근제어 또는 JSON 변환 시에 사용할 이름
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 접근제어 적을 수만 있다.
    private String profilePath;


    @CreationTimestamp // "시간"을 만든다.(호출된 한 번만 업데이트)
    @Column(updatable = false, nullable = false) // 호출된 한 번만 업데이트, null 허용 X
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime created;

    @UpdateTimestamp // "시간"을 업데이크한다.
    @Column(nullable = false) // null 허용 X
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime modified;

    public User(String account, String password, String name, String email, String phone, String profilePath) {
        this.account = account;
        setPassword(password); //password 해시로 암호화
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePath = profilePath;
    }
}