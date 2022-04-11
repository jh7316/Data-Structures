package LinkedListandRecursion;

import java.util.Arrays;

public class main {
	public static int maxNum(int[] x, int start, int end) {
		if(end==start) {
			return x[start];
		}
		int mid=(start+end)/2;
		int max1=maxNum(x,start,mid);
		int max2=maxNum(x,mid+1,end);
		
		if(max1>=max2) {
			return max1;
		}else {
			return max2;
		}
		
		
	}
	
	public static double avgNum(int[] x,int start,int end) {

		int mid=(start+end)/2;
		if(end==start) {
			return x[start];
		}else {
			return (avgNum(x,start,mid)+avgNum(x,mid+1,end))/2;
		}
		
	}

	public static int[] mergeArr(int[] a,int[] b) {
		int[] finalarr=new int[a.length+b.length];
		for(int i=0;i<a.length;i++) {
			finalarr[i]=a[i];
		}
		for(int j=a.length;j<finalarr.length;j++) {
			finalarr[j]=b[j-a.length];
		}
		
		Arrays.sort(finalarr);
		return finalarr;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] testarr= {2,3,6,45,2,45,9,6};
		int[] testarr2= {7,12,13,21,42,46};
		int[] testarr3= {2,2,3,6,6,9,45,45};
		
		
		
		System.out.println(maxNum(testarr,0,testarr.length-1));
		System.out.println(avgNum(testarr,0,testarr.length-1));
		
		int[] newarr=mergeArr(testarr2,testarr3);
		for(int i=0;i<newarr.length;i++) {
			System.out.print(newarr[i]+"  ");
		}
		
		
		
	}

}
