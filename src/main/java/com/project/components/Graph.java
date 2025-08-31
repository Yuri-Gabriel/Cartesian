package com.project.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.project.exprInterpreter.calculator.Calculator;
import com.project.exprInterpreter.datastruct.Queue;
import com.project.exprInterpreter.parser.ParserExpr;
import com.project.exprInterpreter.parser.nodetype.NodeExpression;
import com.project.exprInterpreter.token.Token;
import com.project.exprInterpreter.token.TokenManager;

public class Graph extends JPanel {

	private Calculator calculator;
	private Queue<Token> tokens;
	private NodeExpression treeExpr;

	private int window_width;
    private int window_height;

	public static boolean calculateSenoids = false;
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		this.setOpaque(false);
		g.setColor(Color.RED);
		
		window_width = getWidth();  // Obtém a largura do painel
        window_height = getHeight(); // Obtém a altura do painel
        
        //Defini os valores maximos e minimos para X e Y de acordo com o tamanho da janela
		double xMin = window_width / (Globals.SCALE * -1);
        double xMax = window_width / Globals.SCALE;
        double yMin = window_height / (Globals.SCALE * -1);
        double yMax = window_height / Globals.SCALE;
		
        //Defini quantos pixels da janela cabem em um ponto do plano cartesiano 
		double scaleX = window_width / (xMax - xMin) * 1;
        double scaleY = window_height / (yMax - yMin) * 1;
        
        double y = 0;
        for(double x = -50.0; x <= 50.0; x += Globals.PRECISION) {
        	y = this.calculate(x);
            
        	//Converte os valores do ponto cartesiando em posisões em pixels para desenhar na janela
            int pixelX = (int) ((x - xMin) * scaleX);
            int pixelY = (int) ((yMax - y) * scaleY);
            
            
            //Desenha apenas os pixels que representam os valores de X e Y estão dentro da janela
            if((pixelX > 0 && pixelX < getWidth()) && (pixelY > 0 && pixelY < getHeight())) {
            	g.drawRect(
                		(int) pixelX,
                		(int) pixelY,
                		1,
                		1
                	);
            }
        }
	}
	
	public void setMathExpression(String expr) {
		try {
			this.tokens = new TokenManager(expr).tokenize();
			this.treeExpr = new ParserExpr(tokens).parse();
			this.calculator = new Calculator(this.treeExpr);
		} catch (Exception err) {
			JOptionPane.showMessageDialog(
				null,
				err.getMessage(),
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
		}
	}

	private double calculate(double x) {
		try {
			if(this.calculateSenoids) {
				return this.sN(x);
			} else {
				this.calculator.setX_value(x);
				double retult = this.calculator.calculate();
				return retult;
			}
		} catch (Exception err) {
			JOptionPane.showMessageDialog(
				null,
				err.getMessage(),
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
			return 0;
		}
	}

	public double sN(double t) {
        double sum = 0.0;
        for (int m = 1; m <= Globals.HARMONICS; m++) {
            sum += (1.0 / (2 * m - 1)) * Math.sin((2 * m - 1) * t);
        }
        return (4.0 / Math.PI) * sum;
    }

}
