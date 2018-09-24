package gobblerobservation;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextArea;
 
class GobblerObserver extends JFrame implements Observer {

	static int count = 0;
	private ColorMark colormarker;
	
	final int WIDTH = 350;
	final int HEIGHT = 250;
	private JTextArea textarea = null;
	
	GobblerObserver()  {
		setBounds(10,HEIGHT*count++, WIDTH,HEIGHT);
		 add(colormarker = new ColorMark());
		 //add(textarea = new JTextArea());
		setFont(new Font("monospace", Font.PLAIN, 12));
		setVisible(true);		
	}
	
	@Override
	public void update(Observable o, Object n) {
		colormarker.spot();
		//  hexIt((Integer)n);
	}

	int numbercount = 0;
	
	private void hexIt(Integer n) {
		String number = String.format("%3s", Integer.toHexString(n & 0xff));
		textarea.append(number + (++numbercount % 8 == 0 ? "\n" : ""));
	}
	
}


class ColorMark extends Canvas {
	
	private ArrayList<ByteBox> boxes = new ArrayList<ByteBox>();

	public void spot() {
		boxes.add(new ByteBox(getWidth(),getHeight()));
	}
    	
	public void paint(Graphics g) {
		for (ByteBox b:boxes) {
			g.setColor(b.c);
			g.setXORMode(Color.BLACK);
			g.fillRect(b.x, b.y, b.width, b.height);
		}
	}
	



class ByteBox extends Rectangle {
	
	private Random r = new Random();
	public Color c;
	
	public ByteBox(int w, int h) {
		x = r.nextInt(w);
		y = r.nextInt(h);
		width = r.nextInt(w/5);
		height = r.nextInt(h/5);
		c = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
	}
	
}


}