package kr.hs.dgsw.webblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Protocol.ResponseFormat;
import kr.hs.dgsw.webblog.Protocol.ResponseType;
import kr.hs.dgsw.webblog.Service.UserService;

// CRUD / Create - Read - Update - Delete
// SQL / insert - select - update - delete
// HTTP/ POST - GET - PUT - DELETE
@RestController
public class UserController {

    // get,set 대신 사용, 의존성 주입
    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    //(요청 내용을 user 자바 객체에 매핑)
    public ResponseFormat create(@RequestBody User user) { 
        User newUser = userService.create(user);
        if(newUser != null) {
            //(요청 타입[유저 추가], user, user id)
            return new ResponseFormat(ResponseType.USER_ADD, newUser,newUser.getId());
        }else {
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    @PutMapping("/user/update/{id}")
    //(주소url의 / 뒤에 있는 id 데이터),(요청 내용을 user 자바 객체에 매핑)
    public ResponseFormat update(@PathVariable Long id, @RequestBody User user) { 
        if(userService.update(id, user) != null) {
            //(요청 타입[유저 수정], 수정(id, user), user id)
            return new ResponseFormat(ResponseType.USER_UPDATE, userService.update(id, user),user.getId());
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    //(주소url의 / 뒤에 있는 id 데이터)
    public ResponseFormat delete(@PathVariable Long id) {
        if(userService.delete(id)){
            //(요청 타입[유저 삭제], 삭제(id), id)
            return new ResponseFormat(ResponseType.USER_DELETE, userService.delete(id),id);
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    @GetMapping("/user/read/{id}")
    //(주소url의 / 뒤에 있는 id 데이터)
    public ResponseFormat read(@PathVariable Long id) {
        if(userService.read(id) != null) {
            //(요청 타입[유저 한명 읽기], 읽기(id), id)
            return new ResponseFormat(ResponseType.USER_GET, userService.read(id),id);
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }

    @GetMapping("/user/read")
    public ResponseFormat readAll() {
        if(userService.readAll() != null) {
            //(요청 타입[유저 모두 읽기], 모두읽기())
            return new ResponseFormat(ResponseType.USER_GET_ALL, userService.readAll());
        }else{
            //(요청 타입[실패], null)
            return new ResponseFormat(ResponseType.FAIL, null);
        }
    }
    
}