package com.hypermind.provider.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 无间
 * @since 2019-10-20
 */
@Controller
@RequestMapping("/scripts")
public class ScriptsController extends BaseController {

    @GetMapping("post")
    public String post() {
        return "scripts/post";
    }
}

