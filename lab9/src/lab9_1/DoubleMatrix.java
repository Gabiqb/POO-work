package lab9_1;

public class DoubleMatrix extends GenericMatrix<Double> {
		 @Override /** Aduna doi intregi */
		 protected Double add(Double o1, Double o2) {
		 return o1 + o2;
		 }
		 @Override /** Inmulteste doi intregi */
		 protected Double multiply(Double o1, Double o2) {
		 return o1 * o2;
		 }
		 @Override /** Specifica zero pentru un intreg */
		 protected Double zero() {
		 return 0.0;
		 }
		
}
