package io.github.jlowery.cookieshop;


import android.media.Image;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.app.Activity;
import android.widget.ListView;

import io.github.jlowery.cookieshop.R;


public class CookieFragment extends Fragment {

    private long cookie_id;

    // add the itemClicked method to implement & a listener
    static interface CookieListListener {
        void itemClicked(long id);
    }

    private CookieListListener listener;


    public CookieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // restore state when rotated
        if (savedInstanceState != null) {
            cookie_id = savedInstanceState.getInt("cookie_id");
        }
        // this tells Android which layout the fragment uses
        return inflater.inflate(R.layout.fragment_cookie, container, false);
    }


    // set listener here
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (CookieListListener)context;
    }


    // set view's values in onStart()
    @Override
    public void onStart() {
        super.onStart();
        View view = getView(); // get Fragment's root view so we can get references to its textViews - Fragments aren't Activities so don't have findViewById method
        if (view != null) {
            // display cookie name & description in its TextViews
            Cookie cookie = Cookie.cookies[(int)cookie_id];
            ImageView imgView = (ImageView)view.findViewById(R.id.cookie_img);
            imgView.setImageResource(cookie.getImageId());
            TextView name = (TextView)view.findViewById(R.id.cookie_name);
            name.setText(cookie.getCookieName());
            TextView description = (TextView) view.findViewById(R.id.cookie_description);
            description.setText(cookie.getDescription());
        }
    }


    // save cookie_id so we can restore the current cookie when rotated
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cookie_id", (int)cookie_id);
    }

    public void setCookie(long id) {
        this.cookie_id = id;
    }
}
