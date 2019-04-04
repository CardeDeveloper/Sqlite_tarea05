package com.example.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tarea4.beans.itemProduct;
import com.example.tarea4.tools.Constants;

public class ProductActivity extends AppCompatActivity {

    EditText title,store,location;
    ImageView image;
    Button save, cancel;
    itemProduct item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        item = getIntent().getParcelableExtra(Constants.ITEM);
        title = (EditText) findViewById(R.id.activity_detail_title);
        store = (EditText) findViewById(R.id.activity_detail_store);
        location = (EditText) findViewById(R.id.activity_detail_location);
        image = (ImageView) findViewById(R.id.activity_detail_image);
        save = (Button) findViewById(R.id.activity_detail_save);
        cancel = (Button) findViewById(R.id.activity_detail_cancel);

        title.setText(item.getTitle());
        store.setText(item.getStore().toString());
        location.setText(item.getLocation());
        switch(item.getImage()){
            case 0:
                image.setImageResource(R.drawable.mac); break;
            case 1:
                image.setImageResource(R.drawable.alienware); break;
            case 2:
                image.setImageResource(R.drawable.pillows); break;
            case 3:
                image.setImageResource(R.drawable.sheets); break;
            case 4:
                image.setImageResource(R.drawable.refrigerator); break;
            case 5:
                image.setImageResource(R.drawable.micro); break;
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item.setTitle(title.getText().toString());
                item.getStore().setName(store.getText().toString());
                item.getStore().getCity().setName(location.getText().toString());
                item.setLocation(location.getText().toString());
                Intent intent = new Intent();
                intent.putExtra(Constants.ITEM, item);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}
