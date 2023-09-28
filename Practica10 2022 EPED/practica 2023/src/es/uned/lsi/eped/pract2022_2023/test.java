package es.uned.lsi.eped.pract2022_2023;

import es.uned.lsi.eped.DataStructures.*;

public class GTreeTest {

	public static void main(String[] args) throws Exception {
		System.out.println("Arboles");
		GTree<Integer> gTree = new GTree<Integer>();
		GTree<Integer> a = new GTree<Integer>();
		GTree<Integer> a1 = new GTree<Integer>();
		GTree<Integer> b = new GTree<Integer>();
		GTree<Integer> c = new GTree<Integer>();
		GTree<Integer> c1 = new GTree<Integer>();
		GTree<Integer> c2 = new GTree<Integer>();
		GTree<Integer> c3 = new GTree<Integer>();
		gTree.addChild(1, a);
		gTree.addChild(2, b);
		gTree.addChild(3, c);
		a.addChild(1, a1);
		c.addChild(1, c1);
		c.addChild(2, c2);
		c.addChild(3, c3);

		IteratorIF<Integer> iterator = gTree.iterator(GTree.IteratorModes.PREORDER);
		System.out.println("Size = " + gTree.size());
		System.out.println("FanOut = " + gTree.getFanOut());
		System.out.println("Height = " + gTree.getHeight());
		while (iterator.hasNext()) {
			System.out.print("[" + iterator.getNext() + "] ");
		}
		System.out.println();

		//gTree.setRoot(1);
		//a.setRoot(2);
		b.setRoot(3);
		//c.setRoot(4);
		a1.setRoot(5);
		c1.setRoot(6);
		c2.setRoot(7);
		c3.setRoot(8);
		iterator = gTree.iterator(GTree.IteratorModes.PREORDER);
		System.out.println("Size = " + gTree.size());
		System.out.println("FanOut = " + gTree.getFanOut());
		System.out.println("Height = " + gTree.getHeight());
		while (iterator.hasNext()) {
			System.out.print("[" + iterator.getNext() + "] ");
		}
		System.out.println();
	}

}
