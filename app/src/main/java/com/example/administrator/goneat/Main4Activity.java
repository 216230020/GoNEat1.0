package com.example.administrator.goneat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    String dbName = "Example.db";
    int dbVersion = 1;
    DBHelper dbHelper;
    SQLiteDatabase db;
    String sql, data;
    EditText value;
    ListView Listview;
    ArrayList<String> Datas = new ArrayList<String>();
    ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        dbHelper = new DBHelper(this, dbName, null, dbVersion);
        db = dbHelper.getWritableDatabase();

        sql = "SELECT * FROM Example";
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor.getCount() > 0){
                while (cursor.moveToNext()){
                    Datas.add(cursor.getString(1));
                }
            }else{

            }
        }finally{
            cursor.close();
        }

        Button add = (Button)findViewById(R.id.add);
        Button go = (Button)findViewById(R.id.go);
        value = (EditText)findViewById(R.id.value);
        Listview = (ListView)findViewById(R.id.list1);

        if (!Datas.isEmpty()){
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Datas);
            Listview.setAdapter(Adapter);
        }

        View.OnClickListener buttonlistener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){

                    case R.id.add:

                        if (Datas.isEmpty()){
                            data = value.getText().toString();

                            sql = String.format("INSERT INTO Example VALUES(NULL, '%S');", data);
                            db.execSQL(sql);

                            Datas.add(data);
                            Adapter = new ArrayAdapter<String>(Main4Activity.this, android.R.layout.simple_list_item_1, Datas);
                            Listview.setAdapter(Adapter);
                        }else{
                            data = value.getText().toString();
                            sql = String.format("INSERT INTO Example VALUES(NULL, '%S');", data);
                            db.execSQL(sql);
                            Datas.add(data);

                            Adapter.notifyDataSetChanged();
                        }
                        break;

                    case R.id.go:
                        if (!Datas.isEmpty()){
                            sql = "SELECT * FROM Example;";
                            Cursor cs = db.rawQuery(sql, null);

                            int count = cs.getCount();

                            cs.moveToLast();
                            int lastid = cs.getInt(0);
                            sql = "DELETE FROM Example WHERE _id = " + lastid + ";";
                            db.execSQL(sql);

                            Datas.remove(count - 1);
                            Adapter.notifyDataSetChanged();

                            cs.close();
                        }
                        break;
                }
            }
        };

        add.setOnClickListener(buttonlistener);
        go.setOnClickListener(buttonlistener);
    }
    public void nextScene( View view ){
        Intent i = new Intent(this, Main7Activity.class);
        this.startActivity( i );
    }
}
