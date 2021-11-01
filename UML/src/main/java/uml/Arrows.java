package uml;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Arrows {
	
	private BoxObject src;
	private BoxObject dest;
	private String type;
	
	public Arrows(BoxObject src, BoxObject dest, String type) {
		this.src = src;
		this.dest = dest;
		this.type = type;
	}
	
	public BoxObject getSrc() {
		return src;
	}
	
	public BoxObject getDest() {
		return dest;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public static void updateArrows() {
		for(Arrows arrow : Model.getArrows()) {
			drawArrow(arrow);
		}
	}
	
	public static void drawArrow(Arrows arrow) {
		if(arrow.getType().equals("aggregation")) {
			drawAggregation(arrow);
		}
		else if(arrow.getType().equals("realization")) {
			drawRealization(arrow);
		}
		else if(arrow.getType().equals("inheritance")) {
			drawInheritance(arrow);
		}
		else if(arrow.getType().equals("composition")) {
			drawComposition(arrow);
		}
	}
	
	public static void drawAggregation(Arrows arrow) {
		Graphics g = View.panel.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		Rectangle srcBounds = arrow.getSrc().getLabel().getBounds();
		Rectangle destBounds = arrow.getDest().getLabel().getBounds();
		
		if(srcBounds.x + srcBounds.getWidth() < destBounds.x) {
			g.drawLine(srcBounds.x + srcBounds.width, srcBounds.y + (srcBounds.height / 2), srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x, destBounds.x - 5, destBounds.x - 10, destBounds.x - 5};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 3, destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) - 3};
			g2.drawPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2), destBounds.x - 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.x > destBounds.x + destBounds.getWidth()) {
			g.drawLine(srcBounds.x, srcBounds.y + (srcBounds.height / 2), srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x + destBounds.width, destBounds.x + destBounds.width + 5, destBounds.x + destBounds.width + 10, destBounds.x + destBounds.width + 5};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 3, destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) - 3};
			g2.drawPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2), destBounds.x + destBounds.width + 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.y + srcBounds.getHeight() < destBounds.y) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height, srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) + 3, destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 3};
			int[] y = {destBounds.y, destBounds.y - 5, destBounds.y - 10, destBounds.y - 5};
			g2.drawPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10, destBounds.x + (destBounds.width / 2), destBounds.y - 10);
		}
		else if(srcBounds.y > destBounds.y + destBounds.height) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y, srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) + 3, destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 3};
			int[] y = {destBounds.y + destBounds.height, destBounds.y + destBounds.height + 5, destBounds.y + destBounds.height + 10, destBounds.y + destBounds.height + 5};
			g2.drawPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10, destBounds.x + (destBounds.width / 2), destBounds.y + destBounds.height + 10);
		}
	}
	
	public static void drawRealization(Arrows arrow) {
		Graphics g = View.panel.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));

		Rectangle srcBounds = arrow.getSrc().getLabel().getBounds();
		Rectangle destBounds = arrow.getDest().getLabel().getBounds();
        
		if(srcBounds.x + srcBounds.getWidth() < destBounds.x) {
			g.drawLine(srcBounds.x + srcBounds.width, srcBounds.y + (srcBounds.height / 2), srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x, destBounds.x - 10, destBounds.x - 10};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 6, destBounds.y + (destBounds.height / 2) - 6};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2), destBounds.x - 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.x > destBounds.x + destBounds.getWidth()) {
			g.drawLine(srcBounds.x, srcBounds.y + (srcBounds.height / 2), srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x + destBounds.width, destBounds.x + destBounds.width + 10, destBounds.x + destBounds.width + 10};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 6, destBounds.y + (destBounds.height / 2) - 6};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2), destBounds.x + destBounds.width + 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.y + srcBounds.getHeight() < destBounds.y) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height, srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 6, destBounds.x + (destBounds.width / 2) + 6};
			int[] y = {destBounds.y, destBounds.y - 10, destBounds.y - 10};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10, destBounds.x + (destBounds.width / 2), destBounds.y - 10);
		}
		else if(srcBounds.y > destBounds.y + destBounds.height) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y, srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 6, destBounds.x + (destBounds.width / 2) + 6};
			int[] y = {destBounds.y + destBounds.height, destBounds.y + destBounds.height + 10, destBounds.y + destBounds.height + 10};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10, destBounds.x + (destBounds.width / 2), destBounds.y + destBounds.height + 10);
		}
	}
	
	public static void drawInheritance(Arrows arrow) {
		Graphics g = View.panel.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		Rectangle srcBounds = arrow.getSrc().getLabel().getBounds();
		Rectangle destBounds = arrow.getDest().getLabel().getBounds();
        
		if(srcBounds.x + srcBounds.getWidth() < destBounds.x) {
			g.drawLine(srcBounds.x + srcBounds.width, srcBounds.y + (srcBounds.height / 2), srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x, destBounds.x - 10, destBounds.x - 10};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 6, destBounds.y + (destBounds.height / 2) - 6};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2), destBounds.x - 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.x > destBounds.x + destBounds.getWidth()) {
			g.drawLine(srcBounds.x, srcBounds.y + (srcBounds.height / 2), srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x + destBounds.width, destBounds.x + destBounds.width + 10, destBounds.x + destBounds.width + 10};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 6, destBounds.y + (destBounds.height / 2) - 6};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2), destBounds.x + destBounds.width + 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.y + srcBounds.getHeight() < destBounds.y) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height, srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 6, destBounds.x + (destBounds.width / 2) + 6};
			int[] y = {destBounds.y, destBounds.y - 10, destBounds.y - 10};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10, destBounds.x + (destBounds.width / 2), destBounds.y - 10);
		}
		else if(srcBounds.y > destBounds.y + destBounds.height) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y, srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 6, destBounds.x + (destBounds.width / 2) + 6};
			int[] y = {destBounds.y + destBounds.height, destBounds.y + destBounds.height + 10, destBounds.y + destBounds.height + 10};
			g2.fillPolygon(x, y, 3);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10, destBounds.x + (destBounds.width / 2), destBounds.y + destBounds.height + 10);
		}
	}
	
	public static void drawComposition(Arrows arrow) {
		Graphics g = View.panel.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));

		Rectangle srcBounds = arrow.getSrc().getLabel().getBounds();
		Rectangle destBounds = arrow.getDest().getLabel().getBounds();
		
		if(srcBounds.x + srcBounds.getWidth() < destBounds.x) {
			g.drawLine(srcBounds.x + srcBounds.width, srcBounds.y + (srcBounds.height / 2), srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x, destBounds.x - 5, destBounds.x - 10, destBounds.x - 5};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 3, destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) - 3};
			g2.fillPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + srcBounds.width + 10, srcBounds.y + (srcBounds.height / 2), destBounds.x - 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.x > destBounds.x + destBounds.getWidth()) {
			g.drawLine(srcBounds.x, srcBounds.y + (srcBounds.height / 2), srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2));
			
			int[] x = {destBounds.x + destBounds.width, destBounds.x + destBounds.width + 5, destBounds.x + destBounds.width + 10, destBounds.x + destBounds.width + 5};
			int[] y = {destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) + 3, destBounds.y + (destBounds.height / 2), destBounds.y + (destBounds.height / 2) - 3};
			g2.fillPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x - 10, srcBounds.y + (srcBounds.height / 2), destBounds.x + destBounds.width + 10, destBounds.y + (destBounds.height / 2));
		}
		else if(srcBounds.y + srcBounds.getHeight() < destBounds.y) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height, srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) + 3, destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 3};
			int[] y = {destBounds.y, destBounds.y - 5, destBounds.y - 10, destBounds.y - 5};
			g2.fillPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y + srcBounds.height + 10, destBounds.x + (destBounds.width / 2), destBounds.y - 10);
		}
		else if(srcBounds.y > destBounds.y + destBounds.height) {
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y, srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10);
			
			int[] x = {destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) + 3, destBounds.x + (destBounds.width / 2), destBounds.x + (destBounds.width / 2) - 3};
			int[] y = {destBounds.y + destBounds.height, destBounds.y + destBounds.height + 5, destBounds.y + destBounds.height + 10, destBounds.y + destBounds.height + 5};
			g2.fillPolygon(x, y, 4);
			
			g.drawLine(srcBounds.x + (srcBounds.width / 2), srcBounds.y - 10, destBounds.x + (destBounds.width / 2), destBounds.y + destBounds.height + 10);
		}
	}
}
