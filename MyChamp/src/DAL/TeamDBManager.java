/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Group;
import BE.Team;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TeamDBManager extends ConnectionDBManager
{

    private Team t;

    public TeamDBManager() throws IOException
    {
    }

    public Team addTeam(Team t) throws SQLException
    {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO Team(School, TeamCaptain, Email, GroupID, Points)"
                + "VALUES(?,?,?,1,0)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to add team");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);

        return new Team(id, t);

    }

    public void updateTeam(Team t) throws SQLException
    {
        {

            String sql = "UPDATE Team SET School = ?, TeamCaptain = ?, Email = ?, GroupId= ?, WHERE Id = ?";

            Connection con;
            try
            {
                con = dataSource.getConnection();
            }
            catch (SQLServerException ex)
            {
                throw new SQLException("Unable to connect to server.");
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getSchoolName());
            ps.setString(2, t.getCaptain());
            ps.setString(3, t.getTeamEmail());
            ps.setInt(4, t.getGroupId());
            ps.setInt(5, t.getTeamId());


            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to update Song");
            }
        }
    }

    public ArrayList<Team> search()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<Team> listAll() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT * FROM Team";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {

            int id = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
//            int groupid = rs.getInt("GroupID");
//            int points = rs.getInt("Points");


            Team t = new Team(id, school, teamcaptain, email);
            Team.add(t);
        }
        return Team;

    }

       
    /**
     * Fjerner et team fra databasen efter skolenavn
     * @param School
     * @throws SQLException
     */
    public void RemoveTeam(String SchoolName) throws SQLException
    {
        String sql = "DELETE FROM TEAM WHERE ID = ?";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, SchoolName);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Team");
        }
    }

    public void getBySchool()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

  
}
