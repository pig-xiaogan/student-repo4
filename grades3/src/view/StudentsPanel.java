package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CourseView;
import controller.EditInfo;
import controller.GradeInfo;
import controller.Info;
import controller.ExamView;



@SuppressWarnings("serial")
public class StudentsPanel extends JFrame implements ActionListener {
	/*
	 * 学生登陆后操作主界面
	 */
	JPanel contain;
	String id;
	JButton infoButton, gradeButton, courseButton, editButton,examButton,swich;

	public StudentsPanel(String id) {
		super("学生");
		this.id = id;
		setLocation(300, 200);
		setSize(300, 380);
		contain = new JPanel();
		contain.setLayout(null);
		add(contain);
		infoButton = new JButton("信息查询");
		gradeButton = new JButton("成绩查询");
		courseButton = new JButton("课程查询");
		editButton = new JButton("修改信息");
		examButton = new JButton("考试查询");
		examButton.setBackground(new Color(0x00, 0xa0, 0xdd));
		swich = new JButton("退出登录");
		swich.setBackground(new Color(0x00, 0xa0, 0xdd));
		infoButton.setBounds(70, 40, 140, 30);
		gradeButton.setBounds(70, 80, 140, 30);
		courseButton.setBounds(70, 120, 140, 30);
		editButton.setBounds(70, 160, 140, 30);
		examButton.setBounds(70, 200, 140, 30);
		swich.setBounds(70,240,140,30);
		contain.add(infoButton);
		infoButton.addActionListener(this);
		contain.add(gradeButton);
		gradeButton.addActionListener(this);
		contain.add(courseButton);
		courseButton.addActionListener(this);
		contain.add(editButton);
		editButton.addActionListener(this);
		contain.add(examButton);
		examButton.addActionListener(this);
		contain.add(swich);
		swich.addActionListener(this);//切换账号
		setVisible(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == infoButton) {
			new Info(id, 1);
		}
		if (e.getSource() == gradeButton) {
			new GradeInfo(id);
		}
		if (e.getSource() == courseButton) {
			new CourseView(id, 0);
		}
		if (e.getSource() == editButton) {
			new EditInfo(id, 0);
		}
		if (e.getSource() == examButton) {
			new ExamView(id, 0);
		}
		if (e.getSource() == swich) {
			setLocation(300, 200);
			setSize(300, 340);
			this.dispose();
			new MainFrame();
		}
	}

	public void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
			setVisible(false);
			System.exit(0);
		}
	}
}
