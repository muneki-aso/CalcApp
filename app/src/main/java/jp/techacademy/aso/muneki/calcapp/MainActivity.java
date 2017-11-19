package jp.techacademy.aso.muneki.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        String str;
        double value1 = 0;
        double value2 = 0;
        str = mEditText1.getText().toString();
        value1 = Double.parseDouble(str);
        try{
            value1 = "" || value1 = "." || value2 = "" || value2 = ".";
        }
        catch (Exception e){
            Toast toast = Toast.makeText(this, "数値を入れてください。", Toast.LENGTH_LONG);
            toast.show();
        }

        str = mEditText2.getText().toString();
        value2 = Double.parseDouble(str);
        try{
            value2 = 0;
        }
        catch (Exception e){
            Toast toast = Toast.makeText(this, "0で割ると余りは0です。", Toast.LENGTH_LONG);
            toast.show();
        }

        double result = 0;

        if (v.getId() == R.id.button1) {
            result = (value1 + value2);
        } else if (v.getId() == R.id.button2) {
            result = (value1 - value2);
        } else if (v.getId() == R.id.button3) {
            result = (value1 * value2);
        } else {
            result = (value1 / value2);
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }
}
