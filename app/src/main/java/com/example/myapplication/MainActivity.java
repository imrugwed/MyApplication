package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    EditText name,day,month,year,email;
    Button submit;
    DBHandler DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit= findViewById(R.id.submit);
        name= findViewById(R.id.name);
        day= findViewById(R.id.day);
        month= findViewById(R.id.month);
        year= findViewById(R.id.year);
        email= findViewById(R.id.email);
        DB =new DBHandler(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String d=day.getText().toString();
                String m=month.getText().toString();
                String y=year.getText().toString();
                String e=email.getText().toString();
                if (n.equals("") || d.equals("") || m.equals("")|| y.equals("")|| e.equals("")){
                    Toast.makeText(MainActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Details entered", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Activity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}