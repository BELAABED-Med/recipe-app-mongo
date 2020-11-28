package com.beles.commands;

import com.beles.domain.Difficulty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RecipeCommand {
    private String id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Min(1)
    @Max(999)
    private Integer prepTime;

    @Min(1)
    @Max(999)
    private Integer cookTime;

    @Min(1)
    @Max(100)
    private Integer serving;
    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;

    private Byte[] image;
    private List<IngredientCommand> ingredients= new ArrayList<>();
    private NotesCommand notes;
    private Difficulty difficulty;
    private List<CategoryCommand> categories= new ArrayList<>();

    public RecipeCommand() {
    }
}
