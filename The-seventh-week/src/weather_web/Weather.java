package weather_web;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.SocketTimeoutException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
   
import net.sf.json.JSONObject;  
   
public class Weather {  
       
    private String Cityid;  
    private URLConnection connectionData;  
    private StringBuilder sb;  
    private BufferedReader br;// ��ȡdata������   
    private JSONObject jsonData;   
    private JSONObject info;   
       
     public Weather(String cityid) throws IOException{  
         ///��������IP��ַ  
         this.Cityid=cityid;  
            
         ///������������̨��APi  
         URL url=new URL("http://m.weather.com.cn/data/" + Cityid + ".html");  
         connectionData = url.openConnection();  
         connectionData.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
         connectionData.setConnectTimeout(1000);   
            try {   
                br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(), "UTF-8"));   
                sb = new StringBuilder();   
                String line = null;   
                while ((line = br.readLine()) != null){  
                    sb.append(line);   
                }  
            } catch (SocketTimeoutException e) {   
                System.out.println("���ӳ�ʱ");   
            } catch (FileNotFoundException e) {   
                System.out.println("�����ļ�����");   
            }     
               
            String datas = sb.toString();     
               
               jsonData = JSONObject.fromObject(datas);   
              //  System.out.println(jsonData.toString());    
               info = jsonData.getJSONObject("weatherinfo");   
                  
                  
               //�õ�1��6����������  
               List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();  
               for(int i=1;i<=6;i++){  
                   //�õ�δ��6�������  
                   Calendar cal = Calendar.getInstance();  
                   cal.add(Calendar.DAY_OF_YEAR, i-1);  
                   Date date = cal.getTime();  
                   SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��");  
                      
                   Map<String,Object> map = new HashMap<String, Object>();  
                   map.put("city", info.getString("city").toString());//����  
                   map.put("date_y", sf.format(date));//����  
                   map.put("week", getWeek(cal.get(Calendar.DAY_OF_WEEK)));//����  
                   map.put("fchh", info.getString("fchh").toString());//����ʱ��  
                   map.put("weather", info.getString("weather"+i).toString());//����  
                   map.put("temp", info.getString("temp"+i).toString());//�¶�  
                   map.put("wind", info.getString("wind"+i).toString());//���  
                   map.put("fl", info.getString("fl"+i).toString());//����  
                   map.put("index", info.getString("index").toString());// ����Ĵ���ָ��   
                   map.put("index_uv", info.getString("index_uv").toString());// ����ָ��   
                   map.put("index_tr", info.getString("index_tr").toString());// ����ָ��   
                   map.put("index_co", info.getString("index_co").toString());// ����ָ��   
                   map.put("index_cl", info.getString("index_cl").toString());// ����ָ��   
                   map.put("index_xc", info.getString("index_xc").toString());//ϴ��ָ��   
                   map.put("index_d", info.getString("index_d").toString());//������ϸ����ָ��   
                   list.add(map);  
                  }  
                  
                  
               //����̨��ӡ������  
               for(int j=0;j<list.size();j++){  
                Map<String,Object> wMap = list.get(j);  
                System.out.println(wMap.get("city")+"\t"+wMap.get("date_y")+"\t"+wMap.get("week")+"\t" 
                +wMap.get("weather")+"\t"+wMap.get("temp")+"\t"+wMap.get("index_uv"));  
               }  
                  
     }////  
        
        
       private String getWeek(int iw){  
          String weekStr = "";  
       switch (iw) {  
           case 1:weekStr = "������";break;  
           case 2:weekStr = "����һ";break;  
           case 3:weekStr = "���ڶ�";break;  
           case 4:weekStr = "������";break;  
           case 5:weekStr = "������";break;  
           case 6:weekStr = "������";break;  
           case 7:weekStr = "������";break;  
           default:  
           break;  
       }  
               
       return weekStr;  
               
       }///////////////////////  
        
       public static void main(String[] args) {   
            try {   
                new Weather("101010100"); // 101010100(����)������ĳ��д���  
                new Weather("101280101"); // 101280101(����)������ĳ��д���  
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }      
}