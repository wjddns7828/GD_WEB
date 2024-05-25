package com.min.edu;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedList_Queue {
	public void linked() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//마지막 인덱스에 입력이 됨
		list.add(3);
		list.add(10);
		list.addFirst(1);
		list.addLast(4);
		list.add(1,99);//위치 값
		
		System.out.println(list);
	}
	public void queue() {
		Queue<String> que = new LinkedList<String>();
		String str1="JAVA";
		String str2="DB";
		String str3="WEB";
		String str4="SERVER";
		
		que.offer(str1);
		que.offer(str2);
		que.offer(str3);
		que.offer(str4);
		System.out.println("peek()"+que.peek());
//		while (que.peek()!=null) {
//			System.out.println(que.element());
//		}
		while (que.peek()!=null) {
			System.out.println(que.poll());
		}
	}
}
