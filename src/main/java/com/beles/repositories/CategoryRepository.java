package com.beles.repositories;

import com.beles.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,String> {

    Optional<Category> findByDescription(String description);

}
