
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjLink lin = new ObjLink();
		lin.add(null);
		lin.add(new Person("����",20));
		lin.add(new Person("����",34));
		lin.add(new Person("��˼",37));
		lin.add(new Person("ë�η�",23));
		System.out.printf("get(2):%s\n",lin.get(2).getInfo());
		System.out.printf("get(3):%s\n",lin.get(3).getInfo());
		System.out.printf("contains(\"��˼\",37):%s\n",lin.contains(new Person("��˼",37)));
		System.out.printf("size():%s\n",lin.size());
		lin.remove(new Person("��˼",37));
		System.out.printf("contains(\"��˼\",37):%s\n",lin.contains(new Person("��˼",37)));
		System.out.printf("size():%s\n",lin.size());
		System.out.println(lin.isEmpty());
		lin.clean();
		System.out.println(lin.isEmpty());
		System.out.println(lin.size());
		
		// ---- toArray()����
		lin.add(new Person("����",20));
		lin.add(new Person("����",25));
		lin.add(new Person("�ź���",34));
		lin.add(new Person("�źڵ�",22));
		Person [] a = lin.toArray();
		System.out.println("------------------toArray����--------------------");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].getInfo());
		}
	}

}
