package Algorithm;

import javabean.StuAnswer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebOcrTest {

    @Test
    void read() throws IOException, ParseException {
        WebOcr webOcr = new WebOcr();
        List<StuAnswer> stuAnswers =  webOcr.read("C://Users/19554/Desktop/5.png");
        System.out.println("");
    }
}