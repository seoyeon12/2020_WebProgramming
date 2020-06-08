package kr.hs.dgsw.webblog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.webblog.Domain.Post;

// JPA => DB와 연결해 java 객체를 맵핑하는 방식
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{ //<테이블이름, pk 타입>
    //user(id)가 쓴 게시글 중 게시글 id로 정렬하는데 (Top == limit 1)하나만 보겠다.
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId); 
}