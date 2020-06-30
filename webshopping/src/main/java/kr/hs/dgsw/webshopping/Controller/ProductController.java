package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.Product;
import kr.hs.dgsw.webshopping.Service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/api/product")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(value = "/api/product/id")
    public Product findById(@Param("id") Long id){
        return productService.findById(id);
    }

    @GetMapping(value = "/api/product/menuid")
    public List<Product> findByMenuId(@Param("menuid") Long menuid){
        return productService.findByMenuId(menuid);
    }
}