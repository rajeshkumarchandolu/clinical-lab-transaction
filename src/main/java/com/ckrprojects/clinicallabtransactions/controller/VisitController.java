package com.ckrprojects.clinicallabtransactions.controller;

import com.ckrprojects.clinicallabtransactions.entity.Visit;
import com.ckrprojects.clinicallabtransactions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitService visitService;


    @GetMapping("/{id}")
    public Visit get(@PathVariable("id") String id) {
        return visitService.getVisitByid(id);
    }

    @PostMapping("")
    public Visit post(@RequestBody Visit visit) {
        return visitService.save(visit);
    }


    @PutMapping("/{id}")
    public Visit put(@PathVariable("id") int id,
                     @RequestBody Visit visit) {
        return visitService.update(visit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        visitService.delete(id);
    }

}
