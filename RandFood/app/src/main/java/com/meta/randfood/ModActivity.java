package com.meta.randfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;

import Data.Constants;
import Data.FoodData;
import Process.Mgr_Food;
import UIData.FoodItemAdapter;

public class ModActivity extends AppCompatActivity {

    private ListView lv_food;
    private FoodItemAdapter adapter;
    /*private Button btn_addfood;
    private EditText editText_food;
    private RatingBar ratingBar_food;*/

    // UI 註冊
    private void processView() {
        lv_food = (ListView) findViewById(R.id.lview_food);

        /*btn_addfood = (Button) findViewById(R.id.btn_add);
        editText_food = (EditText) findViewById(R.id.ediTxt_foodName);
        ratingBar_food = (RatingBar) findViewById(R.id.ratingBar_FoodWeight);*/
    }

    // UI 事件
    private void processControllers() {
        // Listener
        AdapterView.OnItemClickListener viewListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                Constants.DebugLog("Items select : " + position);
            }
        };
        /*View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button btn = (Button) v;

                if(btn == btn_addfood) {
                    addFood();
                }
            }
        };*/

        // 自訂 List View 內容橋接器
        adapter = new FoodItemAdapter(this, R.layout.fooditem, Mgr_Food.getInstance().getoFoodArray());

        lv_food.setAdapter(adapter);
        lv_food.setOnItemClickListener(viewListener);
        //btn_addfood.setOnClickListener(listener);
    }

    /*private void addFood(){
        String foodName = editText_food.getText().toString();

        if(foodName != null && Mgr_Food.getInstance().checkName(foodName)) {
            FoodData food = new FoodData(foodName, (byte)ratingBar_food.getRating());
            Mgr_Food.getInstance().addFoodData(food);
            adapter.notifyDataSetChanged();
            lv_food.smoothScrollToPosition(lv_food.getCount() - 1);
        } else {
            // TODO
            //return error
            return;
        }
    }*/

    // Action Bar 裡面的物件點集事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // User chose the "Settings" item, show the app settings UI...
                Constants.DebugLog("Action Add Clicked");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    // 產生自訂的 Action Bar
    // @see /res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        processView();
        processControllers();
    }
}
