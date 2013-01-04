/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Team;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public Team AddTeam(Team t) throws SQLException
    {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO Team(School, TeamCaptain, Email, GroupID, Points)" +
                "VALUES(?,?,?,?,0)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
        ps.setInt(4, t.getGroup().getGroupId());
       
        int affectedRows = ps.executeUpdate();
        if(affectedRows == 0)
        {
            throw new SQLException("Unable to add team");
        }
        
        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);
        
        return new Team(id, t);
        
    }
}
