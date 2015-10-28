package com.meta.randfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import Data.FoodData;
import Process.Mgr_Food;

public class ModActivity extends AppCompatActivity {

    private ListView lv_food;
    private SimpleAdapter adapter;

    // UI 註冊
    private void processView() {
        lv_food = (ListView) findViewById(R.id.lview_food);
    }

    // UI 事件
    private void processControllers() {
        // Listener
        /*View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button btn = (Button) v;

                if(btn == btn_MenuRend) {
                    MenuRand();
                } else if(btn == btn_MenuMod){
                    MenuMod();
                }
            }
        };*/
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(FoodData food : Mgr_Food.getInstance().getoFoodArray()){
            HashMap<String,String> item = new HashMap<String,String>();
            item.put( "Name", food.getName());
            //item.put("Weight", String.valueOf(food.getWeight()));
            list.add(item );
        }

        adapter = new SimpleAdapter(
                this,
                list,
                R.layout.fooditem,
                new String[] {"Name"},
                new int[] { R.id.txt_name});

        lv_food.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        processView();
        processControllers();
    }
}
