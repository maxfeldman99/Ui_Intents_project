package com.example.maxfeldman.ui_intents_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    Bitmap bitmapP1;
    final int CAMERA_REQUEST_PRODUCT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText p1NameEt = findViewById(R.id.prod_edit);
        final EditText p1ProvEt = findViewById(R.id.prov_edit);
        final EditText p1PriceEt = findViewById(R.id.price_edit);

        imageView1 = findViewById(R.id.result_photo);

        Button takePhotoBtn = findViewById(R.id.take_photo);
        takePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),CAMERA_REQUEST_PRODUCT);
            }
        });

        Button sendDataBtn = findViewById(R.id.send);
        sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pName = p1NameEt.getText().toString();
                String pProv = p1ProvEt.getText().toString();
                String pPrice = p1PriceEt.getText().toString();

                Product product1 = new Product(pName,pProv,pPrice,bitmapP1);

                ArrayList<Product> products = new ArrayList<>();
                products.add(product1);


                Intent intent2 = new Intent(MainActivity.this, Product_stock.class);
                intent2.putExtra("products", product1);










                try {
                    FileOutputStream fos = openFileOutput("products",MODE_PRIVATE);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(products);
                    oos.close();

                    p1NameEt.setText("");
                    p1ProvEt.setText("");
                    p1PriceEt.setText("");
                    imageView1.setImageBitmap(null);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startActivity(intent2);

            }


        });

        Button goStockBtn = findViewById(R.id.go_to_stock);
        goStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Product_stock.class);
                startActivity(intent);
            }
        });


    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== CAMERA_REQUEST_PRODUCT && resultCode == RESULT_OK){
            bitmapP1 = (Bitmap)data.getExtras().get("data");
            imageView1.setImageBitmap(bitmapP1);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
