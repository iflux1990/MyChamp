/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Team;
import BLL.TeamManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * The update Menu
 * @author Daniel, Marco, Mak & Jonas
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
                "Update Mail");

        EXIT_OPTION = EXIT_VALUE;
        t = team;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                updateSchool();     //update school
                break;
            case 2:
                updateCaptain();    //Update Captain   
                break;
            case 3:
                updateMail();       //Update Email
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void updateSchool()     //Update school name
    {
        System.out.println();
        System.out.print("New School Name: ");
        String SchoolName = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setSchoolName(SchoolName);
    }

    private void updateCaptain()    //update Captain name
    {
        System.out.println();
        System.out.print("New Captain: ");
        String captain = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setCaptain(captain);
    }

    private void updateMail()       //Update Email
    {
        System.out.println();
        System.out.print("New E-Mail Adress: ");
        String email = new Scanner(System.in, "ISO-8859-1").nextLine();
        t.setTeamEmail(email);
    }



    private void saveChanges()  //Saves the chages
    {
        try
        {
            TeamManager tmgr = new TeamManager();
            tmgr.updateTeam(t);

        }
        catch (SQLException | IOException e)
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
