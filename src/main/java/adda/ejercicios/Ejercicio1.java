package adda.ejercicios;

public class Ejercicio1 {
	public static Double fRec(Integer a) {
		if(a < 6) {
			return 10.;
		} else {
			System.out.println(Math.pow(a, 3) * fRec(a-1));
			return Math.pow(a, 3) * fRec(a-1);
		}
	}
	
	public static Double fIter(Integer a) {
		Double res = null;
		while(!(a < 6)) {
			res = Math.pow(a, 3);
			a--;
		}
		return res;
	}
}
