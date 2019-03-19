package com.example.tarea4.interfaces;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface{
    Context mContext;

    public WebAppInterface(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void showToast(String toast){
        android.widget.Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
