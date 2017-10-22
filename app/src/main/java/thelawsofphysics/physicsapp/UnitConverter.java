package thelawsofphysics.physicsapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by yanlinzhu on 10/15/17.
 */

public class UnitConverter extends Activity {

    EditText unit0;
    EditText unit1;
    EditText expression;
    EditText result;
    String lengthUnits[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);
        unit0 = (EditText)findViewById(R.id.editUnit0);
        unit1 = (EditText)findViewById(R.id.editUnit1);
        expression = (EditText)findViewById(R.id.editExpression);
        result = (EditText)findViewById(R.id.convertresult);

        lengthUnits = getResources().getStringArray(R.array.lengthUnits);
    }

    public void convert(View v) {
        double value = new Double(expression.getText().toString());

        result.setText("Result: " + new Double(value).toString() + " " + unit1.getText().toString());
    }
}
