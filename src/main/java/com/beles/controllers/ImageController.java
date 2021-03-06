package com.beles.controllers;

import com.beles.commands.RecipeCommand;
import com.beles.services.ImageService;
import com.beles.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeId}/image")
    public String getImageForm(@PathVariable String recipeId, Model model){
        model.addAttribute("recipe",recipeService.findCommandById(recipeId));
        return "recipe/imageuploadform";
    }

    @PostMapping("/recipe/{recipeId}/image")
    public String handleImagePost(@PathVariable String recipeId, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImage(recipeId,file);

        return "redirect:/recipe/" + recipeId + "/show";
    }

    @GetMapping("/recipe/{recipeId}/recipeimage")
    public void renderImageFromDb(@PathVariable String recipeId, HttpServletResponse response) throws IOException {

        RecipeCommand recipeCommand=recipeService.findCommandById(recipeId);

        if (recipeCommand.getImage() != null) {
            byte[] byteArray= new byte[recipeCommand.getImage().length];
            int i=0;
            for (Byte wrappedByte :recipeCommand.getImage()){
                byteArray[i++]=wrappedByte;
            }
            response.setContentType("image/jpg");
            InputStream is=new ByteArrayInputStream(byteArray);
            IOUtils.copy(is,response.getOutputStream());
        }

    }

}
