package adda.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;

public class Ejercicio4 {		
	public static List<List<Integer>> ej4Aux(BinaryTree<Integer> tree) {
		return switch (tree) {
			case BEmpty<Integer> t -> List.of();
			case BLeaf<Integer> t -> List.of(new ArrayList<>(List.of(t.optionalLabel().get())));
			case BTree<Integer> t -> {
				List<List<Integer>> res = new ArrayList<>();
				for (List<Integer> path : ej4Aux(t.left())) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(0, t.optionalLabel().get());
					res.add(newPath);
				}
				for (List<Integer> path : ej4Aux(t.right())) {
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(0, t.optionalLabel().get());
					res.add(newPath);
				}
				yield res;
			}
		};
	}

	public static List<List<Integer>> ej4(BinaryTree<Integer> tree) {
		Function<List<Integer>,Integer> suma = ls -> ls.stream().collect(Collectors.summingInt(i -> i + (i+1)));
		List<List<Integer>> res = ej4Aux(tree).stream().filter(path -> suma.apply(path) % path.size() == 0)
				.collect(Collectors.toList());
		return res;
	}
}
