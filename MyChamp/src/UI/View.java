/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Match;
import BLL.MatchManager;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class View extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
    private Match m;
 
    public View()
    {
        super("View", "Schedule Matches", "Remove all Matches", "Team Match", "Finale Match");
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
                scheduleMatches();
                pause();
                break;
            case 2:
                removeAllMatches();
                break;
            case 3:
                doActionSuboption3();
                break;
            case 4:
                doActionSuboption4();
                break;
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void scheduleMatches()
    {
        try
        {
            mmgr.scheduleMatches();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void removeAllMatches()
    {
         try
        {
            mmgr.removeAllMatches(m);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void doActionSuboption3()
    {
        System.out.println("Team match");
    }
    
    private void doActionSuboption4()
    {
        System.out.println("Finale match");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}
