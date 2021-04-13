package server.view.backstage;
/*
*服务端与数据库通信的后台类
 */


import common.User;

import java.sql.ResultSet;

public class Server_Connect_Database {
    private ResultSet rs=null;
    private DatabaseManage databaseManage=null;

    /*
    注册用户并返回注册结果
     */
    public boolean checkRegister(User user){
        databaseManage=new DatabaseManage();
        return databaseManage.Register(user);
    }
}
