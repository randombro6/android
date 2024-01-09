package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    static String dbname="comp";
    static String tbname = "employ";
    static int dbversion =1;

    public dbhelper( Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname,null, dbversion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tbname+"(uname VARCHAR(10),passw VARCHAR(10))"+";");
    }


    public void adduser(String name, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO " + tbname + " (uname, passw) VALUES ('" + name + "', '" + pass + "')";

        db.execSQL(query);
        db.close();
    }


    public void update(String name, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+tbname+" SET passw='"+pass+"' "+" WHERE uname='"+name+"'");
        db.close();
    }
    public void delete(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + tbname + " WHERE uname='" + name+"'");
        db.close();
    }
    public String display(Context ctx){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tbname,null);
        String finalres = " ";
        while(cursor.moveToNext()) {
            finalres += cursor.getString(0) + ":" + cursor.getString(1);
        }
        return finalres;
    }
}


















public class MainActivity extends AppCompatActivity {
    EditText uname,pass;
    TextView txt;
    Button ins,del,dis,upd;
    dbhelper helper;
    private static final String dbname="comp";
    private static final String tbname = "employ";
    private static final int dbversion =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
        ins=findViewById(R.id.ins);
        del=findViewById(R.id.del);
        dis=findViewById(R.id.dis);
        upd=findViewById(R.id.upd);
        txt=findViewById(R.id.txt);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new dbhelper(MainActivity.this,dbname,null,dbversion);
                helper.addUser(uname.getText().toString(),pass.getText().toString());
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new dbhelper(MainActivity.this,dbname,null,dbversion);
                helper.delete(uname.getText().toString());
            }
        });
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new dbhelper(MainActivity.this,dbname,null,dbversion);
                helper.update(uname.getText().toString(),pass.getText().toString());
            }
        });
        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper=new dbhelper(MainActivity.this,dbname,null,dbversion);
                String res= helper.display();
                txt.setText(res);
            }
        });
    }
}
