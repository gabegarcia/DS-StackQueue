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
	public List<E> myList;
	
	public ArrayListStack() {
		myList = new ArrayList<E>();
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		
		return myList.size() == 0;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(empty()) { 
			throw new EmptyStackException();
		}
		return myList.get(myList.size() - 1);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(empty()) {
			throw new EmptyStackException();
		}
		return myList.remove(myList.size() - 1);
	}

	@Override
	public E push(E obj) {
		myList.add(obj);
		return obj;
	}



}
