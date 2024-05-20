package comm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import comm.db.DBManager;
import comm.entity.Student;

public class StudentDao extends DBManager {
    /**
     * 添加学员
     */
    public boolean addStudent(Student student) {
        String sql = "insert into stuTbl(sid,sname,sphone,semail,age,ssex,QQNumber,username,password)values(?,?,?,?,?,?,?,?,?)";
        Object[] param = {student.getSid(), student.getSname(), student.getPhone(), student.getEmail(), student.getSage(), student.isSex(), student.getQQNumber(), student.getUsername(), student.getPassword()};
        int rows = super.update(sql, param);
        return rows > 0;
    }

    /**
     * 根据学员编号查询
     *
     * @return
     */
    public Student queryStudentByUsername(String username) {
        String sql = "select sid,sname,sphone,semail,age,ssex,QQNumber,password,username from stutbl where username=?";
        String[] param = {username};
        ResultSet rst = super.query(sql, param);
        try {
            if (rst.next()) {
                Student student = new Student();
                student.setEmail(rst.getString("semail"));
                student.setPhone(rst.getString("sphone"));
                student.setSage(rst.getInt("age"));
                student.setSid(rst.getString("sid"));

                student.setSex(rst.getBoolean("ssex"));
                student.setSname(rst.getString("sname"));
                student.setQQNumber(rst.getString("QQNumber"));
                student.setUsername(rst.getString("username"));
                student.setPassword(rst.getString("password"));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return null;
    }

    public Student queryStudentById(String sid) {
        String sql = "select sname,sphone,semail,age,ssex,QQNumber,username,password,sid from stutbl where sid=?";
        String[] param = {sid};
        ResultSet rst = super.query(sql, param);
        try {
            if (rst.next()) {
                Student student = new Student();

                student.setEmail(rst.getString("semail"));
                student.setPhone(rst.getString("sphone"));
                student.setSage(rst.getInt("age"));

                student.setSex(rst.getBoolean("ssex"));
                student.setSid(rst.getString("sid"));
                student.setSname(rst.getString("sname"));
                student.setQQNumber(rst.getString("QQNumber"));
                student.setUsername(rst.getString("username"));
                student.setPassword(rst.getString("password"));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return null;
    }

    /**
     * 修改学员信息
     */
    public boolean update(Student student) {
        String sql = "update stutbl set sname=?,age=?,sphone=?,semail=?,ssex=?,QQNumber=?,username=?,password=? where sid=?";
        Object[] param = {student.getSname(), student.getSage(), student.getPhone(), student.getEmail(), student.isSex(), student.getQQNumber(), student.getUsername(), student.getPassword(), student.getSid()};
        return super.update(sql, param) > 0;
    }

    /**
     * 删除学员信息
     */
    public boolean delStudent(String sid) {
        String sql = "delete from stutbl where sid=?";
        Object[] param = {sid};
        return super.update(sql, param) > 0;
    }

    /**
     * 根据搜索条件 查询列表
     */
    public Vector<Vector<Object>> search(Student student) {
        String sql = "select * from stutbl where 1=1";

        List<Object> list = new ArrayList<Object>();

        if (student.getSname() != null && !student.getSname().equals("")) {
            sql += " and sname like ?";
            list.add("%" + student.getSname() + "%");
        }
        if (student.getEmail() != null && !student.getEmail().equals("")) {
            sql += " and semail like ?";
            list.add("%" + student.getEmail() + "%");
        }
        if (student.getQQNumber() != null && !student.getQQNumber().equals("")) {
            sql += " and QQNumber like ?";
            list.add("%" + student.getQQNumber() + "%");
        }
        if (student.getPhone() != null && !student.getPhone().equals("")) {
            sql += " and sphone like ?";
            list.add("%" + student.getPhone() + "%");
        }
        Object[] param = list.toArray();//转为数组

        ResultSet rst = super.query(sql, param);
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        try {
            while (rst.next()) {
                Vector<Object> row = new Vector<Object>();
                row.add(rst.getString("sid"));
                row.add(rst.getString("sname"));
                if (rst.getBoolean("ssex")) {
                    row.add("男");
                } else {
                    row.add("女");
                }
                row.add(rst.getString("age"));
                row.add(rst.getString("sphone"));
                row.add(rst.getString("semail"));
                row.add(rst.getString("QQNumber"));
                row.add(rst.getString("Class"));
                row.add(rst.getString("username"));
                row.add(rst.getString("password"));

                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }

        return data;
    }

    public boolean queryUserName(String UserName) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSys?serverTimezone=Asia/Shanghai", "root", "123456");
        Statement stmt = conn.createStatement();
        String sql = "select username from stutbl";
        ResultSet rst = stmt.executeQuery(sql);
        boolean isExist = true;
        while (rst.next()) {
            String existUN;
            existUN = rst.getString("username");
            if (existUN.equals(UserName)) {
                isExist = false;
                break;
            } else continue;
        }
        return isExist;
    }
    /**
     * 根据数据获取饼图
     */

    /**
     * 根据学校统计学员人数
     */

}
