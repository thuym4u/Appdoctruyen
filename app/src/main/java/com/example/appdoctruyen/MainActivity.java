package com.example.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.api.ApiLayTruyen;
import com.example.appdoctruyen.interfaces.LayTruyenVe;
import com.example.appdoctruyen.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    EditText edtTimKiem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClink();
        new ApiLayTruyen( this ).execute(  );
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
        adapter = new TruyenTranhAdapter(this,0,truyenTranhArrayList);
    }
    private void anhXa(){

        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById( R.id.edtTimKiem );
    }

    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }

    private void setClink(){
        edtTimKiem.addTextChangedListener( new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen( s );

            }
        } );
        gdvDSTruyen.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TruyenTranh truyenTranh = truyenTranhArrayList.get( i );
                Bundle b = new Bundle(  );
                b.putSerializable( "truyen",truyenTranh );
                Intent intent = new Intent( MainActivity.this,ChapActivity.class );
                intent.putExtra( "data",b );
                startActivity( intent );
            }
        } );
    }

    @Override
    public void batDau() {
        Toast.makeText( this, "Dang Lay Ve", Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenTranhArrayList.clear();
            JSONArray arr  = new JSONArray( data );
            for (int i = 0; i<arr.length();i++){
                JSONObject o = arr.getJSONObject( i );
                truyenTranhArrayList.add( new TruyenTranh( o ) );
            }
            adapter = new TruyenTranhAdapter(this,0,truyenTranhArrayList);
            gdvDSTruyen.setAdapter( adapter );
        }catch (JSONException e){

        }

    }

    @Override
    public void biLoi() {
        Toast.makeText( this,"Loi Ket Noi",Toast.LENGTH_SHORT ).show();

    }

    public void updata(View view) {
        new ApiLayTruyen( this ).execute(  );
    }
}
