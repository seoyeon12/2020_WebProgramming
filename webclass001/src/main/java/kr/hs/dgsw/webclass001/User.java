package kr.hs.dgsw.webclass001;
import lombok.*;

//@Data
// => @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor를 지원한다.
@RequiredArgsConstructor //생성자
@Getter @Setter // getter, setter를 생성하지 않도록 지원
@Builder //빌더를 추가
public class User {
    //@NonNull => 자동 null 체크, 오류 시 NullPointException 예외 발생
    private @NonNull String id;
    private @NonNull String name;
    private @NonNull String email;
}

// public class User {
//     private String id;
//     private String name;
//     private String email;

//     @Override
//     public String toString() {
//         return id + "/" + name + "/" + email;
//     }
//     public User() {}

//     public User(String id,String name,String email) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//     }

//     public String getId() {
//         return id;
//     }
//     public void setId(String id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }
//     public void setEmail(String email) {
//         this.email = email;
//     }
// }