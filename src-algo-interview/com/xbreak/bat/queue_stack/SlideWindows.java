package com.xbreak.bat.queue_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * 
 * 思路 : 通过双端队列维护滑动窗口, 遍历数组,若当前队列为空则加入, 若当前队尾元素大于当前遍历的元素,则加入队尾, 否则弹出队尾直至找到比当前遍历的元素大的位置,插入队尾, 
 *        每当遇到一个窗口则,判断队头元素是否过期,过期删除, 最后取队头元素,维护起来
 * 
 * @author XBreak
 */
public class SlideWindows {
	public List<Integer> slide(int[] arr, int w) {
		List<Integer> list = new ArrayList<Integer>();   //维护结果集
		Deque<Integer> q = new LinkedList<Integer>();
		int i = 0; //当前索引
		while(i < arr.length) {
			if(q.isEmpty() || arr[q.peekLast()] > arr[i]){
				q.addLast(i);
				i++;
				if(i >= w  && i<=arr.length) {  //遇到窗口
					while(q.peekFirst() < i-w) q.removeFirst();	//去除过期, 直到队头大于等于i-w
					list.add(arr[q.peekFirst()]);					//维护队头元素
				}
			}else 
				q.removeLast();
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		SlideWindows sw = new SlideWindows();
		List<Integer> list = sw.slide(new int[] {4,3,2,3,3,3,6,7}, 3);
		System.out.println(list);
	}
	
}
