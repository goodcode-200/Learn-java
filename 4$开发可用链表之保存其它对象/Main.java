
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjLink lin = new ObjLink();
		lin.add(null);
		lin.add(new Person("张明",20));
		lin.add(new Person("李涛",34));
		lin.add(new Person("刘思",37));
		lin.add(new Person("毛任峰",23));
		System.out.printf("get(2):%s\n",lin.get(2).getInfo());
		System.out.printf("get(3):%s\n",lin.get(3).getInfo());
		System.out.printf("contains(\"刘思\",37):%s\n",lin.contains(new Person("刘思",37)));
		System.out.printf("size():%s\n",lin.size());
		lin.remove(new Person("刘思",37));
		System.out.printf("contains(\"刘思\",37):%s\n",lin.contains(new Person("刘思",37)));
		System.out.printf("size():%s\n",lin.size());
		System.out.println(lin.isEmpty());
		lin.clean();
		System.out.println(lin.isEmpty());
		System.out.println(lin.size());
		
		// ---- toArray()测试
		lin.add(new Person("张明",20));
		lin.add(new Person("李桃",25));
		lin.add(new Person("张红日",34));
		lin.add(new Person("张黑的",22));
		Person [] a = lin.toArray();
		System.out.println("------------------toArray测试--------------------");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].getInfo());
		}
	}

}
