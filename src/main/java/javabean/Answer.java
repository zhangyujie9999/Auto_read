package javabean;

public class Answer {
    int ID;//题号
    String type;//题目类型
    String answer;//该题的标准答案
    double grade;//该题的分数

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public double getGrade() { return grade; }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
