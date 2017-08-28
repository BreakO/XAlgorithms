package com.xbreak.bat.binaryTree;

/**
 * �������������� X
 *
 * ˼· : ���ݶ����������Ķ���,ÿ���ڵ����ڵ㶼С�ڸýڵ�,���������ҽڵ㶼���ڸýڵ�
 * 		������� + ά�����ڵ���,�Լ��ýڵ�,  
 * 			�����ҽڵ�Ϊnull, ������ڵ�
 * 
 * @author XBreak
 */
public class LargestBSTSubtree {

	public TreeNode findLargestBST(TreeNode root) {
		
		postOrder(root);
		
		return temp;
	}
	TreeNode temp = null;		//���Ķ���������
	int count = 0;				//���ڵ���
	public Integer[] postOrder(TreeNode x) {
		if(x == null)
			return new Integer[] {null,0};
		Integer[] la = postOrder(x.left);
		Integer[] ra = postOrder(x.right);
		Integer lv = la[0], rv = ra[0];
		int lc = la[1], rc = ra[1];
		if((lv == null && rv == null) || ( rv == null && lv < x.val)) {	//�� ����Ϊnull,�� �ҽڵ�Ϊ��,���������С�ڸ��ڵ�,����������
			if(temp == null )
				temp = x;
				
			return new Integer[] {x.val,lc+1+rc};
		}else if((lv == null && rv > x.val) || ((lv != null && rv != null) && (lv < x.val && rv > x.val))) {
			if(temp == null )
				temp = x;
			if(lc + 1 + rc > count || (lc+1+rc == count && x.val > temp.val)) {
				temp = x;
				count = lc + rc + 1;
			}
			return new Integer[] {rv, lc+1+rc};
		}else {
			
			if(la != null && lc >= count &&  (temp == null || lv > temp.val)) {
				temp = x.left;
				count = lc;
			}else if(ra != null && rc >= count &&  (temp == null || rv > temp.val)) {
				temp = x.right;
				count = rc;
			}
			int max = x.val;
			if(lv > max)
				max = lv;
			if(rv > max)
				max = rv;
			return new Integer[] {null, max};
		}
	}
	public static void main(String[] args) {
		TreeNode r = new TreeNode(4);
		 r.left = new TreeNode(2);
		 r.right = new TreeNode(6);
		 r.left.left = new TreeNode(9);
		 r.left.right = new TreeNode(3);
		 r.right.left = new TreeNode(5);
		 r.right.right = new TreeNode(7);
		 TreeNode treeNode = new LargestBSTSubtree().findLargestBST(r);
		 System.out.println(treeNode);
	}
}
