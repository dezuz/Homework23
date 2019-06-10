package com.mateacademy.service;

import com.mateacademy.model.Producer;
import com.mateacademy.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public Producer addProducer(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public List<Producer> findAllProducers() {
        return producerRepository.findAll();
    }

    @Override
    public Producer getById(Long id) {
        return producerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public Producer update(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public void delete(Long id) {
        producerRepository.deleteById(id);
    }
}
