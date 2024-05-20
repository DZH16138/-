package comm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import comm.db.DBManager;
import comm.entity.Student;
import comm.entity.User;

public class UserDao extends DBManager {
    public int login(String uname, String upass) {
        //0:错误 1:管理员 2:学生 3:老师//
        String sql = "select upass from usertbl where uname=?";
        String sqlR = "select uright from usertbl where uname=?";
        String[] data = {uname};
        ResultSet rst = super.query(sql, data);
        ResultSet rstR = super.query(sqlR, data);
        try {
            if (rst.next()) {
                String dbpass = rst.getString("upass");//数据库中的密码
                if (dbpass != null && dbpass.equals(upass)) {//匹配密码
                    if (rstR.next()) {
                        String dbright = rstR.getString("uright");
                        if (dbright.equals("student")) {
                            return 2;
                        }
                        if (dbright.equals("teacher")) {
                            return 3;
                        }
                        if (dbright.equals("manager")) {
                            return 1;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean addUser(User user) {
        String sql = "insert into usertbl(uname,upass,uright)values(?,?,?)";
        Object[] param = {user.getUsername(),user.getPassword(),user.getRight()};
        int rows = super.update(sql, param);
        return rows > 0;
    }

    public User queryUserByUsername(String uname) {
        String sql = "select uid,uname,upass,uright from usertbl where uname=?";
        String[] param = {uname};
        ResultSet rst = super.query(sql, param);
        try {
            if (rst.next()) {
                User user = new User();

//				user.setEmail(rst.getString("semail"));
//				user.setPhone(rst.getString("sphone"));
//				user.setSage(rst.getInt("age"));
//
//				user.setSex(rst.getBoolean("ssex"));
                user.setSid(rst.getString("uid"));
//				user.setSname(rst.getString("sname"));
//				user.setQQNumber(rst.getString("QQNumber"));
                user.setUsername(rst.getString("uname"));
                user.setPassword(rst.getString("upass"));
                user.setRight(rst.getString("uright"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return null;

    }

    public User queryUserById(String uid) {
        String sql = "select uid,uname,upass,uright from usertbl where uid=?";
        String[] param = {uid};
        ResultSet rst = super.query(sql, param);
        try {
            if (rst.next()) {
                User user = new User();

//				user.setEmail(rst.getString("semail"));
//				user.setPhone(rst.getString("sphone"));
//				user.setSage(rst.getInt("age"));
//
//				user.setSex(rst.getBoolean("ssex"));
                user.setSid(rst.getString("uid"));
//				user.setSname(rst.getString("sname"));
//				user.setQQNumber(rst.getString("QQNumber"));
                user.setUsername(rst.getString("uname"));
                user.setPassword(rst.getString("upass"));
                user.setRight(rst.getString("uright"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return null;

    }

    public boolean delUser(String sid) {
        String sql = "delete from usertbl where sid=?";
        Object[] param = {sid};
        return super.update(sql, param) > 0;
    }

    public boolean update(User user) {
        String sql = "update usertbl set uname=?,upass=?,uright=? where uid=?";
        Object[] param = {user.getUsername(), user.getPassword(), user.getRight(), user.getSid()};
        return super.update(sql, param) > 0;
    }
}
