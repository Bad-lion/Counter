package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int number = 0;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = (TextView) findViewById(R.id.count);

        if (savedInstanceState != null){
            number= savedInstanceState.getInt("number");
            count.setText(savedInstanceState.getString("count"));
        }

    }

    public void plus(View view) {
        number = number + 1;
        display(number);

    }

    public void display(int num) {

        if (number >= 0 && number < 10) {
            count.setText(String.format("000%s", num));
        } else if (number >= 9 && number < 100) {
            count.setText(String.format("00%s", num));
        } else if (number > 99 && number < 1000) {
            count.setText(String.format("0%s", num));

        }else {
            count.setText(String.format("%s", num));
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count",count.getText().toString());
        outState.putInt("number", number);
    }
}