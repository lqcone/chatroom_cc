package client.view;

import client.backstage.ClientManage;
import common.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel jl1,jl2;	//标签
    private JTextField jtf;	//文本框
    private JPasswordField jpf;	//密码文本框
    private JButton jb1,jb2,jb3;
    private JFrame jf;

    public LoginFrame(){
        super("登录界面");
        setLayout(null);
        this.setSize(400,300);

        Container container=getContentPane();
        jl1 = new JLabel("用户名");
        jl1.setBounds(100, 60, 50, 20);
        container.add(jl1);

        jtf = new JTextField();
        //获得光标
        jtf.grabFocus();
        jtf.setBounds(160, 60, 120, 20);
        container.add(jtf);

        jl2 = new JLabel("密码");
        jl2.setBounds(100, 140, 50, 20);
        container.add(jl2);

        jpf = new JPasswordField();
        jpf.setBounds(160, 140, 120, 20);
        container.add(jpf);

        jb1 = new JButton("登录");
        jb1.setBounds(90, 210, 60, 20);
        container.add(jb1);
        //登陆按扭添加事件监听

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=jtf.getText();
                String passWord=new String(jpf.getPassword());
                if(name.equals("")){
                    JOptionPane.showMessageDialog(jf,"用户名不能为空");
                }
                else if(passWord.equals("")){
                    JOptionPane.showMessageDialog(jf,"密码不能为空");
                }
                else{
                    User user=new User(name,passWord);
                    ClientManage cm=new ClientManage();
                    if(cm.isconnected()){
                        if(!cm.checkIsLogin(user)){
                            if(cm.lo)
                        }
                    }
                }
            }
        });

        //注册功能
        jb3=new JButton("注册");
        jb3.setBounds(250, 210, 60, 20);

        container.add(jb3);
        //注册按钮添加监听事件
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //启动注册界面
                RegisterFrame register=new RegisterFrame();
            }
        });


        setVisible(true);
    }
}
