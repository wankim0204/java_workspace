/*
 데이터간 구조화된 포함관계를 표현할때 흔히 사용되는 Tree를 배워보자!! 
*/
package day1117.db;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
public class TreeApp extends JFrame{
	JTree tree;
	JScrollPane scroll;
	
	public TreeApp() {
		//트리에 보여질 노드를 구성해보자!!
		String[] categoryName={"상의","하의","엑세서리","신발"};
		
		String[][] data= {
				{"운동화", "슬리퍼", "고무신", "축구화"},
				{"반지", "목걸이", "귀걸이", "팔찌"},
				{},
				{}
		};
		
		DefaultMutableTreeNode top=new DefaultMutableTreeNode("제품");
		for(int i=0;i<categoryName.length;i++) {
			top.add(createNode(categoryName[i], data[i]));
		}
		
		tree = new JTree(top);//최상위 노드를 생성자의 인수로 넣음
		scroll = new JScrollPane(tree);
		
		add(scroll);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public DefaultMutableTreeNode createNode(String parentName, String[] childName) {
		DefaultMutableTreeNode parent=new DefaultMutableTreeNode(parentName);
		
		for(int i=0;i<childName.length;i++) {
			parent.add(new DefaultMutableTreeNode(childName[i]));
		}
		return parent;
	}
	
	public static void main(String[] args) {
		new TreeApp();
	}

}







