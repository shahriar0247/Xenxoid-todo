package com.shahriar.zenxoidtodo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    public int numberofitems;
    public int idstart = 10000;


    public LinearLayout ll1;
    public DatabaseHelper db;
    public Button add_item;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

       ll1 = findViewById(R.id.ll1);

       add_item = findViewById(R.id.add_item);
        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateItem("");
            }
        });


       /* if (db.get_all_item().getCount() > 0){
            int a = 0;
            while (a <= db.get_all_item().getCount()){
                a = a +1;
                CreateItem();
            }
        }*/



    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void CreateItem(String title){
        generateid("group");
        ConstraintLayout cl1 = new ConstraintLayout(this);
        cl1.setId(generateid("element"));
        cl1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        ll1.addView(cl1);

        Button btn1 = new Button(this);
        btn1.setText("Edit");
        btn1.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
        btn1.setId(generateid("element"));
        cl1.addView(btn1);

        final EditText et1 = new EditText(this);

        et1.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
        et1.setId(generateid("element"));
        cl1.addView(et1);

        CheckBox cb1 = new CheckBox(this);
        cb1.setText("");
        cb1.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
        cb1.setId(generateid("element"));
        cl1.addView(cb1);

        ConstraintSet cs1 = new ConstraintSet();
        cs1.clone(cl1);

        cs1.connect(cb1.getId(),ConstraintSet.LEFT,cl1.getId(), ConstraintSet.LEFT);
        cs1.connect(cb1.getId(),ConstraintSet.RIGHT,et1.getId(), ConstraintSet.LEFT);
        cs1.connect(et1.getId(),ConstraintSet.RIGHT,btn1.getId(),ConstraintSet.LEFT);
        cs1.connect(et1.getId(),ConstraintSet.LEFT,cb1.getId(),ConstraintSet.RIGHT);
        cs1.connect(btn1.getId(),ConstraintSet.LEFT,et1.getId(),ConstraintSet.RIGHT);
        cs1.connect(btn1.getId(),ConstraintSet.RIGHT,cl1.getId(),ConstraintSet.RIGHT);

        cs1.applyTo(cl1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert_title(et1.getText().toString());
                Intent intent = new Intent(getBaseContext(), Edit_todo.class);

                startActivity(intent);
            }
        });




    }

    public int generateid(String type){
        if (type == "element"){
            idstart = idstart +1;

        }
        else {
            idstart = idstart + 100;
        }
        Log.d("generated id type", "id = " + idstart);
        return  idstart;
    }

}
