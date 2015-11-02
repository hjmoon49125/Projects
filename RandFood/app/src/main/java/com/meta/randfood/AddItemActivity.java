package com.meta.randfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import Data.FoodData;
import Process.Mgr_Food;

public class AddItemActivity extends AppCompatActivity {

    private Button btn_addfood;
    private EditText ediTxt_food;
    private RatingBar ratingBar_food;

    // UI 註冊
    private void processView() {
        btn_addfood = (Button) findViewById(R.id.btn_addFood);
        ediTxt_food = (EditText) findViewById(R.id.ediTxt_addFood);
        ratingBar_food = (RatingBar) findViewById(R.id.rb_add);
    }

    // UI 事件
    private void processControllers() {
        btn_addfood.setOnClickListener(listener);
    }

    // Listener 按鈕事件
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button btn = (Button) v;

            if(btn == btn_addfood) {
                addFood();
            }
        }
    };

    // 新增食物
    private void addFood(){
        String foodName = ediTxt_food.getText().toString();

        if(foodName != null && Mgr_Food.getInstance().checkName(foodName)) {
            FoodData food = new FoodData(foodName, (byte)ratingBar_food.getRating());
            Mgr_Food.getInstance().addFoodData(food);

            finish();
            //adapter.notifyDataSetChanged();
            //lv_food.smoothScrollToPosition(lv_food.getCount() - 1);
        } else {
            // TODO
            //return error
            return;
        }
    }

    // 結束時回傳更新指令
    @Override
    public void finish() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        processView();
        processControllers();
    }
}
