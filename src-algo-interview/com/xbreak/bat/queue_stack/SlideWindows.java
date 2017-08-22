package com.xbreak.bat.queue_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ��������
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * {[2,3,4],2,6,2,5,1}��{2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 * 
 * ˼· : ͨ��˫�˶���ά����������, ��������,����ǰ����Ϊ�������, ����ǰ��βԪ�ش��ڵ�ǰ������Ԫ��,������β, ���򵯳���βֱ���ҵ��ȵ�ǰ������Ԫ�ش��λ��,�����β, 
 *        ÿ������һ��������,�ж϶�ͷԪ���Ƿ����,����ɾ��, ���ȡ��ͷԪ��,ά������
 * 
 * @author XBreak
 */
public class SlideWindows {
	public List<Integer> slide(int[] arr, int w) {
		List<Integer> list = new ArrayList<Integer>();   //ά�������
		Deque<Integer> q = new LinkedList<Integer>();
		int i = 0; //��ǰ����
		while(i < arr.length) {
			if(q.isEmpty() || arr[q.peekLast()] > arr[i]){
				q.addLast(i);
				i++;
				if(i >= w  && i<=arr.length) {  //��������
					while(q.peekFirst() < i-w) q.removeFirst();	//ȥ������, ֱ����ͷ���ڵ���i-w
					list.add(arr[q.peekFirst()]);					//ά����ͷԪ��
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
