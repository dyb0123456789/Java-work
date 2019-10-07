package FileReader;

public class test_test {
	public static void main(String[] args) {
		String s1 = "    <a href=\"https://www.360.cn/\" rel=\"nofollow\" class=\"member\">360</a>";
		String[] arr1 = s1.split("rel=\"nofollow\" class=\"member\">");
		String[] arr2 = arr1[1].split("</a>");
		System.out.println(arr2[0]);
	}
}
