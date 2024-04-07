package com.example.moviesapp.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static int version = 1;
    private static String name = "moviesapp";
    public Database(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);
        sqLiteDatabase.execSQL("CREATE TABLE MOVIES(ID INTEGER PRIMARY KEY AUTOINCREMENT, MOVIE_NAME TEXT, MOVIE_DESC TEXT, MOVIE_RATING TEXT, MOVIE_DUR TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERS");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DOCTOR");
        onCreate(sqLiteDatabase);
    }

    public void register(String username,String email,String password){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int login(String username,String password){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username = ? and password = ?",str);
        if(c.moveToFirst()){
            result = 1;
        }
        return result;
    }

    public void addMovie(String moviename,String desc,String rating, String dur){
        ContentValues cv = new ContentValues();
        cv.put("movname",moviename);
        cv.put("movdesc",desc);
        cv.put("movrating",rating);
        cv.put("movdur",dur);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("MOVIES",null,cv);
        db.close();
    }

    public Movies[] getMoviesDet(){
        Movies mov[] = new Movies[15];
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns={"ID","MOVIE_NAME","MOVIE_DESC","MOVIE_RATING","MOVIE_DUR"};
            String selection="";
            String[] selectionArgs = {};
            Cursor cursor = db.query("MOVIES",columns,selection,selectionArgs,null,null,null);
            System.out.println(cursor);
            int count = cursor.getCount();
            if(cursor!=null && cursor.getCount() !=0){
                int i = 0;
                while(cursor.moveToNext() && i < count){
                    mov[i] = new Movies();
                    //Need to fill
                }
            }


        }catch(Exception e){

        }
        return mov;
    }


}
