package cn.edu.sdu.ise.labs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
public class BillController {
    @GetMapping("login")
    public String add(String username, Integer age) {
        return age + username;

    }
}
