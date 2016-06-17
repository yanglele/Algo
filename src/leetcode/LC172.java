package leetcode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

//分解因子, 当且仅当 因子中出现 一对 (2,5)时, 最后结果会增加一个 trailing zero.
//1.  2的个数永远多于5个个数.
//2.  计算5的个数时, 最简单的方法是 SUM(N/5^1,  N/5^2, N/5^3...)
public class LC172 {

	 public synchronized int trailingZeroes(int n) {
	        int count=0;
	        while(n/5 != 0){
	        	n=n/5;
	        	count=count+n;
	        }
		 return count;
	    }
}
