package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hw1.models.Operation;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private String firstNum = "";
    private String secondNum = "";
    private String charOperetion = "";
    private boolean flagNum = false;
    private boolean flagPoint = false;

    private Operation operation = new Operation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


    }

    public void onBtnClick(View view)
    {
        Button btn = (Button) view;
        String num = (String) btn.getText();
        String str = (String) textView.getText();
        str += num;

        if (charOperetion != null && secondNum == "")
        {
            flagPoint = false;
            textView.setText("");
        }

        if (!flagNum && !flagPoint)
        {
            if (firstNum == "")
            {
                textView.setText(num);
                firstNum = (String) textView.getText();
            }
            else
            {
                textView.setText("");
                textView.setText(num);
                secondNum = (String) textView.getText();
            }
            flagNum = true;
        }
        else
        {
            if (charOperetion == "")
            {
                textView.setText(str);
                firstNum = (String) textView.getText();

            }
            else
            {
                textView.setText(str);
                secondNum = (String) textView.getText();
            }
        }


    }

    public void onBtnOperationClick(View view)
    {
        flagPoint = true;


        if (charOperetion == "")
        {
            if (firstNum == null) firstNum = "0";

            Button btn = (Button) view;
            String tmp = (String) btn.getText();

            charOperetion = tmp;
            flagNum = false;

            textView.setText(charOperetion);
        }

    }

    public void onBtnClearClick(View view)
    {
        flagNum = false;
        flagPoint = false;
        textView.setText("0");
        charOperetion = "";
        firstNum = "";
        secondNum = "";

    }

    public void onBtnPointClick(View view)
    {
        if (!flagPoint)
        {
            Button btn = (Button) view;
            String point = (String) btn.getText();
            String str = (String) textView.getText();
            str += point;

            textView.setText(str);

            flagPoint = true;
        }
    }

    public void  onBtnEqualClick(View view)
    {
        double num1 = new Double(firstNum);

        double num2 = new Double(secondNum);


//        if (num1 && num2)
//        {
//
//        }

        switch (charOperetion)
        {
            case "+":
            {
                String res = operation.addition(num1, num2);
                textView.setText(res);
                break;
            }
            case "-":
            {
                String res = operation.subtraction(num1, num2);
                textView.setText(res);
                break;
            }
            case "*":
            {
                String res = operation.multiplication(num1, num2);
                textView.setText(res);
                break;
            }
            case "/":
            {
                String res = operation.division(num1, num2);
                textView.setText(res);
                break;
            }
            default:
                break;
        }

        flagNum = false;
        flagPoint = false;
    }

}