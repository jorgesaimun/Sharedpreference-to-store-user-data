package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;

    Button saveBtn, resetBtn, showDataBtn;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.userNameId);
        editText2 = findViewById(R.id.passwordId);

        saveBtn = findViewById(R.id.saveBtnId);
        resetBtn = findViewById(R.id.resetBtnId);
        showDataBtn = findViewById(R.id.showBtnId);
        showText = findViewById(R.id.showDataTextId);

        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
//
//                String userName = editText1.getText().toString();
//                String pass = editText2.getText().toString();
//                showText.setText("User Name :" + userName + "\n Password :" + pass);

                if (sharedPreferences.contains("userName") && sharedPreferences.contains("password")) {
                    String userName = sharedPreferences.getString("userName", "null");
                    String pass = sharedPreferences.getString("password", "null");
                    showText.setText("User Name :" + userName + "\n Password :" + pass);
                }

            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText1.getText().toString();
                String pass = editText2.getText().toString();
                // writing data
//                if (userName.equals("")|| pass.equals("")) {
//                    Toast.makeText(MainActivity.this, "Please enter data ", Toast.LENGTH_SHORT).show();
//
//                } else {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName", userName);
                editor.putString("password", pass);
                editor.commit();

                Toast.makeText(MainActivity.this, "Data is saved successfully", Toast.LENGTH_SHORT).show();
                // }

            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reset Data ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}