package Algorithm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javabean.StuAnswer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
/**手写文字识别WebAPI接口调用示例接口文档(必看):https://doc.xfyun.cn/rest_api/%E6%89%8B%E5%86%99%E6%96%87%E5%AD%97%E8%AF%86%E5%88%AB.html
  *图片属性：jpg/png/bmp,最短边至少15px，最长边最大4096px,编码后大小不超过4M,识别文字语种：中英文
  *webapi OCR服务参考帖子(必看)：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=39111&highlight=OCR
  *(Very Important)创建完webapi应用添加服务之后一定要设置ip白名单，找到控制台--我的应用--设置ip白名单，如何设置参考：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=41891
  *错误码链接：https://www.xfyun.cn/document/error-code (code返回错误码时必看)
  *@author iflytek
  */
public class WebOcr {
	// 手写文字识别webapi接口地址
	private static final String WEBOCR_URL = "http://webapi.xfyun.cn/v1/service/v1/ocr/handwriting";
	// 应用APPID(必须为webapi类型应用,并开通手写文字识别服务,参考帖子如何创建一个webapi应用：http://bbs.xfyun.cn/forum.php?mod=viewthread&tid=36481)
	private static final String TEST_APPID = "5eabe22e";
	// 接口密钥(webapi类型应用开通手写文字识别后，控制台--我的应用---手写文字识别---相应服务的apikey)
	private static final String TEST_API_KEY = "713642d7d81909c8c8e64704fcf51287";
	// 测试图片文件存放位置
	private static final String IMAGE_FILE_PATH = "C://Users/19554/Desktop/5.png";

	public int ID;
	public String answer;
	public String type;
	List<StuAnswer> ll = new ArrayList<>();
	/**
	 * 组装http请求头
	 * 
	 * @param aue
	 * @param engineType
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException 
	 */
	private static Map<String, String> constructHeader(String language, String location) throws UnsupportedEncodingException, ParseException {
		// 系统当前时间戳
		String X_CurTime = System.currentTimeMillis() / 1000L + "";
		// 业务参数
		String param = "{\"language\":\""+language+"\""+",\"location\":\"" + location + "\"}";
		String X_Param = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
		// 接口密钥
		String apiKey = TEST_API_KEY;
		// 讯飞开放平台应用ID
		String X_Appid = TEST_APPID;
		// 生成令牌
		String X_CheckSum = DigestUtils.md5Hex(apiKey + X_CurTime + X_Param);
		// 组装请求头
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		header.put("X-Param", X_Param);
		header.put("X-CurTime", X_CurTime);
		header.put("X-CheckSum", X_CheckSum);
		header.put("X-Appid", X_Appid);
		return header;
	}

	public List<StuAnswer> read(String filepath) throws IOException, ParseException {
		Map<String, String> header = constructHeader("en", "false");
		// 读取图像文件，转二进制数组，然后Base64编码
		byte[] imageByteArray = FileUtil.read2ByteArray(filepath);
		String imageBase64 = new String(Base64.encodeBase64(imageByteArray), "UTF-8");
		String bodyParam = "image=" + imageBase64;
		String result = HttpUtil.doPost(WEBOCR_URL, header, bodyParam);
		//System.out.println(result);
		//System.out.println(result.charAt(result.indexOf("\"content\":\"")-1));
		//System.out.println(result.charAt(result.indexOf("}", result.indexOf("\"content\":\"")-1)));
		int start1 = result.indexOf("\"content\":\"")-1;
		int end1 = result.indexOf("}", start1);
		int start2;
		int end2;
		String str = "";
		String str1 = "";
		while(end1<result.length())
		{
			//System.out.println(start);
			//System.out.println(end);
			//System.out.println(result.substring(start1,end1));
			str1 = result.substring(start1,end1);
			start2 = str1.indexOf(":");
			end2 = str1.length();
			str+=str1.substring(start2+2,end2-1);
			//System.out.println(str1.substring(start2+2,end2));
			start1 = result.indexOf("\"content\":\"",end1);
			if(start1==-1)
				break;
			end1 = result.indexOf("}", start1);

		}
		System.out.println(str);
		this.choice(str);
		int end2_=0;
		int end3=0;
		char [] str3 = str.toCharArray();
		for(int i=0;i<str3.length;i++)
		{

			if(str3[i]=='三')
				end2_ = i;
			if(str3[i]=='四')
				end3 = i;

		}
		String str2 = str.substring(end2_, end3);

		tk(str2);


		//System.out.println(result.substring(start,end+1));
		//System.out.println(result.indexOf("\"content\":\""));
		return ll;
	}


	public void choice(String str)
	{
		char [] str1 = str.toCharArray(); 
		char [] a = new char[1000];
		char [][] b = new char[2][1000];
		char t='1';
		int n = 0;
		int q = 0;
		int p = 0;
		int h=10;
		int s;
		int order;
		int start=0;
		int end1=0;
		int end2=0;
		
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i]=='一')
				start = i;
			if(str1[i]=='二')
				end1 = i;
			if(str1[i]=='三')
				end2 = i;
			
			
		}
//		System.out.println(start);
//		System.out.println(end1);
//		System.out.println(end2);
		
		for(int r=0;r<2;r++){
		for(int i=start;i<end1;i++)
		
		{  
//		System.out.println("start="+start);
//		System.out.println("end1="+end1);
//		System.out.println("p="+p);
			if(isdigit(str1[i]))
			
				if(!isdigit(str1[i+1]))
				
					{
					
					if(str1[i]==t)
					{
						//System.out.println(t);
						for(int j=i+1;j<end1;j++)
							if(isdigit(str1[j]))
								{
								for(int k=i+1;k<j;k++)
									if(isalpha(str1[k]))
									{
										//a[n++] = str1[k];
										this.answer = str1[k]+"";
										this.type = (p==0)?("choise"):("Tf");
										this.ll.add(new StuAnswer(ID,this.type,this.answer));
										ID++;
										b[p][q++]=str1[k];
										t = (char)(((int)t)+1);
										//System.out.println(t);
									}
								s = j;
								break;
						     
								}
								
	}
					else {
						for(int d=((int)t);d<(int)str1[i];d++)
						{
							//a[n++] = ' ';
							this.answer = str1[i]+"";
							this.type = (p==0)?("choise"):("Tf");
							this.ll.add(new StuAnswer(ID,this.type,this.answer));
							ID++;
							b[p][q++]=' ';
							//a[0]='a';
							t = (char)(((int)t)+1);
						}
						for(int j=i+1;j<end1;j++)
							if(isdigit(str1[j]))
								{
								for(int k=i+1;k<j;k++)
									if(isalpha(str1[k]))
									{
										this.answer = str1[k]+"";
										this.type = (p==0)?("choise"):("Tf");
										this.ll.add(new StuAnswer(ID,this.type,this.answer));
										ID++;
										//a[n++] = str1[k];
										b[p][q++]=str1[k];
										//a[0]='a';
										t = (char)(((int)t)+1);
										//System.out.println(t);
									}
								s = j;
								break;
						     
								}	
							
							
						
					} 
				
					}
				else {
					
				  order = (int)(10 * (str1[i]-'0'))+((int)(str1[i+1]-'0'));
					
						while(h<order)
						{
							//a[n++] = ' ';
							this.answer = str1[h]+"";
							this.type = (p==0)?("choise"):("Tf");
							this.ll.add(new StuAnswer(ID,this.type,this.answer));
							ID++;
							b[p][q++]=' ';
							//a[0]='a';
							h=h+1;
							//System.out.println("h1="+h);
						}
						label:for(int j=i+2;j<end1;j++)
							{
							if(isdigit(str1[j]))
								{
								for(int k=i+1;k<j;k++)
									if(isalpha(str1[k]))
									{
										//a[n++] = str1[k];
										this.answer = str1[k]+"";
										this.type = (p==0)?("choise"):("Tf");
										this.ll.add(new StuAnswer(ID,this.type,this.answer));
										ID++;
										b[p][q++]=str1[k];
										//a[0]='a';
										h=h+1;
										//System.out.println("h2="+h);
										break label;
										
									}
								
						     
								}	
							
							
							}
						i=i+2;
						
					}
					
}
		for(int g=end1-1;g>start;g--)
		{
		if(isalpha(str1[g]))
			{
			//a[n++] = str1[g];
				this.answer = str1[g]+"";
				this.type = (p==0)?("choise"):("Tf");
				this.ll.add(new StuAnswer(ID,this.type,this.answer));
				ID++;
				b[p][q++]=str1[g];
				break;
			}
		}
		
//		for(int e=0;e<n;e++)
//			System.out.print(a[e]+",");
//		System.out.println();
		for(int e=0;e<q;e++)
			System.out.print(b[p][e]+",");
		System.out.println();
//		for(int e=0;e<q;e++)
//			System.out.print(b[1][e]+",");
		q = 0;
		p++;
		
		start=end1;
		end1=end2;
//		System.out.println(start);
//		System.out.println(end1);
		t='1';
	
	}
		}
	public void tk(String str) {
		char [] str2 = str.toCharArray();
		String str3="";
		String[] str1 = {"","","","","","","","","","","","","","",""};
		int h=0;
		int n=0;
		int k=0;
		int [] a = new int[100];
		for(int i=0;i<str2.length;i++)
			if(isdigit(str2[i]))
			{
				a[k++] = i;

				label:for(int j=i+1;j<str2.length;j++)
				{
					if(isdigit(str2[j]))
					{
						h=j;
						a[k++]=j;
						break label;

					}
				}


			}
		for(int i=0;i<k-1;)
		{   a[i]=a[i]+1;
			if(str2[a[i]]=='.'||str2[a[i]]=='、')
				a[i]=a[i]+1;
			str3=str.substring(a[i], a[i+1]);
			str1[n++]=str3;
			str3="";
			i=i+2;

		}
		str3=str.substring(a[k-1]+1);
		str1[n++]=str3;
//		System.out.println(n);
//		System.out.println(str1[5]);

		for(int i=0;i<n;i++)
			{
				if(str1[i] == null)
					continue;
				this.answer = str1[i]+"";
				this.type = "Tk";
				this.ll.add(new StuAnswer(ID,this.type,this.answer));
				ID++;
				System.out.print(str1[i]+" ");
			}
		
	}
	
	public static boolean isdigit(char ch)
	{
		if(ch>=48&&ch<=57)
			return true;
		else
			return false;
		
		
	}
	public static boolean isalpha(char ch)
	{
		if((ch>=65&&ch<=90)||(ch>=97&&ch<=122))
			return true;
		else
			return false;
		
		}
}
