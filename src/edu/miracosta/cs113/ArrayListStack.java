/**
 * Project: CS113 Homework 5 use ArrayList to implement a Stack
 * 
 * @author Gabe Garcia
 * @date	4/7/2021
 * @version	1.0
 * 
 */

package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack<E> implements StackInterface<E> {
	
	//Data fields
	public List<E> myList;
	
	//Constructor
	
	public ArrayListStack() {
		myList = new ArrayList<E>();
	}
	
	/** Returns boolean true or false if the List is empty
	 * @return true or false
	 */
	@Override
	public boolean empty() {
				
		return myList.size() == 0;
	}

	/** Returns the item at the top of the stack without removing it if stack is not empty
	 * @return item at top of stack; throws EmptyStackException if stack is empty
	 */
	@Override
	public E peek() {
		
		if(empty()) { 
			throw new EmptyStackException();
		}
		return myList.get(myList.size() - 1);
	}

	/** Returns the item at the top of the stack and removes it if stack is not empty
	 * @return the item at the top of the stack; throws EmptyStackException if stack is empty
	 */
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(empty()) {
			throw new EmptyStackException();
		}
		return myList.remove(myList.size() - 1);
	}

	/** Adds an object to the top of the stack and returns the object
	 * @param E object to add
	 * @return returns object
	 */
	@Override
	public E push(E obj) {
		myList.add(obj);
		return obj;
	}



}
