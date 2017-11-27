package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.List;

public class MainScreen extends AppCompatActivity {

    String[] list;
    String[] constantValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        final Resources res = getResources();
        constantValues=res.getStringArray(R.array.constantValuesMetric);
        //Menud here**************
        Toolbar mtoolbar= (Toolbar) findViewById(R.id.toolbarmenu);
        setSupportActionBar(mtoolbar);
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
                for(int i = 0; i < list.length; i++)
                {
                    list[i] += " = " + constantValues[i];
                }
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

        Button searchBtn = (Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SearchPage.class);
                startActivity(startIntent);
            }
        });

        Button problemBtn = (Button)findViewById(R.id.problemBtn);
        problemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ProblemSearch.class);
                startActivity(startIntent);
            }
        });

        Button favoriteBtn = (Button)findViewById(R.id.FavoriteBtn);
        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Favorite.class);
                startActivity(startIntent);
            }
        });

        Button recentlyBtn = (Button)findViewById(R.id.recentlyBtn);
        recentlyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                //read from input file into list
                try {
                    ArrayList<String> equations = new ArrayList<>();
                    String aEquation;
                    FileInputStream inputStream = openFileInput("Recent");
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while ((aEquation = bufferedReader.readLine())!=null)
                    {
                        equations.add(0, aEquation);
                    }
                    list = equations.toArray(new String[equations.size()]);
                    startIntent.putExtra("display", list);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //creates list
                startActivity(startIntent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mMenuInflater=getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        final Resources res = getResources();
        if (item.getItemId()==R.id.imperial){
            constantValues=res.getStringArray(R.array.constantValuesImperial);
        }
        if (item.getItemId()==R.id.metric){
            constantValues=res.getStringArray(R.array.constantValuesMetric);
        }
        return super.onOptionsItemSelected(item);
    }
}
