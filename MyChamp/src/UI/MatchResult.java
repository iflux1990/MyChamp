/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class MatchResult extends Menu
{

    private static final int EXIT_VALUE = 0;
    private final MatchManagement mmui;
 
    public MatchResult()
    {
        super("Match Result", "Record Result");
        EXIT_OPTION = EXIT_VALUE;
        
        mmui = new MatchManagement();
    }
    
    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                matchResult();
                break;
            case EXIT_VALUE: doActionExit();
        }
    }

    private void matchResult()
    {
        mmui.viewOpeningRounds();
        
        Scanner matchId = new Scanner(System.in, "ISO-8859-1");
        
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}
