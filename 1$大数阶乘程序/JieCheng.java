package test_feibo;

import java.util.Scanner;

public class JieCheng {
	public static void jie_cheng(int n) {
		int[] array = new int[10000];
		array[0] = 1; //�׳����
		int len = 1;//��¼��ֵ��λ������
		for(int i=1;i<=n;i++) {
		//��ѭ����ÿ�λ�ȡһ�����ݲ���׳�
			for(int j=0;j<len;j++) {
			//��ѭ��������õĽ׳�������ÿһλ���
				array[j] *= i; //һλ���˶�λ�������ֳ˷��������
			}
			//��һ������λ����
			int super_add = 0;
			for(int j=0;j<len;j++) {
			//����������λ�Ͻ�λ
				array[j] += super_add; 
				super_add = array[j]/10;  //super_addҲ�������
				array[j] = array[j]%10;
			}
			while(super_add>0) {
			//������������λ��
				array[len++] = super_add;
				int last = len-1;
				super_add = array[last]/10;
				array[last] = array[last]%10;
			}
			//��ӡ����ǰ�׳˽����
			System.out.printf("%d�Ľ׳�: ",i);
			for(int j=len-1;j>=0;j--) {
			//�����������ȷ
				System.out.print(array[j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		jie_cheng(n);
		input.close();
	}

}
