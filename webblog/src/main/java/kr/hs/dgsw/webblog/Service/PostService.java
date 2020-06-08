package kr.hs.dgsw.webblog.Service;

import java.util.List;

import kr.hs.dgsw.webblog.Domain.Post;

public interface PostService { 
    //Impl에서 상세하게 기능 구현
    Post create(Post post);
    Post read(Long id);
    Post readByUserId(Long userId);
    Post update(Long id, Post post);
    boolean delete(Long id);
    List<Post> readAll();
}