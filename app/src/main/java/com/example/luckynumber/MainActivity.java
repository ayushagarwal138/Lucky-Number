package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    ImageView image_view;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edit_text);
        btn=findViewById(R.id.mybtn);
        image_view=findViewById(R.id.imageview);
        text=findViewById(R.id.textView);
        btn.setOnClickListener(view -> {
            String username=editText.getText().toString();

            Intent i=new Intent(
                    getApplicationContext(),
                    SecondActivity.class
            );
                    i.putExtra("name",username);
                    startActivity(i);
        });
    }
}