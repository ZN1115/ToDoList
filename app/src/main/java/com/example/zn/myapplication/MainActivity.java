package com.example.zn.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.andy);


        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=(int)(Math.random()* 99 + 101);
                int b=(int)(Math.random()* 99 + 101);
                int c=(int)(Math.random()* 99 + 101);
                textView.setTextColor(Color.rgb(a,b,c));

            }
        });

    }
}
