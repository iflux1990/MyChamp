/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.MatchManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Groggy
 */
public class GroupRanking extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
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
                doActionSuboption1();
                break;
            case 2:
                doActionSuboption2();
                break;
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        try
        {
            mmgr.scheduleMatches();
            pause();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void doActionSuboption2()
    {
        System.out.println("Team Ranking");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");

    }
}
