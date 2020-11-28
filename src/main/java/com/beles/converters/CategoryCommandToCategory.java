package com.beles.converters;

import com.beles.commands.CategoryCommand;
import com.beles.domain.Category;

import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if(source == null){
            return null;
        }
        final Category category=new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
