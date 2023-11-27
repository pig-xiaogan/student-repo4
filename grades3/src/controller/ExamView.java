package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ExamView extends JFrame {
    /*
     * ѧ����ѯ�γ̣���ʦ��ѯ�����ڿγ�
     */

    JPanel contain;
    JTextArea list;

    public ExamView(String id, int flag) {
        super("����");
        setSize(330, 400);
        contain = new JPanel();
        setLocation(600, 400);
        list = new JTextArea();
        list.setEditable(false);
        contain.add(list);
        list.append("�γ̱��\t�γ���\t����ʱ��\t���Խ���\n");

        String courseid;
        String coursename;
        String examdate = null;
        String examroom = null;

        if(flag == 0){   // ѧ����ѯ�γ�

            // String path = "D://test//course_student";
            String path = System.getProperty("user.dir")+"/data/course_student";
            List<String> files = new ArrayList<String>(); // Ŀ¼�������ļ�
            File file = new File(path);
            File[] tempList = file.listFiles();

            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile()) {
                    files.add(tempList[i].toString());
                    // �ļ�����������·��
                    // String fileName = tempList[i].getName();
                }
                if (tempList[i].isDirectory()) {
                    // ����Ͳ��ݹ���
                }
            }

            try {
                for (int i = 0; i < files.size(); i++) {
                    BufferedReader br = new BufferedReader(new FileReader(files.get(i)));
                    String s = null;
                    while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��
                        String[] result = s.split(" ");
                        if (result[2].equals(id)) {      // ѧ��ѧ�����ʱ
                            courseid = result[0];
                            coursename = result[1];


                            String path1 = System.getProperty("user.dir")+"/data/exam.txt";
                            BufferedReader br1 = new BufferedReader(
                                    new FileReader(path1));        // ����һ��BufferedReader������ȡ�ļ�

                            while ((s = br1.readLine()) != null) { // ʹ��readLine������һ�ζ�һ��
                                String[] result1 = s.split(" ");
                                if (result[0].equals(result1[0])) {
                                    examdate = result1[4];
                                    examroom = result1[5];
                                }
                            }

                            list.append(courseid + "\t");
                            list.append(coursename + "\t");
                            list.append(examdate + "\t");
                            list.append(examroom + "\n");

                            br1.close();
                        }

                    }

                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(flag == 1){      // ��ʦ��ѯ�Լ����ڿγ�
            String path = System.getProperty("user.dir")+"/data/exam.txt";
            // String path = "D://test//course.txt";
            String s = null;

            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while((s = br.readLine())!=null){   //ʹ��readLine������һ�ζ�һ��
                    String[] result = s.split(" ");
                    if(result[3].equals(id)){
                        courseid = result[0];
                        coursename = result[1];
                        examdate = result[4];
                        examroom = result[5];

                        list.append(courseid + "\t");
                        list.append(coursename + "\t");
                        list.append(examdate + "\t");
                        list.append(examroom + "\n");

                    }
                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



        add(contain);
        setVisible(true);
    }
}
