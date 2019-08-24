package com.example.onlineshopping.Adapter;

import android.graphics.Movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, desc;
        ImageView product_image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.product_name);
            price = (TextView) view.findViewById(R.id.product_price);
            desc = (TextView) view.findViewById(R.id.desc);
            product_image = (ImageView) view.findViewById(R.id.product_image);
        }
    }


    public HomeAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.name.setText(product.getProduct_name());
        holder.price.setText(product.getPrice() + " BDT");
        holder.desc.setText(product.getDetails());
        Picasso.get().load(product.getImage()).into(holder.product_image);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}