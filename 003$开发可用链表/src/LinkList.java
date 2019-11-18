
public class LinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Link lin = new Link();
		lin.add(null);
		lin.add("Hello");
		lin.add("World");
		lin.add("google");
		lin.add("yooyin");
		System.out.printf("get(2):%s\n",lin.get(2));
		System.out.printf("get(3):%s\n",lin.get(3));
		System.out.printf("contains(\"World\"):%s\n",lin.contains("World"));
		System.out.printf("size():%s\n",lin.size());
		lin.remove("World");
		System.out.printf("contains(\"World\"):%s\n",lin.contains("World"));
		System.out.printf("size():%s\n",lin.size());
		System.out.println(lin.isEmpty());
		lin.clean();
		System.out.println(lin.isEmpty());
		System.out.println(lin.size());
		
		// ---- toArray()≤‚ ‘
		lin.add("1");
		lin.add("2");
		lin.add("3");
		lin.add("4");
		String [] a = lin.toArray();
		System.out.println("------------------toArray≤‚ ‘--------------------");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
	}
}
