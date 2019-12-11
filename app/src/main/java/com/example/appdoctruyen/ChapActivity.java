package com.example.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.adapter.ChapTruyenAdapter;
import com.example.appdoctruyen.api.ApiChapTruyen;
import com.example.appdoctruyen.interfaces.LayChapVe;
import com.example.appdoctruyen.object.ChapTruyen;
import com.example.appdoctruyen.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ChapActivity extends AppCompatActivity implements LayChapVe {
    TextView txvTenTruyens;
    ImageView imgAnhTruyens;
    TruyenTranh truyenTranh;
    ListView lsvDanhSachChap;
    ArrayList<ChapTruyen> arrChap;
    ChapTruyenAdapter chapTruyenAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chap );
        init();
        anhXa();
        setUp();
        setClink();
        new ApiChapTruyen( this,truyenTranh.getId() ).execute(  );
    }
    private void init(){
        Bundle b = getIntent().getBundleExtra( "data" );
        truyenTranh=(TruyenTranh) b.getSerializable( "truyen" );

        //Tao du lieu ao
        arrChap=new ArrayList<>(  );
      /* for (int i=0; i<1000;i++){
            arrChap.add( new ChapTruyen( "Chapter"+i,"07-12-2019" ) );
        }
        chapTruyenAdapter = new ChapTruyenAdapter( this,0,arrChap );*/
    }
    private void anhXa(){
        imgAnhTruyens = findViewById( R.id.imgAnhTruyens );
        txvTenTruyens = findViewById( R.id.txvTenTruyens );
        lsvDanhSachChap = findViewById( R.id.lsvDanhSachChap );
    }
    private void setUp(){
        txvTenTruyens.setText( truyenTranh.getTenTruyen() );
        Glide.with(this).load(truyenTranh.getLinkAnh()).into(imgAnhTruyens);
       // lsvDanhSachChap.setAdapter( chapTruyenAdapter );
    }
    private void setClink(){
        lsvDanhSachChap.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Bundle b = new Bundle(  );
               b.putString( "idChap",arrChap.get( i ).getId());
                Intent intent = new Intent( ChapActivity.this,DocTruyenActivity.class );
                intent.putExtra( "data",b );
                startActivity( intent );

            }
        } );
    }

    @Override
    public void batDau() {
        Toast.makeText( this,"Lay Chap Ve",Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void ketThuc(String data) {

            try {
                JSONArray array = new JSONArray( data );
                for (int i = 0; i < array.length(); i++) {
                    ChapTruyen chapTruyen = new ChapTruyen( array.getJSONObject( i ) );
                    arrChap.add( chapTruyen );
                }
                chapTruyenAdapter = new ChapTruyenAdapter( this, 0, arrChap );
                lsvDanhSachChap.setAdapter( chapTruyenAdapter );
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    @Override
    public void biLoi() {

    }
}
