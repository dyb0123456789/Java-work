package TestString;

import java.util.Date;
public class TTime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 long a=new Date().getTime();
	        @SuppressWarnings("unused")
			String s1="";
	        int n=20000;
	        for (int i = 0; i < n; i++) {
	            s1+="a"+i;
	        }
	        System.out.println("String使用的时间"+(System.currentTimeMillis()-a)/1000.0+"s");
			long b=System.currentTimeMillis();
	        StringBuilder sb=new StringBuilder();
	        for (int i = 0; i < n; i++) {
	            sb.append("a"+i);
	        }
	        System.out.println("StringBuilder使用的时间"+(System.currentTimeMillis()-b)/1000.0+"s");
	}

}
