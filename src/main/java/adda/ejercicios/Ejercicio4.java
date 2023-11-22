package adda.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio4 {		
	public static List<List<Integer>> ej4Bin(BinaryTree<Integer> tree) {
		Function<List<Integer>,Integer> suma = ls -> ls.stream().collect(Collectors.summingInt(i -> i + (i+1)));
		List<List<Integer>> res = ej4BinAux(tree).stream()
				.filter(path -> suma.apply(path) % path.size() == 0)
				.collect(Collectors.toList());
		return res;
	}
		
	public static List<List<Integer>> ej4BinAux(BinaryTree<Integer> tree) {
		return switch (tree) {
			case BEmpty<Integer> t -> List.of();
			case BLeaf<Integer> t -> List.of(new ArrayList<>(List.of(t.optionalLabel().get())));
			case BTree<Integer> t -> {
				List<List<Integer>> res = new ArrayList<>();
				for (List<Integer> path : ej4BinAux(t.left())) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(0, t.optionalLabel().get());
					res.add(newPath);
				}
				for (List<Integer> path : ej4BinAux(t.right())) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(0, t.optionalLabel().get());
					res.add(newPath);
				}
				yield res;
			}
		};
	}

	public static List<List<Integer>> ej4Nary(Tree<Integer> tree) {
        Function<List<Integer>, Integer> suma = ls -> ls.stream().mapToInt(i -> i + (i + 1)).sum();
        List<List<Integer>> res = ej4NaryAux(tree, suma).stream()
                .filter(path -> suma.apply(path) % path.size() == 0)
                .collect(java.util.stream.Collectors.toList());
        return res;
    }

    private static List<List<Integer>> ej4NaryAux(Tree<Integer> tree, Function<List<Integer>, Integer> suma) {
        return switch (tree) {
            case TEmpty<Integer> t -> List.of();
            case TLeaf<Integer> t -> List.of(new ArrayList<>(List.of(t.optionalLabel().get())));
            case TNary<Integer> t -> {
                List<List<Integer>> res = new ArrayList<>();
                for (Tree<Integer> child : t.children()) {
                    List<List<Integer>> childPaths = ej4NaryAux(child, suma);
                    for (List<Integer> path : childPaths) {
                        path.add(0, t.optionalLabel().get());
                        res.add(new ArrayList<>(path));
                    }
                }
                yield res;
            }
        };
    }
}
