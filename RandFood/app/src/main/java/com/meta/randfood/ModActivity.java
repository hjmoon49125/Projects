package com.meta.randfood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import Data.Constants;
import Process.Mgr_Food;
import UIData.FoodItemAdapter;

public class ModActivity extends AppCompatActivity {

    private ListView lv_food;
    private FoodItemAdapter adapter;
    int itemSelect;

    // UI 註冊
    private void processView() {
        lv_food = (ListView) findViewById(R.id.lview_food);
    }

    // UI 事件
    private void processControllers() {
        // 自訂 List View 內容橋接器
        adapter = new FoodItemAdapter(this, R.layout.fooditem, Mgr_Food.getInstance().getoFoodArray());

        lv_food.setAdapter(adapter);
        lv_food.setOnItemClickListener(viewListener);
    }

    // List View Listener 事件註冊
    AdapterView.OnItemClickListener viewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            view.setSelected(true);
            itemSelect = position;
        }
    };

    // Action Bar 裡面的物件點集事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // 開啟更新界面 並等待其回傳結果
                Intent intent = new Intent(this, AddItemActivity.class);
                startActivityForResult(intent, Constants.ADD_REQUEST);

                return true;

            case R.id.action_del:
                DeleteData();
                return true;

            case R.id.action_mod:
                // User chose the "Settings" item, show the app settings UI...
                Constants.DebugLog("Action mod Clicked");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    // 刪除 彈出視窗
    private void DeleteData() {
        // TODO
        // 優化
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.confirm_del)
                .setPositiveButton(R.string.confirm_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Mgr_Food.getInstance().delFoodData(itemSelect);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(R.string.confirm_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
        AlertDialog about_dialog = builder.create();
        about_dialog.show();
    }

    // 產生自訂的 Action Bar
    // @see /res/menu/menu_main.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = getMenuInflater();
        mif.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 更新 List 界面
    public void refreshAdapter() {
        adapter.notifyDataSetChanged();
        lv_food.smoothScrollToPosition(lv_food.getCount());
    }

    // 收到更新的回傳要求 @see /Constant/ADD_REQUEST
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == Constants.ADD_REQUEST) {
            refreshAdapter();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod);

        processView();
        processControllers();
    }
}
