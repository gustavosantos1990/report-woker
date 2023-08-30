package org.gdas.bigreportsworker.service;

import org.gdas.bigreportsworker.model.entity.AnyEntity;
import org.gdas.bigreportsworker.repository.AnyEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnyService {

    private final AnyEntityRepository anyEntityRepository;

    public AnyService(AnyEntityRepository anyEntityRepository) {
        this.anyEntityRepository = anyEntityRepository;
    }

    public AnyEntity save(String message) {
        return anyEntityRepository.save(new AnyEntity(message));
    }

}
