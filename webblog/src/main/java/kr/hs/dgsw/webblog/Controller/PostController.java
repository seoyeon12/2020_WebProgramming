package kr.hs.dgsw.webblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.hs.dgsw.webblog.Domain.Post;
import kr.hs.dgsw.webblog.Protocol.ResponseFormat;
import kr.hs.dgsw.webblog.Protocol.ResponseType;
import kr.hs.dgsw.webblog.Service.PostService;

// CRUD / Create - Read - Update - Delete
// SQL / insert - select - update - delete
// HTTP/ POST - GET - PUT - DELETE
@RestController
public class PostController {

    // get,set 대신 사용, 의존성 주입
    @Autowired
    private PostService postService;
    
    // create
    @PostMapping("/post/create")
    //(요청 내용을 post 자바 객체에 매핑)
    public ResponseFormat create(@RequestBody Post post) {
        Post newPost = postService.create(post);
        if(newPost != null) {
            //(요청 타입[post 추가], post, post id)
            return new ResponseFormat(ResponseType.POST_ADD, newPost,newPost.getId());
        }else {
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    // update
    @PutMapping("/post/update/{id}")
    //(주소url의 / 뒤에 있는 id 데이터),(요청의 내용을 post 자바 객체에 매핑)
    public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
        if(postService.update(id, post) != null) {
            //(요청 타입[post 수정], 수정(id, post), post id)
            return new ResponseFormat(ResponseType.POST_UPDATE, postService.update(id, post),post.getId());
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    // delete
    @DeleteMapping("/post/delete/{id}")
    //(주소url의 / 뒤에 있는 id 데이터)
    public ResponseFormat delete(@PathVariable Long id) {
        if(postService.delete(id)){
            //(요청 타입[삭제], 삭제(id), id)
            return new ResponseFormat(ResponseType.POST_DELETE, postService.delete(id),id);
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    // post read id
    @GetMapping("/post/read/{id}")
    //(주소url의 / 뒤에 있는 id 데이터)
    public ResponseFormat read(@PathVariable Long id) {
        if(postService.read(id) != null) {
            //(요청 타입[게시글 하나 읽기], 읽기(id), id)
            return new ResponseFormat(ResponseType.POST_GET, postService.read(id),id);
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    // post read by user id
    @GetMapping("/post/read/user/{userId}")
    //(주소url의 / 뒤에 있는 userId 데이터)
    public ResponseFormat readByUserId(@PathVariable Long userId) {
        if(postService.readByUserId(userId) != null) {
            //(요청 타입[유저에 따른 게시글 하나 읽기], 읽기(userid), userid)
            return new ResponseFormat(ResponseType.POST_GET_BY_USER, postService.readByUserId(userId),userId);
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    // post All read
    @GetMapping("/post/read")
    public ResponseFormat readAll() {
        if(postService.readAll() != null) {
            //(요청 타입[게시글 모두 읽기], 모두읽기())
            return new ResponseFormat(ResponseType.POST_GET_ALL, postService.readAll());
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }
}