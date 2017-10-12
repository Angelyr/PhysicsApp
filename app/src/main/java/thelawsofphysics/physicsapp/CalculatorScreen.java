package thelawsofphysics.physicsapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


/**
 * Created by h1aih on 2017/10/5.
 * Screen for calculator
 */

public class CalculatorScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_screen);
        Button addbtn= (Button) findViewById(R.id.AddButton);
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result= num1 + num2;
                resultTextview.setText(result+"");
            }
        });

        Button minusbtn= (Button) findViewById(R.id.MinusBotton);
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result= num1 - num2;
                resultTextview.setText(result+"");
            }
        });

        Button mulbtn= (Button) findViewById(R.id.MultiBotton);
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result= num1 * num2;
                resultTextview.setText(result+"");
            }
        });
        Button divbtn= (Button) findViewById(R.id.DivideButton);
        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result= num1 / num2;
                resultTextview.setText(result+"");
            }
        });
    }
}
