package cs319;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JTree;

public class Lab2Swing extends JFrame {

	@SuppressWarnings("rawtypes")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2Swing frame = new Lab2Swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lab2Swing() {
		setTitle("JTree Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(3, 3, 431, 258);
		contentPane.add(tabbedPane);
		
		DataModel d = new DataModel();
		JScrollPane scrollPane = new JScrollPane(d.companies);
		d.companies.setSelectionBackground(Color.YELLOW);
		d.companies.setSelectionForeground(Color.BLACK);
		scrollPane.setBounds(0, 0, 425, 197);
		JPanel List = new JPanel();
		tabbedPane.addTab("List", null, List, null);
		List.setLayout(null);

		List.add(scrollPane);
		
		JButton add = new JButton("Add");
		add.setBounds(91, 201, 89, 23);
		List.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog( add, "What is new company?", "Enter new company name", JOptionPane.QUESTION_MESSAGE);
				
					d.addCompany(s);
				
			}
		});
		
		JButton remove = new JButton("Remove");
		remove.setBounds(223, 201, 89, 23);
		List.add(remove);
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=d.companies.getSelectedIndex();
				//if statement garuntees a list item was selected
				if (index != -1) 
				   d.remove(index);
			}
		});
			
		DefaultTreeModel defaultTree=createTModel();
					
		JTree tree = new JTree(defaultTree);
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
				
				//add listeners, we used similar code that was used in Dr. Mitra's TreeFrame example - with a few minor adjustments to fit our code


//				addTreeElement.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent evt) {
//						// Identify the node that has been selected
//						DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree
//								.getLastSelectedPathComponent();
//						if (selected == null)
//							return;
//
//						// add a new node as the last child of the selected node
//						tModel.insertNodeInto(new DefaultMutableTreeNode("New Node"),
//								selected, selected.getChildCount());
//
//						// Lets also expand the tree to show the new node
//						// Find the array of nodes that make up the path from the root
//						// to the newly added node
//						TreeNode[] nodes = tModel.getPathToRoot(selected
//								.getChildAt(selected.getChildCount() - 1));
//
//						// Create a tree path with these nodes
//						TreePath path = new TreePath(nodes);
//						// Make the entire path visible and make the scroller to move to
//						// the last path component
//						tree.scrollPathToVisible(path);
//					}
//				});

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
		
				
				
		JPanel Table = new JPanel();
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

}
