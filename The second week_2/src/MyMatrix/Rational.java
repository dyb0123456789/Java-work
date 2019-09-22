package MyMatrix;


//@SuppressWarnings("serial")
public class Rational extends Number{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int numerator;     //分子
    int denominator;  //分母
    Rational(){

    }
    Rational(int a,int b){    //有参构造函数
        if(a==0){
            numerator=0;
            denominator=0;
        }
        else{
            setNumeratorAndDenominator(a,b);
        }
    }
    void setNumeratorAndDenominator(int a,int b){    //设置分子和分母
        int c=f(Math.abs(a),Math.abs(b));            //计算最大公约数
        numerator=a/c;
        denominator=b/c;
        if(numerator<0&&denominator<0){
            numerator=-numerator;
            denominator=-denominator;
        }
    }
    int getNumerator(){
        return numerator;
    }
    int getDenominator(){
        return denominator;
    }
    int f(int a,int b){              //计算最大公约数
        if(a<b){
            int c=a;
            a=b;
            b=c;
        }
        int r=a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
    Rational add(Rational r){       //加法运算
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b+denominator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational(newNumerator,newDenominator);
        return result;
    }
    Rational sub(Rational r){      //减法运算
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b-denominator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational(newNumerator,newDenominator);
        return result;
    }
    Rational muti(Rational r){         //乘法运算
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*a;
        int newDenominator=denominator*b;
        Rational result=new Rational(newNumerator,newDenominator);
        return result;
    }
    Rational div(Rational r){        //除法运算
        int a=r.getNumerator();
        int b=r.getDenominator();
        int newNumerator=numerator*b;
        int newDenominator=denominator*a;
        Rational result=new Rational(newNumerator,newDenominator);
        return result;
    }
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}