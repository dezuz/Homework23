package com.mateacademy.service;

import com.mateacademy.model.Producer;

import java.util.List;

public interface ProducerService {

    Producer addProducer(Producer producer);

    List<Producer> findAllProducers();

    Producer getById(Long id);

    Producer update(Producer producer);

    void delete(Long id);
}
