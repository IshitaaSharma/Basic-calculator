import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class key extends JButton implements MouseListener{
	Color n,a;
	key(String lablel){
		super(lablel);
		addMouseListener(this);
		this.setFocusable(false);
		n= Color.WHITE;
		a= Color.BLACK;
		this.setBorder(null);
		this.setBackground(n);
		this.setForeground(a);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(a);
		this.setForeground(n);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(n);
		this.setForeground(a);
	}
}
public class Q25 extends JFrame implements ActionListener {
	String s1,s2,s0;
	JFrame f;
	GridBagLayout layout;
	JPanel p;
	JTextField screen;
	key b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,b00,bc,ba,bs,bm,bd,be,bdd,bdo,bp;
	Q25(String title){
		super(title);
		s1=s2=s0="";
		f= new JFrame();
		layout= new GridBagLayout();
		p = new JPanel(layout, false);
		screen= new JTextField("0");
		b1 = new key("1");
		b2 = new key("2");
		b3 = new key("3");
		b4 = new key("4");
		b5 = new key("5");
		b6 = new key("6");
		b7 = new key("7");
		b8 = new key("8");
		b9 = new key("9");
		b0 = new key("0");
		b00 = new key("00");
		bc = new key("C");
		ba = new key("+");
		bs = new key("-");
		bm = new key("*");
		bd = new key("/");
		be = new key("=");
		bdd = new key("---");
		bdo = new key(".");
		bp = new key("%");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		b00.addActionListener(this);
		bc.addActionListener(this);
		ba.addActionListener(this);
		bs.addActionListener(this);
		bm.addActionListener(this);
		bd.addActionListener(this);
		be.addActionListener(this);
		bdd.addActionListener(this);
		bdo.addActionListener(this);
		bp.addActionListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 400);
		f.setVisible(true);
		f.getContentPane().add(p);


		p.setBackground(Color.black);
		screen.setBackground(Color.BLACK);
		screen.setForeground(Color.WHITE);
		screen.setColumns(4);
		p.add(screen,lc(3,0));
		p.add(bc,lc(0,1));
		p.add(bp,lc(1,1));
		p.add(bdd,lc(2,1));
		p.add(bd,lc(3,1));
		p.add(b7,lc(0,2));
		p.add(b8,lc(1,2));
		p.add(b9,lc(2,2));
		p.add(bm,lc(3,2));
		p.add(b4,lc(0,3));
		p.add(b5,lc(1,3));
		p.add(b6,lc(2,3));
		p.add(bs,lc(3,3));
		p.add(b1,lc(0,4));
		p.add(b2,lc(1,4));
		p.add(b3,lc(2,4));
		p.add(ba,lc(3,4));
		p.add(b00,lc(0,5));
		p.add(b0,lc(1,5));
		p.add(bdo,lc(2,5));
		p.add(be,lc(3,5));
	}	
	GridBagConstraints lc (int x, int y){
	GridBagConstraints c = new GridBagConstraints();
	c.gridx=x;
	c.gridy=y;
	c.fill=GridBagConstraints.BOTH;
	c.weightx=1;
	c.weighty=1;
	return c;
	}


	public static void main(String[] args) {
		Q25 mainwindow = new Q25("Calculator");
		}
		@Override
		public void actionPerformed(ActionEvent e){
			String s = e.getActionCommand();
			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
				if (!s1.equals(""))
					s2 = s2 + s;
				else
					s0 = s0 + s;
				screen.setText(s0 + s1 + s2);
			}
			else if (s.charAt(0) == 'C') {
				s0 = s1 = s2 = "";
				screen.setText(s0 + s1 + s2);
			}
			else if (s.charAt(0) == '=') {
				double te;
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) *	Double.parseDouble(s2));
				screen.setText(s0 + s1 + s2 + "=" + te);
				s0 = Double.toString(te);
				s1 = s2 = "";
			}
			else {
				if (s1.equals("") || s2.equals(""))
					s1 = s;
				else {
					double te;
						if (s1.equals("+"))
							te = (Double.parseDouble(s0) + Double.parseDouble(s2));
						else if (s1.equals("-"))
							te = (Double.parseDouble(s0) - Double.parseDouble(s2));
						else if (s1.equals("/"))
							te = (Double.parseDouble(s0) / Double.parseDouble(s2));
						else
							te = (Double.parseDouble(s0) * Double.parseDouble(s2));
						s0 = Double.toString(te);
						s1 = s;
						s2 = "";
				}
				screen.setText(s0 + s1 + s2);
			}
		}
}
