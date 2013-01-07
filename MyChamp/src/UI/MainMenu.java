/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.TeamManager;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Hovedmenuen
 *
 * @author Mak, Jonas, Daniel og Marco
 */
public class MainMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    private TeamManager tmgr;

    /**
     * Constructor, opretter en hovedmenu med titlen "MyChamps" og fem
     * menupunkter
     */
    public MainMenu()
    {
        super("Main Menu", "Team Management", 
                            "View",
                            "Match Result",
                            "Group Ranking",
                            "Final Ranking");
                            EXIT_OPTION = EXIT_VALUE;
        try
        {
            tmgr = new TeamManager();
                    
        }
        catch (SQLException | IOException ex)
        {
            System.out.println("ERROR - :" + ex.getMessage());
        }
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                goToTeamManagenment();
                break;
            case 2:
                goToView();
                break;
            case 3:
                goToMatchResult();
                break;
            case 4:
                goToGroupRanking();
                break;
            case 5:
                goToFinalRanking();
                break;
        }
    }

    private void goToTeamManagenment()
    {
        new TeamManagenment().run();
        clear();
    }

    private void goToView()
    {
        new View().run();
        clear();
    }

    private void goToMatchResult()
    {
        new MatchResult().run();
        clear();
    }

    private void goToGroupRanking()
    {
        new GroupRanking().run();
        clear();
    }

    private void goToFinalRanking()
    {
        new FinaleRanking().run();
//        try
//        {
//            tmgr.getRandomTeam();
//        }
//        catch (SQLException ex)
//        {
//            System.out.println("ERROR - " + ex.getMessage());
//        }
        
    }
}
