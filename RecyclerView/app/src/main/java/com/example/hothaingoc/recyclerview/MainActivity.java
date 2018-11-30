package com.example.hothaingoc.recyclerview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//AppCompatActivity
    final String DATABASE_NAME = "nguyento.sqlite";
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ArrayList<data_rec> arrayList;
    dataAdapter dataA;

    EditText editText_search;
    Button button_search, button_PTHH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        readData();
        findData();
        PTHHactivity();

    }

    private void PTHHactivity() {
        button_PTHH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PTHHActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findData() {
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String tenNT = String.valueOf(editText_search.getText());
                //Toast.makeText(MainActivity.this,tenNT, Toast.LENGTH_SHORT).show();
                readData();
            }
        });
    }

    private void readData() {
        sqLiteDatabase = Database.initDatabase(this,DATABASE_NAME);
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUYENTO",null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUYENTO WHERE NAME_NT = ?",new String[]{String.valueOf(editText_search.getText())});
        arrayList.clear();

        for (int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            arrayList.add(new data_rec(R.drawable.fire,ten,null));
        }

        dataA.notifyDataSetChanged();
    }

    public void initView()
    {


        editText_search =(EditText) findViewById(R.id.edt_search);
        button_search = (Button) findViewById(R.id.btn_search);
        button_PTHH = (Button) findViewById(R.id.btn_PTHH);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true); //toi uu data ko bi anh huong boi adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        //chen khoang cach vao trong recyclerView
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);

        //custom divider
        //DividerItemDecoration itemDecoration =new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        //Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        //itemDecoration.setDrawable(drawable);
        //recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setItemAnimator( new DefaultItemAnimator());
        arrayList = new ArrayList<>();
        //dataA = new dataAdapter(arrayList,getApplicationContext());
        dataA = new dataAdapter(arrayList,this);
        recyclerView.setAdapter(dataA);

        //arrayList.add(new data_rec(R.drawable.fire,"HTC"));
        //arrayList.add(new data_rec(R.drawable.fire,"HTC"));
        //arrayList.add(new data_rec(R.drawable.fire,"HTC"));
        //arrayList.add(new data_rec(R.drawable.fire,"HTC"));

        //do du lieu vao recyclerView

    }
}
