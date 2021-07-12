package com.example.customizedkeyboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*private Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;*/
    private Button buttonC;
    private TextView editable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDivision = (Button) findViewById(R.id.buttonDiv);

        buttonEqual = (Button) findViewById(R.id.buttonEql);*/
        buttonC = (Button) findViewById(R.id.buttonC);
        editable = (TextView) findViewById(R.id.editable);
        buttonC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setEmpty();
                return true;
            }
        });
    }

    private void changeText(String text){
        editable.setText(editable.getText().toString()+text);
        if(editable.getLineCount()==2)
            backSpace();
    }
    private void setEmpty(){
        editable.setText("");
    }
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void backSpace(){
        String text=editable.getText().toString();
        if(!text.isEmpty()) {
            if(text.charAt(text.length()-1)=='\uDE02'){
                editable.setText(text.substring(0, text.length() - 2));
            }
            else
                editable.setText(text.substring(0, text.length() - 1));
        }
    }

    public void setButton(View v){
        switch (v.getId()){
            case R.id.button0:
                changeText("0");
                break;
            case R.id.button1:
                changeText("1");
                break;
            case R.id.button2:
                changeText("2");
                break;
            case R.id.button3:
                changeText("3");
                break;
            case R.id.button4:
                changeText("4");
                break;
            case R.id.button5:
                changeText("5");
                break;
            case R.id.button6:
                changeText("6");
                break;
            case R.id.button7:
                changeText("7");
                break;
            case R.id.button8:
                changeText("8");
                break;
            case R.id.button9:
                changeText("9");
                break;
            case R.id.button10:
                changeText(".");
                break;
            case R.id.buttonEql:
                changeText("\uD83D\uDE02");
                break;
            case R.id.buttonAdd:
                changeText("+");
                break;
            case R.id.buttonSub:
                changeText("-");
                break;
            case R.id.buttonMul:
                changeText("x");
                break;
            case R.id.buttonDiv:
                changeText("÷");
                break;
            case R.id.buttonC:
                backSpace();
                break;
        }
    }
}