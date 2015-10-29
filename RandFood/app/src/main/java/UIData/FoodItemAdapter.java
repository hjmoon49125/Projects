package UIData;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.meta.randfood.R;
import Data.FoodData;

/**
 * Created by META on 2015/10/29.
 */
public class FoodItemAdapter extends ArrayAdapter<FoodData> {

    // 畫面資源編號
    private int resource;
    // 食物的資料
    private List<FoodData> items;

    public FoodItemAdapter(Context context, int resource, List<FoodData> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout itemView;
        // 讀取目前位置的物件
        final FoodData item = getItem(position);

        if (convertView == null) {
            // 建立項目畫面元件
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, itemView, true);
        } else {
            itemView = (LinearLayout) convertView;
        }

        // 讀取食物名稱和權重數
        TextView titleView = (TextView) itemView.findViewById(R.id.txt_name);
        RatingBar ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

        // 設定食物名稱和權重數
        titleView.setText(item.getName());
        ratingBar.setRating((float) item.getWeight());

        return itemView;
    }

    // 設定指定編號的食物資料
    public void set(int index, FoodData item) {
        if (index >= 0 && index < items.size()) {
            items.set(index, item);
            notifyDataSetChanged();
        }
    }

    // 讀取指定編號的食物資料
    public FoodData get(int index) {
        return items.get(index);
    }


}
