package com.example.ashutosh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button correct, incorrect, next;
    TextView textView;

    Random random = new Random();
    int random_num;

    public static boolean pr(int n) {
        int m=n/2;
        for(int i=2;i<=m;i++){
            if(n%i==0){
               return false;
            }
        }
         return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        correct = (Button) findViewById(R.id.correct);
        incorrect = (Button) findViewById(R.id.incorrect);

        next = (Button) findViewById(R.id.next);
        random_num = random.nextInt(1000 - 1) + 1;
        textView.setText("" + random_num);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random_num = random.nextInt(1000 - 1) + 1;
                textView.setText("" + random_num);
            }
        });

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pr(random_num)==true){
                    Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_LONG).show();
                }
            }
        });

        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pr(random_num)==false){
                    Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "InCorrect Ans", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
