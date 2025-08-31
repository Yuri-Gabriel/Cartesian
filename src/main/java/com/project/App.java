package com.project;

import com.project.exprInterpreter.calculator.Calculator;

public class App {

	public static void main(String[] args) throws Exception {
		try {
			new Window();
		} catch (Exception err) {
			System.out.println(err.getLocalizedMessage());
		}
		// String expr = "log(x)";
		// Calculator calculator = new Calculator(expr);
		// calculator.setX_value(1.0);
		// double result = calculator.calculate();
		// System.out.println();
		// System.out.println(expr + " = " + result);
	}
}
