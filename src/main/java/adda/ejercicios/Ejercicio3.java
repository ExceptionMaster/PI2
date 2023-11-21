package adda.ejercicios;

import java.util.List;

import adda.util.TreeUtilities;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio3 {
	public static Boolean isBalancedBinary(BinaryTree<Character> tree) {
		return switch(tree) {
			case BEmpty<Character> t -> true;
			case BLeaf<Character> t -> true;
			case BTree<Character> t -> {
				int heightLeft = TreeUtilities.heightBinary(t.left());
				int heightRight = TreeUtilities.heightBinary(t.right());
				
				boolean isLeftBalanced = isBalancedBinary(t.left());
				boolean isRightBalanced = isBalancedBinary(t.right());
				
				yield Math.abs(heightLeft - heightRight) <= 1 && isLeftBalanced && isRightBalanced;
			}
		};
	}
	
	public static Boolean isBalancedNary(Tree<Character> tree) {
	    return switch (tree) {
	        case TEmpty<Character> t -> true;
	        case TLeaf<Character> t -> true;
	        case TNary<Character> t -> {
	            List<Tree<Character>> children = t.children();
	            int maxHeight = t.children().stream().mapToInt(x -> TreeUtilities.heightNary(x)).max().getAsInt();
	            int minHeight = t.children().stream().mapToInt(x -> TreeUtilities.heightNary(x)).min().getAsInt();
	            
	            boolean isSubtreesBalanced = isBalancedNary(children, 0);
	            
	            yield (maxHeight - minHeight <= 1) && isSubtreesBalanced;
	        }
	    };
	}
	
	public static Boolean isBalancedNary(List<Tree<Character>> children, Integer level) {
		if (level == children.size()) {
	        return true;
	    }
	    Tree<Character> child = children.get(level);
	    boolean isSubtreeBalanced = isBalancedNary(child);
	    return isSubtreeBalanced && isBalancedNary(children, level + 1);
	}

}
