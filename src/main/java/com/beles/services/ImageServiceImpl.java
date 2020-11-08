package com.beles.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{
    @Override
    public void saveImage(Long recipeId, MultipartFile file) {
        log.info("image file of recipe "+recipeId+" is received" );
    }
}