/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Match;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class MatchDBManager extends ConnectionDBManager
{

    public MatchDBManager() throws IOException
    {
    }

    public Match addMatches(Match m) throws SQLException
    {
        Connection con = dataSource.getConnection();
        
        String sql = "INSERT INTO Match(MatchRound, HomeTeamID, GuestTeamID, isPlayed, HomeGoals, GuestGoals) VALUES (?, ?, ?, ?, ? ,?)";

        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setInt(1, m.getMatchRound());
        ps.setInt(2, m.getHomeTeamId());
        ps.setInt(3, m.getGuestTeamId());
        ps.setBoolean(4, m.isIsPlayed());
        ps.setInt(5, m.getHomeGoals());
        ps.setInt(6, m.getGuestGoals());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to add Match");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int Id = keys.getInt(1);

        return new Match(Id, m);
    }

    public void removeAllMatches(Match m) throws SQLException
    {
        String sql = "DELETE FROM Match" + " DBCC CHECKIDENT (Match, RESEED, 0)";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);


        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException();
        }
    }

    public Match getMatchById(int Id) throws SQLException
    {
        Connection con = dataSource.getConnection();


        String sql = ("SELECT * FROM Match WHERE ID Like ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Id);

        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {

            int MatchRound = rs.getInt("MatchRound");
            int HomeTeam = rs.getInt("HomeTeamID");
            int GuestTeam = rs.getInt("GuestTeamID");
            boolean isPlayed = rs.getBoolean("isPlayed");
            int HomeGoals = rs.getInt("HomeGoals");
            int GuestGoals = rs.getInt("GuestGoals");

            Match m = new Match(Id, MatchRound, HomeTeam, GuestTeam, isPlayed, HomeGoals, GuestGoals);
            return m;
        }
        return null;
    }

    public Match getMatchByTeams(int homeTeamId, int guestTeamId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = ("SELECT * FROM Match WHERE HomeTeamID LIKE ? AND GuestTeamID LIKE ?");
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, homeTeamId);
        ps.setInt(2, guestTeamId);
        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {

            int MatchRound = rs.getInt("MatchRound");
            int HomeTeam = rs.getInt("HomeTeamID");
            int GuestTeam = rs.getInt("GuestTeamID");
            boolean isPlayed = rs.getBoolean("isPlayed");
            int HomeGoals = rs.getInt("HomeGoals");
            int GuestGoals = rs.getInt("GuestGoals");

            Match m = new Match(MatchRound, HomeTeam, GuestTeam, isPlayed, HomeGoals, GuestGoals);
            return m;
        }
        return null;
    }

    public ArrayList<Match> getMatchesInGroup(int groupId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = ("SELECT Match.* FROM Team, [Group], Match WHERE Team.GroupID = [Group].ID AND Team.ID = Match.HomeTeamID AND [Group].ID = ?");
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, groupId);
        ResultSet rs = ps.executeQuery();

        ArrayList<Match> Match = new ArrayList<>();


        while (rs.next())
        {
            int MatchId = rs.getInt("ID");
            int MatchRound = rs.getInt("MatchRound");
            int HomeTeam = rs.getInt("HomeTeamID");
            int GuestTeam = rs.getInt("GuestTeamID");
            boolean isPlayed = rs.getBoolean("isPlayed");
            int HomeGoals = rs.getInt("HomeGoals");
            int GuestGoals = rs.getInt("GuestGoals");

            Match matches = new Match(MatchId, MatchRound, HomeTeam, GuestTeam, isPlayed, HomeGoals, GuestGoals);
            Match.add(matches);

        }
        return Match;

    }

    public ArrayList<Match> getMatchesByTeam(int teamId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = " SELECT Match.* FROM Match WHERE Match.HomeTeamID = ? OR Match.GuestTeamID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, teamId);
        ps.setInt(2, teamId);
        ResultSet rs = ps.executeQuery();

        ArrayList<Match> Match = new ArrayList<>();

        while (rs.next())
        {
            int MatchId = rs.getInt("ID");
            int MatchRound = rs.getInt("MatchRound");
            int HomeTeam = rs.getInt("HomeTeamID");
            int GuestTeam = rs.getInt("GuestTeamID");
            boolean isPlayed = rs.getBoolean("isPlayed");
            int HomeGoals = rs.getInt("HomeGoals");
            int GuestGoals = rs.getInt("GuestGoals");

            Match matches = new Match(MatchId, MatchRound, HomeTeam, GuestTeam, isPlayed, HomeGoals, GuestGoals);
            Match.add(matches);
        }
        return Match;

    }

    public int count() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String query = "SELECT COUNT(*) as NumberOfMatches FROM Match";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next())
        {
            int count = rs.getInt("NumberOfMatches");

            return count;
        }
        return 0;

    }

    public void update(Match m) throws SQLException
    {
        Connection con = dataSource.getConnection();
        
        String sql = "UPDATE Match SET MatchRound = ?, HomeGoals = ?, GuestGoals = ?, IsPlayed = ? WHERE ID = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, m.getMatchRound());
        ps.setInt(2, m.getHomeGoals());
        ps.setInt(3, m.getGuestGoals());
        ps.setBoolean(4, m.isIsPlayed());
        ps.setInt(5, m.getId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to update Match");
        }
    }

    public void updateMatchRound(Match m) throws SQLException
    {
        Connection con = dataSource.getConnection();
        
        String sql = "UPDATE Match SET MatchRound = ? WHERE ID = ?";
      
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, m.getMatchRound());
        ps.setInt(2, m.getId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to update Match");
        }
    }
}
