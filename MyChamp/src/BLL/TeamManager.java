/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Team;
import DAL.TeamDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TeamManager
{

    private TeamDBManager tdb = null;

    public TeamManager() throws IOException
    {
        tdb = new TeamDBManager();
    }

    public ArrayList<Team> Search()
    {
        return tdb.search();
    }
    
    public ArrayList<Team> ListAllTeams()
    {
        return tdb.listAll();
    }
    
    public Team addTeam(Team t) throws SQLException
    {
        return tdb.AddTeam(t);
    }
    
    public void updateTeam(Team t) throws SQLException
    {
        tdb.updateTeam(t);
    }
    
    public void RemoveTeam(int id)
    {
        tdb.removeTeam();
    }
    
    public void getBySchool(String schoolName)
    {
        tdb.getBySchool();
    }
}
