package lab9_1;

public class TestIntegerMatrix {
	 public static void main(String[] args) {
	 // Creaza tablourile de intregi m1, m2
	 Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
	 Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};
	 // Creaza o instanta de IntegerMatrix
	 IntegerMatrix integerMatrix = new IntegerMatrix();
	 System.out.println("\nm1 + m2 is ");
	 GenericMatrix.printResult( m1, m2, integerMatrix.addMatrix(m1, m2), '+');
	 System.out.println("\nm1 * m2 is ");
	 GenericMatrix.printResult( m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
	 
	 Double[][] m3 = new Double[][]{{1.2, 2.1, 3.1}, {4.1, 5.5, 6.2}, {1.5, 1.7, 1.8}};
	 Double[][] m4 = new Double[][]{{1.6, 1.5, 1.5}, {2.1, 2.5, 2.3}, {0.0, 0.0, 0.0}};
	 DoubleMatrix doubleMatrix = new DoubleMatrix();
	 System.out.println("\nm3 + m4 is ");
	 GenericMatrix.printResult( m3, m4, doubleMatrix.addMatrix(m3, m4), '+');
	 System.out.println("\nm3 * m4 is ");
	 GenericMatrix.printResult( m3, m4, doubleMatrix.multiplyMatrix(m3, m4), '*');
	 
	 
	 Long[][] m5 = new Long[][]{{1L, 2L, 3L}, {4L, 5L, 6L}, {1L, 1L, 1L}};
	 Long[][] m6 = new Long[][]{{1L, 1L, 1L}, {2L, 2L, 2L}, {0L, 0L, 0L}};
	 LongMatrix longMatrix = new LongMatrix();
	 System.out.println("\nm5 + m6 is ");
	 GenericMatrix.printResult( m5, m6, longMatrix.addMatrix(m5,m6), '+');
	 System.out.println("\nm5 * m6 is ");
	 GenericMatrix.printResult( m6, m6, longMatrix.multiplyMatrix(m5, m6), '*');
	 
	 
	 }
}