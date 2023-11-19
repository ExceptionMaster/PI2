package adda.tests;

import adda.ejercicios.Ejercicio1;

public class Tests {
	public static void test1() {
		System.out.println("Recursivo:");
		System.out.println(Ejercicio1.fRec(20));
		System.out.println("Iterativo:");
		System.out.println(Ejercicio1.fIter(20));
	}
	
	public static void main(String[] args) {
		test1();
	}
}
