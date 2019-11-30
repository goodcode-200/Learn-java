import java.util.Stack;

public class Main {
	public static StringBuffer toPostfix(String infix) {
		int len = infix.length();
		Stack<String> stack = new Stack<String>(); //�����ջ��˳��ջ
		StringBuffer postfix = new StringBuffer(len * 2); //��׺���ʽ�ַ���
		int i = 0;
		while(i < len) { //������׺���ʽ
			char ch = infix.charAt(i); //���һ���ַ�
			
			switch(ch) { //�����õ��ַ�
			case '+':
			case '-': //���� + - �����
				while(!stack.isEmpty() && !stack.peek().equals("("))  //��ջ��������Ƚ�
					postfix.append(stack.pop()); //��ջ����� ��ӵ���׺���ʽ��
				stack.push(ch + ""); //��ǰ�������ջ
				i ++;
				break;
				
			case '*':
			case '/': //���� * / �����
				while(!stack.isEmpty() && (stack.peek().equals("*")||stack.peek().equals("/"))) 
					postfix.append(stack.pop());  //ջ�����ȼ��ߵ��������ջ
				stack.push(ch + "");
				i ++;
				break;
				
			case '(': //���������ţ���ջ
				stack.push(ch + "");
				i ++;
				break;
				
			case ')': 
				String out = stack.pop(); //���������ţ���ջ����ջΪ�շ���null
				while(out!=null && !out.equals("(") ) { //ֱ����ջ�����Ϊ������
					postfix.append(out);
					out = stack.pop();
				}
				i ++;
				break;
			
			case ' ': //�пո�ʲô����������������
				i ++;
				break;
				
			default: //�������֣���ӵ���׺���ʽ
				while(i<len && ch>='0' && ch <='9') {
					postfix.append(ch);
					i ++;
					if(i < len)
						ch = infix.charAt(i);
				}
				postfix.append(" ");
				break;
				
			}
		}
		while(!stack.isEmpty()) { //�����з��Ų��ܴ�ʹǰ��ķ��ų�ջ�����һ���ĺ���û�з����ˣ������ֶ�����
			postfix.append(stack.pop());
		}
		return postfix;
	}
	public static double toValue(StringBuffer postfix) {
		Stack<Double> stack = new Stack<Double>();
		int len = postfix.length();
		int i = 0;
		while(i < len) {
			char ch = postfix.charAt(i);
			double dou1,dou2; //���Ƕ�Ŀ���㣬��������������
			double value = 0;
			
			switch(ch) {
			case '+':
				dou1 = stack.pop();
				dou2 = stack.pop();
				stack.push(dou1 + dou2);
				i ++;
				break;
				
			case '-':
				dou1 = stack.pop();
				dou2 = stack.pop();
				stack.push(dou2 - dou1);
				i ++;
				break;
			
			case '*':
				dou1 = stack.pop();
				dou2 = stack.pop();
				stack.push(dou1 * dou2);
				i ++;
				break;
				
			case '/':
				dou1 = stack.pop();
				dou2 = stack.pop();
				stack.push(dou2 /dou1);
				i ++;
				break;
				
			case ' ':
				i ++;
				break;
				
			default: //�������ֵ����
				while(i<len && ch>='0' && ch<='9') {
					value = value*10 + (ch-'0');
					i ++;
					if(i < len) { //����һ��
						ch = postfix.charAt(i);
					}
				}
				stack.push(value);
				break;
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "3*5-3+6/2-(3-1)+10";
		System.out.println(a);
		StringBuffer b = toPostfix(a);
		System.out.println(b);
		System.out.println(toValue(b));
		
	    a = "(2-(3*4-2-(3-2)/4)+2+1*9-3)";
		System.out.println(a);
		b = toPostfix(a);
		System.out.println(b);
		System.out.println(toValue(b));
		
		a = "6-2-3/3  +   9  -1";
		System.out.println(a);
		b = toPostfix(a);
		System.out.println(b);
		System.out.println(toValue(b));
		
		a = "1+1*7-2+9-3-(10/2-2+1)+0";
		System.out.println(a);
		b = toPostfix(a);
		System.out.println(b);
		System.out.println(toValue(b));
		
	}
}
