package controller;


import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;


@SuppressWarnings("serial")
public class AddExam extends JFrame implements ActionListener {
    /*
     * ��ʦ���ӿγ�
     */


    JPanel contain;
    JButton submit;
    JLabel id, name, examDate, examRoom, teacherId, teacherName;
    JTextField idt, namet, examDatet, examRoomt, teacherIdt, teacherNamet;

    public AddExam() {
        super("���ӿ���");
        setSize(500, 450);
        setLocation(600, 400);
        contain = new JPanel();
        contain.setLayout(null);
        id = new JLabel("�γ̺�");
        name = new JLabel("�γ���");
        examDate= new JLabel("����ʱ��");
        examRoom = new JLabel("���Խ���");

        teacherId = new JLabel("��ʦ");
        teacherName = new JLabel("��ʦ��");

        submit = new JButton("�ύ");
        idt = new JTextField();
        namet = new JTextField();
        examDatet = new JTextField();
        examRoomt = new JTextField();
        teacherIdt = new JTextField();
        teacherNamet = new JTextField();

        id.setBounds(42, 35, 75, 35);
        idt.setBounds(80, 35, 150, 35);
        name.setBounds(42, 90, 75, 35);
        namet.setBounds(80, 90, 150, 35);
        examDate.setBounds(30, 145, 75, 35);
        examDatet.setBounds(80, 145, 150, 35);
        examRoom.setBounds(30, 200, 75, 35);
        examRoomt.setBounds(80, 200, 150, 35);

        teacherId.setBounds(44, 255, 75, 35);
        teacherIdt.setBounds(80, 255, 150, 35);

        teacherName.setBounds(42, 310, 75, 35);
        teacherNamet.setBounds(80, 310, 75, 35);

        submit.setBounds(102, 365, 70, 30);
        contain.add(id);
        contain.add(idt);
        contain.add(name);
        contain.add(namet);
        contain.add(examDate);
        contain.add(examDatet);
        contain.add(examRoom);
        contain.add(examRoomt);
        contain.add(teacherId);
        contain.add(teacherIdt);
        contain.add(teacherName);
        contain.add(teacherNamet);
        contain.add(submit);
        submit.addActionListener(this);
        add(contain);
        setVisible(true);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    public int hasExam(String id){  //  ��ʦ����ǰ���γ��Ƿ��Ѿ�����

        String file = System.getProperty("user.dir")+"/data/exam.txt";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file)); //����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
                String[] result = s.split(" ");
                if(result[0].equals(id)){
                    return 1;

                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if ((idt.getText().equals("")) || (namet.getText().equals("")) || (examDatet.getText().equals(""))
                    || (examRoomt.getText().equals("")) || teacherIdt.getText().equals("") || teacherNamet.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ�գ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if ((hasExam(idt.getText())) == 1) {
                    JOptionPane.showMessageDialog(null, "�˿����Ѿ����ڣ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    String file = System.getProperty("user.dir")+"/data/exam.txt";

                    ArrayList<String> modifiedContent = new ArrayList<String>();
                    // StringBuilder result = new StringBuilder();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String s = null;
                        while ((s = br.readLine()) != null) {  // �Ƚ�ԭ�����ڵ���Ϣ�洢����
                            String[] result = s.split(" ");

                            String s1 = "";
                            for (int i = 0; i < result.length - 1; i++) {
                                s1 = s1 + result[i];
                                s1 = s1 + " ";
                            }
                            s1 = s1 + result[result.length - 1];
                            // System.out.println(s1);
                            modifiedContent.add(s1);
                        }
                        br.close();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    Course course = new Course(idt.getText(), namet.getText(), examDatet.getText(), examRoomt.getText(), teacherIdt.getText(), teacherNamet.getText());


                    modifiedContent.add(course.getCourseId()+" "+course.getCourseName()+" "+course.getExamDate()+" "+course.getExamRoom()+" "
                            +course.getTeacherId()+" "+course.getTeacherName());

                    try {
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);

                        for (int i = 0; i < modifiedContent.size(); i++) {
                            bw.write(modifiedContent.get(i));
                            bw.newLine();
                        }

                        bw.close();
                        fw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    //  ������Ӷ�Ӧ�γ��ļ��⣬����Ҫ��ӿγ̳ɼ��ļ��Լ��γ�ѧ���ļ�
                    File gradeFile = new File(System.getProperty("user.dir")+"/data/grade"+course.getCourseName()+".txt");
                    File studentFile = new File(System.getProperty("user.dir")+"/data/course_student"+course.getCourseName()+"_student.txt");

                    JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            setVisible(false);
        }
    }
}
