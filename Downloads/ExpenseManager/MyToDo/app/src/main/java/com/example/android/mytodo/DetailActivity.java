package com.example.android.mytodo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.id;

public class DetailActivity extends AppCompatActivity {
    EditText ed1;
    EditText ed2;
    int position;


    public static final int RESULT_SAVE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        ToDoOpenHelper openHelper = new ToDoOpenHelper(getApplicationContext());
        SQLiteDatabase db = openHelper.getReadableDatabase();
        ed1 = (EditText) findViewById(R.id.EditedTitle);
        ed2 = (EditText) findViewById(R.id.editedDescription);

        long id   =  intent.getLongExtra(constatnts.KEY_ID,-1);
        if(id > -1){

            Cursor cursor = db.query(constatnts.ToDo_Table_name,null,
                    constatnts.ToDo_Id + " = ?",new String[]{id + ""}
                    ,null,null,null);

            if(cursor.moveToFirst()) {
                String title = cursor.getString(cursor.getColumnIndex(constatnts.ToDo_col_title));
                String desc = cursor.getString(cursor.getColumnIndex(constatnts.ToDo_col_desc));
                schedules sch = new schedules(title, desc, id);

                ed1.setText(sch.getTitle());
                ed2.setText(sch.getDescription());
                position = intent.getIntExtra(constatnts.KEY_POSITION,0);
            }}
        //schedules sch = (schedules)intent.getSerializableExtra(constatnts.KEY_SCHEDULE);



    }
    public void saveEdit(View view){
        String updatedTitle = ed1.getEditableText().toString();
        String updatedDesc = ed2.getEditableText().toString();

        ContentValues cv = new ContentValues();
        cv.put(constatnts.ToDo_col_title,updatedTitle);
        cv.put(constatnts.ToDo_col_desc,updatedDesc);

        ToDoOpenHelper openHelper = new ToDoOpenHelper(getApplicationContext());
        SQLiteDatabase db = openHelper.getReadableDatabase();
Intent intent =getIntent();
        long id   =  intent.getLongExtra(constatnts.KEY_ID,-1);
        db.update(constatnts.ToDo_Table_name,cv,constatnts.ToDo_Id + " = ?",new String[]{id + ""});
        Intent i = new Intent();

        i.putExtra(constatnts.KEY_POSITION,position);
        setResult(RESULT_SAVE,i);
        finish();


    }
}
