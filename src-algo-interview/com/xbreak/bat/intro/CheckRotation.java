package com.xbreak.bat.intro;

/**
 * 1.2 检查旋转词
 * 链接：https://www.nowcoder.com/questionTerminal/c3f30092999e42a9b2c36496693bd458
 *	对字符串的旋转操作描述如下：  
 * 	例如： str = "123456"
 * 	str的所有旋转词为："123456"，"234561","345612","456123","561234","612345"。  
 * 	给定两个字符串str1和str2，实现判断str1是否是str2的旋转词。
 * 
 * 思路 : 把 str2+str2,然后再str2+str2中查找是否含有str1, 这边用到了kmp
 * 
 * @author XBreak
 */
public class CheckRotation {
		/**
		 *	判断str1是否是str2的旋转词
		 *	输入：字符串str1，字符串str2
		 *	返回：true代表str1是str2的旋转词；false代表不是
		 */
		public boolean isRotation(String str1, String str2) {
	        if(str1.length() == 0)
	            if(str2.length() == 0)
	                return true;
	            else
	                return false;
	        if(str1.length() != str2.length())
	            return false;
			return kmp(str2+str2, str1);
		}
	    
	    public boolean kmp(String str, String des){
	        int [] next = getNext(des);
	        int i=0,j=0;
	        while(i < str.length()){
	            if(j == -1 || str.charAt(i) == des.charAt(j)){
	                i++;
	                j++;
	           	    if(j == des.length())
	                    return true;
	            }else
	                j = next[j];
	        }
	        return false;
	    }
	    public int[] getNext(String pat){
	        int [] next = new int[pat.length()];
	        int i = 0, j = -1;
	        next[0] = -1;
	        while(i < pat.length() - 1){
	            if(j == -1 || pat.charAt(i) == pat.charAt(j)){
	                j++;
	                i++;
	                next[i] = j;
	            }else{
	                j = next[j];
	            }
	                
	        }
	        return next;
	    }
	public static void main(String[] args) {
		CheckRotation ch = new CheckRotation();
		System.out.println(ch.isRotation("EAACBADAAE", "BAAACADAEE"));
		
	}
}
