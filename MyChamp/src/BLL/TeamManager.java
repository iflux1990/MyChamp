/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Group;
import BE.Team;
import DAL.GroupDBManager;
import DAL.TeamDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Business Layer Logic of the Team table
 * @author Daniel, Marco, Mak & Jonas
 */
public class TeamManager
{

    private Group g;
    private Team t;
    private TeamDBManager tdb = null;
    private GroupDBManager gdb;
    private MatchManager mmgr;

    public TeamManager() throws SQLException, IOException
    {
        tdb = new TeamDBManager();
        gdb = new GroupDBManager();
        mmgr = new MatchManager();
    }
    /**
     * Lister alle teams
     * @return listall
     * @throws SQLException 
     */
    public ArrayList<Team> listAllTeams() throws SQLException
    {
        return tdb.listAll();
    }
    /**
     * Returnere addTeam
     * @param t     
     * @throws SQLException 
     */
    public Team addTeam(Team t) throws SQLException
    {
        return tdb.addTeam(t);
    }
    /**
     * 
     * @param t
     * @throws SQLException 
     */
    public void updateTeam(Team t) throws SQLException
    {
        tdb.updateTeam(t);
    }
    /**
     * 
     * @param school
     * @throws SQLException 
     */
    public void removeTeam(String school) throws SQLException
    {
        tdb.removeTeam(school);
    }
    /**
     * returnere count
     * @throws SQLException 
     */
    public int showNumber() throws SQLException
    {
        return tdb.count();
    }
    
    public Team getTeamById(int id) throws SQLException
    {
        return tdb.getTeamById(id);
    }
    /**
     * Resetter points
     * @throws SQLException 
     */
    public void resetPoints() throws SQLException
    {
        tdb.resetPoints();
    }
    
    public Team getTeamByName(String teamName) throws SQLException
    {
        return tdb.getTeamByName(teamName);
    }
    /**
     * Tilføjer Teams til 4 grupper, fra listAll.
     * Hvis under 16 er tilmeldt, laves det manglende antal som "No One"
     * @throws SQLServerException
     * @throws SQLException 
     */
    public void assignGroups() throws SQLServerException, SQLException
    {
        int maxGroups = 4;
        int currentGroup = 1;

        ArrayList<Team> allTeams = tdb.listAll();

        Collections.shuffle(allTeams);

        ArrayList<ArrayList<Team>> Groups = new ArrayList();
        
        for(int i = tdb.listAll().size(); i < 16; i++)
        {
             addTeam(new Team(-1,"No One","Fake","Not to be counted"));
        }

        for (int i = 0; i < maxGroups; i++)
        {
            Groups.add(new ArrayList());
        }

        for (Team t : allTeams)
        {
            gdb.assign(t, currentGroup++);

            if (currentGroup > maxGroups)
            {
                currentGroup = 1;
            }

        }
        System.out.println("Groups assigned");
        

    }
}
