package adda.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4 {
	private static final Predicate<List<Integer>> ADDITION_DIVISIBLE_BY_PATH_SIZE = ls -> ls.stream().collect(Collectors.summingInt(i -> i + (i+1))) % ls.size() == 0;
	
	public static List<List<Integer>> ej4Binary(BinaryTree<Integer> tree) {
		List<List<Integer>> res = new ArrayList<>();
		ej4Binary(tree, new ArrayList<>(), 0, 0, res);
        return res;
	}
	
	public static List<List<Integer>> ej4Binary(BinaryTree<Integer> tree, List<Integer> l, Integer sum, Integer length, List<List<Integer>> res) {
	    return switch (tree) {
	        case BEmpty<Integer> t -> res; // En caso de ser BEmpty, no hay acciones que hacer, retornamos el resultado actual
	        case BLeaf<Integer> t -> {
	            l.add(t.label());
	            sum += t.label();
	            length += 1;

	            if (sum % length == 0) {
	                res.add(new ArrayList<>(l));
	            }

	            l.remove(l.size() - 1);
	            sum -= t.label();
	            length -= 1;

	            yield res; // Retornamos el resultado actual
	        }
	        case BTree<Integer> t -> {
	            ej4Binary(t.left(), l, sum, length, res);
	            ej4Binary(t.right(), l, sum, length, res);

	            yield res; // Retornamos el resultado actual
	        }
	    };
	}
	
	/*public static List<List<Integer>> ej4Nary(Tree<Integer> tree) {
		
	}*/
}
