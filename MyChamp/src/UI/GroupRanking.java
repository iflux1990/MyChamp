/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.MatchManager;
import DAL.TeamDBManager;
import java.io.IOException;
import java.sql.SQLException;

/**
 * controlling the viewing of the Group Ranking
 * @author Daniel, Marco, Mak & Jonas
 */
public class GroupRanking extends Menu  
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
    private TeamDBManager tdbmgr;
    
    /**
    * Creates the menu for group ranking
    */
    
    public GroupRanking()
    {
        super("Group Ranking", "Group", "Team");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            mmgr = new MatchManager();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }
    
    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                groupRanking();
                break;
            case 2:
                teamRanking();
                break;
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void groupRanking()
    {
        try
        {
            mmgr.scheduleMatches();
           
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        pause();
    }
    
    private void teamRanking()
    {
        System.out.println("Team Ranking");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");

    }
}
