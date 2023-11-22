package adda.tests;

import java.util.List;

import adda.ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio4 {
	
	public static void testBinary() {
		System.out.println("BINARIO:");
	    for(String linea : Files2.linesFromFile("data/PI2Ej4DatosEntradaBinary.txt")) {
	        BinaryTree<Integer> t = BinaryTree.parse(linea, Integer::parseInt);
	        List<List<Integer>> caminos = Ejercicio4.ej4Bin(t);
	        System.out.println("Arbol: " + linea);
	        for(List<Integer> camino : caminos) {
	            System.out.println("    " + camino);
	        }
	    }
	}
	
	public static void testNary() {
		System.out.println("\n\nN-ARIO:");
	    for(String linea : Files2.linesFromFile("data/PI2Ej4DatosEntradaNary.txt")) {
	        Tree<Integer> t = Tree.parse(linea, Integer::parseInt);
	        List<List<Integer>> caminos = Ejercicio4.ej4Nary(t);
	        System.out.println("Arbol: " + linea);
	        for(List<Integer> camino : caminos) {
	            System.out.println("    " + camino);
	        }
	    }
	}

	
	public static void test() {
		testBinary();
		testNary();
	}
}
