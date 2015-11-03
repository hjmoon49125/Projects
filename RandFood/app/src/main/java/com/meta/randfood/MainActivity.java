package com.meta.randfood;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Data.Constants;
import Process.Mgr_Food;
import Process.FoodGenerate;

public class MainActivity extends AppCompatActivity {

    private FoodGenerate foodGenerate;

    private Button btn_rand;
    private TextView txt_rand;

    int ArrayCount = 0;

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

    // 隨機轉盤的按鈕事件
    private void randFood() {
        txt_rand.setTextColor(Color.BLACK);
        randomAnimation(Constants.ACTION_STATE.RAND_ANIMATE);
        btn_rand.setClickable(false);
    }

    // 動畫演出狀態機
    private void randomAnimation(Constants.ACTION_STATE state) {
        switch(state) {
            case RAND_ANIMATE:
                parameterFunc func = new parameterFunc () {
                    @Override
                    public void run() {
                        randomAnimation(Constants.ACTION_STATE.RAND_STOP);
                    }
                };
                TimerMethod(3000, 10, func);
                break;
            case RAND_STOP:
                parameterFunc func2 = new parameterFunc () {
                    @Override
                    public void run() {
                        int foodID = foodGenerate.Generate();
                        txt_rand.setText(Mgr_Food.getInstance().getFoodData(foodID).getName());
                        txt_rand.setTextColor(Color.RED);
                        btn_rand.setClickable(true);
                    }
                };
                /*parameterFunc func2 = () -> {
                    int foodID = foodGenerate.Generate();
                    txt_rand.setText(Mgr_Food.getInstance().getFoodData(foodID).getName());
                    txt_rand.setTextColor(Color.RED);
                    btn_rand.setClickable(true);
                }*/
                TimerMethod(2000, 200, func2);
                break;
        }
    }

    // Function Interface
    interface parameterFunc {
        void run();
    }

    // Countdown 的實作內容 帶入 Function Interface 當值型內容 @see parameterFunc
    private void TimerMethod(long countdown, long everysec, final parameterFunc func) {
        new CountDownTimer(countdown, everysec){
            public void onTick(long millisUntilFinished) {
                reFreshTxtUI();
            }

            public void onFinish() {
                func.run();
            }
        }.start();
    }

    // UI 文字刷新
    private void reFreshTxtUI() {
        if(ArrayCount == Mgr_Food.getInstance().getoFoodArray().size())
            ArrayCount = 0;

        txt_rand.setText(Mgr_Food.getInstance().getFoodData(ArrayCount).getName());

        ArrayCount ++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodGenerate = new FoodGenerate();

        processView();
        processControllers();
    }
}
