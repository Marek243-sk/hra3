package sk.tuke.hra3;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static List<EntityScoreModel> getEntityScoreData() {
        List<EntityScoreModel> outputModel = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            outputModel.add(new EntityScoreModel(
                    "Score" + Integer.toString(i),
                    "Time" + Integer.toString(i)
            ));
        }
        return outputModel;
    }
}
