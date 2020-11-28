package com.beles.services;

import com.beles.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> findAllUom();
}
