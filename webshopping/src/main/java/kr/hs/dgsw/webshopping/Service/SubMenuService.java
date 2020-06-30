package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import kr.hs.dgsw.webshopping.Domain.SubMenu;

public interface SubMenuService {
    List<SubMenu> findByMenuId(Long menuid);
    SubMenu findById(Long id);
}