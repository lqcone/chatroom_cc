//hello
package client.backstage;





import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientManage {

    private boolean isConnect=true;
    private Socket s;
    private ObjectOutputStream os;
    private ObjectInputStream ois;

    public ClientManage(){
        try{
            s=new Socket("127.0.0.1",9999);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(ConnectException e){
            isConnect=false;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean register(User user){
        boolean b=false;
        try{
            if(s!=null){
                os=new ObjectOutputStream(s.getOutputStream());
                user.setType(MessageType.UserRegister);
                os.writeObject(user);
                ois=new ObjectInputStream(s.getInputStream());
                Message mess=(Message) ois.readObject();
                if(mess.getMessageType().equals(MessageType.Register_Sucess)){
                    b=true;
                }
            }
        }catch(IOException e){
            b=false;
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            b=false;
            e.printStackTrace();
        }

        return b;
    }

    public boolean login(User user){
        boolean b=false;

        return b;
    }

    public boolean checkIsLogin(User user){
        boolean b=false;
        try{
            if(s!=null){
                os=new ObjectOutputStream(s.getOutputStream());
                user.setType(MessageType.UserLogin);
                os.writeObject(user);
                ois=new ObjectInputStream(s.getInputStream());
                Message mess=(Message) ois.readObject();
                if(mess.getMessageType().equals(MessageType.Login)){
                    b=true;
                }
                else if(mess.getMessageType().equals(MessageType.NoLogin)){
                    b=false;
                }
            }
        }catch(IOException e){
            b=true;
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            b=true;
            e.printStackTrace();
        }

        return b;
    }

    public boolean isconnected(){
        return isConnect;
    }

}
