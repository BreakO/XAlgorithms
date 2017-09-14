package com.xbreak.newcode.godfutrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author XBreak
 *	出现次数大于n/2的数
 */
public class FindOutMaxTime {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			String[] split = str.split(" ");
			
			getRes(split);
		}
		
	}

	private static void getRes(String[] str) {
		// TODO Auto-generated method stub
		
		if(str == null || str.length == 0)
			return ;
		int N = str.length;
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : str)
			if(map.containsKey(s)) {
				int t = map.get(s);
				if(t >= N/2)
					continue;
				t++;
				if(t >= N/2)
					System.out.println(s);
				map.put(s, t);
			}else {
				map.put(s, 1);
			}
	}
}
