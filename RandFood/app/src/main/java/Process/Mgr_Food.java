package Process;

import java.util.ArrayList;
import java.util.List;

import Data.FoodData;
import Data.Constants;

/**
 * Created by META on 2015/10/23.
 */
public class Mgr_Food {

    // Singleton
    private static Mgr_Food mgrFood = new Mgr_Food();
    public static Mgr_Food getInstance(){
        return mgrFood;
    }

    // 所有食物的資料List & Constructor載入Data
    private List<FoodData> oFoodArray;
    private Mgr_Food(){
        oFoodArray = new ArrayList<FoodData>();
        loadFoodData();
    }

    // 載入設定
    public void loadFoodData(){
        // 載入食物數量
        int FoodArraySize = ReadnWrite.getInstance().readInteger(Constants.KEY_FOOD_NUM, 0);

        // 載入食物
        for(int i=0;i<FoodArraySize;i++) {
            String foodkey = String.format(Constants.KEY_FOOD, i);
            String name = ReadnWrite.getInstance().readString(foodkey, "");
            String weightkey = String.format(Constants.KEY_FOOD_WEIGHT, i);
            byte weight = ReadnWrite.getInstance().readByte(weightkey, "");

            FoodData food = new FoodData(name, weight);
            oFoodArray.add(food);
        }
    }

    // 儲存設定
    public void saveFoodData(){
        // 寫入食物筆數
        int FoodArraySize = oFoodArray.size();
        ReadnWrite.getInstance().writeInteger(Constants.KEY_FOOD_NUM, FoodArraySize);

        // 寫入食物
        for(int i=0;i<FoodArraySize;i++) {
            String foodkey = String.format(Constants.KEY_FOOD, i);
            ReadnWrite.getInstance().writeString(foodkey, oFoodArray.get(i).getName());
            String weightkey = String.format(Constants.KEY_FOOD_WEIGHT, i);
            ReadnWrite.getInstance().writeByte(weightkey, oFoodArray.get(i).getWeight());
        }
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
