package thelawsofphysics.physicsapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class List extends AppCompatActivity {

    ListView listView;
    String[] displayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        listView = (ListView) findViewById(R.id.listView);

        //receives string array to display and sends it to list adapter
        if(getIntent().hasExtra("display")) {
            displayList = getIntent().getExtras().getStringArray("display");
            ListAdapter listAdapter = new ListAdapter(this, displayList);
            listView.setAdapter(listAdapter);
        }
    }
}
