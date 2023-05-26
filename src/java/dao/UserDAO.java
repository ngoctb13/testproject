/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Delete_Request;
import model.Feedback;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public User getUser(String input_email, String input_password) throws Exception {
        User user = null;
        String query = "SELECT * FROM dbo.[User] WHERE [email] = ? and [password] = ?";
        try {
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, input_email);
            ps.setString(2, input_password);
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String phone_number = rs.getString("phone_number");
                String avatar_link = rs.getString("avatar_link");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                int role = rs.getInt("role_id");
                user = new User(user_id, full_name, phone_number, avatar_link, email, password, address, role);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return user;
    }

    public User getUserByEmail(String input_email) throws Exception {
        User user = null;
        String query = "SELECT * FROM dbo.[User] WHERE [email] = ?";
        try {
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, input_email);
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String phone_number = rs.getString("phone_number");
                String avatar_link = rs.getString("avatar_link");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                int role = rs.getInt("role_id");
                user = new User(user_id, full_name, phone_number, avatar_link, email, password, address, role);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return user;
    }

    public int addUser(User a) throws Exception {
        int status = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement("insert into dbo.[User] (full_name, email, password, role_id) values (?,?,?,?)");
            ps.setString(1, a.getFull_name());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPassword());
            ps.setInt(4, 2);
            status = ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return status;
    }

    public int resetPassword(String new_password, String email) throws Exception {
        int status = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement("update dbo.[User] set password = ? where email = ?");
            ps.setString(1, new_password);
            ps.setString(2, email);
            status = ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return status;
    }

    public int addDeleteRequest(Delete_Request a) throws Exception {
        int status = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement("insert into dbo.[Delete_Request] (reason, email, user_id) values (?,?,?)");
            ps.setString(1, a.getReason());
            ps.setString(2, a.getEmail());
            ps.setInt(3, a.getUser_id());
            status = ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
        return status;
    }

    public List<User> getListUser() throws Exception {
        try {
            String sql = "SELECT * FROM dbo.[User]";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String full_name = rs.getString("full_name");
                String phone_number = rs.getString("phone_number");
                String avatar_link = rs.getString("avatar_link");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int role = rs.getInt("role_id");
                String address = rs.getString("address");
                User user = new User(id, full_name, phone_number, avatar_link, email, password, address, role);
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
    }
    
    public List<Delete_Request> getListDeleteRequest() throws Exception {
        try {
            String sql = "SELECT * FROM dbo.[Delete_Request]";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Delete_Request> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("request_id");
                String reason = rs.getString("reason");
                String email = rs.getString("email");
                int user_id = rs.getInt("user_id");
                Delete_Request rq = new Delete_Request(user_id, reason, email, user_id);
                list.add(rq);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);
        }
    }
    
    
}
