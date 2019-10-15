
public class Link {
        //Node�౻��װ��Link���ֻϣ����Linkʹ��
		private class Node{
			private String data;
			private Node next;
			public Node(String data) {
				this.data = data;
			}
			public void addNode(Node newNode) {
				if(this.next == null) {  //��ǰ�ڵ����һ���ڵ�Ϊnull
					this.next = newNode;
					Link.this.count ++;  //�ⲿ�������count ��1
				}else {   //���ܷ��ڵ�ǰ�ڵ�ĺ��棬�Ϳ���һ���ڵ��ܲ��ܼ�
					this.next.addNode(newNode);
				}
			}
			public String getNode(int index) {
				if(index == Link.this.foot ++) { 	//���ϲ��ҵ�����
					return this.data; //���ص�ǰ�ڵ������
				}else {
					return this.next.getNode(index);
				}
			}
			public boolean containsNode(String data) {
				if(data.equals(this.data)) {
					return true;
				}else {
					if(this.next != null) {
						return this.next.containsNode(data);
					}else {
						return false;
					}
				}
			}
			public void removeNode(Node previous,String data) {
				if(this.data.equals(data)) { //��ǰ�ڵ�����ɾ������
					previous.next = this.next;   //�ճ���ǰ�ڵ�
				}else {
					this.next.removeNode(this,data);
				}
			}
		}
		// ============�������ڲ���===============
		// ----����link��ҵ��
		private Node root; 	//���ڵ�
		private int count = 0; 	//ͳ�ƽڵ�ĸ���
		private int foot;	//�����������˳��
		public void add(String data) {
			if(data == null) {
				return ;  	//��������ݲ���Ϊnull
			}
			Node newNode = new Node(data); 	//�����ݷ�װΪ�ڵ�
			if(this.root == null) {		//û�и��ڵ�
				this.root = newNode;
				this.count ++; 
			}else {		//����node��ȥ����
				this.root.addNode(newNode);
			}
		}
		public int size() { 	//�������ĳ���
			return this.count;
		}
		public boolean isEmpty() { 	//�ж��Ƿ�Ϊ��
			return this.count == 0;
		}
		public void clean(){	//�������
			this.root = null; 	//��������������root�����ڵģ�rootΪ�գ�������ʧ
			this.count = 0;
		}
		public String get(int index) {
			if(index > this.count) {
				return null;
			}
			this.foot = 0; 	//�ű��0��ʼ
			return this.root.getNode(index);
		}
		public boolean contains(String data) {	//�ж��Ƿ��������
			if(data == null) {
				return false;
			}
			return this.root.containsNode(data);
		}
		public void remove(String data) {
			if(this.contains(data)) { //�鵽�д�����
				if(this.root.data.equals(data)) {
					this.root = this.root.next;   //�ı���ڵ�
				}
			}else {	//Ҫɾ���Ĳ��Ǹ��ڵ�
				this.root.next.removeNode(this.root,data);
			}
			this.count--;
		}
}
