package com.example.tarea2.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tarea2.R;
import com.example.tarea2.adapters.AdapterProduct;
import com.example.tarea2.beans.itemProduct;

import java.util.ArrayList;
import java.util.List;

public class FragmentElectronics extends Fragment implements AdapterProduct.OnPhoneClickListener {
    private RecyclerView listProducts;

    public static FragmentTechnology newInstance() {

        Bundle args = new Bundle();
        FragmentTechnology fragment = new FragmentTechnology();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listProducts = view.findViewById(R.id.listProducts);
        listProducts.setLayoutManager(new LinearLayoutManager(getActivity()));
        fillProducts();
    }

    private void fillProducts() {
        List<itemProduct> itemProducts = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if (i %2 == 0){
                itemProducts.add(new itemProduct("Producto " + (i +1), "BestBuy", "3141212323", 4, "Guadalajara, Jalisco"));

            }else{
                itemProducts.add(new itemProduct("Producto " + (i +1), "BestBuy", "3141212323", 5, "Guadalajara, Jalisco"));
            }

        }
        listProducts.setAdapter(new AdapterProduct(itemProducts, this));
    }
    @Override
    public void onPhoneClick(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phone));
        getContext().startActivity(intent);
    }

    @Override
    public void onTabItem(String item) {
        Toast.makeText(getContext(), item,
                Toast.LENGTH_LONG).show();
    }
}