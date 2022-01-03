package heapclasses;

import entities.Entity;

public class Node {
	Node leftChild;
	Node rightChild;
	Node parent;
	
	// entity saved in this node
	Entity entity;
	
	public Node(Entity newEntity) {
		entity = newEntity;
		leftChild = null;
		rightChild = null;
		parent = null;
	}
}
