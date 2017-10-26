package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
//import java.util.List;

public class MainScreen extends AppCompatActivity {

    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        final Resources res = getResources();
        //when equations button is clicked creates list of equations
        Button equationsBtn = (Button)findViewById(R.id.equationsBtn);
        equationsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.equations);
                startIntent.putExtra("display",list);
                startActivity(startIntent);
            }
        });
        //when variables button is pressed creates list of variables
        Button variablesBtn = (Button)findViewById(R.id.variablesBtn);
        variablesBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.variables);
                startIntent.putExtra("display", list);
                startActivity(startIntent);
            }
        });
        //when constants button is pressed creates list of constants
        Button constantsBtn = (Button)findViewById(R.id.constantsBtn);
        constantsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.constants);
                startIntent.putExtra("display", list);
                startActivity(startIntent);
            }
        });

        Button converterBtn = (Button)findViewById(R.id.converterBtn);
        converterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), UnitConverter.class);
                startActivity(startIntent);
            }
        });

        Button calculatorBtn = (Button)findViewById(R.id.calculatorBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CalculatorScreen.class);
                startActivity(startIntent);
            }
        });

        //When finds equations when search bar is done
        EditText searchBar = (EditText)findViewById(R.id.searchBar);
        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String input = v.getText().toString();
                    java.util.List<String> searchResults = new ArrayList<>();
                    String[] equations = res.getStringArray(R.array.equations);
                    for (String equation : equations) {
                        if (equation.contains(input)) {
                            searchResults.add(equation);
                        }
                    }
                    String[] result = new String[searchResults.size()];
                    result = searchResults.toArray(result);
                    Intent startIntent = new Intent(getApplicationContext(), List.class);
                    startIntent.putExtra("display", result);
                    startActivity(startIntent);
                    return true;
                }
                return false;
            }
        });
    }
}
