package com.hypermind.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hypermind.provider.model.Config;
import com.hypermind.provider.model.Scripts;
import com.hypermind.provider.service.iService.ConfigService;
import com.hypermind.provider.service.iService.ScriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.font.Script;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ConfigService configService;
    @Autowired
    ScriptsService scriptsService;

    @RequestMapping("/get/{name}")
    public Object get(@PathVariable("name") String name) {
        return configService.getOne(new QueryWrapper<Config>().eq("name", name));
    }

    @RequestMapping("/set/{name}")
    public Object set(@PathVariable("name") String name, Integer value) {
        return configService.update(new UpdateWrapper<Config>().eq("name", name).set("value", value));
    }

    @RequestMapping("/script/{name}")
    public Object script(@PathVariable("name") String name) {
        Config config = configService.getOne(new QueryWrapper<Config>().eq("name", name));
        return scriptsService.getOne(new QueryWrapper<Scripts>().eq("id", config.getValue()));
    }

    @RequestMapping("/add/{name}")
    public Object add(@PathVariable("name") String name, Integer value) {
        Config config = new Config();
        config.setName(name);
        config.setValue(value);
        return configService.save(config);
    }

    @RequestMapping("/save")
    public Object save(Integer id, String content) {
        return scriptsService.update(new UpdateWrapper<Scripts>().eq("id", id).set("content", content));
    }
}
