package weather3;

public class WeatherInfo {
	private String date;//ʱ��
	private String cityname;//������
	private String weather;//����
	private String temperature;//����
	private String airquality;//pm2.5
 
	public String getDate() {
		return date;
	}
 
	public void setDate(String date) {
		this.date = date;
	}
 
	public String getCityname() {
		return cityname;
	}
 
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
 
	public String getWeather() {
		return weather;
	}
 
	public void setWeather(String weather) {
		this.weather = weather;
	}
 
	public String getTemperature() {
		return temperature;
	}
 
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
 
	public String getAirquality() {
		return airquality;
	}
 
	public void setAirquality(String airquality) {
		this.airquality = airquality;
	}
 
	@Override
	public String toString() {
		return "WeatherInfo [date=" + date + ", cityname=" + cityname
				+ ", weather=" + weather + ", temperature=" + temperature
				+ ", airquality=" + airquality + "]";
	}
	
}
