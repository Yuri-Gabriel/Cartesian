package com.project;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import com.project.components.Axis;
import com.project.components.Globals;
import com.project.components.FuncInput;
import com.project.components.Graph;
import com.project.components.MouseScrollListener;

public class Window extends JFrame {
	
	private Axis axis;
	public static Graph graph;
	
	public Window() {
		this.setSize(Globals.HEIGHT, Globals.WIDTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setTitle("Cartesiano");
		
		FuncInput input = new FuncInput();
		
		axis = new Axis();
		
        graph = new Graph();
        graph.setMathExpression("x ^ 2");

		MouseScrollListener listener = new MouseScrollListener();
		this.addMouseWheelListener(listener);
        
        JPanel layeredPane = new JPanel();
        layeredPane.setLayout(new OverlayLayout(layeredPane));
        layeredPane.add(graph);
        layeredPane.add(axis);
        
        this.add(input, BorderLayout.NORTH);
        this.add(layeredPane, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
}