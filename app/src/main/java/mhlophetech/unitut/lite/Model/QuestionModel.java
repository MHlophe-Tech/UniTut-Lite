package mhlophetech.unitut.lite.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionModel {

    public String question;
    public HashMap<String, Object> option;
    public ArrayList<HashMap> optionList;
    public int time;

    public QuestionModel(){
        question = "demo quiz";
        optionList = new ArrayList();
        option= new HashMap<>();
        time = 30;
    }

    public void addOption(){
        // we add the option to the list
        optionList.add(option);

        //we remove the set option
        option = new HashMap<>();

    }
}
