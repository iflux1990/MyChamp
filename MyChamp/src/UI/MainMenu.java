/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 * Hovedmenuen
 * @author Mak, Jonas, Daniel og Marco
 */
public class MainMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    
    /**
     * Constructor, opretter en hovedmenu med titlen "MyChamps" og 
     * fem menupunkter 
     */
    public MainMenu()
    {
        super("Main Menu", "Team Management", "View", "Match Result",
                "Group Ranking", "Final Ranking");
                EXIT_OPTION = EXIT_VALUE;
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
        clear();
    }
}
