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
        ps.setBoolean(4, m.getIsPlayed());
        ps.setInt(5, m.getHomeGoals());
        ps.setInt(6, m.getGuestGoals());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to add Song");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int Id = keys.getInt(1);

        return new Match(Id, m);

    }
}
