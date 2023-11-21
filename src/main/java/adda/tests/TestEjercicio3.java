package adda.tests;

import adda.ejercicios.Ejercicio3;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class TestEjercicio3 {
	private static void testBinary() {
		int i = 1;
		System.out.println("========= ARBOLES BINARIOS =========");
		for(String t : Files2.linesFromFile("data/PI2Ej3DatosEntradaBinary.txt")) {
			BinaryTree<Character> tree = BinaryTree.parse(t,s -> s.charAt(0));
			System.out.println("Arbol " + i + " equilibrado: " + Ejercicio3.isBalancedBinary(tree));
			i++;
		}
	}
	
	private static void testNary() {
		int i = 1;
		System.out.println("\n\n========= ARBOLES N-ARIOS =========");
		for(String t : Files2.linesFromFile("data/PI2Ej3DatosEntradaNary.txt")) {
			Tree<Character> tree = Tree.parse(t,s -> s.charAt(0));
			System.out.println("Arbol " + i + " equilibrado: " + Ejercicio3.isBalancedNary(tree));
			i++;
		}		
	}
	
	public static void test() {
		testBinary();
		testNary();
	}
}
