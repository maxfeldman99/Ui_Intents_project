package com.example.maxfeldman.ui_intents_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MAX FELDMAN on 25/02/2018.
 */

public class MyCustomListAdapter extends ArrayAdapter<Product> {

   private Context myContext;
    private int resource;
    private List<Product> productList;


    public MyCustomListAdapter(Context myContext, int resource, List<Product> productList){
        super(myContext,resource,productList);

        this.myContext=myContext;
        this.resource=resource;
        this.productList=productList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(myContext);

        View view = inflater.inflate(resource,null);

        TextView textView1 = view.findViewById(R.id.text1);
        TextView textView2 = view.findViewById(R.id.text2);
        TextView textView3 = view.findViewById(R.id.text3);
        TextView textView4 = view.findViewById(R.id.text4);
        ImageView imageView =view.findViewById(R.id.image_view);

        Product product = productList.get(position);

        textView1.setText("Name: "+ product.getProductName());
        textView2.setText("Provider: "+product.getProviderName());
        textView3.setText("Price: "+product.getProductPrice());
        textView4.setText("In Stock:  "+product.getInStock());
        imageView.setImageBitmap(product.getPhoto());






    return view;
    }
}
