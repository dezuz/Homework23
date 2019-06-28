package com.mateacademy.controller;

import com.mateacademy.model.Producer;
import com.mateacademy.service.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/producer")
public class ProducerController {

    @Autowired
    private ProducerServiceImpl producerService;

    @GetMapping("/create")
    public ModelAndView createProducerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("createProducer");
        modelAndView.addObject("producer", new Producer());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerCreatedPage");
        modelAndView.addObject("create", producerService.addProducer(producer));
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateProducerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("updateProducer");
        modelAndView.addObject("producer", new Producer());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerUpdatedPage");
        modelAndView.addObject("update", producerService.update(producer));
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProducerPage(ModelAndView modelAndView) {
        modelAndView.setViewName("deleteProducer");
        modelAndView.addObject("producer", new Producer());
        modelAndView.addObject("producers", producerService.findAllProducers());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteProducer(@ModelAttribute Producer producer, ModelAndView modelAndView) {
        modelAndView.setViewName("producerDeletedPage");
        modelAndView.addObject("delete", producerService.getById(producer.getId()));
        producerService.delete(producer.getId());
        return modelAndView;
    }
}
