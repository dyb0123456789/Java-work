package weather3;

public class Test {
	public static void main(String[]  args){
		String info = WeatherUtils.GetWeatherData("±±¾©");
		System.out.println(info);
		WeatherInfo weatherinfo = WeatherUtils.GetWeather(info);
		System.out.println(weatherinfo.toString());
	}
}
