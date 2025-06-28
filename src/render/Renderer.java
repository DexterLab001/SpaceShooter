package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import core.Window;

public class Renderer extends JPanel {
	private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>();
	private static ArrayList<Renderable> addrenderableObjects = new ArrayList<Renderable>();
	private static ArrayList<Renderable> removerenderableObjects = new ArrayList<Renderable>();
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		
		for(Renderable object: renderableObjects)
			object.drawSprite(g2d);
		
		renderableObjects.removeAll(removerenderableObjects);
		if(addrenderableObjects.size()>0) {
			renderableObjects.addAll(addrenderableObjects);
			Collections.sort(renderableObjects);
		}
		addrenderableObjects.clear();
		removerenderableObjects.clear();
	}
	public static void addRenderableObjects(Renderable object) {
		addrenderableObjects.add(object);
	}
	public static void removeRenderableObjects(Renderable object) {
		removerenderableObjects.add(object);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension((int)Window.getWinWidth(), (int)Window.getWinHeight());
	}

}
