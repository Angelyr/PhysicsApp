package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class ProblemSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_search);

        //Takes user input then finds all variables used and sends them to search bar
        EditText input = (EditText)findViewById(R.id.problemInput);
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    Resources res = getResources();
                    String result="";
                    String problem = v.getText().toString();
                    String[] search = problem.split(" ");
                    String[] equations = res.getStringArray(R.array.equations_variables);
                    for(int i = 0; i < equations.length; i++)
                    {
                        String[] variables = equations[i].split(",");
                        for(int j = 0; j < variables.length; j++)
                        {
                            for(int k = 0; k < search.length; k++)
                            {
                                if(variables[j].equalsIgnoreCase(search[k]) && !result.contains(variables[j]))
                                {
                                    result += variables[j] + ",";
                                }
                            }
                        }
                    }
                    Intent startIntent = new Intent(getApplicationContext(), SearchPage.class);
                    startIntent.putExtra("search", result);
                    startActivity(startIntent);
                }

                return false;
            }
        });
    }
}
