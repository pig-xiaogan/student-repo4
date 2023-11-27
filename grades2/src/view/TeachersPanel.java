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
	 * ��ʦ��½�����������
	 */
	
	String idd;
	JPanel contain;
	JButton infoButton, gradeButton, gradeButton1,courseButton, examButton,editButton, courseView, sortGrade,exam,swich;

	public TeachersPanel(String idd) {
		super("��ʦ");
		this.idd = idd;
		setLocation(300, 200);
		setSize(300, 470);
		contain = new JPanel();
		contain.setLayout(null);
		add(contain);
		infoButton = new JButton("��Ϣ��ѯ");
		editButton = new JButton("�޸���Ϣ");
		courseView = new JButton("����");
		courseButton = new JButton("ȫ���γ�");
		exam = new JButton("���迼��");
		examButton = new JButton("ȫ������");
		sortGrade = new JButton("�ɼ���׼");
		gradeButton = new JButton("�ɼ�¼��");
		gradeButton1 = new JButton("�ɼ�ͳ��");
		swich = new JButton("�л��˺�");
		
		infoButton.setBounds(70, 20, 140, 30);
		editButton.setBounds(70, 60, 140, 30);
		courseView.setBounds(70, 100, 140, 30);
		courseButton.setBounds(70, 140, 140, 30);
		exam.setBounds(70, 180, 140, 30);//���ӿ���
		examButton.setBounds(70, 220, 140, 30);//ȫ������
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
		contain.add(exam);//���ӿ���
		exam.addActionListener(this);
		contain.add(sortGrade);
		sortGrade.addActionListener(this);
		examButton.addActionListener(this);//ȫ������
		contain.add(examButton);
		swich.addActionListener(this);//�л��˺�
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
