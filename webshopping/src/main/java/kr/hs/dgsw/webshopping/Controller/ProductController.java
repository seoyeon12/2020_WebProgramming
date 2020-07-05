package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.Product;
import kr.hs.dgsw.webshopping.Service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/api/product") //구현완료(모든 제품보기)
    public List<Product> findAll(){
        return productService.findAll();
    }

    @DeleteMapping(value = "/api/product/id")
    public int deleteById(@Param("id") long id) {
        return productService.deleteById(id);
    }

    @PostMapping(value = "/api/product")
    public long add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping(value = "/api/product")
    public int modify(@RequestBody Product product) {
        return productService.modify(product);
    }

    @GetMapping(value = "/api/product/id") //구현완료(상세보기)
    public Product findById(@Param("id") Long id){
        return productService.findById(id);
    }

    @GetMapping(value = "/api/product/menuid")
    public List<Product> findByMenuId(@Param("menuid") Long menuid){
        return productService.findByMenuId(menuid);
    }

    @GetMapping(value = "/api/product/submenuid") //구현중...(서브메뉴에 따른 물건 리스트)
    public List<Product> findBySubMenuId(@Param("submenuid") Long submenuid) {
        return productService.findBySubMenuId(submenuid);
    }

}