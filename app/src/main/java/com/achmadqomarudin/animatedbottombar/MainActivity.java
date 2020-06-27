package com.achmadqomarudin.animatedbottombar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.achmadqomarudin.animatedbottombar.activities.Example1Activity;
import com.achmadqomarudin.animatedbottombar.activities.Example2Activity;
import com.achmadqomarudin.animatedbottombar.activities.Example3Activity;
import com.achmadqomarudin.animatedbottombar.activities.Example4Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_example1, btn_example2, btn_example3, btn_example4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_example1 = findViewById(R.id.btn_example1);
        btn_example2 = findViewById(R.id.btn_example2);
        btn_example3 = findViewById(R.id.btn_example3);
        btn_example4 = findViewById(R.id.btn_example4);

        btn_example1.setOnClickListener(this);
        btn_example2.setOnClickListener(this);
        btn_example3.setOnClickListener(this);
        btn_example4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_example1:
                startActivity(new Intent(MainActivity.this, Example1Activity.class));
                break;
            case R.id.btn_example2:
                startActivity(new Intent(MainActivity.this, Example2Activity.class));
                break;
            case R.id.btn_example3:
                startActivity(new Intent(MainActivity.this, Example3Activity.class));
                break;
            case R.id.btn_example4:
                startActivity(new Intent(MainActivity.this, Example4Activity.class));
                break;
        }
    }
}
