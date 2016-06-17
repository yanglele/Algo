package alogo;

import javax.lang.model.element.NestingKind;
import javax.management.Descriptor;

public class KMP {
	// myKMP
	public static void main(String[] args) {
		String deString = "abcab";
		String reString = "bcabcabdde";
		int[] next = new int[deString.length()];
		getNext(deString, next);

		for (int i = 0; i < next.length; i++)
			System.out.println("next[" + i + "]=  " + next[i]);

		int result = kmp(deString, reString, next);
		System.out.println("===");
		System.out.println("math index=" + result);
	}

	//��ѯ�ַ����Ƿ�����ַ�һ���Ǳ����������ʱÿ����ǰ�ƶ�1��KMP�㷨���Ǽ����ƶ���ֵ��Ȼ���ƶ���Ӧ����
	//�ƶ�λ�� = ��ƥ����ַ��� - ���ƥ���ַ��Ӧ��next[]�е�ֵ
	public static int kmp(String des, String res, int[] next) {
		int i = 0, j = 0;
		while (i < res.length() && j < des.length()) {
			if (des.charAt(j) == res.charAt(i)) {
				i++;
				j++;
			} else {
				int moveLength = 0;
				if (j == 0)
					moveLength = 1;
				else moveLength = j - 1 - next[j - 1];
					i = i - j + moveLength;
					j = 0;
			}
		}
		if (j == des.length())
			return i - j;
		else
			return -1;
	}

	//next����ͨ��������des�ַ�ǰiλ�ַ� ��ǰ��׺�ַ�Ȼ�����ǰ��׺�ַ����� �����ͬ�ַ�λ���iλ�ַ��ƥ��ֵ��
	public static void getNext(String des, int[] next) {
		int right = des.length() - 1;
		next[0] = 0;
		for (int i = 1; i <= right; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (des.substring(0, j + 1).equals(des.substring(i - j, i + 1)))
					if (j >= max)
						max = j + 1;
			}
			next[i] = max;
		}
	}


	 
}