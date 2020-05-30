package Algorithm;
import com.baidu.aip.nlp.AipNlp;
import javabean.Answer;
import javabean.StuAnswer;
import org.json.JSONObject;

import java.util.HashMap;

public class CompareAnswerimpl implements CompareAnswer{
    public static final String APP_ID = "19801376";
    public static final String API_KEY = "r2Z4OkeWY6yykjxFWyvPG1bT";
    public static final String SECRET_KEY = "EUpM9DjNr5ztvvWGs8LtZFDsvyBbRf6p";
    @Override
    public double compare(StuAnswer stuAnswer, Answer answer) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        String text1 = stuAnswer.getAnswer();
        String text2 = answer.getAnswer();

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("model", "CNN");

        // 短文本相似度
        JSONObject res = client.simnet(text1, text2, options);
        String s=res.toString(0);
        String a=s.substring(s.indexOf("e")+3,s.indexOf("t")-2);
        double score=Double.parseDouble(a);
        //System.out.println(a);
        return score;
    }
}
