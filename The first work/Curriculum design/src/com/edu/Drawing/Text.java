package com.edu.Drawing;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Text extends Drawing {
	public Text() {
		//������ť
        Button b14 = new Button("�ı�");
		b14.setBounds(0, 80, 100, 30);
		b14.addActionListener(this);
		this.add(b14);
		
		/*JFrame frame=new JFrame("Java�ı������ʾ��");    //����Frame����
        JPanel jp=new JPanel();    //�������
		JTextField t=new JTextField(); //����һ��Ĭ�ϵ��ı���
		t.setText("��ͨ�ı���");    //�����ı��������*/
	}
}
