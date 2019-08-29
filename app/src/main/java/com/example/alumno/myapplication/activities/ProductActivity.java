package com.example.alumno.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.helpers.QueueUtils;
import com.example.alumno.myapplication.models.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ArrayList<Product> items;
    Product productno;
    QueueUtils.QueueObject queue = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        productno = new Product();
        //items = Product.getData();
        Product.injectProductFromCloud(queue,productno,this);
    }
    @Override
    public void onResume() {
        super.onResume();
        Intent myIntent = getIntent();
        int _productId = myIntent.getIntExtra("productId", 1);
        //refreshList(_productId);
    }
    public void refreshList(int _productId) {
        for(Product i : items) {
            if ( i.getId() == _productId ) {
                fill(i);
                return;
            }
        }
        Intent o = new Intent(ProductActivity.this, ProductlistActivity.class);
        o.putExtra("status", "error");
        startActivity(o);
        finish();
        return;
    }

    public void fill(Product productObject) {
        TextView name = (TextView)findViewById(R.id.textViewName);
        TextView Description = (TextView)findViewById(R.id.textDescription);
        name .setText(productObject.getName());
        Description.setText(productObject.getDescription());
    }
    public void refreshListone(){
        TextView name = (TextView)findViewById(R.id.textViewName);
        TextView Description = (TextView)findViewById(R.id.textDescription);
        name .setText(        productno
                .getName());
        Description.setText(productno.getDescription());
    }

}
