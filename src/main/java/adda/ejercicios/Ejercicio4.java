package adda.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;

public class Ejercicio4 {
	private static final Predicate<List<Integer>> ADDITION_DIVISIBLE_BY_PATH_SIZE = ls -> ls.stream().collect(Collectors.summingInt(i -> i + (i+1))) % ls.size() == 0;
	
	public static List<List<Integer>> ej4Binary(BinaryTree<Integer> tree) {
		List<List<Integer>> res = new ArrayList<>();
		ej4Binary(tree, new ArrayList<>(), 0, res);
        return res;
	}
	
	public static List<List<Integer>> ej4Binary(BinaryTree<Integer> tree, List<Integer> currentPath, Integer addition, List<List<Integer>> res) {
	    return switch (tree) {
	        case BEmpty<Integer> t -> res;
	        case BLeaf<Integer> t -> {
	            currentPath.add(t.label());
	            addition += t.label();
	            
	            if (ADDITION_DIVISIBLE_BY_PATH_SIZE.test(currentPath)) {
	                res.add(new ArrayList<>(currentPath));
	            }

	            currentPath.remove(currentPath.size() - 1);
	            addition -= t.label();

	            yield res;
	        }
	        case BTree<Integer> t -> {
	            ej4Binary(t.left(), currentPath, addition, res);
	            ej4Binary(t.right(), currentPath, addition, res);

	            yield res;
	        }
	    };
	}
	
	/*public static List<List<Integer>> ej4Nary(Tree<Integer> tree) {
		
	}*/
}
