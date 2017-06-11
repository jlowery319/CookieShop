package io.github.jlowery.cookieshop;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.app.Fragment;

import org.w3c.dom.Text;

public class CookieCategoryActivity extends Activity implements CookieFragment.CookieListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_category);

        // get message from Intent & display in TextView
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(message);

        // display cookie option list
        // must use ArrayAdapter since data is not in strings.xml
        ArrayAdapter<Cookie> listAdapter = new ArrayAdapter<Cookie>(
                this, android.R.layout.simple_list_item_1, Cookie.cookies);
        // add adapter to the listview
        ListView listView = (ListView) findViewById(R.id.cookie_list);
        listView.setAdapter(listAdapter);

        // call implemented itemClicked method when an item is clicked
        // create Listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View v, int position, long id){
                // call itemClicked
                itemClicked(id);
            }
        };
        listView.setOnItemClickListener(itemClickListener);

        }

    @Override
    public void itemClicked(long id) {
        // implement itemClicked from Fragment -- use FrameLayout for changing fragments
        // must use transaction with FrameLayout
        CookieFragment frag = new CookieFragment(); // create new fragment to add/replace
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        frag.setCookie(id);
        ft.replace(R.id.fragment_container, frag);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
