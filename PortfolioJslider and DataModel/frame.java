package calList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;

public class frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider();
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("Bank") );
		labelTable.put( new Integer( 1 ), new JLabel("National") );
		labelTable.put( new Integer( 2 ), new JLabel("Religious") );
		labelTable.put( new Integer( 3 ), new JLabel("All") );
		slider.setLabelTable( labelTable );
		slider.setMajorTickSpacing(1);
		slider.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		slider.setName("");
		slider.setMaximum(3);
		slider.setValue(3);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setBounds(10, 201, 258, 49);
		contentPane.add(slider);
		
		//NOTE: need a listener in TableDataModel that if any other country than US is selected then 
			//slider.setEnabled(false);
		
//		slider.addChangeListener(new ChangeListener() {
//	        @Override
//	        public void stateChanged(ChangeEvent ce) {
//	            if(ce.getSource().getValue()==0)
//					//display only bank holidays
//		else if(ce.getSource().getValue()==1)
//			//display only national holidays
//		else if(ce.getSource().getValue()==2)
//			//display only religious
//		else
			//display all holidays
//	        }
//	    });
	}
}
