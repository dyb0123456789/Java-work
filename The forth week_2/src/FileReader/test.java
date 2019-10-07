package FileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class test {
	public static void main(String[] args) throws IOException {
		String charset = "utf-8";
		URL url = new URL("http://www.w3.org/Consortium/Member/List");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
		BufferedWriter write = new BufferedWriter(new FileWriter("data.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			//System.out.println(line);
			String s = null;
			//System.out.println(line);
			String str = "rel=\"nofollow\" class=\"member\"";
			if(line.contains(str)) {
				String[] arr1 = line.split("rel=\"nofollow\" class=\"member\">");
				String[] arr2 = arr1[1].split("</a>");
				s = arr2[0];
				write.write(s);
				write.newLine();
			}
		}
		reader.close();
		write.close();
	}
}