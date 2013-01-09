/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Match;
import BE.Team;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class MatchDBManager extends ConnectionDBManager
{

    public MatchDBManager() throws IOException
    {
    }

    public void addMatches(Match m) throws SQLException
    {

        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO Match (MatchRound,HomeTeamID,GuestTeamID,IsPlayed,HomeGoals,GuestGoals) VALUES (?,?,?,?,?,?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, m.getMatchRound());
            ps.setInt(2, m.getHomeTeamId());
            ps.setInt(3, m.getGuestTeamId());
            ps.setBoolean(4, m.getIsPlayed());
            ps.setInt(5, m.getHomeGoals());
            ps.setInt(6, m.getGuestGoals());
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException raised:" + ex.getMessage());
        }


    }
}
