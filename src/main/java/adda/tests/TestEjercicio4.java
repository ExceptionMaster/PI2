package adda.tests;

import adda.ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjercicio4 {
	private static void testBinary() {
		int i = 1;
		System.out.println("========= ARBOLES BINARIOS =========");
		for(String t : Files2.linesFromFile("data/PI2Ej4DatosEntradaBinary.txt")) {
			BinaryTree<Integer> tree = BinaryTree.parse(t, s -> Integer.valueOf(s));
			System.out.println("Arbol " + i + ": " + Ejercicio4.ej4Binary(tree));
			i++;
		}
	}
	
	public static void test() {
		testBinary();
	}
}
