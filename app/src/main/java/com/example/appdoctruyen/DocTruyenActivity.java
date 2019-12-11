package com.example.appdoctruyen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.api.ApiLayAnh;
import com.example.appdoctruyen.interfaces.LayAnhVe;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DocTruyenActivity extends Activity implements LayAnhVe {
    ImageView imgAnh;
    ArrayList<String> arrUrlAnh;
    int soTrang, soTrangDangDoc;
    String idChap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_doc_truyen );

        init();
        anhXa();
        setUp();
        setClink();
        new ApiLayAnh( this,idChap ).execute(  );
    }


    private void init(){
       Bundle b = getIntent().getBundleExtra( "data" );
       idChap = b.getString( "idChap" );

    }
    private void anhXa(){


        imgAnh = findViewById( R.id.imgAnh );

    }

    private void setUp(){
       // docTheoTrang( 0 );

    }

    private void setClink() {
    }



public void left(View view) {
        docTheoTrang( -1 );
    }

    public void right(View view) {
        docTheoTrang( 1 );
    }
    public void docTheoTrang(int i){
        soTrangDangDoc = soTrangDangDoc+i;
        if (soTrangDangDoc==0){
            soTrangDangDoc=1;
        }
        if (soTrangDangDoc>soTrang){
            soTrangDangDoc=soTrang;
        }


        Glide.with(this).load(arrUrlAnh.get( soTrangDangDoc - 1 )).into(imgAnh);
    }

    @Override
    public void batDau() {

    }

    @Override
    public void ketThuc(String data) {
     arrUrlAnh = new ArrayList<>(  );
     try {
         JSONArray arr = new JSONArray( data );
         for (int i=0;i<arr.length();i++){
             arrUrlAnh.add( arr.getString( i ) );
         }
         soTrangDangDoc = 1;
         soTrang=arrUrlAnh.size();
     }catch (JSONException e){

     }
    }

    @Override
    public void biLoi() {

    }
}
