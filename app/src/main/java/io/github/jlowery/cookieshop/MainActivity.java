package io.github.jlowery.cookieshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ListView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an onItemClickListener for the ListView to start CookieCategoryActivity
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            // implement the onItemClick method
            // on click, passes in the current listView, the View item that was clicked, its position in the Listview & its id
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                // if either is clicked, go to CookieCategoryActivity
                Intent intent = new Intent(MainActivity.this, CookieCategoryActivity.class);
                // if 'no', send message to show in activity
                if (position == 1) {
                    intent.putExtra("message", "Start your diet tomorrow! Eat cookies today!");
                }
                startActivity(intent);
            }
        };
        // add listener to the listview
        ListView listView = (ListView)findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
