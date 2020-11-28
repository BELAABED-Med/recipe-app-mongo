package com.beles.services;

import com.beles.commands.UnitOfMeasureCommand;
import com.beles.converters.UnitOfMeasureToUniteOfMeasureCommand;
import com.beles.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureToUniteOfMeasureCommand unitOfMeasureConverter;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureToUniteOfMeasureCommand unitOfMeasureConverter,
                                    UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasureCommand> findAllUom() {
         return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureConverter::convert)
                .collect(Collectors.toSet());
    }
}
