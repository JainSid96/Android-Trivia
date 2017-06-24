package com.example.siddhantjain.trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;
        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangle(){
            int x=1;
            int triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber = triangularNumber +x;
            }
            if (triangularNumber == number){
                return true;
            }else{
                return false;
            }
        }
    }

    public void click(View view){

        String message = "";
        EditText t1 = (EditText) findViewById(R.id.t1);

        if (t1.getText().toString().isEmpty()){
            message = "Please enter a number";
        }else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(t1.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangle()) {
                    message = myNumber.number + " is both triangular and square !";
                } else {
                    message = myNumber.number + " is square";
                }
            } else {
                if (myNumber.isTriangle()) {
                    message = myNumber.number + " is triangular!";
                } else {
                    message = myNumber.number + " is nothing";
                }

            }
        }
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
