package kr.yeotaeho.api.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.yeotaeho.api.common.domain.Messenger;

@RestController
public class HomeController {

    @GetMapping("/")
    public Messenger home() {
        return Messenger.builder()
                .code(200)
                .message("Home")
                .build();
    }

}