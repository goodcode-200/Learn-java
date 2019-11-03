
public class MyDecimal {
	public static void main(String[] args) {
		Decimal a = new Decimal("123","234");
		Decimal b = new Decimal("123","834");
		Decimal c = new Decimal("123","834");
		Decimal d = new Decimal("123","236");
		Decimal e = new Decimal("123","23656");
		//¼Ó
		Decimal test1 = a.add(b);
		System.out.println(test1);
		Decimal test2 = c.add(d);
		System.out.println(test2);
		Decimal test3 = d.add(e);
		System.out.println(test3);
		//¼õ
		System.out.println("==================================");
		Decimal test4 = a.subtraction(b);
		System.out.println(test4);
		Decimal f = new Decimal("525","236");
		Decimal g = new Decimal("433","236");
		Decimal h = new Decimal("433","236");
		Decimal i = new Decimal("433","237");
		Decimal j = new Decimal("5467","5768");
		Decimal k = new Decimal("67","578");
		Decimal l= new Decimal("57","3462");
		Decimal test5 = f.subtraction(g);
		System.out.println(test5);
		Decimal test6 = h.subtraction(g);
		System.out.println(test6);
		Decimal test7 = h.subtraction(i);
		System.out.println(test7);
		Decimal test8 = i.subtraction(j);
		Decimal test9 = j.subtraction(k);
		Decimal test10 = l.subtraction(k);
		System.out.println(test8);
		System.out.println(test9);
		System.out.println(test10);
		//³Ë·¨
		System.out.println("==================================");
		Decimal m = new Decimal("57","34");
		Decimal n = new Decimal("5","34");
		Decimal o = new Decimal("57","4");
		Decimal p = new Decimal("32","1");
		Decimal q = new Decimal("0","57");
		Decimal r = new Decimal("0","135");
		Decimal test11 = m.multi(n);
		Decimal test12 = o.multi(p);
		Decimal test13 = n.multi(p);
		Decimal test14 = m.multi(o);
		Decimal test15 = q.multi(r);
		System.out.println(test11);
		System.out.println(test12);
		System.out.println(test13);
		System.out.println(test14);
		System.out.println(test15);
	}
}
