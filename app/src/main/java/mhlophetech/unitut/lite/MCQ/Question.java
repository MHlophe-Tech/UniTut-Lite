package mhlophetech.unitut.lite.MCQ;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    private String strTopic;
    private HashMap model;
    private ArrayList<HashMap> list;
    private int score = 0;
    public int count = 0;
    public int time = 30;

    public Question() {
        strTopic = "demo";
        model = new HashMap<>();
        list = new ArrayList();
        getDummyData();

    }

    private void getDummyData() {
        for (int i = 0; i < 10; i++) {
            model = new HashMap<>();
            model.put("question", "question " + i);
            model.put("id", i);

            list.add(model);
        }
    }

    public HashMap getNext() {
        model = list.get(count);
        count++;
        time=30;

        return model;

    }
}
