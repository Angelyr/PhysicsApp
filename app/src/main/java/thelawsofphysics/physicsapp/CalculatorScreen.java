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
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result= num1 + num2;
                resultTextview.setText(result+"");
            }
        });

        Button minusbtn= (Button) findViewById(R.id.MinusBotton);
        minusbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result= num1 - num2;
                resultTextview.setText(result+"");
            }
        });

        Button mulbtn= (Button) findViewById(R.id.MultiBotton);
        mulbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result= num1 * num2;
                resultTextview.setText(result+"");
            }
        });
        Button divbtn= (Button) findViewById(R.id.DivideButton);
        divbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result= num1 / num2;
                resultTextview.setText(result+"");

            }
        });
        Button pwrbtn= (Button) findViewById(R.id.PowerButton);
        pwrbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.pow(num1,num2);
                resultTextview.setText(result+"");

            }
        });
        Button logbtn= (Button) findViewById(R.id.LogButton);
        logbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.log(num2)/Math.log(num1);
                resultTextview.setText(result+"");

            }
        });
        Button lnbtn= (Button) findViewById(R.id.LnButton);
        lnbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.log(num1);
                Double result2=Math.log(num2);
                resultTextview.setText("1st:"+String.format("%.2f", result)+" 2nd:"+String.format("%.2f", result2));

            }
        });
        Button sqrbtn= (Button) findViewById(R.id.SquarertButton);
        sqrbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.sqrt(num1);
                Double result2=Math.sqrt(num2);
                resultTextview.setText("1st:"+String.format("%.2f", result)+" 2nd:"+String.format("%.2f", result2));

            }
        });
        Button sinbtn= (Button) findViewById(R.id.SinButton);
        sinbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result= Math.sin(num1);
                Double result2=Math.sin(num2);
                resultTextview.setText("1st:"+String.format("%.2f", result)+" 2nd:"+String.format("%.2f", result2));

            }
        });
        Button cosbtn= (Button) findViewById(R.id.CosButton);
        cosbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.cos(num1);
                Double result2=Math.cos(num2);
                resultTextview.setText("1st:"+String.format("%.2f", result)+" 2nd:"+String.format("%.2f", result2));

            }
        });
        Button tanbtn= (Button) findViewById(R.id.TanButton);
        tanbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=Math.tan(num1);
                Double result2=Math.tan(num2);
                resultTextview.setText("1st:"+String.format("%.2f", result)+" 2nd:"+String.format("%.2f", result2));

            }
        });
        Button modbtn= (Button) findViewById(R.id.ModuloButton);
        modbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText= (EditText) findViewById(R.id.FirstNumEditText);
                EditText secondNumEditText= (EditText) findViewById(R.id.SecondNumEditText);
                TextView resultTextview = (TextView) findViewById(R.id.resultTextView);
                Double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                Double num2 = Double.parseDouble(secondNumEditText.getText().toString());
                Double result=num1%num2;
                resultTextview.setText(""+result);

            }
        });
    }
}