package com.prototype.adidas.adidas.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class lector {
    public static void main(String[] args) throws IOException, JSONException {
        User usr= new User("12" , "eduardfores@gmail.com", "sad", "jose", "cardo");

        System.out.println(usr.comprar("1", "Adidas"));
    }
}
