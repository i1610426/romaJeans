package com.example.alumno.myapplication.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.activities.ProductActivity;
import com.example.alumno.myapplication.activities.ProductlistActivity;
import com.example.alumno.myapplication.helpers.QueueUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private String description;
    private int categoryId;
    private Double price;
    private int amount;
    private char[] monto;

    public String toString(){
        return String.format("%s - %s - %s", this.getId(), this.getName(), this.getDescription());
    }
public Product(){}
    public Product(int _id, String _name, String _description, int _categoryId, Double _price, int _amount) {
        //Constructor
        this.id=_id;
        this.name= _name;
        this.setDescription(_description);
        this.setCategoryId(_categoryId);
        this.setPrice(_price);
        this.setAmount(_amount);

    }

    public static ArrayList getData() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1, "Pantalon", "Visualizar ",
                1, 80.00, 2));
        list.add(new Product(2, "Casaca", "Visualizar ",
                1, 130.00, 2));
        list.add(new Product(3, "Polo", "Visualizar",
                1, 180.00, 2));
        list.add(new Product(4, "Camisa", "Visualizar ",
                1, 40.00, 2));
        return list;
    }
    public static void injectProductFromCloud(final QueueUtils.QueueObject o,
                                               final Product _product,
                                               final ProductActivity _interface) {
        String url = "https://reqres.in/api/products";
        url = "https://reqres.in/api/users/2";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("data")) {

                            try {
                                JSONObject list = response.getJSONObject("data");

                                _product.setId(list.getInt("id"));
                                _product.setName(list.getString("first_name"));
                                _product.setDescription(list.getString("last_name"));
                                    //Double_price = o.getString("price");



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            _interface.refreshListone();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        int b = 2;
                        b += 1;

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }
    public static void injectProductsFromCloud(final QueueUtils.QueueObject o,
                                               final ArrayList<Product> products,
                                               final ProductlistActivity _interface) {
        String url = "https://reqres.in/api/products";
        url = "https://reqres.in/api/users";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("data")) {

                            try {
                                JSONArray list = response.getJSONArray("data");
                                for (int i=0; i < list.length(); i++) {
                                    JSONObject o = list.getJSONObject(i);
                                    //Double_price = o.getString("price");
                                    products.add(new Product(o.getInt("id"),
                                            o.getString("first_name"),
                                            o.getString("last_name"),
                                            1,5.0,5
                                            ));
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            _interface.refreshList();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        int b = 2;
                        b += 1;

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMonto(char[] monto) {
        this.monto = monto;
    }
}