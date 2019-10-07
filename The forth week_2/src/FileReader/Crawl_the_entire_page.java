package FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Crawl_the_entire_page {
	public static void main(String[] args) throws IOException{
		String charset = "utf-8";
		URL url = new URL("http://www.w3.org/Consortium/Member/List");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),charset));
		BufferedWriter write = new BufferedWriter(new FileWriter("data.html"));
		String line;
		while ((line = reader.readLine()) != null) {
		System.out.println(line);
		write.write(line);
		write.newLine();
		}
		reader.close();
		write.close();
		}
}
