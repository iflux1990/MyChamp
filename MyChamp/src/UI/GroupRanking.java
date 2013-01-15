/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.MatchManager;
import DAL.TeamDBManager;
import java.io.IOException;

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
    /**
     * Printer du har valgt Group Ranking
     */
    private void groupRanking()
    {       
        System.out.println("Group Ranking");
    }
    /**
     * Printer du har valgt Team Ranking
     */
    private void teamRanking()
    {
        System.out.println("Team Ranking");
    }
    /**
     * Printer du har valgt exit
     */
    private void doActionExit()
    {
        System.out.println("You selected to exit.");

    }
}
