package com.Converter.E2French;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.stereotype.Component;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
@Component
public class Translationclass {



    private static Translate translate;

    static {
        try {
            translate = TranslateOptions.newBuilder()
                    .setApiKey("AIzaSyCfv9gCghNQGGrkGmX8-9XCXvWK66aBs-s")
                    .build()
                    .getService();
        } catch (Exception e) {
            // Handle the exception, e.g., log it
            e.printStackTrace();
        }
    }

    public static String translateText(String text, String targetLanguage) {
        try {
            return translate.translate(text, Translate.TranslateOption.targetLanguage(targetLanguage)).getTranslatedText();
        } catch (Exception e) {
            // Handle the exception, e.g., log it
            e.printStackTrace();
            return null;
        }
    }
}