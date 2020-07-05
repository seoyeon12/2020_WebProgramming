package kr.hs.dgsw.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubMenuMapper {
    List<SubMenu> findByMenuId(Long menuid);
    SubMenu findById(Long id);
}