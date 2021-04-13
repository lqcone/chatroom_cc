package server.view.backstage;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerManage implements Runnable{

    private ServerSocket ss;
    private ObjectInputStream ois;
    private ObjectOutputStream os;
    private Server_Connect_Database server;

    public ServerManage(){

        //服务器对象开始监听端口
        try{
            ss=new ServerSocket(9999);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            while(true){
                try{
                    Socket s=null;
                    try{
                        s=ss.accept();
                    }catch(SocketException e){
                        if(s!=null)
                            s.close();
                        break;
                    }
                    //输出日志信息
                    System.out.println("socket accepted!");
                    ois=new ObjectInputStream(s.getInputStream());
                    User user=(User)ois.readObject();
                    //判断读取到的用户信息类型
                    //如果时注册信息
                    if(user.getType().equals(MessageType.UserRegister)){
                        server=new Server_Connect_Database();
                        Message mess=new Message();
                        if(server.checkRegister(user)){
                            mess.setMessageType(MessageType.Register_Sucess);
                            os=new ObjectOutputStream(s.getOutputStream());
                            os.writeObject(mess);
                            s.close();
                        }
                        else{
                            mess.setMessageType(MessageType.Register_Fail);
                            os=new ObjectOutputStream(s.getOutputStream());
                            os.writeObject(mess);
                            s.close();
                        }
                    }

                }catch(SocketException e){
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
