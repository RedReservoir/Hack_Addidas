package com.prototype.adidas.adidas.http;

import android.graphics.drawable.Drawable;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by gerar on 15/04/2018.
 */

public final class StaticMethods {
    public static Drawable LoadImageFromWebOperations(String url, String productDescription) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, productDescription);
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
