package adda.tests;

import java.util.List;

import adda.ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class TestEjercicio4 {
	
	public static void testBinary() {
	    for(String linea : Files2.linesFromFile("data/PI2Ej4DatosEntradaBinary.txt")) {
	        BinaryTree<Integer> t = BinaryTree.parse(linea, Integer::parseInt);
	        List<List<Integer>> caminos = Ejercicio4.ej4(t);
	        System.out.println("Arbol: " + linea);
	        for(List<Integer> camino : caminos) {
	            System.out.println("    " + camino);
	        }
	    }
	}

	
	public static void test() {
		testBinary();
	}
}
