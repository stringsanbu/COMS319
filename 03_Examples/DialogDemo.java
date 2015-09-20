/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Credits: www
 * Modified to make it easier to read - smitra
 * 
 * There are really THREE demos (one in each TABBED Panel).
 * 		createSimpleDialogBox(); (EASY)
 * 		createFeatureDialogBox(); -- USES CUSTOM DIALOG  + NON-MODAL DIALOG
 * 		createIconDialogBox(); (EASY)
 * 
 * It is a good idea to FIRST run it and play with it to see what it does and
 * then to look at the code for each panel one by one.
 * 
 */
public class DialogDemo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JLabel label;
	ImageIcon icon = new ImageIcon("happyFace.gif");
	JFrame frame;

	CustomDialog customDialog;
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create and set up the window.
				JFrame frame = new JFrame("DialogDemo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// Create and set up the content pane.
				DialogDemo newContentPane = new DialogDemo(frame);
				//newContentPane.setOpaque(true); // content panes must be opaque
				frame.setContentPane(newContentPane);

				// Display the window.
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	/** Creates the GUI shown inside the frame's content pane. */
	public DialogDemo(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;

		// CREATE THE DIFFERENT DIALOG DEMOS
		JPanel frequentPanel = createSimpleDialogBox();
		JPanel featurePanel  = createFeatureDialogBox();
		JPanel iconPanel     = createIconDialogBox();

		// CREATE TABBED PANES FOR EACH TYPE OF DIALOG DEMO
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Simple Modal Dialogs", null, frequentPanel, "Some simple message dialogs"); 
		tabbedPane.addTab("More Dialogs", null, featurePanel, "Some more dialogs"); 
		tabbedPane.addTab("Dialog Icons", null, iconPanel, "A JOptionPane has its choice of icons"); 
		add(tabbedPane, BorderLayout.CENTER);
		
		// CREATE THE LABEL AT THE BOTTOM
		label = new JLabel("Make a choice and then click the \"Show it!\" button to show dialog", JLabel.CENTER);
		add(label, BorderLayout.SOUTH);
		label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		customDialog = new CustomDialog(frame, "geisel", this);
		customDialog.pack();
	}

	/** Sets the text displayed at the bottom of the frame.
	 *  This is used by all the DEMOs
	 */
	void setBottomLabel(String newText) {
		label.setText(newText);
	}

	/** CREATE THE FIRST DEMO */
	private JPanel createSimpleDialogBox() {
		final int numButtons = 4;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];

		JButton showItButton = null;
		radioButtons[0] = new JRadioButton("OK (in the L&F's words)");
		radioButtons[0].setActionCommand("default");
		radioButtons[0].setSelected(true);
		radioButtons[1] = new JRadioButton("Yes/No (in the L&F's words)");
		radioButtons[1].setActionCommand("yesno");
		radioButtons[2] = new JRadioButton("Yes/No " + "(in the programmer's words)");
		radioButtons[2].setActionCommand("yeahnah");
		radioButtons[3] = new JRadioButton("Yes/No/Cancel " + "(in the programmer's words)");
		radioButtons[3].setActionCommand("ync");

		final ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}

		showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				// ok dialog
				if (command == "default") { 
					JOptionPane.showMessageDialog(frame, "Eggs aren't supposed to be green.");

					// yes/no dialog 
				} else if (command == "yesno") {
					int n = JOptionPane.showConfirmDialog(frame,
							"Would you like green eggs and ham?",
							"An Inane Question", JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) { setBottomLabel("Ewww!");} 
					else if (n == JOptionPane.NO_OPTION) { setBottomLabel("Me neither!");} 
					else { setBottomLabel("Come on -- tell me!");}

					// yes/no (not in those words)
				} else if (command == "yeahnah") {
					Object[] options = { "Yes, please", "No way!" };
					int n = JOptionPane.showOptionDialog(frame,
							"Would you like green eggs and ham?",
							"A Silly Question", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);
					if (n == JOptionPane.YES_OPTION) { setBottomLabel("You're kidding!");} 
					else if (n == JOptionPane.NO_OPTION) { setBottomLabel("I don't like them, either.");} 
					else { setBottomLabel("Come on -- 'fess up!"); }

					// yes/no/cancel (not in those words)
				} else if (command == "ync") {
					Object[] options = { "Yes, please", "No, thanks", "No eggs, no ham!" };
					int n = JOptionPane.showOptionDialog(frame,
							"Would you like some green eggs to go "
									+ "with that ham?", "A Silly Question",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[2]);
					if (n == JOptionPane.YES_OPTION) { setBottomLabel("Here you go: green eggs and ham!");} 
					else if (n == JOptionPane.NO_OPTION) { setBottomLabel("OK, just the ham, then.");} 
					else if (n == JOptionPane.CANCEL_OPTION) { setBottomLabel("Well, I'm certainly not going to eat them!");} 
					else { setBottomLabel("Please tell me what you want!"); }
				}
				return;
			}
		});

		return createPane("Simple Dialog" + ":", radioButtons, showItButton);
	}

	/**
	 * Used by createSimpleDialogBox and createFeatureDialogBox to create a pane
	 * containing a description, a single column of radio buttons, and the Show
	 * it! button.
	 */
	private JPanel createPane(String description, JRadioButton[] radioButtons,
			JButton showButton) {

		int numChoices = radioButtons.length;
		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);

		for (int i = 0; i < numChoices; i++) {
			box.add(radioButtons[i]);
		}

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.NORTH);
		pane.add(showButton, BorderLayout.SOUTH);
		return pane;
	}


	/** CREATE THE SECOND DEMO */
	private JPanel createFeatureDialogBox() {
		final int numButtons = 5;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		JButton showItButton = null;

		final String pickOneCommand = "pickone";
		final String textEnteredCommand = "textfield";
		final String nonAutoCommand = "nonautooption";
		final String customOptionCommand = "customoption";
		final String nonModalCommand = "nonmodal";

		radioButtons[0] = new JRadioButton("Pick one of several choices");
		radioButtons[0].setActionCommand(pickOneCommand);

		radioButtons[1] = new JRadioButton("Enter some text");
		radioButtons[1].setActionCommand(textEnteredCommand);

		radioButtons[2] = new JRadioButton("Non-auto-closing dialog");
		radioButtons[2].setActionCommand(nonAutoCommand);

		radioButtons[3] = new JRadioButton("Input-validating dialog "
				+ "(with custom message area)");
		radioButtons[3].setActionCommand(customOptionCommand);

		radioButtons[4] = new JRadioButton("Non-modal dialog");
		radioButtons[4].setActionCommand(nonModalCommand);

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				// pick one of many
				if (command == pickOneCommand) {
					Object[] possibilities = { "ham", "spam", "yam" };
					String s = (String) JOptionPane.showInputDialog(frame,
							"Complete the sentence:\n"
									+ "\"Green eggs and...\"",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							icon, possibilities, "ham");

					// If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						setBottomLabel("Green eggs and... " + s + "!");
						return;
					}

					// If you're here, the return value was null/empty.
					setBottomLabel("Come on, finish the sentence!");

					// text input
				} else if (command == textEnteredCommand) {
					String s = (String) JOptionPane.showInputDialog(frame,
							"Complete the sentence:\n"
									+ "\"Green eggs and...\"",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							icon, null, "ham");

					// If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						setBottomLabel("Green eggs and... " + s + "!");
						return;
					}

					// If you're here, the return value was null/empty.
					setBottomLabel("Come on, finish the sentence!");

					// non-auto-closing dialog
				} else if (command == nonAutoCommand) {
					final JOptionPane optionPane = new JOptionPane(
							"The only way to close this dialog is by\n"
									+ "pressing one of the following buttons.\n"
									+ "Do you understand?",
							JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);

					// You can't use pane.createDialog() because that
					// method sets up the JDialog with a property change
					// listener that automatically closes the window
					// when a button is clicked.
					final JDialog dialog = new JDialog(frame, "Click a button",
							true);
					dialog.setContentPane(optionPane);
					dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					dialog.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							setBottomLabel("Thwarted user attempt to close window.");
						}
					});
					optionPane
							.addPropertyChangeListener(new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent e) {
									String prop = e.getPropertyName();

									if (dialog.isVisible()
											&& (e.getSource() == optionPane)
											&& (JOptionPane.VALUE_PROPERTY
													.equals(prop))) {
										// If you were going to check something
										// before closing the window, you'd do
										// it here.
										dialog.setVisible(false);
									}
								}
							});
					dialog.pack();
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);

					int value = ((Integer) optionPane.getValue()).intValue();
					if (value == JOptionPane.YES_OPTION) {
						setBottomLabel("Good.");
					} else if (value == JOptionPane.NO_OPTION) {
						setBottomLabel("Try using the window decorations "
								+ "to close the non-auto-closing dialog. "
								+ "You can't!");
					} else {
						setBottomLabel("Window unavoidably closed (ESC?).");
					}

					// non-auto-closing dialog with custom message area
					// NOTE: if you don't intend to check the input,
					// then just use showInputDialog instead.
				} else if (command == customOptionCommand) {
					customDialog.setLocationRelativeTo(frame);
					customDialog.setVisible(true);

					String s = customDialog.getValidatedText();
					if (s != null) {
						// The text is valid.
						setBottomLabel("Congratulations!  " + "You entered \"" + s
								+ "\".");
					}

					// non-modal dialog
				} else if (command == nonModalCommand) {
					// Create the dialog.
					final JDialog dialog = new JDialog(frame,
							"A Non-Modal Dialog");

					// Add contents to it. It must have a close button,
					// since some L&Fs (notably Java/Metal) don't provide one
					// in the window decorations for dialogs.
					JLabel label = new JLabel("<html><p align=center>"
							+ "This is a non-modal dialog.<br>"
							+ "You can have one or more of these up<br>"
							+ "and still use the main window.");
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(label.getFont().deriveFont(Font.PLAIN, 14.0f));

					JButton closeButton = new JButton("Close");
					closeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dialog.setVisible(false);
							dialog.dispose();
						}
					});
					JPanel closePanel = new JPanel();
					closePanel.setLayout(new BoxLayout(closePanel,
							BoxLayout.LINE_AXIS));
					closePanel.add(Box.createHorizontalGlue());
					closePanel.add(closeButton);
					closePanel.setBorder(BorderFactory.createEmptyBorder(0, 0,
							5, 5));

					JPanel contentPane = new JPanel(new BorderLayout());
					contentPane.add(label, BorderLayout.CENTER);
					contentPane.add(closePanel, BorderLayout.PAGE_END);
					contentPane.setOpaque(true);
					dialog.setContentPane(contentPane);

					// Show it.

					dialog.setSize(new Dimension(300, 150));
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);
				}
			}
		});

		return createPane("More Dialogs" + ":", radioButtons, showItButton);
	}

	
	/*
	 * CREATE THE THIRD DEMO
	 */
	private JPanel createIconDialogBox() {
		JButton showItButton = null;

		final int numButtons = 6;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		final String plainCommand = "plain";
		final String infoCommand = "info";
		final String questionCommand = "question";
		final String errorCommand = "error";
		final String warningCommand = "warning";
		final String customCommand = "custom";

		radioButtons[0] = new JRadioButton("Plain (no icon)");
		radioButtons[0].setActionCommand(plainCommand);

		radioButtons[1] = new JRadioButton("Information icon");
		radioButtons[1].setActionCommand(infoCommand);

		radioButtons[2] = new JRadioButton("Question icon");
		radioButtons[2].setActionCommand(questionCommand);

		radioButtons[3] = new JRadioButton("Error icon");
		radioButtons[3].setActionCommand(errorCommand);

		radioButtons[4] = new JRadioButton("Warning icon");
		radioButtons[4].setActionCommand(warningCommand);

		radioButtons[5] = new JRadioButton("Custom icon");
		radioButtons[5].setActionCommand(customCommand);

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				// no icon
				if (command == plainCommand) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"A plain message", JOptionPane.PLAIN_MESSAGE);
					// information icon
				} else if (command == infoCommand) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane informational dialog",
							JOptionPane.INFORMATION_MESSAGE);

					// XXX: It doesn't make sense to make a question with
					// XXX: only one button.
					// XXX: See "Yes/No (but not in those words)" for a better
					// solution.
					// question icon
				} else if (command == questionCommand) {
					JOptionPane.showMessageDialog(frame,
							"You shouldn't use a message dialog "
									+ "(like this)\n" + "for a question, OK?",
							"Inane question", JOptionPane.QUESTION_MESSAGE);
					// error icon
				} else if (command == errorCommand) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.", "Inane error",
							JOptionPane.ERROR_MESSAGE);
					// warning icon
				} else if (command == warningCommand) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane warning", JOptionPane.WARNING_MESSAGE);
					// custom icon
				} else if (command == customCommand) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane custom dialog",
							JOptionPane.INFORMATION_MESSAGE, icon);
				}
			}
		});

		return create2ColPane("JOptionPane" + ":", radioButtons, showItButton);
	}
	
	/**
	 * Like createPane, but creates a pane with 2 columns of radio buttons. The
	 * number of buttons passed in *must* be even.
	 */
	private JPanel create2ColPane(String description,
			JRadioButton[] radioButtons, JButton showButton) {
		JLabel label = new JLabel(description);
		int numPerColumn = radioButtons.length / 2;

		JPanel grid = new JPanel(new GridLayout(0, 2));
		for (int i = 0; i < numPerColumn; i++) {
			grid.add(radioButtons[i]);
			grid.add(radioButtons[i + numPerColumn]);
		}

		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);
		grid.setAlignmentX(0.0f);
		box.add(grid);

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.PAGE_START);
		pane.add(showButton, BorderLayout.PAGE_END);

		return pane;
	}


}

/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Sun Microsystems nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

/* 1.4 example used by DialogDemo.java. */
class CustomDialog extends JDialog implements ActionListener,
		PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private String typedText = null;
	private JTextField textField;
	private DialogDemo dd;

	private String magicWord;
	private JOptionPane optionPane;

	private String btnString1 = "Enter";
	private String btnString2 = "Cancel";
	

	

	/**
	 * Returns null if the typed string was invalid; otherwise, returns the
	 * string as the user entered it.
	 */
	public String getValidatedText() {
		return typedText;
	}

	/** Creates the reusable dialog. */
	public CustomDialog(Frame aFrame, String aWord, DialogDemo parent) {
		super(aFrame, true);
		dd = parent;

		magicWord = aWord.toUpperCase();
		setTitle("Quiz");

		textField = new JTextField(10);

		// Create an array of the text and components to be displayed.
		String msgString1 = "What was Dr. SEUSS's real last name?";
		String msgString2 = "(The answer is \"" + magicWord + "\".)";
		Object[] array = { msgString1, msgString2, textField };

		// Create an array specifying the number of dialog buttons
		// and their text.
		Object[] options = { btnString1, btnString2 };

		// Create the JOptionPane.
		optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, options, options[0]);

		// Make this dialog display it.
		setContentPane(optionPane);

		// Handle window closing correctly.
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				/*
				 * Instead of directly closing the window, we're going to change
				 * the JOptionPane's value property.
				 */
				optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
			}
		});

		// Ensure the text field always gets the first focus.
		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				textField.requestFocusInWindow();
			}
		});

		// Register an event handler that puts the text into the option pane.
		textField.addActionListener(this);

		// Register an event handler that reacts to option pane state changes.
		optionPane.addPropertyChangeListener(this);
	}

	/** This method handles events for the text field. */
	public void actionPerformed(ActionEvent e) {
		optionPane.setValue(btnString1);
	}

	/** This method reacts to state changes in the option pane. */
	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();

		if (isVisible()
				&& (e.getSource() == optionPane)
				&& (JOptionPane.VALUE_PROPERTY.equals(prop) || JOptionPane.INPUT_VALUE_PROPERTY
						.equals(prop))) {
			Object value = optionPane.getValue();

			if (value == JOptionPane.UNINITIALIZED_VALUE) {
				// ignore reset
				return;
			}

			// Reset the JOptionPane's value.
			// If you don't do this, then if the user
			// presses the same button next time, no
			// property change event will be fired.
			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

			if (btnString1.equals(value)) {
				typedText = textField.getText();
				String ucText = typedText.toUpperCase();
				if (magicWord.equals(ucText)) {
					// we're done; clear and dismiss the dialog
					clearAndHide();
				} else {
					// text was invalid
					textField.selectAll();
					JOptionPane.showMessageDialog(CustomDialog.this,
							"Sorry, \"" + typedText + "\" "
									+ "isn't a valid response.\n"
									+ "Please enter " + magicWord + ".",
							"Try again", JOptionPane.ERROR_MESSAGE);
					typedText = null;
					textField.requestFocusInWindow();
				}
			} else { // user closed dialog or clicked cancel
				dd.setBottomLabel("It's OK.  " + "We won't force you to type "
						+ magicWord + ".");
				typedText = null;
				clearAndHide();
			}
		}
	}

	/** This method clears the dialog and hides it. */
	public void clearAndHide() {
		textField.setText(null);
		setVisible(false);
	}
}