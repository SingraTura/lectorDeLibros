package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class bookUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel pageLeft;
	private JLabel pageRight;
	private JButton btnNext;
	private JTextArea pageLeftTo;
	private JTextArea pageRightTo;
	private JButton btnPrevious;


	/**
	 * Create the frame.
	 */
	public bookUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		pageRight = new JLabel("220");
		
		pageLeft = new JLabel("219");
		
		btnNext = new JButton("next");
		
		pageLeftTo = new JTextArea();
		
		pageLeftTo.setLineWrap(true);
		pageLeftTo.setWrapStyleWord(true);
		contentPane.add(pageLeftTo, BorderLayout.CENTER);

		pageRightTo = new JTextArea();
		
		pageRightTo.setLineWrap(true);
		pageRightTo.setWrapStyleWord(true);
		
		btnPrevious = new JButton("previous");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pageLeftTo, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pageLeft)
							.addPreferredGap(ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
							.addComponent(btnPrevious)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNext)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pageRight))
						.addComponent(pageRightTo, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pageLeftTo, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
						.addComponent(pageRightTo, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pageLeft)
						.addComponent(pageRight)
						.addComponent(btnPrevious)
						.addComponent(btnNext))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	public void setBtnPrevious(JButton btnPrevious) {
		this.btnPrevious = btnPrevious;
	}

	public JLabel getPageLeft() {
		return pageLeft;
	}

	public void setPageLeft(JLabel pageLeft) {
		this.pageLeft = pageLeft;
	}

	public JLabel getPageRight() {
		return pageRight;
	}

	public void setPageRight(JLabel pageRight) {
		this.pageRight = pageRight;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	public JTextArea getPageLeftTo() {
		return pageLeftTo;
	}

	public void setPageLeftTo(JTextArea pageLeftTo) {
		this.pageLeftTo = pageLeftTo;
	}

	public JTextArea getPageRightTo() {
		return pageRightTo;
	}

	public void setPageRightTo(JTextArea pageRightTo) {
		this.pageRightTo = pageRightTo;
	}
}
