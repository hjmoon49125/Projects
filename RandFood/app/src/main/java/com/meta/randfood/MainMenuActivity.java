package com.meta.randfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import Process.ReadnWrite;

public class MainMenuActivity extends AppCompatActivity {

    private Button btn_MenuRend;
    private Button btn_MenuMod;
    private ImageView img_logo;

    ReadnWrite readnWrite;

    // UI 註冊
    private void processView() {
        btn_MenuRend = (Button) findViewById(R.id.btn_MenuRend);
        btn_MenuMod = (Button) findViewById(R.id.btn_MenuMod);
        img_logo = (ImageView) findViewById(R.id.img_logo);

        img_logo.setImageResource(R.drawable.meta);
    }

    // UI 事件
    private void processControllers() {
        btn_MenuRend.setOnClickListener(listener);
        btn_MenuMod.setOnClickListener(listener);
    }

    // 按鈕 Listener 事件
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;

            if (btn == btn_MenuRend) {
                MenuRand();
            } else if (btn == btn_MenuMod) {
                MenuMod();
            }
        }
    };

    // 隨機食物 UI
    private void MenuRand() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // 新增資料 UI
    private void MenuMod() {
        Intent intent = new Intent(this, ModActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        readnWrite.initializeInstance(getApplicationContext());

        processView();
        processControllers();
    }

}
