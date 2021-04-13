package client.view;

import client.backstage.ClientManage;
import common.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame{
    private JLabel jl1,jl2,jl3;
    private JTextField jtf;   //文本框：输入用户名
    private JPasswordField jpf1,jpf2;  //密码框，输入用户密码
    private JButton jb1,jb2,jb3;
    private JFrame jf;

    public RegisterFrame(){

        super("注册界面");
        setLayout(null);
        this.setSize(400,300);

        Container container=getContentPane();

        //用户名标签布局
        jl1 = new JLabel("用户名");
        jl1.setBounds(100, 60, 50, 20);
        container.add(jl1);

        //用户名输入框布局
        jtf = new JTextField();
        //获取光标
       // jtf.grabFocus();
        jtf.setBounds(160, 60, 120, 20);
        container.add(jtf);


        //密码输入框布局
        jl2 = new JLabel("密码");
        jl2.setBounds(100, 110, 50, 20);
        container.add(jl2);

        jpf1 = new JPasswordField();
        jpf1.setBounds(160, 110, 120, 20);
        container.add(jpf1);

        //密码确认框布局
        jl3 = new JLabel("确认密码");
        jl3.setBounds(100, 162, 70, 20);
        container.add(jl3);

        jpf2 = new JPasswordField();
        jpf2.setBounds(160, 162, 120, 20);
        container.add(jpf2);



        jb1 = new JButton("注册");
        jb1.setBounds(90, 210, 60, 20);
        container.add(jb1);

        //添加事件监听
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=jtf.getText();
                String passWord=new String(jpf1.getPassword());
                String rePassWord=new String(jpf2.getPassword());
                if(name.equals("")||passWord.equals("")){
                    JOptionPane.showMessageDialog(jf,"用户名或密码不能为空");
                }
                else if(rePassWord.equals("")){
                    JOptionPane.showMessageDialog(jf,"请确认密码");
                }
                else if(!passWord.equals(rePassWord)){
                    JOptionPane.showMessageDialog(jf,"确认密码错误");
                }
                else{
                    User user=new User(name,passWord);
                    ClientManage cm=new ClientManage();
                    if(cm.isconnected()){
                        if(cm.register(user)){
                            JOptionPane.showMessageDialog(jf,"注册成功");
                            jf.dispose();
                            LoginFrame login=new LoginFrame();
                        }
                        else{
                            JOptionPane.showMessageDialog(jf,"注册失败");
                            jf.dispose();
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(jf,"连接不到服务器");
                        jf.dispose();
                    }
                }

            }
        });



        setVisible(true);

    }

}
