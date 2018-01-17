package com.ngoxuanhuy.swipinglistview;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Display;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "swiping";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);

        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

        ArrayList<String> list = new ArrayList<>();
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");
        list.add("Ngo Xuan Huy");


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());

                // set item background to orange color
                openItem.setBackground(new ColorDrawable(Color.rgb(0xFF, 0xA2, 0x15)));

                // variable width equals phone screen width
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;

                // set item width
                openItem.setWidth(width/2);

                // create "call" item
                SwipeMenuItem callItem = new SwipeMenuItem(getApplicationContext());

                // set item background
                callItem.setBackground(new ColorDrawable(Color.rgb(0xFF, 0xA2, 0x15)));
                // set item width
                callItem.setWidth(width/2);

                // set a icon
                callItem.setIcon(R.drawable.call);


                // add to menu
                menu.addMenuItem(callItem);

                // create "msg" item
                SwipeMenuItem msgItem = new SwipeMenuItem(getApplicationContext());

                // set item background
                msgItem.setBackground(new ColorDrawable(Color.rgb(0xFF, 0xA2, 0x15)));
                // set item width
                msgItem.setWidth(width/2);

                // set a icon
                msgItem.setIcon(R.drawable.message);

                // add to menu
                menu.addMenuItem(msgItem);
            }
        };

        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Log.e(TAG, "onMenuItemClick: clicked item " + index);
                        //call();
                        break;
                    case 1:
                        Log.e(TAG, "onMenuItemClick: clicked item " + index);
                        //sendSMS();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }
}


