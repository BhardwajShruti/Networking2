package com.example.android.mytodo;

import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import static com.example.android.mytodo.DetailActivity.RESULT_SAVE;

public class AddActivity extends AppCompatActivity {
EditText ed1,ed2;
  //  int position;
    public static final  int RESULT_SAVE=20;
    int hrs = 0;
    int mins = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent intent = getIntent();
     //   schedules sch = (schedules)intent.getSerializableExtra(constatnts.KEY_SCHEDULE);
        ed1 = (EditText) findViewById(R.id.EditedTitle);
        ed2 = (EditText) findViewById(R.id.editedDescription);

//        position = intent.getIntExtra(constatnts.KEY_POSITION,0);


    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
TimePickerFragment tp = new TimePickerFragment();


    }
    public void saveEdit(View view){
        String updatedTitle = ed1.getEditableText().toString();
        String updatedDesc = ed2.getEditableText().toString();
        Calendar calendar = Calendar.getInstance();
        hrs = calendar.get(Calendar.HOUR_OF_DAY);
        mins = calendar.get(Calendar.MINUTE);
        Toast.makeText(this, "hrs:"+hrs+"mins"+mins, Toast.LENGTH_SHORT).show();
        ToDoOpenHelper openHelper = new ToDoOpenHelper(getApplicationContext());

        SQLiteDatabase db = openHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(constatnts.ToDo_col_title,updatedTitle);
        cv.put(constatnts.ToDo_col_desc,updatedDesc);

      //  db.insert(constatnts.ToDo_Table_name,null,cv);

//NotificationCompat.Builder nb =  new NotificationCompat.Builder(this);




        long id = db.insert(constatnts.ToDo_Table_name,null,cv);



//        Expense expense = new Expense(titleText,amount);
        Intent result = new Intent();
        result.putExtra(constatnts.ToDo_Id,id);

        setResult(RESULT_SAVE, result);
        finish();

      //  NotificationCompat.Builder nb =new NotificationCompat().Builder(Context);
//        Intent i = new Intent();
//        i.putExtra(constatnts.KEY_TITLE,updatedTitle);
//        i.putExtra(constatnts.KEY_DISC,updatedDesc);
//        i.putExtra(constatnts.KEY_POSITION,position);
//        setResult(RESULT_SAVE,i);
//        finish();


    }
}

