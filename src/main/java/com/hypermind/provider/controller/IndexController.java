package com.hypermind.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hypermind.provider.model.Scripts;
import com.hypermind.provider.service.iService.ScriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
    @Autowired
    ScriptsService scriptsService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("all", scriptsService.list());

        return "index";
    }

    @GetMapping("script")
    @ResponseBody
    public Object script(Integer id, Model model) {
        return scriptsService.getOne(new QueryWrapper<Scripts>().eq("id", id));
    }

    @GetMapping("view")
    public Object view(Integer id, Model model) {
        model.addAttribute("script", scriptsService.getOne(new QueryWrapper<Scripts>().eq("id", id)));
        return "scripts/view";
    }
}
