package core;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static double winWidth = 500;
	private static double winHeight = 600;
	private static String winName;
	public Window(String winName, double winWidth, double winHeight) {
		super(winName);
		Window.winName=winName;
		Window.winWidth=winWidth;
		Window.winHeight=winHeight;
		
		setWindowAttributes();
	}
	public void packWindow() {
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void setWindowAttributes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static double getWinWidth() {
		return winWidth;
	}
	public static double getWinHeight() {
		return winHeight;
}
	public static String getWinName(){
		return winName;
	}
}