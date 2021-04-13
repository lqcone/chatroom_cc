package server.view;

import server.view.backstage.ServerManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerFrame extends JFrame{

    private JButton jb1,jb2,jb3;
    private ServerManage server;

    public ServerFrame(){

        super("聊天服务器");

        Container container=getContentPane();

        setSize(500,400);

        setLayout(null);

        jb1=new JButton("开启服务器");
        //设置开启服务器按钮位置和大小
        jb1.setBounds(100,10,100,30);
        //将jb1按钮放到图形面板上
        container.add(jb1);
        //开启服务器按钮注册事件监听
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server=new ServerManage();
                Thread t=new Thread(server);
                t.start();
            }
        });


        setVisible(true);

    }

}
