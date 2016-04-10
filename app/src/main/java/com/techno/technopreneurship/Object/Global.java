package com.techno.technopreneurship.Object;

import java.util.ArrayList;

/**
 * Created by User on 4/1/2016.
 */
public class Global {
    public static String currentUsername;
    public static String currentName;

    public static FamilyMember currentMainFamilyMember;
    public static HealthDetails currentMainHealthDetail;

    public static ArrayList<FamilyMember> currentFamily = new ArrayList<>();
    public static ArrayList<Allergy> currentAllergies = new ArrayList<>();

    public static ArrayList<User> users =  new ArrayList<>();
    public static ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    public static ArrayList<HealthDetails> healthDetailses = new ArrayList<>();
    public static ArrayList<Allergy> allergies = new ArrayList<>();


    /**
     * Set the main user of family having username <i>username</i>
     * @param username username of current family
     */
    public static void setMainFamilyMember(String username) {
        for (FamilyMember famMember : Global.familyMembers) {
            if (famMember.getUsername().equalsIgnoreCase(username) && famMember.getStatus().equalsIgnoreCase("main")) {
                Global.currentMainFamilyMember = famMember;
                break;
            }
        }
    }

    /**
     * Set the health details of current main user
     * @param username username of current family
     */
    public static void setMainHealthDetail(String username, String name){
        for (HealthDetails healthDetails : Global.healthDetailses) {
            if (healthDetails.getUsername().equalsIgnoreCase(username) && healthDetails.getName().equalsIgnoreCase(Global.currentMainFamilyMember.getName())) {
                Global.currentMainHealthDetail = healthDetails;
                break;
            }
        }
    }

    /**
     * List of family member having username <i>Global.users</i>
     */
    public static void setCurrentFamilyMember() {
        Global.currentFamily.clear();
        for (FamilyMember famMember : Global.familyMembers) {
            if (famMember.getUsername().equalsIgnoreCase(Global.currentUsername)) {
                Global.currentFamily.add(famMember);
            }
        }
    }

    /**
     * List of current user's allergies
     */
    public static void setCurrentAllergy() {
        Global.currentAllergies.clear();
        for (Allergy allergy : Global.allergies) {
            if (allergy.getUser().equalsIgnoreCase(Global.currentUsername) && allergy.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentAllergies.add(allergy);
            }
        }
    }
}
