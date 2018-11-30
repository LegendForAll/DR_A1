package com.example.hothaingoc.recyclerview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Nguyen_toactivity extends AppCompatActivity {

    TextView tenNTF;
    SQLiteDatabase sqLiteDatabase;
    final String DATABASE_NAME = "nguyento.sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_toactivity);

        initView();
        initUI();
    }

    private void initUI() {
        Intent intent = getIntent();
        String tenF = intent.getStringExtra("TEN");
        sqLiteDatabase = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUYENTO WHERE NAME_NT = ? ",new String[]{tenF});
        cursor.moveToFirst();
        String tenFD = cursor.getString(1);

        tenNTF.setText(tenFD);
    }

    private void initView() {
        tenNTF = (TextView) findViewById(R.id.txt_tenNT);
    }
}
