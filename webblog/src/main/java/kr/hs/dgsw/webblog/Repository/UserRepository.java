package kr.hs.dgsw.webblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.webblog.Domain.User;

// JPA => DB와 연결해 java 객체를 맵핑하는 방식
@Repository
public interface UserRepository extends JpaRepository<User, Long>{ //<테이블이름, pk 타입>
    Optional<User> findByAccount(String account); 
}