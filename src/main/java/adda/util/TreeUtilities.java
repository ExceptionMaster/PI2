package adda.util;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class TreeUtilities {
	public static int heightBinary(BinaryTree<Character> tree) {
		return switch (tree) {
			case BEmpty<Character> t -> 0;
			case BLeaf<Character> t -> 0;
			case BTree<Character> t -> Math.max(heightBinary(t.left()), heightBinary(t.right())) +1;
		};
	}
	
	public static int heightNary(Tree<Character> tree) {
		return switch (tree) {
			case TEmpty<Character> t -> 0;
			case TLeaf<Character> t -> 1;
			case TNary<Character> t -> t.children().stream().mapToInt(c -> heightNary(c)).max().orElse(0) + 1;
		};
	}
}
