package com.example.tarea4.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarea4.R;
import com.example.tarea4.beans.itemProduct;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private List<itemProduct> itemProducts;
    private OnPhoneClickListener listener;

    public AdapterProduct(List<itemProduct> itemProducts) {
        this.itemProducts = itemProducts;
    }

    public AdapterProduct(List<itemProduct> itemProducts, OnPhoneClickListener listener) {
        this.itemProducts = itemProducts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final itemProduct itemProduct = itemProducts.get(position);

        viewHolder.txtTitle.setText(itemProduct.getTitle());
        viewHolder.txtStore.setText(itemProduct.getStore().toString());
        viewHolder.txtPhone.setText(itemProduct.getPhone());
        viewHolder.txtLocation.setText(itemProduct.getLocation());
        switch(itemProduct.getImage()){
            case 0:
                viewHolder.imgProduct.setImageResource(R.drawable.mac);
                break;
            case 1:
                viewHolder.imgProduct.setImageResource(R.drawable.alienware);
                break;
            case 2:
                viewHolder.imgProduct.setImageResource(R.drawable.pillows);
                break;
            case 3:
                viewHolder.imgProduct.setImageResource(R.drawable.sheets);
                break;
            case 4:
                viewHolder.imgProduct.setImageResource(R.drawable.refrigerator);
                break;
            case 5:
                viewHolder.imgProduct.setImageResource(R.drawable.micro);
                break;
            default:
                viewHolder.imgProduct.setImageResource(R.drawable.mac);
                break;
        }

        viewHolder.txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPhoneClick(itemProduct.getPhone());
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTabItem(itemProduct);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtLocation;
        TextView txtStore;
        TextView txtPhone;
        Button btnShare;
        Button btnSeeMore;
        ImageView imgProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.item_product_title);
            txtLocation = itemView.findViewById(R.id.item_product_location);
            txtStore = itemView.findViewById(R.id.item_product_store);
            txtPhone = itemView.findViewById(R.id.item_product_phone);
            imgProduct = itemView.findViewById(R.id.item_product_image);
            btnShare = itemView.findViewById(R.id.item_product_share);
            btnSeeMore = itemView.findViewById(R.id.item_product_detail);
        }
    }

    public void addItems(List<itemProduct> list){
        itemProducts.addAll(list);
    }

    public interface OnPhoneClickListener {
        void onPhoneClick(String phone);
        void onTabItem(itemProduct item);
    }
}
