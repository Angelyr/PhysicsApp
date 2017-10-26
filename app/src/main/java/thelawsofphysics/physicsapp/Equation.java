package thelawsofphysics.physicsapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Equation extends AppCompatActivity {

    EditText substituteEquation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);

        Resources res = getResources();
        substituteEquation = (EditText) findViewById(R.id.substituteEquation);
        if(getIntent().hasExtra("substitute")) {
            String equation = getIntent().getExtras().getString("substitute");
            substituteEquation.setText(equation);
        }
    }
}
