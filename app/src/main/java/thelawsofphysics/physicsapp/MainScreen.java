package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
                list = res.getStringArray(R.array.mechanicsEquations);
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
                list = res.getStringArray(R.array.CommonConstants);
                startIntent.putExtra("display", list);
                startActivity(startIntent);
            }
        });
    }
}
