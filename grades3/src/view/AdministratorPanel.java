package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.AddUser;
import controller.DeleteUser;
import controller.EditInfo;



@SuppressWarnings("serial")
public class AdministratorPanel extends JFrame implements ActionListener {
	/*
	 * ����Ա��½�����������
	 */
	JButton deleteUser, addUser, selfInfo,swich;
	JPanel contain;
	String idd;

	public AdministratorPanel(String idd) {
		super("ϵͳ����Ա");
		this.idd = idd;
		setLocation(300, 200);
		setSize(300, 380);
		contain = new JPanel();
		contain.setLayout(null);
		add(contain);
		selfInfo = new JButton("�޸���Ϣ");
		addUser = new JButton("�����û�");
		deleteUser = new JButton("ɾ���û�");
		swich = new JButton("�˳���¼");
		swich.setBackground(new Color(0x00, 0xa0, 0xdd));
		selfInfo.setBounds(70, 45, 140, 30);
		addUser.setBounds(70, 100, 140, 30);
		deleteUser.setBounds(70, 155, 140, 30);
		swich.setBounds(70,210,140,30);
		contain.add(selfInfo);
		contain.add(addUser);
		contain.add(deleteUser);
		contain.add(swich);
		selfInfo.addActionListener(this);
		addUser.addActionListener(this);
		deleteUser.addActionListener(this);
		swich.addActionListener(this);//�л��˺�
		setVisible(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addUser) {
			new AddUser();    // �û������ʼ��ͳһΪ123456
		} else if (e.getSource() == deleteUser) {
			new DeleteUser();
		} else if (e.getSource() == selfInfo) {
			new EditInfo(idd, 3);
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