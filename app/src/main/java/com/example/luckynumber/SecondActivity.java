package com.example.luckynumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcmtext,luckytext;
    Button sharebtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcmtext=findViewById(R.id.textview2);
        luckytext=findViewById(R.id.lucky_number_txt);
        sharebtn=findViewById(R.id.share_btn);

        Intent i=getIntent();
        String username=i.getStringExtra("name");
       int random_num=genrateRandomNumber();
       luckytext.setText(""+random_num);
       sharebtn.setOnClickListener(view -> ShareData(username , random_num));

    }

    public int genrateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        return random.nextInt(upper_limit);
    }
    public void ShareData(String userName,int randomNum)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is : "+randomNum);
        startActivity(Intent.createChooser(i,"choose a platform"));
    }
}