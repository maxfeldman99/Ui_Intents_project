package com.example.maxfeldman.ui_intents_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Product_stock extends Activity {

    ArrayList<Product> productList;
    ListView listview;


    ArrayList<Product> myList;
    ArrayAdapter<Product> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_stock);
        myList = new ArrayList<>();

        listview = findViewById(R.id.list_view);

        //productList = new ArrayList<>();/////////
        for (int i = 0; i <myList.size() ; i++) {

        }


      //  arrayAdapter = new ArrayAdapter<Product>(this,android.R.layout.simple_expandable_list_item_1,myList);

         MyCustomListAdapter adapter = new MyCustomListAdapter(this,R.layout.my_list_item,myList);
         listview.setAdapter(adapter);
        // listview.setAdapter(arrayAdapter);
        update();
    }

    void update(){

        try {
            FileInputStream stream = openFileInput("products");
            ObjectInputStream input = new ObjectInputStream(stream);
            Product p;
            while ((p = (Product) input.readObject()) != null) {

                myList.add(p);

            }

            input.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
