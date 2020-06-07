package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText etUsername;
    EditText etPassword;
    ViewPager vp;
    ImageAdapter ia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn_submit);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);

        ///////////////////////////////////////////////////////////
        vp=findViewById(R.id.view_pager);
        ia=new ImageAdapter(this);
        vp.setAdapter(ia);

        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                vp.postOnAnimation(new Runnable() {
                    @Override
                    public void run() {
                        vp.setCurrentItem((vp.getCurrentItem() + 1) % ia.getCount(),true);
                    }
                });
            }
        };

        Timer t= new Timer();
        t.schedule(timerTask,0,2000);

        ///////////////////////////////////////////////////////////
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                moveIntent();
                Button b=findViewById(R.id.bt);
                b.setBackgroundColor(Color.RED);
                b.setText("merah sekali");
            }
        });

    }

    private void moveIntent(){
        Intent intent= new Intent(this, ProfileActivity.class);

        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();

        intent.putExtra("username",username);
        intent.putExtra("password",password);

        startActivity(intent);
    }

}
