package thelawsofphysics.physicsapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
/**
 * Created by h1aih on 2017/11/23.
 */
//uses ratpoly to calculate derivative of the expression
public class DerivativeCalculator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivativecalculator);
        Button dxbtn= (Button) findViewById(R.id.Derivativebutton);
        //on click event for derivative button
        dxbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText expressiontext= (EditText) (findViewById(R.id.PolyEditText));
                String expression= expressiontext.getText().toString();
                TextView resultTextview = (TextView) findViewById(R.id.dresultTextView);
                RatPoly poly=RatPoly.valueOf(expression);
                String result= poly.differentiate().toString();
                resultTextview.setText(result);
            }
        });
        Button inbtn= (Button) findViewById(R.id.Integralbutton);
        inbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText expressiontext= (EditText) (findViewById(R.id.PolyEditText));
                String expression= expressiontext.getText().toString();
                TextView resultTextview = (TextView) findViewById(R.id.dresultTextView);
                RatPoly poly=RatPoly.valueOf(expression);
                String result= poly.antiDifferentiate(RatNum.ZERO).toString();
                resultTextview.setText(result);
            }
        });
    }
}
