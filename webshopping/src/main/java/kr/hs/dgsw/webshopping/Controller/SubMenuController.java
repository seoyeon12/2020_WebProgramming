package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.SubMenu;
import kr.hs.dgsw.webshopping.Service.SubMenuService;

@RestController
public class SubMenuController {
    @Autowired
    SubMenuService subMenuService;

    @GetMapping(value = "/api/subMenu/menuid")
    public List<SubMenu> findByMenuId(@Param("menuid") Long menuid){
        return subMenuService.findByMenuId(menuid);
    }

    @GetMapping(value = "/api/subMenu/uid")
    public SubMenu findById(@Param("id") Long id){
        return subMenuService.findById(id);
    }
}