
public class Decimal {
	private String a;
	private String b;
	private int intA;
	private int intB;
	private int lenA;
	private int lenB;
	
	/**
	 * ��ʼ��
	 * @param integer: �������ֵ��ַ���
	 * @param decimal: С�����ֵ��ַ���
	 */
	public Decimal(String integer,String decimal) {
		this.a = integer;
		this.b = decimal;
		this.lenA = integer.length();
		this.lenB = decimal.length();
		
		try {
			intA = Integer.parseInt(this.a);
			intB = Integer.parseInt(this.b);
		}catch(NumberFormatException e){
			System.out.println("Wrong number!");
			throw e;
		}
	}
	
	/**
	 * ������С�����ּӷ�(˽�����ں���)
	 * @param num1: ����������ʽ�洢����1��ÿ��Ԫ�ش洢С����һλ
	 * @param num2: ����������ʽ�洢����2����������������������
	 * @return: �����һ��Ԫ�ش洢��λ������λ��ֵ, �ڶ���Ԫ�ش洢С�����ֵĽ��
	 */
	private Decimal leftTrimAdd(int integer, int[] num1, int[] num2) {
		int maxLen = num1.length > num2.length ? num1.length:num2.length;
		int[] num1Full = new int[maxLen];
		int[] num2Full = new int[maxLen];
		int[] result = new int[maxLen];
		
		for(int i = 0; i < maxLen; i++) {
			num1Full[i] = 0;
			num2Full[i] = 0;
		}
		for(int i = 0; i < num1.length; i++) {
			num1Full[i] = num1[i];
		}
		for(int i = 0; i < num2.length; i++) {
			num2Full[i] = num2[i];
		}
		int carry = 0;
		for(int i = maxLen - 1; i >= 0; i--) {
			int tmp = num1Full[i] + num2Full[i] + carry;
			carry = tmp / 10;
			result[i] = tmp % 10;
		}
		//С�������ַ���
		String deci = "";
		int flag = maxLen -1;
		while(result[flag]==0 && flag>0) {
			flag--;
		}
		for(int i = 0; i <= flag; i++) {
			deci = deci + result[i];
		}
		return new Decimal(integer+carry+"",deci);
	}
	
	/**
	 * �ӷ�����
	 * 
	 * @param anotherNum: ��һ�����������Decimalʵ��
	 * @return:�ӷ�������
	 */
	public Decimal add(Decimal anotherNum) {
		//�淶������
		int integer = this.intA + anotherNum.intA;
		int[] decimal_1 = new int[this.lenB];
		int[] decimal_2 = new int[anotherNum.getLenB()];
		
		for(int i = 0;i < this.b.length(); i++) {
			decimal_1[i] = this.b.toCharArray()[i] - 48;
		}
		for(int i = 0; i<anotherNum.getDecimalString().length(); i++) {
			decimal_2[i] = anotherNum.getDecimalString().toCharArray()[i] - 48;
		}
		//����
		return this.leftTrimAdd(integer,decimal_1,decimal_2);
	}
	/**
	 * ��������
	 * @param anotherNum
	 * @return
	 */
	public Decimal subtraction(Decimal anotherNum) {
		//С������
		int[] decimal_1 = new int[this.lenB];
		int[] decimal_2 = new int[anotherNum.getLenB()];
		
		for(int i = 0;i < this.lenB; i++) {
			decimal_1[i] = this.b.toCharArray()[i] - 48;
		}
		for(int i = 0; i<anotherNum.getLenB(); i++) {
			decimal_2[i] = anotherNum.getDecimalString().toCharArray()[i] - 48;
		}
		//��������
		int[] inte_1 = new int[this.lenA];
		int[] inte_2 = new int[anotherNum.getLenA()];
		for(int i = 0; i < this.lenA; i++) {
			inte_1[i] = this.a.toCharArray()[i] - 48;
		}
		for(int i = 0; i < anotherNum.getLenA(); i++) {
			inte_2[i] = anotherNum.getIntergerString().toCharArray()[i] - 48;
		}
		//����
		int maxLenA = this.lenA > anotherNum.getLenA() ? this.lenA:anotherNum.getLenA();
		int maxLenB = this.lenB >  anotherNum.getLenB() ? this.lenB:anotherNum.getLenB();
		int maxLen = maxLenA + maxLenB;
		int[] result = new int[maxLen];
		
		//��
		for(int i=0; i<maxLenA; i++) {
			int get_1;
			int get_2;
			if(this.lenA<maxLenA) {
				int cha = maxLenA - this.lenA;
				if(i< cha)
					get_1 = 0;
				else
					get_1 = inte_1[i-cha];
				get_2 = inte_2[i];
			}else {
				int cha = maxLenA - anotherNum.getLenA();
				if(i< cha)
					get_2 = 0;
				else
					get_2 = inte_2[i-cha];
				get_1 = inte_1[i];
			}
			result[i] = get_1 - get_2;
		}
		for(int i = 0; i < maxLenB; i++) {
			int get_1;
			int get_2;
			if(this.lenB < maxLenB) {
				if(i >= this.lenB)
					get_1 = 0;
				else
					get_1 = decimal_1[i];
				get_2 = decimal_2[i];
			}else {
				if(i >= anotherNum.getLenB())
					get_2 = 0;
				else
					get_2 = decimal_2[i];
				get_1 = decimal_1[i];
			}
			result[i+maxLenA] = get_1 - get_2;
		}
		//��������
		int tag = 0;
		int st = 0;
		while(st < maxLen) {
			if(result[st]>0) {
				tag = 1;
				break;
			}else if(result[st]<0) {
				tag = -1;
				break;
			}
			st++;
		}//ֻ�ǻ��tag,˵�������Ǹ�,st��������ʼλ
		int start = 0;
		while(start < maxLenA) {
			if(result[start] != 0)
				break;
			start++;
		}//start����ʼλ
		int en = maxLen - 1;
		while(en>0) {
			if(result[en] != 0)
				break;
			en--;
		}//en�ǽ���λ
		
		if(en<st) {
			return new Decimal("0","0");
		}
			
		if(tag == 1) {//ȫ��ȡ��ֵ
			int super_sub = 0;
			for(int i = en;i>=st;i--) {
				result[i] -= super_sub;
				if(result[i] >= 0) {
					super_sub = 0;
					continue;
				}
				else {
					 result[i] += 10;
					 super_sub = 1;
				}
			}
		}
		if(tag==-1) { //ȫ��ȡ��ֵ
			int super_add = 0;
			for(int i=en;i>=st;i--) {
				result[i] += super_add;
				if(result[i] <= 0) { 
					
					//��ֵ������������ʾ,ֻ������ǰ��Ӹ���
					result[i] = -result[i];
					
					super_add = 0;
					continue;
				}
				else {
					result[i] -= 10;
					super_add = 1;
					
					//��ֵ������������ʾ,ֻ������ǰ��Ӹ���
					result[i] = -result[i];
				}
			}
		}
		String str_x = "";
		String str_y = "";
		//�ó����
		boolean contrl = false; //�Ƿ�ȥ��������ǰ����
		for(int i = start;i<=en;i++) {
			if(contrl==false && i<maxLenA && result[i]==0) {
				continue;
			}
			else {
				contrl = true;
			}
			if(i<maxLenA) {
				str_x = str_x + result[i];
			}
			else {
				str_y = str_y + result[i];
			}
		}
		if (str_x.equals(""))
			str_x = "0";
		if(str_y.equals(""))
			str_y = "0";
		if(tag==-1)
			str_x = "-" + str_x;  //����ֻ����ǰ��Ӹ���
		return new Decimal(str_x,str_y);
	}
	
	/**
	 * �˷�����
	 * @return
	 */
	public Decimal multi(Decimal ano) {
		Decimal bank = ((this.intA + this.intB) < (ano.intA + ano.intB)) ? this:ano;
		Decimal suke = ((this.intA + this.intB) >= (ano.intA + ano.intB)) ? this:ano;
		Decimal result1 = new Decimal("0","0");
		for(int i=0;i<bank.intA;i++) {
			result1 = result1.add(suke);
		}
		Decimal result2 = new Decimal("0","0");
		for(int i=0;i<bank.intB;i++) {
			result2 = result2.add(suke); 
		}
		int[] zong = new int[result2.lenA+result2.lenB];
		int index;
		for(index=0; index<result2.lenA; index++) {
			zong[index] = result2.a.toCharArray()[index] - 48;
		}
		for(int i=0;i<result2.lenB; i++) {
			zong[index++] = result2.b.toCharArray()[i] - 48;
		}
		int new_len_a = result2.lenA - bank.lenB;
		int new_len_b = result2.lenB + bank.lenB;
		String temp_x = "";
		String temp_y = "";
		
		index = 0;
		if(new_len_a>0) {
			for(int i = 0 ;i<new_len_a;i++) {
				temp_x = temp_x + zong[index++];
			}
			for(int i = 0;i<new_len_b;i++) {
				temp_y = temp_y + zong[index++];
			}
		}else if(new_len_a==0) {
			for(int i = 0;i<zong.length;i++) {
				temp_y = temp_y + zong[index++];
			}
		}
		else {
			new_len_a = -new_len_a;
			for(int i = 0;i<new_len_a;i++ )
				temp_y = temp_y + "0";
			for(int i = 0;i<zong.length;i++) {
				temp_y = temp_y + zong[i];
			}
		}
		if(temp_x.equals(""))
			temp_x = "0";
		if(temp_y.equals(""))
			temp_y = "0";
		return result1.add(new Decimal(temp_x,temp_y));
	}
	
	public int getIntegerPart() {
		return this.intA;
	}
	public int getDecimalPart() {
		return this.intB;
	}
	public String getIntergerString() {
		return this.a;
	}
	public String getDecimalString() {
		return this.b;
	}
	public int getLenA() {
		return this.lenA;
	}
	public int getLenB() {
		return this.lenB;
	}
	public String toString() {
		return a + "." + b;
	}
}
