package com.beles.repositories;

import com.beles.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,String> {

    Optional<UnitOfMeasure> findByUom(String uom);

}
