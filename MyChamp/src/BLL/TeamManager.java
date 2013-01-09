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
    private MatchManager mm;

    public TeamManager() throws SQLException, IOException
    {
        tdb = new TeamDBManager();
        gdb = new GroupDBManager();
        mm = new MatchManager();
    }

    public ArrayList<Team> Search()
    {
        return tdb.search();
    }

    public ArrayList<Team> ListAllTeams() throws SQLException
    {
        return tdb.listAll();
    }

    public Team addTeam(Team t) throws SQLException
    {
        return tdb.addTeam(t);
    }

    public void updateTeam(Team t) throws SQLException
    {
        tdb.updateTeam(t);
    }

    public void removeTeam(String school) throws SQLException
    {
        tdb.RemoveTeam(school);
    }

    public void getBySchool(String schoolName)
    {
        tdb.getBySchool();
    }

    public Team getRandomTeam() throws SQLException
    {
        return tdb.getRandomSchool();
    }

    public int showNumber() throws SQLException
    {

        return tdb.Count();
    }

//        ArrayList<Team> allTeams = tdb.listAll();
//        if (tdb.listAll().size() > 12)
//        {
//            for (int i = 0; i < tdb.listAll().size(); i++)
//            {
//                
//                Collections.shuffle(allTeams);
//   
//                for (int j = 1; j < 5; j++)
//                {
//                    g.setGroupId(j);
//                }
//
//                for (int k = 5; k < 9; k++)
//                {
//                    g.setGroupId(k);
//                }
//
//                for (int l = 9; l < 13; l++)
//                {
//                    g.setGroupId(l);
//                }
//
//                for (int o = 13; o < 17; o++)
//                {
//                    g.setGroupId(o);
//        
//                }
//                
//                gdb.updateGroup(i);
//            }
//        }
//        else
//        {
//            System.out.println("Not enough teams to sort");
//
//        }  
//        System.out.println(allTeams);
    public void assignGroups() throws SQLServerException, SQLException
    {
        int MaxGroups = 4;
        int currentGroup = 1;

        ArrayList<Team> allTeams = tdb.listAll();

        Collections.shuffle(allTeams);

        ArrayList<ArrayList<Team>> Groups = new ArrayList();

        for (int i = 0; i < MaxGroups; i++)
        {
            Groups.add(new ArrayList());
        }

        for (Team t : allTeams)
        {
            gdb.assign(t, currentGroup++);

            if (currentGroup > MaxGroups)
            {
                currentGroup = 1;
            }

        }
        System.out.println("Groups assigned!");
        

    }
//        if (tdb.listAll().size() >= 12)
//        {
//            for (int i = 0; i < tdb.listAll().size(); i++)
//            {
//
//                Collections.shuffle(allTeams);
//
//
//                for (int j = 1; j < 5; j++)
//                {
//                    g.setGroupId(j);
//                }
//
//                for (int k = 5; k < 9; k++)
//                {
//                    g.setGroupId(k);
//                }
//
//                for (int l = 9; l < 13; l++)
//                {
//                    g.setGroupId(l);
//                }
//
//                for (int o = 13; o < 17; o++)
//                {
//                    g.setGroupId(o);
//
//                }
//
//                gdb.updateGroup(i);
//            }
//        }
//        else
//        {
//            System.out.println("Not enough teams to sort");
//
//        }
//        System.out.println(allTeams);
}
