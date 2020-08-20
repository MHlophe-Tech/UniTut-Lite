package mhlophetech.unitut.lite.MCQ;

import java.util.ArrayList;

import mhlophetech.unitut.lite.Model.QuestionModel;

public class Question {
    private String strTopic;
    private QuestionModel model;
    public ArrayList<QuestionModel> questionList;
    private int score = 0;
    public int count = 0;
    public int time = 30;

    public Question() {
        strTopic = "demo";
        model = new QuestionModel();
        questionList = new ArrayList();
        this.mockData();

    }

    public int getScore(){
        return score;
    }

    public QuestionModel getQuestion(){
        model =  questionList.get(count);
        time = model.time;
        this.count++;
        return model;
    }

    public void correct(){
        this.score++;

    }

    private void mockData() {

        //set mock questions
        model = new QuestionModel();
        model.question = "What is UniTut?";
        model.time = 30;
        //set the options
        model.option.put("answer", "It's a movie about life after death");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "A novel written by Sandile MHlophe");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "It's a system(apps and websites) that connects tutors and high school learners");
        model.option.put("isCorrect", true);
        model.addOption();

        model.option.put("answer", "It's a website");
        model.option.put("isCorrect", false);
        model.addOption();

        questionList.add(model);

        //quiz 2
        model = new QuestionModel();
        model.question = "Who is the Founder of UniTut?";
        model.time = 15;
        //set the options
        model.option.put("answer", "Sfiso Mahlangu");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "Sandile MHlophe");
        model.option.put("isCorrect", true);
        model.addOption();

        model.option.put("answer", "Lwazi Sangweni");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "Some smart guy :)");
        model.option.put("isCorrect", false);
        model.addOption();

        questionList.add(model);

        model = new QuestionModel();
        model.question = "Do you get cash for using the App?";
        model.time = 21;
        //set the options
        model.option.put("answer", "yes");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "no");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "Depends on how you use it");
        model.option.put("isCorrect", true);
        model.addOption();

        model.option.put("answer", "you get points then you can convert them for cash");
        model.option.put("isCorrect", false);
        model.addOption();

        questionList.add(model);

        //quiz 4
        model = new QuestionModel();
        model.question = "What is Akufani Nokulala Ehlathini?";
        model.time = 31;
        //set the options
        model.option.put("answer", "it's an app created by some guy to annoy google on their naming " +
                "policy, this app can still be downloaded by the way");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "It's a religion book written by Sir Khumalo");
        model.option.put("isCorrect", false);
        model.addOption();

        model.option.put("answer", "It is one of the phrases uttered by Sandile MHlophe");
        model.option.put("isCorrect", true);
        model.addOption();

        model.option.put("answer", "It is something isn't it? ");
        model.option.put("isCorrect", false);
        model.addOption();

        questionList.add(model);
    }


}
