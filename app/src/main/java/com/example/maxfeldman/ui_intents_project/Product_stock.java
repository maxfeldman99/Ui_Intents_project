package com.example.maxfeldman.ui_intents_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class Product_stock extends AppCompatActivity {

    List<Product> productList;
    ListView listview;


    ArrayList<Product> myList = (ArrayList<Product>) getIntent().getSerializableExtra("products");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_stock);

        //productList = new ArrayList<>();/////////
        for (int i = 0; i <myList.size() ; i++) {

        }

        MyCustomListAdapter adapter = new MyCustomListAdapter(this,R.layout.my_list_item,productList);
        listview.setAdapter(adapter);

    }

}
