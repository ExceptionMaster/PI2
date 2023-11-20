package adda.ejercicios;

import java.math.BigInteger;

public class Ejercicio1 {
	public static Double fRecDouble(Integer a) {
		if(a < 6) {
			return 10.;
		} else {
			return Math.pow(a, 3) * fRecDouble(a-1);
		}
	}
	
	public static BigInteger fRecBigInteger(Integer a) {
		BigInteger res = BigInteger.ZERO;
		if(a < 6) {
			res = BigInteger.TEN;
		} else {
			res = BigInteger.valueOf(a).pow(3).multiply(fRecBigInteger(a-1));
		}
		return res;
	}
	
	public static Double fIterDouble(Integer a) {
	    if (a < 6) {
	        return 10.0;
	    } else {
	        Double result = 10.0;
	        for (int i = 6; i <= a; i++) {
	            result *= Math.pow(i, 3);
	        }
	        return result;
	    }
	}
	
	public static BigInteger fIterBigInteger(Integer a) {
		BigInteger res = BigInteger.TEN;
		if (a < 6) {
			return res;
		} else {
			for (int i = 6; i <= a; i++) {
				res = res.multiply(BigInteger.valueOf(i).pow(3));
			}
		}
		return res;		
	}
}
