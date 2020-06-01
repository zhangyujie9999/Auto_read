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
        List<StuAnswer> stuAnswers =  webOcr.read("C:\\Users\\wawade3\\Desktop\\8474f437af192a0c2a7248a122879c4.png");
        System.out.println("");
    }
}