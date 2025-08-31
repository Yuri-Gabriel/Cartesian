package com.project.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.project.Window;

public class FuncInput extends JPanel {
	
	private JTextField inputText;
	private JButton calcBtn;
	private JCheckBox checkBox;
	private ActionListener calcListener = e -> calculateFunc();
	
	public FuncInput() {
		this.setPreferredSize(new Dimension(Window.WIDTH, 100));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		this.setBorder(border);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.inputText = new JTextField();
		this.inputText.setMaximumSize(new Dimension(250, 30));
		this.inputText.setAlignmentX(CENTER_ALIGNMENT);
		
		this.calcBtn = new JButton("Calcular");
		this.calcBtn.setMaximumSize(new Dimension(150, 30));
		this.calcBtn.setAlignmentX(CENTER_ALIGNMENT);
		this.calcBtn.addActionListener(calcListener);

		this.checkBox = new JCheckBox("Senoides?");
		this.checkBox.setMaximumSize(new Dimension(100, 30));
		this.checkBox.setAlignmentX(CENTER_ALIGNMENT);

		this.checkBox.addItemListener(checkBoxEvent -> {
			if(checkBoxEvent.getStateChange() == ItemEvent.SELECTED) {
				this.calcBtn.removeActionListener(calcListener);
				Graph.calculateSenoids = true;
				Window.graph.repaint();
			} else {
				Graph.calculateSenoids = false;
				if(!this.calcBtnAlreadyHaveEvent()) {
					this.calcBtn.addActionListener(calcListener);
				}
				Globals.HARMONICS = 2;
			}
		});

		this.add(Box.createVerticalStrut(15));
		this.add(inputText);
		this.add(Box.createVerticalStrut(5));
		this.add(calcBtn);
		this.add(Box.createVerticalStrut(5));
		this.add(checkBox);
	}

	private void calculateFunc() {
		String expr = this.inputText.getText();
		Window.graph.setMathExpression(expr);
		Window.graph.repaint();
	}

	private boolean calcBtnAlreadyHaveEvent() {
		for (ActionListener al : this.calcBtn.getActionListeners()) {
			if(al.equals(this.calcListener)) return true;
		}
		return false;
	}
}
