package Process;


import java.util.ArrayList;
import java.util.List;

import Data.FoodData;

/**
 * Created by META on 2015/10/23.
 */
public class FoodProcess {

    // Singleton
    public static FoodProcess foodProcess = null;
    public static FoodProcess getInstance(){
        if(foodProcess == null)
            return new FoodProcess();

        return foodProcess;
    }

    // 所有食物的資料
    private List<FoodData> oFoodArray;
    public FoodProcess(){
        oFoodArray = new ArrayList<FoodData>();
        loadFoodData();
    }

    // 載入設定
    public void loadFoodData(){
        // TODO
        System.out.printf("load !");
        FoodData food1 = new FoodData("麥當當", (byte)5);
        oFoodArray.add(food1);
        FoodData food2 = new FoodData("肯機機", (byte)4);
        oFoodArray.add(food2);
        FoodData food3 = new FoodData("周師傅", (byte)3);
        oFoodArray.add(food3);
        FoodData food4 = new FoodData("早餐店", (byte)2);
        oFoodArray.add(food4);
        FoodData food5 = new FoodData("雞肉飯", (byte)1);
        oFoodArray.add(food5);

    }

    // 儲存設定
    public void saveFoodData(){
        // TODO
        System.out.printf("save !");
    }

    // 新增食物
    public void addFoodData(FoodData data){
        oFoodArray.add(data);

        saveFoodData();
    }

    // 刪除食物
    public void delFoodData(int value){
        if(getFoodData(value) != null) {
            oFoodArray.remove(value);
        }

        saveFoodData();
    }

    // 修改食物
    public void modFoodData(int value, FoodData data){
        oFoodArray.set(value, data);

        saveFoodData();
    }

    // 取得Food List
    public List<FoodData> getoFoodArray(){
        return oFoodArray;
    }

    // 取得食物內容
    public FoodData getFoodData(int value){
       return oFoodArray.get(value);
    }



}
