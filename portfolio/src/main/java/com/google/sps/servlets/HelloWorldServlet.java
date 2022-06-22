package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // String[] languageCodes = new String[] {"zh", "en", "hi", "es", "ar"};
    String[] languageCodes = new String[] {"en", "es"};
    String languageCode = languageCodes[(int) ((Math.random() * (languageCodes.length)))];

    String text1 = "Practicing yoga";
    String text2 = "Crocheting";
    String text3 = "Walking my dog";


    Translate translate = TranslateOptions.getDefaultInstance().getService();
    Translation translation =
        translate.translate(text1, Translate.TranslateOption.targetLanguage(languageCode));
    String translatedText1 = translation.getTranslatedText();

    Translation translation2 =
        translate.translate(text2, Translate.TranslateOption.targetLanguage(languageCode));
    String translatedText2 = translation2.getTranslatedText();

    Translation translation3 =
        translate.translate(text3, Translate.TranslateOption.targetLanguage(languageCode));
    String translatedText3 = translation3.getTranslatedText();

    ArrayList<String> arr = new ArrayList<>();
    arr.add(translatedText1);
    arr.add(translatedText2);
    arr.add(translatedText3);
    
    response.setContentType("text/html;");
    Gson gson = new Gson();
    response.getWriter().println(gson.toJson(arr));
  }
}
