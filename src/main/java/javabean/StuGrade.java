package javabean;

public class StuGrade {
    String stu_ID;
    String stu_Name;
    Double s_choice;//单选题模块总分
    Double m_choice;//多选题模块总分
    Double judge;//判断题模块总分
    Double t_kong;//填空题模块总分
    Double Q_A;//简单题模块总分
    Double grade;//总分
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStu_ID() {
        return stu_ID;
    }

    public void setStu_ID(String stu_ID) {
        this.stu_ID = stu_ID;
    }

    public String getStu_Name() {
        return stu_Name;
    }

    public void setStu_Name(String stu_Name) {
        this.stu_Name = stu_Name;
    }

    public Double getS_choice() {
        return s_choice;
    }

    public void setS_choice(Double s_choice) {
        this.s_choice = s_choice;
    }

    public Double getM_choice() {
        return m_choice;
    }

    public void setM_choice(Double m_choice) {
        this.m_choice = m_choice;
    }

    public Double getJudge() {
        return judge;
    }

    public void setJudge(Double judge) {
        this.judge = judge;
    }

    public Double getT_kong() {
        return t_kong;
    }

    public void setT_kong(Double t_kong) {
        this.t_kong = t_kong;
    }

    public Double getQ_A() {
        return Q_A;
    }

    public void setQ_A(Double q_A) {
        Q_A = q_A;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public StuGrade(String stu_ID, String stu_Name, Double s_choice, Double m_choice, Double judge, Double t_kong, Double q_A, Double grade, String path) {
        this.stu_ID = stu_ID;
        this.stu_Name = stu_Name;
        this.s_choice = s_choice;
        this.m_choice = m_choice;
        this.judge = judge;
        this.t_kong = t_kong;
        Q_A = q_A;
        this.grade = grade;
        this.path = path;
    }
}
