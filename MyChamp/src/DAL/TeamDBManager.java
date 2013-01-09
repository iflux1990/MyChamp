/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Group;
import BE.Team;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.activation.DataSource;

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
                + "VALUES(?,?,?,5,0)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
        //       ps.setInt(4, t.getGroup().getGroupId());

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

            String sql = "UPDATE Team SET School = ?, TeamCaptain = ?, Email = ? WHERE ID = ?";

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
            ps.setInt(4, t.getTeamId());


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

        String sql = "SELECT *, [Group].GroupName FROM Team, [Group] WHERE Team.GroupID = [Group].ID ORDER BY GroupID, Team.ID";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {

            int id = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String groupName = rs.getString("GroupName");
            String email = rs.getString("Email");
            int GroupId = rs.getInt("GroupID");
//            int points = rs.getInt("Points");


            Team t = new Team(id, school, teamcaptain, email, new Group(GroupId, groupName));
            Team.add(t);
        }
        return Team;

    }

    /**
     * Fjerner et team fra databasen efter skolenavn
     *
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

    public ArrayList<Team> listGroupA() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT GroupName, School FROM Team join [Group] ON GroupID = [Group].ID and GroupID = 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {

            String GroupName = rs.getString("GroupName");
            String school = rs.getString("School");

//            Team t = new Team(GroupName, school);
//            Team.add(t);
        }
        return Team;

    }

    public Team getRandomSchool() throws SQLException
    {
        String sql = "SELECT TOP 1 School FROM Team, [Group] ORDER BY NEWID()";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
//            int TeamID = rs.getInt("ID");
            String SchoolName = rs.getString("School");
            String Captain = rs.getString("TeamCaptain");
            String TeamEmail = rs.getString("Email");
            String GroupName = rs.getString("GroupName");
            int GroupID = rs.getInt("ID");

            Team t = new Team(-1, SchoolName, Captain, TeamEmail, new Group(GroupID, GroupName));
        }

        return t;
    }

    public ArrayList<Team> GetUnsortedTeams() throws SQLServerException, SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT * FROM Team, [Group] WHERE GroupID=1 AND Team.GroupID = [Group].ID";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {
            int id = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            int groupid = rs.getInt("GroupID");
            String groupName = rs.getString("GroupName");

            Team team = new Team(id, school, teamcaptain, email, new Group(groupid, groupName));
            Team.add(team);
        }
        return Team;
    }

    public int Count() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            String query = "SELECT COUNT(*) as NumberOfTeams FROM Team";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int count = rs.getInt("NumberOfTeams");

                return count;
            }
            return 0;
        }
    }
}
