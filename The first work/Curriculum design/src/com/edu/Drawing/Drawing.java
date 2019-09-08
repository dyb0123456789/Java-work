package com.edu.Drawing;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Container;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.font.*;
import java.awt.Font;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;


public class Drawing extends JFrame implements MouseListener, ActionListener {

	private static int x = 0;
	private static int y = 0;
	private static int w = 0;
	private static int h = 0;
	
    public static JFrame frame;
    public static JTextField t;
    public static String s = new String();
	
	private static Color c;

	private int[] number = {0};

	private static final long serialVersionUID = 1L;

	public Drawing() {
		this.setSize(800, 500);
		this.setVisible(true);
		this.setLayout(null);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setResizable(true);// �ܸı䴰���С
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.getContentPane().setBackground(Color.WHITE);

		Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
		b1 = new Button("��ɫ");
		b1.setBounds(0, 0, 100, 30);
		b1.setBackground(Color.pink);
		b1.addActionListener(this);
		this.add(b1);

		b2 = new Button("��ɫ");
		b2.setBounds(110, 0, 100, 30);
		b2.setBackground(Color.orange);
		b2.addActionListener(this);
		this.add(b2);

		b3 = new Button("��ɫ");
		b3.setBounds(220, 0, 100, 30);
		b3.setBackground(Color.YELLOW);
		b3.addActionListener(this);
		this.add(b3);

		b4 = new Button("��ɫ");
		b4.setBackground(Color.green);
		b4.setBounds(330, 0, 100, 30);
		b4.addActionListener(this);
		this.add(b4);

		b5 = new Button("��Ƥ��");
		b5.setBounds(440, 0, 100, 30);
		b5.addActionListener(this);
		this.add(b5);

		b6 = new Button("����");
		b6.setBounds(550, 0, 100, 30);
		b6.addActionListener(this);
		this.add(b6);

		b7 = new Button("ȫ��ɾ��");
		b7.setBounds(660, 0, 100, 30);
		b7.addActionListener(this);
		this.add(b7);

		b8 = new Button("��Բ��");
		b8.setBounds(0, 40, 100, 30);
		b8.addActionListener(this);
		this.add(b8);

		b9 = new Button("����");
		b9.setBounds(110, 40, 100, 30);
		b9.addActionListener(this);
		this.add(b9);
		
		b10 = new Button("������");
		b10.setBounds(220, 40, 100, 30);
		b10.addActionListener(this);
		this.add(b10);
		
		b11 = new Button("Բ��");
		b11.setBounds(330, 40, 100, 30);
		b11.addActionListener(this);
		this.add(b11);
		
		b12 = new Button("����");
		b12.setBounds(440, 40, 100, 30);
		b12.addActionListener(this);
		this.add(b12);
		
		b13 = new Button("������");
		b13.setBounds(550, 40, 100, 30);
		b13.addActionListener(this);
		this.add(b13);
		
		addComponentListener(new ComponentAdapter ()
		{
		  @SuppressWarnings("null")
		  @Override
		  public void componentResized ( ComponentEvent e )
		 {
			  /*Drawing d = new Drawing();
			  Container contentPane=d.getContentPane();
			  //Point contentPos = contentPane.getLocationOnScreen();// ����Ļ������
			  Dimension size = contentPane.getSize(); // ��������Ĵ�С
			  System.out.println(size);
			  Color c;
			  Graphics g = null;
			  g.setColor(Color.white);
			  for(int i=0;i<size.height;i++)
				  for(int j=0;j<size.width;j++)
				  {
					  Robot robot = null;
					  c=robot.getPixelColor(i, j);
					  boolean equals = c.getRGB()== 0;
						if (equals) {
							// ��ɫ��ͬ
							g.clearRect(i, j, 1, 1);
						}
						else{
						//��ɫ��ͬ
							continue;
						}
				  }*/
			  clear(getGraphics());
		 }
		});
	}

	
	public static void main(String[] args) {
		//Drawing d=new Drawing();
		Text t = new Text();
		//d.clear(d.getGraphics());
		t.clear(t.getGraphics());
		Class<Text>clazz = Text.class;
		System.out.println(clazz.getCanonicalName());
		//System.out.println(clazz.getName());
		//System.out.println(clazz.getClass());
		//System.out.println(clazz.getClass().getCanonicalName());
		//System.out.println(clazz.getPackage().getClass());
		//System.out.println(args);
	}

	
	public void paint(Graphics g) {
		//super.paint(g);             //��Ļ����Ӧ
		//g.setColor(Color.white);      //���û��ʵĳ�ʼ��ɫΪ��ɫ
		if (c == null)
			c = g.getColor();
		g.setColor(c);
		if (number[0]==1) {
			g.fillOval(x, y, w, h);
		} else if(number[0]==2) {
			g.fillRect(x, y, w, h);
		}else if(number[0]==3) {
		    g.fillRect(x, y, w, w);	
		}else if(number[0]==4) {
			g.fillOval(x, y, w, w);
		}else if(number[0]==5){
			g.drawArc(x, y, w, h, 180, 180);
		}else if(number[0]==6) {
			int px1[]= {x,x+w,x-w};
			//int py1[]= {y,Math.abs(y-h),Math.abs(y-h)};
			int py1[]= {y,y+h,y+h};
			g.fillPolygon(px1, py1, 3);
		}else {
			Font f=new Font("Serif",Font.BOLD,w/4);
	        g.setFont(f);
			g.drawString(s, x, y);;
		}
		//System.out.println(g);
	}

	public void clear(Graphics g) {
		g.setColor(Color.WHITE);
		//g.clearRect(0, 0, 440, 500);
		g.clearRect(0, 0, 1920, 1080);
	}

	/**
	 * ����
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * ����
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();

	}

	/**
	 * �ɿ�
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x > this.x) {
			w = x - this.x;
		} else {
			w = this.x - x;
		}
		if (y > this.y) {
			h = y - this.y;
		} else {
			h = this.y - y;
		}
		paint(getGraphics());
	}

	/**
	 * �������¼�
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * ����Ƴ��¼�
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().hashCode()) {
		case 1021705:
			// ��ɫ
			c = Color.pink;
			break;
		case 877369:
			// ��ɫ
			c = Color.orange;
			break;
		case 1293358:
			// ��ɫ
			c = Color.YELLOW;
			break;
		case 1041235:
			// ��ɫ
			c = Color.green;
			break;
		case 27138585:
			// ��Ƥ��
			c = Color.WHITE;
			break;
		case 836828:
			Graphics graphics = getGraphics();
			graphics.setColor(Color.white);

			if (number[0]==1) {
				graphics.fillOval(x, y, w, h);
			} else if(number[0]==2){
				graphics.fillRect(x, y, w, h);
			} else if(number[0]==3) {
				graphics.fillRect(x, y, w, w);
			}else if(number[0]==4) {
				graphics.fillOval(x, y, w, w);
			}else if(number[0]==5){
				graphics.drawArc(x, y, w, h, 180, 180);
			}else if(number[0]==6) {
				int px1[]= {x,x+w,x-w};
				//int py1[]= {y,Math.abs(y-h),Math.abs(y-h)};
				int py1[]= {y,y+h,y+h};
				graphics.fillPolygon(px1, py1, 3);
			}
			break;
		case 657183940:
			// ȫ��ɾ��
			clear(getGraphics());
			break;
		case 26589961:
			// ��Բ��
			number[0] = 1;
			break;
		case 976025:
			// ����
			number[0] = 2;
			break;
		case 27250540:
			//������
			number[0] = 3;
			break;
		case 715036:
			//Բ��
			number[0] = 4;
			break;
		case 787576:
			number[0] = 5;
			break;
		case 20316057:
			number[0] = 6;
			break;
		case 832133:
				frame=new JFrame("TextArea");    //����Frame����
		        JPanel jp=new JPanel();    //�������
				t=new JTextField(10); //����һ��Ĭ�ϵ��ı���
				t.setText("");    //�ı��������
				jp.add(t);
		        frame.add(jp);
		        frame.setBounds(300,200,400,100);
		        frame.setVisible(true);
		        Button b15 = new Button("ȷ��");
				b15.addActionListener(this);
				jp.add(b15);
		        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        break;
		case 979180:
			s = new String(t.getText().toString());//����ı��������
			//s=t.getText().toString();
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//System.out.println(s);
			System.out.println(s);
			frame.dispose();
			number[0] = 7;
			break;
		default:
			System.out.println(e.getActionCommand().hashCode());
			break;
		}
	}
	
}


