package com.edu.Drawing;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Text extends Drawing {
	public Text() {
		//创建按钮
        Button b14 = new Button("文本");
		b14.setBounds(0, 80, 100, 30);
		b14.addActionListener(this);
		this.add(b14);
		
		/*JFrame frame=new JFrame("Java文本框组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
		JTextField t=new JTextField(); //创建一个默认的文本框。
		t.setText("普通文本框");    //设置文本框的内容*/
	}
}
