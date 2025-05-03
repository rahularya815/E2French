package com.Converter.E2French;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    Translationclass translationclass;

    @PostMapping("/convert")
    public ResponseEntity<Object> convert(@RequestBody InDTO inDTO){

        if(inDTO==null || inDTO.getText()==null)
        {
            return new ResponseEntity<>("No text found. Please enter text", HttpStatus.BAD_REQUEST);
        }

        String text = inDTO.getText();
        System.out.println(text);
        String targetLanguage = "fr";
        String translatedText = translationclass.translateText(text, targetLanguage);
        Map<String,String> mp=new HashMap<>();
        mp.put("translation",translatedText);
        return new ResponseEntity<>(mp, HttpStatus.OK);

    }
}
