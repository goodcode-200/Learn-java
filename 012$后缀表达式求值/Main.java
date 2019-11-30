import java.util.Stack;

public class Main {
	public static StringBuffer toPostfix(String infix) {
		int len = infix.length();
		Stack<String> stack = new Stack<String>(); //运算符栈，顺序栈
		StringBuffer postfix = new StringBuffer(len * 2); //后缀表达式字符串
		int i = 0;
		while(i < len) { //遍历中缀表达式
			char ch = infix.charAt(i); //获得一个字符
			
			switch(ch) { //处理获得的字符
			case '+':
			case '-': //遇到 + - 运算符
				while(!stack.isEmpty() && !stack.peek().equals("("))  //与栈顶运算符比较
					postfix.append(stack.pop()); //出栈运算符 添加到后缀表达式串
				stack.push(ch + ""); //当前运算符入栈
				i ++;
				break;
				
			case '*':
			case '/': //遇到 * / 运算符
				while(!stack.isEmpty() && (stack.peek().equals("*")||stack.peek().equals("/"))) 
					postfix.append(stack.pop());  //栈顶优先级高的运算符出栈
				stack.push(ch + "");
				i ++;
				break;
				
			case '(': //遇到左括号，入栈
				stack.push(ch + "");
				i ++;
				break;
				
			case ')': 
				String out = stack.pop(); //遇到右括号，出栈，若栈为空返回null
				while(out!=null && !out.equals("(") ) { //直到出栈运算符为左括号
					postfix.append(out);
					out = stack.pop();
				}
				i ++;
				break;
			
			case ' ': //有空格，什么都不做，继续往下
				i ++;
				break;
				
			default: //遇到数字，添加到后缀表达式
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
		while(!stack.isEmpty()) { //后面有符号才能促使前面的符号出栈，最后一个的后面没有符号了，所以手动弹出
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
			double dou1,dou2; //都是二目运算，所以两个操作数
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
				
			default: //遇到数字的情况
				while(i<len && ch>='0' && ch<='9') {
					value = value*10 + (ch-'0');
					i ++;
					if(i < len) { //有下一个
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
