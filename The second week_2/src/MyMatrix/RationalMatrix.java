package MyMatrix;
//ÓĞÀíÊı¾ØÕó
public class RationalMatrix extends GenericMatrix<Rational>{
	@Override
    protected Rational add(Rational o1,Rational o2) {
        return o1.add(o2);
    }
    @Override
    protected Rational multiply(Rational o1,Rational o2) {
        return o1.muti(o2);
    }
    
    @Override
    protected Rational zero() {
    	Rational o1 = new Rational(0,0);
        return o1;
    }
}
