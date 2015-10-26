package Data;

/**
 * Created by META on 2015/10/23.
 */
public class FoodData {

    private String name;
    private byte weight;

    public FoodData(String name, byte weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }
}
