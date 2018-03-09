package com.example.maxfeldman.ui_intents_project;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String providerName;
    private String productPrice;
    private String inStock;
    transient private Bitmap photo;


    public Product(String productName, String providerName,String productPrice,String inStock, Bitmap photo) {
        this.productName = productName;
        this.providerName = providerName;
        this.productPrice = productPrice;
        this.photo = photo;
        this.inStock=inStock;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }


    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {     // to write an object of this class

        photo.compress(Bitmap.CompressFormat.JPEG,50,out);
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {      // to load an object of this class

        photo = BitmapFactory.decodeStream(in);
        in.defaultReadObject();
    }

}


