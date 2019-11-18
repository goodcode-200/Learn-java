
public class ObjLink {
        //Node类被封装到ObjLink类里，只希望被ObjLink使用
		private class Node{
			private Person data;
			private Node next;
			public Node(Person data) {
				this.data = data;
			}
			public void addNode(Node newNode) {
				if(this.next == null) {  //当前节点的下一个节点为null
					this.next = newNode;
					ObjLink.this.count ++;  //外部类的属性count 加1
				}else {   //不能放在当前节点的后面，就看下一个节点能不能加
					this.next.addNode(newNode);
				}
			}
			public Person getNode(int index) {
				if(index == ObjLink.this.foot ++) { 	//符合查找的索引
					return this.data; //返回当前节点的数据
				}else {
					return this.next.getNode(index);
				}
			}
			public boolean containsNode(Person data) {
				if(data.compare(this.data)) {
					return true;
				}else {
					if(this.next != null) {
						return this.next.containsNode(data);
					}else {
						return false;
					}
				}
			}
			public void removeNode(Node previous,Person data) {
				if(this.data.compare(data)) { //当前节点满足删除条件
					previous.next = this.next;   //空出当前节点
				}else {
					this.next.removeNode(this,data);
				}
			}
			public void toArrayNode() {
				ObjLink.this.retData[ObjLink.this.foot ++] = this.data;
				if(this.next != null) {
					this.next.toArrayNode();
				}
			}
		}
		// ============以上是内部类===============
		// ----定义link的业务
		private Node root; 	//根节点
		private int count = 0; 	//统计节点的个数
		private int foot;	//用来标记索引顺序
		private Person [] retData; //保存的对象数组
		public void add(Person data) {
			if(data == null) {
				return ;  	//保存的数据不能为null
			}
			Node newNode = new Node(data); 	//将数据封装为节点
			if(this.root == null) {		//没有根节点
				this.root = newNode;
				this.count ++; 
			}else {		//交给node类去处理
				this.root.addNode(newNode);
			}
		}
		public int size() { 	//获得链表的长度
			return this.count;
		}
		public boolean isEmpty() { 	//判断是否为空
			return this.count == 0;
		}
		public void clean(){	//清空链表
			this.root = null; 	//整个链表是依靠root来存在的，root为空，链表将消失
			this.count = 0;
		}
		public Person get(int index) {
			if(index > this.count) {
				return null;
			}
			this.foot = 0; 	//脚标从0开始
			return this.root.getNode(index);
		}
		public boolean contains(Person data) {	//判断是否包含数据
			if(data == null) {
				return false;
			}
			return this.root.containsNode(data);
		}
		public void remove(Person data) {
			if(this.contains(data)) { //查到有此数据
				if(this.root.data.compare(data)) {
					this.root = this.root.next;   //改变根节点
				}else {	//要删除的不是根节点
					this.root.next.removeNode(this.root,data);
				}
				this.count--;
			}
		}
		public Person [] toArray() {
			if(this.count == 0) {
				return null;  //没数据
			}
			this.foot = 0; //通过foot设置数组索引
			this.retData = new Person [this.count];  //开辟数组
			this.root.toArrayNode(); //交给Node类来处理
			return this.retData;
		}
}
