import java.util.Random;

public class BT<Template> {
	//内部类,只为BT服务
	private class Node{
		private Template data;
		private Node leftNode = null ;
		private Node rightNode = null ;
		private boolean isLeftClue = false; //标记此结点的左子树是否为线索
		private boolean isRightClue = false; //标记此结点的右子树是否为线索
		private boolean is_go = false; //代表左子树是否遍历过
		public Node(Template data) {
			this.data = data;
		}
		public void addNode(Template data) { //增加函数
			if(this.leftNode==null) {
				this.leftNode = new Node(data) ;
			}else if(this.rightNode==null) {
				this.rightNode = new Node(data) ;
			}else {
				//随机构造二叉树
				Random ra =new Random();
				if(ra.nextInt()%2==0) {
					this.leftNode.addNode(data);
				}else {
					this.rightNode.addNode(data);
				}
			}
		}
		public void orderMidNode() {
			if(this.leftNode != null) {
				this.leftNode.orderMidNode();
			}
			array[BT.this.foot++] = this; //中序
			if(this.rightNode != null){
				this.rightNode.orderMidNode();
			}
		}
		public void clueNode(Object[] arr) {
			Node prev = BT.this.getPre(arr,this);
			Node next = BT.this.getNext(arr,this);
			if(this.leftNode==null) { //左子树空了
				this.leftNode = prev;
				this.isLeftClue = true;
			}else { //左子树非空
				this.leftNode.clueNode(arr); //递归填充线索
			}
			if(this.rightNode==null) {
				this.rightNode = next;
				this.isRightClue = true;
			}else { //右子树非空
				this.rightNode.clueNode(arr); //递归 填充线索
			}
		}
	}
	
	//==========外部类的属性和操作=====
	private Node root = null ;
	private int count = 0;
	private int foot = 0;
	Object[] array = null;
	private boolean is_clue_bt = false;
	
	public void add(Template data) { //增加二叉树（构造）
		if (this.root == null) {
			root = new Node(data) ;
		}else if(this.root.leftNode==null) {
			this.root.leftNode = new Node(data) ;
		}else if(this.root.rightNode==null) {
			this.root.rightNode = new Node(data) ;
		}else {
			//随机构造二叉树
			Random ra =new Random();
			if(ra.nextInt()%2==0) {
				this.root.leftNode.addNode(data);
			}else {
				this.root.rightNode.addNode(data);
			}
		}
		this.count ++; //计数
	}
	public Object[] orderMid() {
		this.foot = 0;
		if(this.root == null) {
			return null;
		}else {
			array = new Object[this.count];
			
			if(this.root.leftNode != null) {
				this.root.leftNode.orderMidNode();
			}
			array[this.foot++] = this.root; //中序
			if(this.root.rightNode != null){
				this.root.rightNode.orderMidNode();
			}
			return array;
		}
	}
	@SuppressWarnings("unchecked")
	public void show() {
		if(this.is_clue_bt == false) {
			Object[] arr = this.orderMid();
			for(int i=0;i<this.count;i++) {
				System.out.print( ((BT<Template>.Node)arr[i]).data + " ");
			}
			System.out.println();
		}else {
			System.out.println("Warning:该树是中序线索树,无法使用.Show()方法");
		}
	}
	@SuppressWarnings("unchecked")
	private Node getNext(Object[] arr,Node node) { //获得中序遍历的下一个
		int len = arr.length;
		int i = 0;
		for(;i<len;i++) {
			if(node == (BT<Template>.Node)arr[i]) {
				break;
			}
		}
		if(i+1 < len) {
			return (BT<Template>.Node)arr[i+1];
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	private Node getPre(Object[] arr,Node node) {
		int len = arr.length;
		int i = 0;
		for(;i<len;i++) {
			if(node == (BT<Template>.Node)arr[i]) {
				break;
			}
		}
		if(i-1 >= 0) {
			return (BT<Template>.Node)arr[i-1];
		}
		return null;
	}
	//线索化
	@SuppressWarnings("unchecked")
	public void clue() { 
		Object[] arr = this.orderMid();
		if(this.root == null) { //空的二叉树
			return;
		}
		if(this.root.leftNode != null) {
			this.root.leftNode.clueNode(arr);
		}
		if(this.root.rightNode != null) { 
			this.root.rightNode.clueNode(arr);
		}
		this.is_clue_bt = true;
	}
	private void showClue(Node node) {
		if(node.is_go||node.leftNode == null||node.isLeftClue) { //如果该结点左边已经遍历了或者左边没有了或者左边是线索（曾经是空的）
			System.out.print(node.data + " "); //把中间的这个结点打印出来
			node.is_go = false; //使用过了，清除标记，方便多次使用
		}else {  //上面的不满足，要往左子树方向去
			while(node.leftNode!=null&&!node.isLeftClue) {
				node.is_go = true;  //去了就标记去过了
				node = node.leftNode; //行动
			}
			System.out.print(node.data + " "); //找到左子树的第一个点
		}
		if(node.rightNode!=null) {
			this.showClue(node.rightNode); //rightNode可能是线索，指向下一个；也可能是当前结点的右子树；递归使用
		}
	}
	public void clueShow() {
		System.out.print("使用线索遍历展示:");
		if(this.is_clue_bt == true) {
			this.showClue(this.root);  //使用showClue()
			System.out.println();
		}else {
			System.out.println("Warning:该树不是中序线索树,无法使用.clueShow()方法");
		}
	}
}
