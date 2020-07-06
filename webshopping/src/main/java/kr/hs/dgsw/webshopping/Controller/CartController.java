package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.Cart;
import kr.hs.dgsw.webshopping.Service.CartService;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(value = "/api/cart") //구현완료(상세보기)
    public Long add(@RequestBody Cart cart){
        return cartService.add(cart);
    }

    @DeleteMapping(value = "/api/cart") //구현완료(품목 삭제)
    public int deleteById(@Param("id") Long id){
        return cartService.deleteById(id);
    }

    @DeleteMapping(value = "/api/cart/userid") //구현완료(전체 삭제)
    public int deleteByUserId(@Param("userid") Long userid){
        return cartService.deleteByUserId(userid);
    }

    @GetMapping("/api/cart/id")
    public Cart findById(@Param("id") Long id){
        return cartService.findById(id);
    }

    @GetMapping("/api/cart/user/userid") //구현완료(장바구니)
    public List<Cart> findByUserId(@Param("userid") Long userid){
        return cartService.findByUserId(userid);
    }
}
