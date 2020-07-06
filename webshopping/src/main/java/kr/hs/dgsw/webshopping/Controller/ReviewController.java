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

import kr.hs.dgsw.webshopping.Domain.Review;
import kr.hs.dgsw.webshopping.Service.ReviewService;

@RestController
public class ReviewController {
    
    @Autowired
    ReviewService reviewService;

    @PostMapping(value = "/api/review") //구현 완료(리뷰 추가)
    public Long add(@RequestBody Review review){
        return reviewService.add(review);
    }

    @DeleteMapping(value = "/api/review")
    public int deleteById(@Param("id") Long id){
        return reviewService.deleteById(id);
    }

    @GetMapping(value = "/api/review/productid") //구현완료(상세보기)
    public List<Review> findByProductId(@Param("productid") Long productid){
        return reviewService.findByProductId(productid);
    }

    @PutMapping(value = "/api/review")
    public int modify(@RequestBody Review review){
        return reviewService.modify(review);
    }
}