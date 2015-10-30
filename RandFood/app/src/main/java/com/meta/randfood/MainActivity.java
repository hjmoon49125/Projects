package com.meta.randfood;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Process.Mgr_Food;
import Process.FoodGenerate;

public class MainActivity extends AppCompatActivity {

    private FoodGenerate foodGenerate;

    private Button btn_rand;
    private TextView txt_rand;

    // UI 註冊
    private void processView() {
        btn_rand = (Button) findViewById(R.id.btn_rand);
        txt_rand = (TextView) findViewById(R.id.txt_rand);
    }

    // UI 事件
    private void processControllers() {
        btn_rand.setOnClickListener(listener);
    }

    // 按鈕 Listener 事件
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button btn = (Button) v;

            if(btn == btn_rand) {
                randFood();
            }
        }
    };

    // 隨機轉盤
    private void randFood() {
        int foodID = foodGenerate.Generate();
        txt_rand.setText(Mgr_Food.getInstance().getFoodData(foodID).getName());
        //mHandler.post(runnable);
    }

    /*Handler mHandler = new Handler();
    int count = 0;

    final Runnable runnable = new Runnable() {
        public void run() {
            if(count == Mgr_Food.getInstance().getoFoodArray().size())
                count = 0;

            txt_rand.setText(Mgr_Food.getInstance().getFoodData(count).getName());

            count ++;
            mHandler.postDelayed(runnable, 10);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodGenerate = new FoodGenerate();

        processView();
        processControllers();
    }
}
