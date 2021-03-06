package com.ckrprojects.clinicallabtransactions.controller;

import com.ckrprojects.clinicallabtransactions.entity.Test;
import com.ckrprojects.clinicallabtransactions.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/{id}")
    public Test get(@PathVariable("id") int id) {
        return testService.getVisitByid(id);
    }

    @PostMapping("")
    public Test post(@RequestBody(required = true) Test test) {
        return testService.save(test);
    }


    @PostMapping("/{id}")
    public Test put(@PathVariable("id") int id,
                    @RequestBody(required = true) Test test) {
        test.setId(id);
        return testService.update(test);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id", required = true) int id) {
        testService.delete(id);
    }
}
