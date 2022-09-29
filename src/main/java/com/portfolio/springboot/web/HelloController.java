package com.portfolio.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

/*
@RestController
    컨트롤러를 JSON을 반환하는 큰터를러로 만듦
    예전에는 @ResponseBody를 각 메서드마다 선언했던 것을 한 번에 사용할 수 있게 해준다고 생각하면 됨
*/
/*
@Getmapping
    HTTP Method인 Get의 요청을 받을 수 있는 API를 만듦
    예전에는 @RequestMapping(method = RequestMethod.GET) 으로 사용되었음
    이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하게 됨
*/
