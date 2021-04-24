package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView resultTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv=findViewById(R.id.result);
    }

    String LHS="";
    String operation="";


    public String calculate(String LHS,String operation,String RHS){

        double res=0.0;
        double DLHS= Double.parseDouble(LHS);
        double DRHS=Double.parseDouble(RHS);
        if(operation.equals("+")){
            res = DLHS + DRHS;
        }else if(operation.equals("-")){
            res = DLHS - DRHS;
        }else if (operation.equals("*")){
            res = DLHS * DRHS;
        }else if(operation.equals("/")){
            res = DLHS / DRHS;
        }
        return res + "";

    }

    public void onDigitClick(View view) {
        Button button= ((Button) view);
        String btnTxt = button.getText().toString();
        resultTv.append(btnTxt);
    }

    public void onOperatorClick(View view) {
        Button operator= ((Button) view);
        if(operation.isEmpty()){
            LHS = resultTv.getText().toString();
            resultTv.setText("");
            operation=operator.getText().toString();
        } else  {
            String RHS = resultTv.getText().toString();
            LHS = calculate(LHS,operation,RHS);
            operation= operator.getText().toString();
            resultTv.setText("");

        }
    }

    public void onEuqalClick(View view) {
        String RHS = resultTv.getText().toString();
        String res= calculate(LHS,operation,RHS);
        LHS=res;
        operation="";
        resultTv.setText(res);
    }
}
