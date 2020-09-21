package com.shahriar.zenxoidtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_todo extends AppCompatActivity {

    public EditText todo_titletext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_todo);

        String todo_text1 = getIntent().getStringExtra("todo_text1");

        todo_titletext1 = findViewById(R.id.todo_titletext1);

        todo_titletext1.setText(todo_text1);


    }


}
