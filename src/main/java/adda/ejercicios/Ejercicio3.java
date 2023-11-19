package adda.ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;

public class Ejercicio3 {
	public static Boolean estaEquilibrado(BinaryTree<Character> t) {
		return switch(t) {
		case BEmpty<Character> tree -> true;
		case BLeaf<Character> tree -> true;
		case BTree<Character> tree -> {
			Boolean res = false;
			int dif=tree.left().height()-tree.right().height();
			if(dif==0||dif==1||dif==-1){
				res = true;
			}
			yield res;
		}
		};
	}
}
