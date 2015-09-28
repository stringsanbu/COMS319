package cs319;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JButton;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JTree;

@SuppressWarnings("serial")
public class Lab3Swing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab3Swing frame = new Lab3Swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Lab3Swing() throws Exception {
		
		
		
		setTitle("JTree Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(3, 3, 475, 270);
		contentPane.add(tabbedPane);
			
		ArrayList<String> listObjects = getListObjects();
		final JList<String> list = new JList<String>();
		final DefaultListModel<String> listmodel = new DefaultListModel<String>();
		list.setModel(listmodel);
		
		for(String s: listObjects){
			listmodel.addElement(s);
		}
		

		JScrollPane scrollPane = new JScrollPane(list);
		list.setSelectionBackground(Color.YELLOW);
		list.setSelectionForeground(Color.BLACK);
		scrollPane.setBounds(0, 0, 470, 197);
		JPanel List = new JPanel();
		tabbedPane.addTab("List", null, List, null);
		List.setLayout(null);

		List.add(scrollPane);
		
		final JButton add = new JButton("Add");
		add.setBounds(91, 201, 89, 23);
		List.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog( add, "What is new company?", "Enter new company name", JOptionPane.QUESTION_MESSAGE);
					listmodel.addElement(s);
					try {
						sendAdd(s);
					} catch (InterruptedException | IOException e1) {
						e1.printStackTrace();
					}
				
			}

		});
		
		JButton remove = new JButton("Remove");
		remove.setBounds(223, 201, 89, 23);
		List.add(remove);
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				//if statement garuntees a list item was selected
				if (index != -1) {
					
					listmodel.remove(index);
					try {
					sendRemove(index);
				} catch (InterruptedException | IOException e1) {
					e1.printStackTrace();
				}
				}
			}
			
		});
			
		final DefaultTreeModel defaultTree=createTModel();
					
		final JTree tree = new JTree(defaultTree);
		tree.setForeground(Color.GRAY);
		tree.setBounds(0, 0, 425, 197);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.setEditable(true);
		
		JScrollPane scroll = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 424, 195);
		JPanel Tree = new JPanel();
		tabbedPane.addTab("Tree", null, Tree, null);
		Tree.setLayout(null);
		
		Tree.add(scroll);
			
				
				JButton addTreeElement = new JButton("Add");
				addTreeElement.setBounds(92, 201, 89, 23);
				Tree.add(addTreeElement);
				JButton removeTreeElement = new JButton("Remove");
				removeTreeElement.setBounds(223, 201, 89, 23);
				Tree.add(removeTreeElement);
				
				// add listeners, we used similar code that was used in Dr. Mitra's TreeFrame example - with a few minor adjustments to fit our code


				addTreeElement.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//Identify the node that has been selected
						DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						if (selected == null)
							return;
						String s = JOptionPane.showInputDialog( add, "What is new Animal?", "Enter new animal", JOptionPane.QUESTION_MESSAGE);
						
						defaultTree.insertNodeInto(new DefaultMutableTreeNode(s.toString()),
								selected, selected.getChildCount());
												
						TreeNode[] nodes = defaultTree.getPathToRoot(
								selected.getChildAt(selected.getChildCount()-1));
						TreePath path = new TreePath(nodes);
						tree.scrollPathToVisible(path);
						tree.clearSelection();
						tree.addSelectionPath(path);
					
					}
				});

				removeTreeElement.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						// identify node
						DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
						//do nothing if no element is slected
						if (selected == null) return;
						
						//set root to null if removing main root
						if (selected.getParent() == null)
							defaultTree.setRoot(null);
						else	
						//all other types of nodes
						defaultTree.removeNodeFromParent(selected);
					}
				});
				
		DataModel2 tableObject = new DataModel2();
		
		
		
		JPanel Table = new JPanel();
		JScrollPane scrollTree = new JScrollPane(tableObject.people);
		scrollTree.setBounds(0, 0, 100, 10);
		Table.add(scrollTree);
		
		tabbedPane.addTab("Table", null, Table, null);
	}

	private DefaultTreeModel createTModel() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Animals");
		DefaultMutableTreeNode mammals = new DefaultMutableTreeNode();//is this the best way to do this??
		mammals.setUserObject("Mammals");
		root.add(mammals);
			mammals.add(new DefaultMutableTreeNode("Human"));
			mammals.add(new DefaultMutableTreeNode("Kangaroo"));
			mammals.add(new DefaultMutableTreeNode("Elephant"));
			mammals.add(new DefaultMutableTreeNode("Goat"));
		DefaultMutableTreeNode reptiles = new DefaultMutableTreeNode();
		reptiles.setUserObject("Reptiles");
		root.add(reptiles);
			reptiles.add(new DefaultMutableTreeNode("Lizard"));
			reptiles.add(new DefaultMutableTreeNode("Boa"));
			reptiles.add(new DefaultMutableTreeNode("Iguana"));
		DefaultMutableTreeNode birds = new DefaultMutableTreeNode();
		birds.setUserObject("Birds");
		root.add(birds);
			birds.add(new DefaultMutableTreeNode("Duck"));
			birds.add(new DefaultMutableTreeNode("Pigeon"));
			birds.add(new DefaultMutableTreeNode("Turkey"));
			birds.add(new DefaultMutableTreeNode("Goose"));
		DefaultMutableTreeNode insects = new DefaultMutableTreeNode();
		insects.setUserObject("Insects");
		root.add(insects);
			insects.add(new DefaultMutableTreeNode("Termite"));
			insects.add(new DefaultMutableTreeNode("Ladybug"));
			insects.add(new DefaultMutableTreeNode("Fly"));
			insects.add(new DefaultMutableTreeNode("Ant"));
		DefaultMutableTreeNode fish = new DefaultMutableTreeNode();
		fish.setUserObject("Fish");
		root.add(fish);
			fish.add(new DefaultMutableTreeNode("Sword Fish"));
			fish.add(new DefaultMutableTreeNode("Shark"));
			fish.add(new DefaultMutableTreeNode("Eel"));

		DefaultTreeModel treeModel = new DefaultTreeModel(root);

		return treeModel;

	}
	
	private ArrayList<String> getListObjects() throws Exception{
		//Opening socket for use to get JList
		Socket socket = new Socket("localhost", 12345);
	    Thread.sleep(1000);
		
	    // Here's the vars we'll use with the socket
        PrintWriter out = new PrintWriter(socket.getOutputStream());
		Scanner in = new Scanner(socket.getInputStream());
		
		out.println("list^dontmatter");
		out.flush();
		Thread.sleep(1000);
		String s;
		ArrayList<String> listObjects = new ArrayList<String>();
		try {
			while(!(s = in.nextLine()).contains("endTransmission")){
				listObjects.add(s);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		
		socket.close();
		in.close();
		out.close();
		
		
		return listObjects;
		
		
	}
	
	private void sendAdd(String s) throws InterruptedException, IOException {
		
		Socket socket = new Socket("localhost", 12345);
	    Thread.sleep(1000);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("add^"+s);
        out.flush();
        socket.close();
		out.close();
	}
	
	private void sendRemove(int index) throws InterruptedException, UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);
	    Thread.sleep(1000);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("remove^"+Integer.toString(index));
        out.flush();
        socket.close();
		out.close();
	}

}
