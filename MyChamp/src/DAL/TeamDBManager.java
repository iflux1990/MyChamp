/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Team;
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
    
    public Team AddTeam(Team t) throws SQLException
    {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO Team(School, TeamCaptain, Email, GroupID, Points)" +
                "VALUES(?,?,?,0,0)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
       
       
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

    public ArrayList<Team> search()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<Team> listAll()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void removeTeam()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void getBySchool()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Team addTeam(Team t)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
