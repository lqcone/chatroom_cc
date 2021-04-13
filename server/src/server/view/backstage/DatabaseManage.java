package server.view.backstage;

import common.User;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;

public class DatabaseManage {
    private Connection ct=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    public void init(){
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://172.17.101.146:3306/ChatRoomDao?useUnicode=true&characterEncoding=utf8","nick","123456");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public DatabaseManage(){
        init();
    }

    //注册用户信息
    public boolean Register(User user){
        boolean b=true;
        try{
            ps=ct.prepareStatement("insert into Users(Name,Password) values(?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassWord());
            if(ps.executeUpdate()!=1){
                b=false;
            }

        }catch(SQLException e){
            b=false;
            e.printStackTrace();
        }
        return b;
    }
}
