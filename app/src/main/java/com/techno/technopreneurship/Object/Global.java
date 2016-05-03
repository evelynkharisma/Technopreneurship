package com.techno.technopreneurship.Object;

import java.util.ArrayList;

/**
 * Created by User on 4/1/2016.
 */
public class Global {
    public static String currentUsername;
    public static String currentName;
    public static String currentCategory;
    public static String currentPage;

    public static User currentUser;
    public static FamilyMember currentMainFamilyMember;
    public static HealthDetails currentMainHealthDetail;
    public static Blood_Count currentMainBloodCount;

    public static ArrayList<FamilyMember> currentFamily = new ArrayList<>();
    public static ArrayList<Allergy> currentAllergies = new ArrayList<>();
    public static ArrayList<Blood_Count> currentBloodCount = new ArrayList<>();
    public static ArrayList<Blood_Tension> currentBloodTension = new ArrayList<>();
    public static ArrayList<Cholesterol> currentCholesterol = new ArrayList<>();
    public static ArrayList<Diabetes> currentDiabetes = new ArrayList<>();
    public static ArrayList<HeartRate> currentHeartRate = new ArrayList<>();
    public static ArrayList<UricAcid> currentUricAcid = new ArrayList<>();
    public static ArrayList<UrineTest> currentUrineTest = new ArrayList<>();
    public static ArrayList<Vaccine> currentVaccine = new ArrayList<>();
    public static ArrayList<Reward> currentReward = new ArrayList<>();
    public static ArrayList<Integer> promotions = new ArrayList<>();

    public static ArrayList<User> users =  new ArrayList<>();
    public static ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    public static ArrayList<HealthDetails> healthDetailses = new ArrayList<>();
    public static ArrayList<Allergy> allergies = new ArrayList<>();
    public static ArrayList<Blood_Count> bloodCounts = new ArrayList<>();
    public static ArrayList<Blood_Tension> bloodTensions = new ArrayList<>();
    public static ArrayList<Cholesterol> cholesterols = new ArrayList<>();
    public static ArrayList<Diabetes> diabeteses = new ArrayList<>();
    public static ArrayList<HeartRate> heartRates = new ArrayList<>();
    public static ArrayList<UricAcid> uricAcids = new ArrayList<>();
    public static ArrayList<UrineTest> urineTests = new ArrayList<>();
    public static ArrayList<Vaccine> vaccines = new ArrayList<>();
    public static ArrayList<Reward> rewards = new ArrayList<>();
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Hospital> hospitals = new ArrayList<>();


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

    public static void setMainBloodCount(String username, String name) {
        for (Blood_Count bloodCount : Global.bloodCounts) {
            if (bloodCount.getUsername().equalsIgnoreCase(username) && bloodCount.getName().equalsIgnoreCase(Global.currentMainFamilyMember.getName())) {
                Global.currentMainBloodCount = bloodCount;
                break;
            }
        }
    }

    /**
     * Set the health details of current main user having username <i>username</i> and name <i>name</i>
     * @param username username of current family
     * @param name name of current main family
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
    public static void updateCurrentFamilyMember() {
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
    public static void updateCurrentAllergy() {
        Global.currentAllergies.clear();
        for (Allergy allergy : Global.allergies) {
            if (allergy.getUser().equalsIgnoreCase(Global.currentUsername) && allergy.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentAllergies.add(allergy);
            }
        }
    }

    public static void updateCurrentBloodCount() {
        Global.currentBloodCount.clear();
        for (Blood_Count bloodcount: Global.bloodCounts) {
            if (bloodcount.getUsername().equalsIgnoreCase(Global.currentUsername) && bloodcount.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentBloodCount.add(bloodcount);
            }
        }
    }

    public static void updateCurrentBloodTension() {
        Global.currentBloodTension.clear();
        for (Blood_Tension bloodTension : Global.bloodTensions) {
            if (bloodTension.getUser().equalsIgnoreCase(Global.currentUsername) && bloodTension.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentBloodTension.add(bloodTension);
            }
        }
    }

    public static void updateCurrentCholesterol() {
        Global.currentCholesterol.clear();
        for (Cholesterol cholesterol : Global.cholesterols) {
            if (cholesterol.getUser().equalsIgnoreCase(Global.currentUsername) && cholesterol.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentCholesterol.add(cholesterol);
            }
        }
    }

    public static void updateCurrentDiabetes() {
        Global.currentDiabetes.clear();
        for (Diabetes diabetes: Global.diabeteses) {
            if (diabetes.getUser().equalsIgnoreCase(Global.currentUsername) && diabetes.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentDiabetes.add(diabetes);
            }
        }
    }

    public static void updateCurrentHeartRate() {
        Global.currentHeartRate.clear();
        for (HeartRate heartRate : Global.heartRates) {
            if (heartRate.getUser().equalsIgnoreCase(Global.currentUsername) && heartRate.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentHeartRate.add(heartRate);
            }
        }
    }

    public static void updateCurrentUricAcid() {
        Global.currentUricAcid.clear();
        for (UricAcid uricAcid : Global.uricAcids) {
            if (uricAcid.getUser().equalsIgnoreCase(Global.currentUsername) && uricAcid.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentUricAcid.add(uricAcid);
            }
        }
    }

    public static void updateCurrentUrineTest() {
        Global.currentUrineTest.clear();
        for (UrineTest urinTest : Global.urineTests) {
            if (urinTest.getUser().equalsIgnoreCase(Global.currentUsername) && urinTest.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentUrineTest.add(urinTest);
            }
        }
    }

    public static void updateCurrentVaccine() {
        Global.currentVaccine.clear();
        for (Vaccine vaccine : Global.vaccines) {
            if (vaccine.getUser().equalsIgnoreCase(Global.currentUsername) && vaccine.getName().equalsIgnoreCase(Global.currentName)) {
                Global.currentVaccine.add(vaccine);
            }
        }
    }

    public static void updateCurrentReward() {
        Global.currentReward.clear();
        for (Reward reward : Global.rewards) {
            if (reward.getUsername().equalsIgnoreCase(Global.currentUsername)) {
                Global.currentReward.add(reward);
            }
        }
    }
}