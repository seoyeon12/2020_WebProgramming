package kr.hs.dgsw.webblog.Service;

import java.util.List;

import kr.hs.dgsw.webblog.Domain.User;

public interface UserService {
    //Impl에서 상세하게 기능 구현
    User create(User user);
    User read(Long id);
    User update(Long id, User user);
    boolean delete(Long id);
    List<User> readAll();
}