package com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser.JTimeChooser;

/**
 * @author jens.ferring(at)tudor.lu
 * 
 * This is a demo of the JTimeChooser.<br>
 * You can see the usage and the options of the JTimeChooser here.
 */
public class JTimeChooserDemo
{
	/* ======================================== */
	// 		MAIN - FOR TESTING
	/* ======================================== */
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame ("JTimeChooser Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setOpaque(true);
		mainPanel.setBackground(Color.WHITE);
		
		
		// initialize the time chooser
		final JTimeChooser timeChooser = new JTimeChooser(new Date());
		timeChooser.setShowIcon(true);
		
		
		// the description
		JLabel description = new JLabel ("<html>" +
				"This is the JTimeChooser demo.<br><br>" +
				"Move the mouse over the JTimeChooser and the section you hover over will be highlighted. " +
				"You can edit the highlighting color with the method JTimeChooser.setHighlightingColor(Color).<br>" +
				"Move your mouse wheel or drag the mouse up or down to edit the time. You can also double " +
				"click on the text field and type the time manually.<br><br>" +
				"I hope you have fun with this component and can create an effective software ...");
//		description.setOpaque(true);
//		description.setBackground(Color.WHITE);
		
		
		// the button to choose the highlighting color
		JButton button = new JButton(new AbstractAction("highlighting color")
		{
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
			{
				Color c = JColorChooser.showDialog((Component)e.getSource(), "Select the highlighting Color", JTimeChooser.DEFAULT_HIGHLIGHTING_COLOR);
				timeChooser.setHighlightingColor(c);
			}
		});
		
		
		JLabel timeLabel = new JLabel ("  Time: ");
//		timeLabel.setOpaque(true);
//		timeLabel.setBackground(Color.WHITE);
		
		
		// add the components to the panel and the frame ...
		JPanel northPanel = new JPanel (new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(timeLabel, 		BorderLayout.WEST);
		northPanel.add(timeChooser, 	BorderLayout.CENTER);
		northPanel.add(button, 			BorderLayout.EAST);
		
		
		mainPanel.add(description);
		mainPanel.add(northPanel, 		BorderLayout.NORTH);
		mainPanel.add(new JLabel("   "),BorderLayout.EAST);
		mainPanel.add(new JLabel("   "),BorderLayout.WEST);
		
		
		f.add(mainPanel);
		
		f.setSize(400, 250);
		f.setLocation(400, 600);
		f.setVisible(true);
	}
}
