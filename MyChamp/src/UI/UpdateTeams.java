/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Team;
import BLL.TeamManager;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class UpdateTeams extends Menu
{

    private static final int EXIT_VALUE = 0;
    private Team t;
    private TeamManager tmgr;

    public UpdateTeams(Team team)
    {
        super("Update Team MENU",
                "Update School",
                "Update Captain",
                "Update Mail",
                "Update Group");

        EXIT_OPTION = EXIT_VALUE;
        t = team;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                updateSchool();
                break;
            case 2:
                updateCaptain();
                break;
            case 3:
                updateMail();
                break;
            case 4:
                updateGroup();
                break;
            case EXIT_VALUE:
                doActionExit();

        }
    }

    private void updateSchool()
    {
        System.out.println();
        System.out.print("New School Name: ");
        String SchoolName = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setSchoolName(SchoolName);
    }

    private void updateCaptain()
    {
        System.out.println();
        System.out.print("New Captain: ");
        String captain = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setCaptain(captain);
    }

    private void updateMail()
    {
        System.out.println();
        System.out.print("New E-Mail Adress: ");
        String email = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setTeamEmail(email);
    }

    private void updateGroup()
    {
        System.out.println();
        System.out.print("New Group: ");
        String group = new Scanner(System.in, "ISO-8859-1").nextLine();
//        t.s(group);
    }

    private void saveChanges()
    {
        try
        {
            TeamManager tmgr = new TeamManager();
            tmgr.updateTeam(t);

        }
        catch (Exception e)
        {
       
            System.out.println("ERROR - " + e.getMessage());
            pause();
        }
    }

    /*
     * Exits and saves the changes you've made.
     */
    private void doActionExit()
    {
        saveChanges();
    }
}
