package com.meta.randfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.gson.Gson;

import Data.Constants;
import Data.FoodData;
import Process.Mgr_Food;

public class AddItemActivity extends AppCompatActivity {

    private Button btn_addfood;
    private Button btn_modfood;
    private EditText ediTxt_food;
    private RatingBar ratingBar_food;
    private int CurrentMod;
    private int foodPos;

    // 初始化
    private void init() {
        CurrentMod = Integer.parseInt(getIntent().getAction());

        processView();
        processControllers();

        switch(CurrentMod){
            case Constants.MOD_REQUEST:
                btn_addfood.setVisibility(View.INVISIBLE);
                Bundle bundle = getIntent().getExtras();
                foodPos = bundle.getInt(Constants.MOD_KEY);
                String value = bundle.getString(Constants.MOD_Value);

                Gson gson = new Gson();
                FoodData food = gson.fromJson(value, FoodData.class);

                ediTxt_food.setText(food.getName());
                ratingBar_food.setRating(food.getWeight());

                break;
            case Constants.ADD_REQUEST:
                btn_modfood.setVisibility(View.INVISIBLE);
                break;
        }
    }

    // UI 註冊
    private void processView() {
        btn_addfood = (Button) findViewById(R.id.btn_addFood);
        btn_modfood = (Button) findViewById(R.id.btn_modFood);
        ediTxt_food = (EditText) findViewById(R.id.ediTxt_addFood);
        ratingBar_food = (RatingBar) findViewById(R.id.rb_add);
    }

    // UI 事件
    private void processControllers() {
        btn_addfood.setOnClickListener(listener);
        btn_modfood.setOnClickListener(listener);
    }

    // Listener 按鈕事件
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button btn = (Button) v;

            if(btn == btn_addfood) {
                addFood();
            } else if(btn == btn_modfood) {
                modFood();
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
        } else {
            // TODO
            //return error
            return;
        }
    }

    // 修改食物
    private void modFood() {
        String foodName = ediTxt_food.getText().toString();

        FoodData food = new FoodData(foodName, (byte)ratingBar_food.getRating());
        Mgr_Food.getInstance().modFoodData(foodPos,food);

        finish();

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

        init();
    }
}
