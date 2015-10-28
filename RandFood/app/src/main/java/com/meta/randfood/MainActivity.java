package com.meta.randfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import Process.*;

public class MainActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG="LogDemo";

    private FoodGenerate foodGenerate;
    public ReadnWrite readnWrite;

    private Button btn_rand;
    private TextView txt_rand;

    private void processView() {
        btn_rand = (Button) findViewById(R.id.btn_rand);
        txt_rand = (TextView) findViewById(R.id.txt_rand);
    }

    private void processControllers() {
        // Listener
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button btn = (Button) v;

                if(btn == btn_rand) {
                    randFood();
                }
            }
        };

        btn_rand.setOnClickListener(listener);
    }

    private void randFood() {
        int foodID = foodGenerate.Generate();
        txt_rand.setText(Mgr_Food.getInstance().getFoodData(foodID).getName());

        Log.i(ACTIVITY_TAG, foodID + " + " + Mgr_Food.getInstance().getFoodData(foodID).getName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readnWrite.initializeInstance(getApplicationContext());
        foodGenerate = new FoodGenerate();

        processView();
        processControllers();

    }



}
