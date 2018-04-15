package com.prototype.adidas.adidas.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {


    @SerializedName("id_product")
    @Expose
    private String id_product;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_link")
    @Expose
    private String image_link;
    @SerializedName("size_p")
    @Expose
    private String size_p;
    @SerializedName("price")
    @Expose
    private float price;

    public Product(String id_product, String barcode, String name, String description, String image_link, String size_p, float price) {
        this.id_product = id_product;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.image_link = image_link;
        this.size_p = size_p;
        this.price = price;
    }

    public Product() {
    }

    public String getString() {
        return size_p;
    }

    public void setString(String size) {
        this.size_p = size;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product='" + id_product + '\'' +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image_link='" + image_link + '\'' +
                ", size=" + size_p +
                ", price=" + price +
                '}';
    }
}
