package comm.db;

import java.sql.*;
import java.util.Arrays;

public class DBManager {
    private String accountName = "root";
    private String accountPass = "123456";
    private String url = "jdbc:mysql://localhost:3306/StudentSys?serverTimezone=Asia/Shanghai";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rst;

    /**
     * 创建连接
     */
    private Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, accountName, accountPass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 查询数据
     *
     * @param sql
     * @return
     */
    protected ResultSet query(String sql, Object[] param) {
        System.out.println(">>>>>===" + sql);
        System.out.println("DATA:" + Arrays.toString(param));
        conn = getConnection();
        try {
            pst = conn.prepareStatement(sql);
            if (param != null && param.length > 0) {
                for (int i = 0; i < param.length; i++) {
                    pst.setObject(i + 1, param[i]);
                }
            }
            rst = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//			close();
        }
        return rst;
    }

    /**
     * 修改
     * insert into usertbl(uname,upass)values(?,?)
     */
    protected int update(String sql, Object[] param) {
        System.out.println(">>>>>===" + sql);
        System.out.println("DATA:" + Arrays.toString(param));
        int rows = 0;
        conn = getConnection();
        try {
            pst = conn.prepareStatement(sql);
            if (param != null && param.length > 0) {
                for (int i = 0; i < param.length; i++) {
                    pst.setObject(i + 1, param[i]);
                }
            }
            rows = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return rows;
    }

    /**
     * 关闭连接 释放资源
     */
    protected void close() {
        try {
            if (rst != null) {
                rst.close();
                rst = null;
            }
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


}

