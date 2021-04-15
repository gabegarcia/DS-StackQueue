/**
 * CS113 - Homework 5 - CircularArrayQueue implementation
 * 
 * @author Gabe Garcia
 * @date	04/14/2021
 * @version	1
 * 
 */


package edu.miracosta.cs113;

import java.util.Queue;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E>{
	
	//Data fields
	private int front; //index of the front of the queue
	private int rear; //index of the rear of the queue
	private int size; //current size of the queue
	private int capacity; //current capacity of the queue
	private static final int DEFAULT_CAPACITY = 10; //default capacity of the queue
	
	private E[] theData;
	
	//Constructors
	/** Construct a queue with a defaul capacity
	 */
	public CircularArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	/** Construct a queue with the specified initial capacity
	 * 
	 * @param initCapacity The initial capacity
	 */
	public CircularArrayQueue(int initCapacity) {
		
		capacity = initCapacity;
		theData = (E[]) new Object[capacity];
		front = 0;
		rear = capacity -1;
		size = 0;
	}
	
	//Public methods
	/** Inserts an item 'e' at the rear of the queue
	 * post: e is added the rear of the queue
	 * @param e is the element to add
	 * @return true (always successful)
	 */
	@Override
	public boolean offer(E e) {
		
		if (size == capacity) {
			reallocate();
		}
		size++;
		rear = (rear + 1) % capacity;
		theData[rear] = e;
		return true;
	}

	/** Removes the entry at the front of the queue and returns it
	 * if the queue is not empty
	 * post: front references item that was second in the queue
	 * @return the item removed if successful or null if not
	 */
	@Override
	public E poll() {
		
		if (size == 0) {
			return null;
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}
	
	/** Returns the item at the front of the queue without removing it
	 * @return the item at the front of the queue if successful;
	 * 			return null if the queue is empty
	 */
	@Override
	public E peek() {
		
		if(size == 0) {
			return null;
		} else
			return theData[front];
		
	}
//Why does AbstractQueue need to implement iterator() and size()?
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/** Double the capacity and reallocate the data
	 * pre: The array is filled to capacity
	 * post: The capacity is doubled and the first half of the 
	 * 		expanded array is filled with data.
	 */
	@SuppressWarnings("unchecked")
	private void reallocate() {
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = theData[j];
			j = (j + 1) % capacity;
		}
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		theData = newData;
	}
}
