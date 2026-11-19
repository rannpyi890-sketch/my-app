package com.example.milsanddegree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final double SCALE_MILS = 6000.0;
    private static final double FULL_CIRCLE_DEG = 360.0;

    private EditText etInput;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);

        Button btnMilsToDeg = findViewById(R.id.btnMilsToDeg);
        Button btnDegToMils = findViewById(R.id.btnDegToMils);

        btnMilsToDeg.setOnClickListener(v -> {
            String text = etInput.getText().toString().trim();
            if (text.isEmpty()) {
                tvResult.setText("Mils ဂဏန်း ထည့်ပါ");
                return;
            }
            try {
                double mils = Double.parseDouble(text);
                double deg = mils * (FULL_CIRCLE_DEG / SCALE_MILS);
                tvResult.setText(String.format("Degree: %.6f°", deg));
            } catch (NumberFormatException e) {
                tvResult.setText("ဂဏန်း မှန်ကန်စွာ ထည့်ပါ");
            }
        });

        btnDegToMils.setOnClickListener(v -> {
            String text = etInput.getText().toString().trim();
            if (text.isEmpty()) {
                tvResult.setText("Degree ဂဏန်း ထည့်ပါ");
                return;
            }
            try {
                double deg = Double.parseDouble(text);
                double mils = deg * (SCALE_MILS / FULL_CIRCLE_DEG);
                tvResult.setText(String.format("Mils (6000): %.6f", mils));
            } catch (NumberFormatException e) {
                tvResult.setText("ဂဏန်း မှန်ကန်စွာ ထည့်ပါ");
            }
        });
    }
}
