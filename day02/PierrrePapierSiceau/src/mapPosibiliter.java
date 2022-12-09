import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapPosibiliter {

    private Integer curentInteger = 0;
    private Map<String, String>[] maps;

    public mapPosibiliter(){
        maps = new Map[9];

        maps[0] = new HashMap<>();
        maps[0].put("X","A");
        maps[0].put("Y","B");
        maps[0].put("Z","C");

        maps[1] = new HashMap<>();
        maps[1].put("X","A");
        maps[1].put("Y","C");
        maps[1].put("Z","B");

        maps[2] = new HashMap<>();
        maps[2].put("X","B");
        maps[2].put("Y","A");
        maps[2].put("Z","C");

        maps[3] = new HashMap<>();
        maps[3].put("X","B");
        maps[3].put("Y","C");
        maps[3].put("Z","A");

        maps[4] = new HashMap<>();
        maps[4].put("X","C");
        maps[4].put("Y","A");
        maps[4].put("Z","B");

        maps[5] = new HashMap<>();
        maps[5].put("X","C");
        maps[5].put("Y","B");
        maps[5].put("Z","A");

    }

    public String getValue(String value){
        return maps[curentInteger].get(value);
    }

    public Integer getCurentInteger() {
        return curentInteger;
    }

    public void setCurentInteger(Integer curentInteger) {
        this.curentInteger = curentInteger;
    }
}
