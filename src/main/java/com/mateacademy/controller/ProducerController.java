package com.mateacademy.controller;

import com.mateacademy.model.Producer;
import com.mateacademy.service.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/producer")
public class ProducerController {

    @Autowired
    private ProducerServiceImpl producerService;

    @GetMapping
    public ModelAndView producerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("producerPage");
        modelAndView.addObject("producer", new Producer());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerPage");
        modelAndView.addObject("create", producerService.addProducer(producer));
        return modelAndView;
    }

    @PutMapping("/update")
    public ModelAndView updateProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerPage");
        modelAndView.addObject("update", producerService.update(producer));
        return modelAndView;
    }

    @DeleteMapping("/delete")
    public ModelAndView deleteProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerPage");
        modelAndView.addObject("delete", producerService.getById(producer.getId()));
        producerService.delete(producer.getId());
        return modelAndView;
    }
}
