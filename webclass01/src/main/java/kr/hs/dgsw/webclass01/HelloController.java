package kr.hs.dgsw.webclass01;

import java.io.Console;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam final String say, @RequestParam final String to){
        return say + " " + to;
    }

    @GetMapping("/greeting1/{say}/{to}")
    public String greeting1(@PathVariable final String say, @PathVariable final String to){
        return say + " " + to;
    }

    @PostMapping("/greeting2")
    public String greeting2(@RequestParam final String say2, @RequestParam final String to2){
        return say2 + " " + to2;
    }
/////////////계산기 과제////////////////
    @GetMapping("/calculate")
    public String calculate(@RequestParam final int num1,@RequestParam final int num2,@RequestParam final String operator){
        if(operator.equals("add")){
            return operator + " : " + Integer.toString(num1+num2);
        }else if(operator.equals("sub")){
            return operator + " : " +  Integer.toString(num1-num2);
        }else if(operator.equals("mul")){
            return operator + " : " +  Integer.toString(num1*num2);
        }else if(operator.equals("div")){
            return operator + " : " +  Integer.toString(num1/num2);
        }else{
            return operator + " error ";
        }
    }

    @GetMapping("/plus/{num1}/{num2}")
    public String plus(@PathVariable final int num1, @PathVariable final int num2){
        return "add : " + Integer.toString(num1+num2);
    }
    @GetMapping("/sub/{num1}/{num2}")
    public String sub(@PathVariable final int num1, @PathVariable final int num2){
        return "sub : " + Integer.toString(num1-num2);
    }
    @GetMapping("/mul/{num1}/{num2}")
    public String mul(@PathVariable final int num1, @PathVariable final int num2){
        return "mul : " + Integer.toString(num1*num2);
    }
    @GetMapping("/div/{num1}/{num2}")
    public String div(@PathVariable final int num1, @PathVariable final int num2){
        return "div : " + Integer.toString(num1/num2);
    }
}