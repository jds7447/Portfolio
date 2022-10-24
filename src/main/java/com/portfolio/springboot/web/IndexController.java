package com.portfolio.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

/*
머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다
    경로 : src/main/resources/templates
    확장자 : .mustache
반환한 문자열의 앞에 경로가 붙고 뒤에 확장자가 붙어서 View Resolver가 해당하는 View 파일을 찾아 처리하게 된다
*/