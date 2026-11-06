package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void showCount(View view){
        mCount++;
        mShowCount.setText(String.valueOf(mCount));
        Button countButton = findViewById(R.id.button_count);
        Button zeroButton = findViewById(R.id.button_zero);
        zeroButton.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255,152,0)));
        if (mCount % 2 == 1){
            countButton.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        }else {
            countButton.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));

        }
    }

    public void showZero(View view){
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        Button zeroButton = findViewById(R.id.button_zero);
        zeroButton.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));


    }

    public void showToast (View view){
        Toast.makeText(this,"Hello Toast" , Toast.LENGTH_SHORT).show();
    }

}
