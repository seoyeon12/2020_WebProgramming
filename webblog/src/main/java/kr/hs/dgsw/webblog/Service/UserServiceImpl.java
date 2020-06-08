package kr.hs.dgsw.webblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webblog.Domain.User;
import kr.hs.dgsw.webblog.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    // get,set 대신 사용, 의존성 주입
    @Autowired
    private UserRepository userRepository;

    //사용자 Insert할 때
    @Override
    public User create(User user) {
        Optional<User> found = userRepository.findByAccount(user.getAccount()); //userRepository에서 Optional<User>를 받는다.
        if(found.isPresent()) return null; //.isPresent()는 null이면 false를 반환
        return userRepository.save(user); // null일 경우 user을 save한다.
    }

    //사용자 한명을 select할 때
    @Override
    public User read(Long id) {
        Optional<User> user = userRepository.findById(id); //id를 가진 user의 정보를 가져온다.
        return user.isPresent() ? user.get() : null; //user가 null이 아니라면(true) user 정보를 반환
    }

    //사용자 update할 때
    @Override
    public User update(Long id, User user) {
        //if(userRepository.findByEmail(user.getEmail()).isPresent() || userRepository.fin)
        //Password, Name, Email, Phone, ProfilePath를 반환(== 업데이트)
        return userRepository.findById(id)
                    .map(found -> {
                        found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                        found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                        found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                        found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                        found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
                        return userRepository.save(found);
                    })
                    .orElse(null);
    }

    //id를 갖는 user을 삭제한다.
    //삭제 됐다면 true, 아니라면 false
    @Override
    public boolean delete(Long id) { 
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //모든 사용자를 select할 때
    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }
    
}