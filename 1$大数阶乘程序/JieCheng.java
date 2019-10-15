package test_feibo;

import java.util.Scanner;

public class JieCheng {
	public static void jie_cheng(int n) {
		int[] array = new int[10000];
		array[0] = 1; //阶乘最初
		int len = 1;//记录数值的位数长度
		for(int i=1;i<=n;i++) {
		//外循环：每次获取一个数据参与阶乘
			for(int j=0;j<len;j++) {
			//内循环：将获得的阶乘数据与每一位相乘
				array[j] *= i; //一位数乘多位数，这种乘法很难溢出
			}
			//下一步：进位操作
			int super_add = 0;
			for(int j=0;j<len;j++) {
			//这里在已有位上进位
				array[j] += super_add; 
				super_add = array[j]/10;  //super_add也很难溢出
				array[j] = array[j]%10;
			}
			while(super_add>0) {
			//这里用来扩充位数
				array[len++] = super_add;
				int last = len-1;
				super_add = array[last]/10;
				array[last] = array[last]%10;
			}
			//打印出当前阶乘结果：
			System.out.printf("%d的阶乘: ",i);
			for(int j=len-1;j>=0;j--) {
			//倒着输出才正确
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
