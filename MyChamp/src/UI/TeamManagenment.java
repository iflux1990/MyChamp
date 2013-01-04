/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Groggy
 */
public class TeamManagenment extends Menu
{
    private static final int EXIT_VALUE = 0;
    
    public TeamManagenment()
    {
        super("Team Managenment", "Add Team", "Update Team", "Remove Team");
        EXIT_OPTION = EXIT_VALUE;
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
            case 3:
                doActionSuboption3();
                break;
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Add Team");
    }

    private void doActionSuboption2()
    {
        System.out.println("Update Team");
    }
    
    private void doActionSuboption3()
    {
        System.out.println("Remove Team");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}
