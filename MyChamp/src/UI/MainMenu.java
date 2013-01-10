/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 * Head menu of the program
 * @author Daniel, Marco, Mak & Jonas
 */
public class MainMenu extends Menu
{

    private static final int EXIT_VALUE = 0;    

    /**
     * Constructor, makes a menu with the title "myChamp" and 5 sub menus
     */
    public MainMenu()
    {
        super("Main Menu", "Team Management", 
                            "Match Management",
                            "Match Result",
                            "Group Ranking",
                            "Final Ranking");
                            EXIT_OPTION = EXIT_VALUE;        
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                goToTeamManagenment();      //go to Team Management
                break;
            case 2:
                goToView();                 //go to View
                break;
            case 3:
                goToMatchResult();          //go to Match Result
                break;
            case 4:
                goToGroupRanking();         //go to Group Ranking
                break;
            case 5:
                goToFinalRanking();         //go to Finale Ranking
                break;
        }
    }

    private void goToTeamManagenment()      //runs a new Team Managenment
    {
        new TeamManagenment().run();
        clear();
    }

    private void goToView()                 //runs a new View
    {
        new View().run();
        clear();
    }

    private void goToMatchResult()          //runs a new Match Result
    {
        new MatchResult().run();
        clear();
    }

    private void goToGroupRanking()         //runs a new Group Ranking
    {
        new GroupRanking().run();
        clear();
    }

    private void goToFinalRanking()         //runs a new FInale Ranking
    {
        new FinaleRanking().run();
        clear();
    }
}
