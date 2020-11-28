package com.beles.converters;

import com.beles.commands.IngredientCommand;
import com.beles.domain.Ingredient;
import com.mongodb.lang.Nullable;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUniteOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUniteOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }
        final IngredientCommand ingredientCommand=new IngredientCommand();
        ingredientCommand.setId(source.getId());
//        if (source.getRecipe() != null) {
//            ingredientCommand.setRecipeId(source.getRecipe().getId());
//        }
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setUom(uomConverter.convert(source.getUom()));
        return ingredientCommand;

    }
}
