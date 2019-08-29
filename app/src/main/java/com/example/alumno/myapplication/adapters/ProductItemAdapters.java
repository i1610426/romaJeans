package com.example.alumno.myapplication.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.activities.ProductlistActivity;
import com.example.alumno.myapplication.models.Product;

import java.util.List;

public class ProductItemAdapters extends ArrayAdapter<Product> {
    Context context;


    private class ViewHolder {
        TextView name;
        TextView Description;
        Button btnproducto;

        private ViewHolder(){
        }
    }
    public ProductItemAdapters(Context context, List<Product> items) {
        super(context, 0, items);
        this.context = context;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final Product rowItem = (Product) getItem(position);
        LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_product_item,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            //  holder.monto = (Button) convertView.findViewById(R.id.monto);
            holder.Description = (TextView) convertView.findViewById(R.id.Description);
            holder.btnproducto = (Button) convertView.findViewById(R.id.btnproducto);
            convertView.setTag(holder);

            //     holder.monto = (Button) convertView.findViewById(R.id.monto);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(rowItem.getName());
        holder.Description.setText(rowItem.getDescription());
        //   holder.monto.setText(rowItem.setMonto(boolean)+ "hh");

        holder.btnproducto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ProductlistActivity activity = (ProductlistActivity) context;
                Toast.makeText(context,"a continuación el producto", Toast.LENGTH_SHORT).show();
                activity.selectProduct(position);

            }
        });

//        holder.image.setImageBitmap(rowItem.getSmallBitMap());
        return convertView;
    }


}