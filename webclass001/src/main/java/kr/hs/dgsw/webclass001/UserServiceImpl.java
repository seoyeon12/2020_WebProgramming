package kr.hs.dgsw.webclass001;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //User를 인자로 가지는 List, userList 선언
    List<User> userList;
    
    public UserServiceImpl() {
        userList = new ArrayList<>();

        //Lombok 사용 했을 시
        //User user = User.builder().id("user1").name("표").email("ka111@dgsw").build();
        userList.add(User.builder().id("user1").name("표").email("ka111@dgsw").build());
        userList.add(User.builder().id("user2").name("지").email("ka222@dgsw").build());
        userList.add(User.builder().id("user3").name("훈").email("ka333@dgsw").build());

        //Lombok 사용 하지 않았을 시
        // userList.add(new User("user1", "표", "ka111@dgsw"));
        // userList.add(new User("user2", "지", "ka222@dgsw"));
        // userList.add(new User("user3", "훈", "ka333@dgsw"));
    }

    //모든 user리스트 보기
    @Override
    public List<User> list() {
        //userList 반환
        return userList;
    }
    
    //특정 id를 갖는 user 보기
    @Override
    public User view(String id) {
        //받아온 id 값을 가지는 user 반환
        User user = userList.stream()
                    .filter(found -> found.getId().equals(id))
                    .findAny()
                    .orElse(null);
        return user;
    }

    //user 추가하기
    @Override
    public boolean add(User user) {
        //받아온 user의 id 값을 view에 넘긴다. 
        User found = view(user.getId());
        //view에서 반환된 user가 있으면 이미 존재하는 user임으로 추가 X
        if(found == null)
            //List에 추가가 되었다면 true를
            return userList.add(user);
        //아니라면 false를
        return false;
    }

    //user 정보 업데이트하기
    @Override
    public User update(User user) {
        //받아온 user의 id 값을 view에 넘긴다. 
        User found = view(user.getId());
        //view에서 반환된 user가 있으면 == null이 아니라면
        if(found != null){
            //이름과 이메일을 수정한다. 
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        //업데이트 된 user값을 넘긴다.
        return found;
    }

    //user 정보 삭제
    @Override
    public boolean delete(String id) {
        //받아온 id 값을 view에 넘긴다. 
        User found = view(id);
        //userList에서 found된 유저를 삭제한다.
        return userList.remove(found);
    }

/////////////////////////////////////////////////////////////
    public User find1(String name) {
        for(int i = 0; i < userList.size(); i++){
            User user = userList.get(i);
            if(user.getName().equals(name)) return user;
        }
        return null;
    }
    public User find2(String name) {
        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if(user.getName().equals(name)) return user;
        }
        return null;
    }
    public User find3(String name) {
        for(User user : userList) {
            if(user.getName().equals(name)) return user;
        }
        return null;
    }
    
}