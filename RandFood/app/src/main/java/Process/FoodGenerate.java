package Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by META on 2015/10/23.
 */
public class FoodGenerate {

    // 機率陣列 & Constructor 載入陣列
    private int StatsArr[];
    public FoodGenerate(){
        StatsArr = new int[calArrayLength()];
        populateList();
    }

    // 陣列長度運算
    private int calArrayLength(){
        int value = 0;
        for (Data.FoodData food : Mgr_Food.getInstance().getoFoodArray()){
            value += (food.getWeight() * 10);
        }
        return value;
    }

    // 產生隨機陣列
    private void populateList(){
        int iCount = 0;
        int iID = 0;
        for (Data.FoodData food : Mgr_Food.getInstance().getoFoodArray()) {
            for (int i = 0; i < food.getWeight() * 10; i++) {
                StatsArr[iCount] = iID;
                iCount++;
            }
            iID++;
        }

        // 隨機 Shuffle 機率 Array
        List<Integer> list = new ArrayList<>();
        for (int i : StatsArr) {
            list.add(i);
        }

        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            StatsArr[i] = list.get(i);
        }
    }

    // 隨機食物
    public int Generate(){
        int rand = (int) (Math.random() * StatsArr.length);
        return  StatsArr[rand];
    }



}
