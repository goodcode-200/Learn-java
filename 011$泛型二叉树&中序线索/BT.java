import java.util.Random;

public class BT<Template> {
	//�ڲ���,ֻΪBT����
	private class Node{
		private Template data;
		private Node leftNode = null ;
		private Node rightNode = null ;
		private boolean isLeftClue = false; //��Ǵ˽����������Ƿ�Ϊ����
		private boolean isRightClue = false; //��Ǵ˽����������Ƿ�Ϊ����
		private boolean is_go = false; //�����������Ƿ������
		public Node(Template data) {
			this.data = data;
		}
		public void addNode(Template data) { //���Ӻ���
			if(this.leftNode==null) {
				this.leftNode = new Node(data) ;
			}else if(this.rightNode==null) {
				this.rightNode = new Node(data) ;
			}else {
				//������������
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
			array[BT.this.foot++] = this; //����
			if(this.rightNode != null){
				this.rightNode.orderMidNode();
			}
		}
		public void clueNode(Object[] arr) {
			Node prev = BT.this.getPre(arr,this);
			Node next = BT.this.getNext(arr,this);
			if(this.leftNode==null) { //����������
				this.leftNode = prev;
				this.isLeftClue = true;
			}else { //�������ǿ�
				this.leftNode.clueNode(arr); //�ݹ��������
			}
			if(this.rightNode==null) {
				this.rightNode = next;
				this.isRightClue = true;
			}else { //�������ǿ�
				this.rightNode.clueNode(arr); //�ݹ� �������
			}
		}
	}
	
	//==========�ⲿ������ԺͲ���=====
	private Node root = null ;
	private int count = 0;
	private int foot = 0;
	Object[] array = null;
	private boolean is_clue_bt = false;
	
	public void add(Template data) { //���Ӷ����������죩
		if (this.root == null) {
			root = new Node(data) ;
		}else if(this.root.leftNode==null) {
			this.root.leftNode = new Node(data) ;
		}else if(this.root.rightNode==null) {
			this.root.rightNode = new Node(data) ;
		}else {
			//������������
			Random ra =new Random();
			if(ra.nextInt()%2==0) {
				this.root.leftNode.addNode(data);
			}else {
				this.root.rightNode.addNode(data);
			}
		}
		this.count ++; //����
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
			array[this.foot++] = this.root; //����
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
			System.out.println("Warning:����������������,�޷�ʹ��.Show()����");
		}
	}
	@SuppressWarnings("unchecked")
	private Node getNext(Object[] arr,Node node) { //��������������һ��
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
	//������
	@SuppressWarnings("unchecked")
	public void clue() { 
		Object[] arr = this.orderMid();
		if(this.root == null) { //�յĶ�����
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
		if(node.is_go||node.leftNode == null||node.isLeftClue) { //����ý������Ѿ������˻������û���˻�������������������ǿյģ�
			System.out.print(node.data + " "); //���м���������ӡ����
			node.is_go = false; //ʹ�ù��ˣ������ǣ�������ʹ��
		}else {  //����Ĳ����㣬Ҫ������������ȥ
			while(node.leftNode!=null&&!node.isLeftClue) {
				node.is_go = true;  //ȥ�˾ͱ��ȥ����
				node = node.leftNode; //�ж�
			}
			System.out.print(node.data + " "); //�ҵ��������ĵ�һ����
		}
		if(node.rightNode!=null) {
			this.showClue(node.rightNode); //rightNode������������ָ����һ����Ҳ�����ǵ�ǰ�������������ݹ�ʹ��
		}
	}
	public void clueShow() {
		System.out.print("ʹ����������չʾ:");
		if(this.is_clue_bt == true) {
			this.showClue(this.root);  //ʹ��showClue()
			System.out.println();
		}else {
			System.out.println("Warning:������������������,�޷�ʹ��.clueShow()����");
		}
	}
}
