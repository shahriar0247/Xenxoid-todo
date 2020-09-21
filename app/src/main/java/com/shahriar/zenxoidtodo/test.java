package com.shahriar.zenxoidtodo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class test extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ConstraintLayout cl1 = findViewById(R.id.cl);
        ConstraintLayout cl2 = new ConstraintLayout(this);
        cl2.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT));
        cl2.setBackgroundColor(Color.rgb(22,22,22));
        cl1.addView(cl2);
        cl2.setId(View.generateViewId());

        EditText tv1 = new EditText(this);
        tv1.setText("hello");
        tv1.setTextColor(Color.rgb(255,255,255));
        tv1.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,ConstraintLayout.LayoutParams.WRAP_CONTENT));
        tv1.setId(View.generateViewId());


        cl2.addView(tv1);

        ConstraintSet cs1 = new ConstraintSet();
        cs1.clone(cl2);
        cs1.connect(tv1.getId(),ConstraintSet.TOP,cl2.getId(),ConstraintSet.TOP,100);
        cs1.connect(tv1.getId(),ConstraintSet.LEFT,cl2.getId(),ConstraintSet.LEFT,100);
        cs1.connect(tv1.getId(),ConstraintSet.RIGHT,cl2.getId(),ConstraintSet.RIGHT,400);
        cs1.applyTo(cl2);






    }
}
