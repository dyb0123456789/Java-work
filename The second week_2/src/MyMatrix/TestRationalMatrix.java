package MyMatrix;

public class TestRationalMatrix {
	
	public static void main(String[] args) {
		Rational[][] m1 = new Rational[][] {};
		Rational[][] m2 = new Rational[][] {};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				m1[i][j].numerator = 1;
				m1[i][j].denominator = i*j+1;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				m2[i][j].numerator = 1;
				m2[i][j].denominator = i*j+3;
			}
		}
        
        RationalMatrix im = new RationalMatrix();
        
        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(m1, m2, im.addMatrix(m1, m2), '+');
        
        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(m1, m2, im.multiplyMatrix(m1, m2), '*');
    }
}
