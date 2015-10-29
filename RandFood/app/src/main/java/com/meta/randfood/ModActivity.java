package com.meta.randfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        processView();
        processControllers();
    }
}
