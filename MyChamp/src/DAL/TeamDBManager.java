/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Group;
import BE.Team;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
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

        String sql = "INSERT INTO Team(School, TeamCaptain, Email, Points)"
                + "VALUES(?,?,?,0)";

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

    public Team getTeamById(int teamId) throws SQLException
    {

        Connection con = dataSource.getConnection();

        String sql = "SELECT Team.*, [Group].GroupName FROM Team,[Group] WHERE [Group].ID = Team.GroupID AND Team.ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, teamId);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            int GroupId = rs.getInt("GroupId");
            String groupName = rs.getString("GroupName");
            int points = rs.getInt("Points");

            Team t = new Team(teamId, school, teamcaptain, email, new Group(GroupId, groupName), points);

            return t;
        }

        return null;
    }

    public ArrayList<Team> getWinnerSecond(int groupId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT TOP 2 Team.*, [Group].GroupName FROM Team, [Group], Match WHERE Team.GroupID = [Group].ID AND [Group].ID = ? ORDER BY Team.Points, (Match.HomeGoals-Match.GuestGoals)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, groupId);
        ResultSet rs = ps.executeQuery();

        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {
            int teamId = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            int GroupId = rs.getInt("GroupId");
            String groupName = rs.getString("GroupName");
            int points = rs.getInt("Points");

            Team t = new Team(teamId, school, teamcaptain, email, new Group(GroupId, groupName), points);
            Team.add(t);
        }
        return Team;
    }

    public Team getWinnerQuarter(int matchId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT Team.*, [Group].GroupName FROM Team, [Group] WHERE [Group].ID = Team.GroupID AND Team.Points IN (SELECT MAX(Team.Points)'Points' FROM Team, Match WHERE Match.ID = ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, matchId);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
            int teamId = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            int GroupId = rs.getInt("GroupId");
            String groupName = rs.getString("GroupName");
            int points = rs.getInt("Points");

            Team team = new Team(teamId, school, teamcaptain, email, new Group(GroupId, groupName), points);
            return team;
        }
        return null;
    }

    public Team getTeamByName(String teamName) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT Team.*, [Group].GroupName FROM Team,[Group] WHERE [Group].ID = Team.GroupID AND Team.School = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, teamName);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
            int teamId = rs.getInt("ID");
            String school = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            int GroupId = rs.getInt("GroupId");
            String groupName = rs.getString("GroupName");
            int points = rs.getInt("Points");

            Team t = new Team(teamId, school, teamcaptain, email, new Group(GroupId, groupName), points);

            return t;
        }
        return null;
    }

    public void updateTeam(Team t) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "UPDATE Team SET School = ?, TeamCaptain = ?, Email = ?, Points = ? WHERE ID = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
        ps.setInt(4, t.getPoints());
        ps.setInt(5, t.getTeamId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to update Team");
        }
    }

    public void resetPoints() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "UPDATE Team SET Points = 0";
        PreparedStatement ps = con.prepareStatement(sql);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to update Team");
        }


    }

    public ArrayList<Team> listAll() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT * FROM Team LEFT JOIN [Group] on Team.GroupID = [Group].ID order by GroupID, Team.ID";
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
            int points = rs.getInt("Points");

            Team t = new Team(id, school, teamcaptain, email, new Group(GroupId, groupName), points);
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
    public void removeTeam(String schoolName) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "DELETE FROM TEAM WHERE ID = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, schoolName);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Team");
        }
    }

    public ArrayList<Team> getTeamsByGroupId(int groupId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT Team.*, GroupName FROM Team, [Group] WHERE Team.GroupID = [Group].ID AND Team.GroupID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, groupId);
        ResultSet rs = ps.executeQuery();

        ArrayList<Team> Team = new ArrayList<>();
        while (rs.next())
        {

            int teamId = rs.getInt("ID");
            String school = rs.getString("School");
            String captain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
            String groupName = rs.getString("groupName");

            Team t = new Team(teamId, school, captain, email, new Group(groupId, groupName));
            Team.add(t);
        }
        return Team;

    }

    public int count() throws SQLException
    {
        Connection con = dataSource.getConnection();

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
