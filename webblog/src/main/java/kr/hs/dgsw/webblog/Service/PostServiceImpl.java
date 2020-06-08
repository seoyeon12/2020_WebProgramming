package kr.hs.dgsw.webblog.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webblog.Domain.Post;
import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Repository.PostRepository;
import kr.hs.dgsw.webblog.Repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

    // get,set 대신 사용, 의존성 주입
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    //생성자가 만들어진 시점에 임시 유저 1, 게시글 1 임의로 입력
    @PostConstruct 
    private void init(){
        User user = userRepository.save(new User("lee","1234","가나다","lee@naver.com",
        "010-2222-2222","https://i.ytimg.com/vi/TJ_R7J76_bc/hq720.jpg?sqp=-oaymwEZCNAFEJQDSFXyq4qpAwsIARUAAIhCGAFwAQ==&rs=AOn4CLB6esGyqzWRhRr8uXRIwSiNk8ub6A"));
        postRepository.save(new Post(user.getId(),"안녕하세요","만나서 반갑습니다."));
    }

    //post(게시글)을 등록(save)한다.
    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    //id를 가진 post를 반환한다.
    @Override
    public Post read(Long id) {
        //id를 가진 post가 있을 경우에 그 post를 반환한다.
        return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
    }

    @Override
    public Post readByUserId(Long userId) {
        //userId가 쓴 게시글 중 게시글 id로 정렬하는데 (Top == limit 1)하나만 보겠다.
        return postRepository
                .findTopByUserIdOrderByIdDesc(userId)
                .orElse(null);
    }

    //게시글 update할 때
    @Override
    public Post update(Long id, Post post) {
        //Title, Content, Pictures를 반환(== 업데이트)
        return postRepository.findById(id)
                .map(found -> {
                    found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                    found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                    found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
                    return postRepository.save(found);
                }).orElse(null);
    }

    //id를 갖는 post를 삭제한다.
    //삭제 됐다면 true, 아니라면 false
    @Override
    public boolean delete(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //모든 post를 읽는다.
    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }
}