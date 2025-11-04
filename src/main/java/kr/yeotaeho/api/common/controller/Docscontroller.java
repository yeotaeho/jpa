package kr.yeotaeho.api.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Docscontroller {

    @GetMapping("/docs")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping("/api-docs")
    public String redirectToApiDocs() {
        return "redirect:/v3/api-docs";
    }
}
