package com.xbreak.bat.sort;

import java.util.Arrays;

/**
 * ������������ֵ     https://leetcode.com/problems/maximum-gap/description/
 * �����һ�����Ӷ�ΪO(n)���㷨������һ��δ�������������������Ԫ�ص�����ֵ��
	����һ����������A������Ĵ�Сn���뷵������ֵ����֤����Ԫ�ظ������ڵ���2С�ڵ���500��
	[9,3,1,10],4
	���أ�6

	Ͱ����

 * @author XBreak
 */
//������������
public class MaxGap {
    public static void main(String args[])
    {
        int asdf[]=new int[]{96,614,146,429,487,250,536,392,178,26,569,178,595,129,363,550,26,492,561,435,113,492,44,213,478,590,593,488,72,231,73,190,40,62,448,563,1,582,453,33,538,407,57,214,137,193,253,323,167,511,278,148,581,557,551,126,167,50,438,139,345,203,292,288,233,360,343,308,586,519,495,369,159,126,46,183,482,50,214,264,161,145,504,527,52,578,489,104,269,253,349,464,318,458,96,349,46,563,478,1,395,262,285,46,184,115,146,171,452,223,518,414,33,246,70,286,348,582,338,72,191,58,590,298,538,75,283,459,551,2,41,86,354,58,178,411,321,137,37,41,553,303,380,96,198,125,222,544,97,533,437,610,304,276,98,196,170,240,98,413,328,109,70,270,37,398,377,309,367,86,123,401,480,211,48,506,257,125,137,201,194,188,170,300,49,148,493,439,575,93,588,130,403,220,118,578,419,70,519,558,544,84,594,51,240,68,304,282,27,447,149,486,602,519,261,264,179,362,2,495,564,259,431,162,343,165,86,346,408,559,293,274};

        System.out.println(findMaxDivision(asdf, asdf.length));
        Arrays.sort(asdf);
        System.out.println(Arrays.toString(asdf));
    }


    public static int findMaxDivision(int[] A, int n)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(max<A[i])
            {
                max=A[i];
            }
            if(min>A[i])
            {
                min=A[i];
            }
        }


        int span=(max-min);

        int maxArray[]=new int[n+1];
        Arrays.fill(maxArray, Integer.MIN_VALUE);
        int minArray[]=new int[n+1];
        Arrays.fill(minArray, Integer.MAX_VALUE);
        for(int i=0;i<n;i++)
        {
            int index=(A[i]-min)*n/span;    //����Ͱ������, (A[i]-min)/span��ȻС��1,����nҲ��ȻС��n
            if(maxArray[index]<A[i])
            {
                maxArray[index]=A[i];
            }
            if(minArray[index]>A[i])
            {
                minArray[index]=A[i];
            }

        }


        int i=1;
        int j=0;
        int result=0;
        while(i<A.length+1)
        {
            while(i<A.length+1&&minArray[i]==Integer.MAX_VALUE)
            {
                i++;
            }
            if(i>=A.length+1)
            {
                break;
            }
            while(j<i&&maxArray[j]==Integer.MIN_VALUE)
            {
                j++;
            }
            if(j>=i)
            {
                i++;
                continue;
            }
            if(result<minArray[i]-maxArray[j])
            {
                result=minArray[i]-maxArray[j];

            }
            i++;
            j++;
        }


        return result;
    }

}
