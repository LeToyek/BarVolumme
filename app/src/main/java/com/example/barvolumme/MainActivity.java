package com.example.barvolumme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editWidth;
    private EditText editLength;
    private EditText editHeight;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWidth = findViewById(R.id.edt_width);
        editLength = findViewById(R.id.edt_length);
        editHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT,tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_calculate){
            String inputWidth = editWidth.getText().toString().trim();
            String inputLength = editLength.getText().toString().trim();
            String inputHeight = editHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                editLength.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                editWidth.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                editWidth.setError("Field ini tidak boleh kosong");
            }
            if(!isEmptyFields){
                Double volume = Double.parseDouble(inputHeight)*Double.parseDouble(inputLength)*Double.parseDouble(inputWidth);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}