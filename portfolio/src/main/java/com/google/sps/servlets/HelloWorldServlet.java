package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> arr = new ArrayList<>();
    arr.add("Practicing yoga");
    arr.add("Crocheting");
    arr.add("Walking my dog");
    
    response.setContentType("text/html;");
    Gson gson = new Gson();
    response.getWriter().println(gson.toJson(arr));
  }
}
