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
public class updateTeam extends Menu
{

    private static final int EXIT_VALUE = 0;
    private Team t;
    private TeamManager tmgr;

    public updateTeam()
    {
        super("Update Team MENU",
                "Update School",
                "Update Captain",
                "Update Mail",
                "Update Group");

        EXIT_OPTION = EXIT_VALUE;
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

        }
    }

    private void updateSchool()
    {
        System.out.println();
        System.out.print("New School Name: ");
        String name = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setSchoolName(name);
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
}
