package kr.hs.dgsw.webclass001;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController 어노테이션을 사용할 경우 
//class 내 @ResponseBody를 사용하지 않아도 적용이 된다. 
//(아래의 코드의 경우 용도를 알기 위해 명시적으로 작성)
@RestController
public class UserController {
    // @Autowired는 UserService userService = new UserService();역할을 해준다.
    @Autowired
    UserService userService;

    //CRUD, SQL, HTTP
    //Read, select, GET
    //모든 user 값 selcet * (ALL)
    @GetMapping("/user")
    //자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할
    @ResponseBody
    public List<User> list() {
        //userService에서 UserList를 받는다.
        return userService.list();
    }

    //Read, select, GET
    //하나의 user 값 selcet user
    @GetMapping("user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
        //userService에 id 값을 넘기고 user값을 받아온다.
        return userService.view(id);
    }

    //Create, insert, POST
    //user 추가
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
        //userService에 user을 넘기고 add 성공여부를 boolean 값으로 받아온다.
        return userService.add(user);
    }

    //Update, update, PUT
    //user Update
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) {
        //userService에 user을 넘기고 update 된 user 값을 받아온다.
        return userService.update(user);
    }

    //Delete, delete, DELETE
    //user Delete
    @DeleteMapping("user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        //userService에 id 값을 넘기고 삭제된 user 값을 받아온다.
        return userService.delete(id);
    }
}

// CRUD / Create - Read - Update - Delete
// SQL / insert - select - update - delete
// HTTP/ POST - GET - PUT - DELETE
