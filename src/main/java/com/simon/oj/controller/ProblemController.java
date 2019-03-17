package com.simon.oj.controller;

import com.simon.oj.model.Problem;
import com.simon.oj.service.impl.ProblemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemServiceImpl problemService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Problem> getProblems(){
        return problemService.findProblemList();
    }

}
