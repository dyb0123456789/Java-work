package weather3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ͨ��get��������վhttp://wthrcdn.etouch.cn/weather_mini��ȡĳ�� ���е�����״�����ݣ����ݸ�ʽ��Json
 * 
 */
public class WeatherUtils {
	/**
	 * ͨ���������ƻ�ȡ�ó��е�������Ϣ
	 * 
	 * @param cityName
	 * @return
	 */
	
	public  static String GetWeatherData(String cityname) {
		StringBuilder sb=new StringBuilder();;
		try {
			cityname = URLEncoder.encode(cityname, "UTF-8");
			String weather_url = "http://wthrcdn.etouch.cn/weather_mini?city="+cityname;
			
 
			URL url = new URL(weather_url);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			GZIPInputStream gzin = new GZIPInputStream(is);
			InputStreamReader isr = new InputStreamReader(gzin, "utf-8"); // ���ö�ȡ���ı����ʽ���Զ������
			BufferedReader reader = new BufferedReader(isr);
			String line = null;
			while((line=reader.readLine())!=null)
				sb.append(line+" ");
			reader.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(sb.toString());
		return sb.toString();
		
	}
	
	
	/**
	 * ��JSON��ʽ���ݽ��н��� ������һ��weather����
	 * @param str
	 * @return
	 */
	public static WeatherInfo GetWeather(String weatherInfobyJson){
		JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson);
		if(dataOfJson.getInt("status")!=1000)
			return null;
		
		//����WeatherInfo������ȡ�����������Ϣ
		WeatherInfo weatherInfo = new WeatherInfo();
		
		//��json��������ȡ����
		String data = dataOfJson.getString("data");
		
		dataOfJson = JSONObject.fromObject(data);
		weatherInfo.setCityname(dataOfJson.getString("city"));
		System.out.println("1111111111111111111111111");
		weatherInfo.setAirquality(dataOfJson.optString("aqi"));
		System.out.println("2222222222222222222222222");
		//��ȡԤ�������Ԥ����Ϣ
		JSONArray forecast = dataOfJson.getJSONArray("forecast");
		//ȡ�õ����
		JSONObject result=forecast.getJSONObject(0);
		
		weatherInfo.setDate(result.getString("date"));
		
		String high = result.getString("high").substring(2);
		String low  = result.getString("low").substring(2);
		
		weatherInfo.setTemperature(low+"~"+high);
		
		weatherInfo.setWeather(result.getString("type"));
		
		
		
		return weatherInfo;
	}
}