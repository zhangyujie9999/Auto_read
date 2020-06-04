package javabean;

public class StuGrade {
    int stu_ID;
    String stu_Name;
    Double s_choice;//单选题模块总分
    Double m_choice;//多选题模块总分
    Double judge;//判断题模块总分
    Double t_kong;//填空题模块总分
    Double Q_A;//简单题模块总分
    Double grade;//总分

    public int getStu_ID(){return stu_ID;}
    public void setStu_ID(int stu_ID){this.stu_ID=stu_ID;}

    public String getStu_Name(){return stu_Name;}
    public void setStu_Name(String stu_Name){this.stu_Name=stu_Name;}

    public Double getS_choice(){return s_choice;}
    public void setS_choice(Double s_choice){this.s_choice=s_choice;}

    public Double getM_choice(){return m_choice;}
    public void setM_choice(Double m_choice){this.m_choice=m_choice;}

    public Double getJudge(){return judge;}
    public void setJudge(Double judge){this.judge=judge;}

    public Double getT_kong(){return t_kong;}
    public void setT_kong(Double T_kong){this.t_kong=T_kong;}

    public Double getQ_A(){return Q_A;}
    public void setQ_A(Double Q_A){this.Q_A=Q_A;}

    public Double getGrade(){return grade;}
    public void setGrade(Double grade){this.grade=grade;}

}
