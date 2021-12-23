package com.example.calculatorraiyanabl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etFirstNum, etSecondNum;
    private Button btnAdd, btnMinus, btnMultiply, btnDivided;
    private TextView tvResults;
    private double result=0;
    private ArrayAdapter<String> resultsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInit();

        resultsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        ListView resultsListView = findViewById(R.id.resultsListView);
        resultsListView.setAdapter(resultsAdapter);
    }
    private void setInit(){
        etFirstNum = findViewById(R.id.et_first_number);
        etSecondNum = findViewById(R.id.et_second_number);
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivided = findViewById(R.id.btn_divided);
        tvResults = findViewById(R.id.tv_results);
        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivided.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (etFirstNum.getText().toString().isEmpty()){
            etFirstNum.setText("0");
        }
        if (etSecondNum.getText().toString().isEmpty()){
            etSecondNum.setText("0");
        }
        double firstNum = Double.parseDouble(etFirstNum.getText().toString());
        double secondNum = Double.parseDouble(etSecondNum.getText().toString());
        switch (view.getId()){
            case R.id.btn_add :
                result=add(firstNum, secondNum);
                break;
            case R.id.btn_minus :
                result=minus(firstNum, secondNum);
                break;
            case R.id.btn_multiply:
                result=multiply(firstNum, secondNum);
                break;
            case R.id.btn_divided:
                result=divided(firstNum, secondNum);
        }
        tvResults.setText(String.valueOf(result));
        CheckBox RecordResultCheckBox = findViewById(R.id.RecordResultCheckBox);

        if(RecordResultCheckBox.isChecked()) {
            resultsAdapter.add("Result: " + result);

        }
    }
    private double add(double firstNum, double secondNum){
        return firstNum + secondNum;
    }
    private double minus(double firstNum, double secondNum){
        return firstNum - secondNum;
    }
    private double multiply(double firstNum, double secondNum){
        return firstNum * secondNum;
    }
    private double divided(double firstNum, double secondNum){
        return firstNum / secondNum;
    }


}




