package Algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Read_allpic {
    public static List<String> all_pic(String filepath){
        String path = filepath;		//要遍历的路径
        List<String> filelist = new ArrayList<>();
        File file = new File(path);		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory())		//若非目录(即文件)，则打印
            {
                System.out.println(f);
                filelist.add(f.toString());
            }
        }
        return filelist;
    }
}
