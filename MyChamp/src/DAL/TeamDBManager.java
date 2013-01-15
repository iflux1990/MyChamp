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

    /**
     * Tilføjer et nyt team til databasen, med værdierner fra objektet "t"
     * @param t et Team objekt
     * @return retunere et team objekt med et autogenereret ID fra databasen
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Henter et team objetkt fra databasen med et givet ID
     * @param teamId 
     * @return retunere et team objekt med der passer med det givne ID
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Henter første og anden pladsen af en gruppe med et givet Gruppe ID.
     * sorteret efter Point og hvis de har samme antal point, så efter målscore differencen
     * @param groupId
     * @return en liste af Team Objekter med vinderen på på plads [0] og anden pladsen på [1]
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Henter en vinder af en match fra databasen
     * @param matchId Match id'et på den kamp du søger vinderen af.
     * @return Retunere vinder teamet af en givet kamp 
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Henter et team objekt fra databasen med et givet navn
     * @param teamName navnet på det hold du søger.
     * @return retunere et objekt Team(teamId, school, teamcaptain, email, new Group(GroupId, groupName), points)
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Opdatere databasen med værdierne fra objektet "t"
     * @param t 
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * sætter alle teams point antal på til 0
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Henter alle teams fra databasen
     * @return Retunere alle hold i databasen i en liste    
     * @throws SQLException smider SQLExceptions videre.
     */
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
     * Fjerner et team fra databasen med et givet Navn eller ID
     *
     * @param School
     * @throws SQLException
     */
    public void removeTeam(String school) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "DELETE FROM TEAM WHERE ID = ? OR Team.School = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, school);
        ps.setString(2, school);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Team");
        }
    }

    /**
     * Henter alle teams med et givet Gruppe id
     * @param groupId
     * @return retunere et ArrayList med team objekter
     * @throws SQLException smider SQLExceptions videre.
     */
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

    /**
     * Tæller alle teams i databasen og retunere antallet som en Int værdi
     * @return int amount of teams.
     * @throws SQLException smider SQLExceptions videre.
     */
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
