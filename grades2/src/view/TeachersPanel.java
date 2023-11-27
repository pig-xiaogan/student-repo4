package view;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.*;


@SuppressWarnings("serial")
public class TeachersPanel extends JFrame implements ActionListener {
	/*
	 * 教师登陆后操作主界面
	 */
	
	String idd;
	JPanel contain;
	JButton infoButton, gradeButton, gradeButton1,courseButton, examButton,editButton, courseView, sortGrade,exam,swich;

	public TeachersPanel(String idd) {
		super("教师");
		this.idd = idd;
		setLocation(300, 200);
		setSize(300, 470);
		contain = new JPanel();
		contain.setLayout(null);
		add(contain);
		infoButton = new JButton("信息查询");
		editButton = new JButton("修改信息");
		courseView = new JButton("开课");
		courseButton = new JButton("全部课程");
		exam = new JButton("开设考试");
		examButton = new JButton("全部考试");
		sortGrade = new JButton("成绩标准");
		gradeButton = new JButton("成绩录入");
		gradeButton1 = new JButton("成绩统计");
		swich = new JButton("切换账号");
		
		infoButton.setBounds(70, 20, 140, 30);
		editButton.setBounds(70, 60, 140, 30);
		courseView.setBounds(70, 100, 140, 30);
		courseButton.setBounds(70, 140, 140, 30);
		exam.setBounds(70, 180, 140, 30);//增加考试
		examButton.setBounds(70, 220, 140, 30);//全部考试
		sortGrade.setBounds(70, 260, 140, 30);
		gradeButton.setBounds(70, 300, 140, 30);
		gradeButton1.setBounds(70, 340, 140, 30);
		swich.setBounds(70,380,140,30);

		contain.add(infoButton);
		infoButton.addActionListener(this);
		contain.add(gradeButton);
		gradeButton.addActionListener(this);
		contain.add(gradeButton1);
		gradeButton1.addActionListener(this);
		contain.add(courseView);
		courseView.addActionListener(this);
		contain.add(courseButton);
		courseButton.addActionListener(this);
		contain.add(editButton);
		editButton.addActionListener(this);
		contain.add(exam);//增加考试
		exam.addActionListener(this);
		contain.add(sortGrade);
		sortGrade.addActionListener(this);
		examButton.addActionListener(this);//全部考试
		contain.add(examButton);
		swich.addActionListener(this);//切换账号
		contain.add(swich);
		
		setVisible(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == infoButton) {
			new Info(idd, 0);
		}
		if (e.getSource() == gradeButton) {
			new GradeEnter(idd);
		}
		if (e.getSource() == courseButton) {  
			new CourseView(idd, 1);
		}
		if (e.getSource() == editButton) {
			new EditInfo(idd, 1);
		}
		if (e.getSource() == courseView) {
			new AddCourse();
		}
		if(e.getSource() == sortGrade){
			new SortGradeFrame();
		}
		if(e.getSource() == exam){
			new AddExam();
		}
		if (e.getSource() == examButton) {
			new ExamView(idd,1);
		}if (e.getSource() == gradeButton1) {
			new GradeInfoteacher(idd);
		}if (e.getSource() == swich) {
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
