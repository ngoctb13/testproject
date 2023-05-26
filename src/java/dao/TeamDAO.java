/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Team;

/**
 *
 * @author Admin
 */
public class TeamDAO extends DBContext {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public int addTeam(Team t) throws Exception {
        int status = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement("insert into dbo.[Team] (team_name, phone_number, email, address, description, coach) values (?,?,?,?,?,?)");
            ps.setString(1, t.getTeam_name());
            ps.setString(2,t.getPhone_number());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getAddress());
            ps.setString(5, t.getDescription());
            ps.setInt(6, t.getCoach());
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
}
