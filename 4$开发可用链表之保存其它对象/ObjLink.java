
public class ObjLink {
        //Node�౻��װ��ObjLink���ֻϣ����ObjLinkʹ��
		private class Node{
			private Person data;
			private Node next;
			public Node(Person data) {
				this.data = data;
			}
			public void addNode(Node newNode) {
				if(this.next == null) {  //��ǰ�ڵ����һ���ڵ�Ϊnull
					this.next = newNode;
					ObjLink.this.count ++;  //�ⲿ�������count ��1
				}else {   //���ܷ��ڵ�ǰ�ڵ�ĺ��棬�Ϳ���һ���ڵ��ܲ��ܼ�
					this.next.addNode(newNode);
				}
			}
			public Person getNode(int index) {
				if(index == ObjLink.this.foot ++) { 	//���ϲ��ҵ�����
					return this.data; //���ص�ǰ�ڵ������
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
				if(this.data.compare(data)) { //��ǰ�ڵ�����ɾ������
					previous.next = this.next;   //�ճ���ǰ�ڵ�
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
		// ============�������ڲ���===============
		// ----����link��ҵ��
		private Node root; 	//���ڵ�
		private int count = 0; 	//ͳ�ƽڵ�ĸ���
		private int foot;	//�����������˳��
		private Person [] retData; //����Ķ�������
		public void add(Person data) {
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
		public Person get(int index) {
			if(index > this.count) {
				return null;
			}
			this.foot = 0; 	//�ű��0��ʼ
			return this.root.getNode(index);
		}
		public boolean contains(Person data) {	//�ж��Ƿ��������
			if(data == null) {
				return false;
			}
			return this.root.containsNode(data);
		}
		public void remove(Person data) {
			if(this.contains(data)) { //�鵽�д�����
				if(this.root.data.compare(data)) {
					this.root = this.root.next;   //�ı���ڵ�
				}else {	//Ҫɾ���Ĳ��Ǹ��ڵ�
					this.root.next.removeNode(this.root,data);
				}
				this.count--;
			}
		}
		public Person [] toArray() {
			if(this.count == 0) {
				return null;  //û����
			}
			this.foot = 0; //ͨ��foot������������
			this.retData = new Person [this.count];  //��������
			this.root.toArrayNode(); //����Node��������
			return this.retData;
		}
}
