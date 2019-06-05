package com.example.modularcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_Base, et_Exp, et_ModValue;
    private TextView tv_Answer;
    private Button btn_Calculate;
    private int base, exp, mod;
    private int [] binaryValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignedVariables();

        calculate();

    }

    private void calculate(){

        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput(et_Base.getText().toString(), et_Exp.getText().toString(), et_ModValue.getText().toString())){

                    BinaryGenrator binaryGenrator = new BinaryGenrator();
                    binaryValue = binaryGenrator.getBinaryValue(exp);
                    int answer = squareAndMultiply(0, base, mod, 1, binaryValue, binaryValue.length);
                    tv_Answer.setTextColor(Color.BLACK);
                    tv_Answer.setText(Integer.toString(answer));
                }else{
                    tv_Answer.setTextColor(Color.RED);
                    tv_Answer.setText("Please Check Your Input");
                }
            }

        });
    }

    private boolean validateInput(String base, String exp, String mod) {

        try {

            this.base = Integer.parseInt(base.trim());
            this.exp = Integer.parseInt(exp.trim());
            this.mod = Integer.parseInt(mod.trim());

        }catch (Exception e) {

            return false;
        }
        return true;
    }

    private int squareAndMultiply(int counter, int base, int mod, int r, int[] binaryValue, int n){

        if(counter < n){
            r = (r*r)%mod;

            if(binaryValue[counter] == 1)
                r=(r*base)%mod;

            counter++;
            return squareAndMultiply(counter, base, mod, r, binaryValue, n);
        }

        return r;
    }

    private void assignedVariables() {
        et_Base = findViewById(R.id.etBase);
        et_Exp = findViewById(R.id.etExponent);
        et_ModValue = findViewById(R.id.etModVal);
        btn_Calculate = findViewById(R.id.btnCalculate);
        tv_Answer = findViewById(R.id.tvAnswer);
    }
}