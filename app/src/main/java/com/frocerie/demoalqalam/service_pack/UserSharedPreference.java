package com.frocerie.demoalqalam.service_pack;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by avocet on 12/09/17.
 */

public class UserSharedPreference {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //Make preference name unique like => packagename.userprefs
    public static final String MyPrefs = "frocerie.userprefs";
    public static final String CUR_ACTIVITY = "currentActivity";

    //FrontPage Activity Variables
    public static final String PT_BADGE_VAL = "timeBadgeValue";
    public static final String GAL_BADGE_VAL = "galleryBadgeValue";
    public static final String SP_BADGE_VAL = "speechBadgeValue";


    //PageLogActivity(SecondActivity) Variables
    public static final String NOTICE_BADGE_VAL = "noticeBadgeValue";

    /*public static final String WEEKLY_BADGE_VAL = "weeklyBadgeValue";*/

    public static final String P_WEEKLY_BADGE_VAL = "previousWeeklyBadgeValue";
    public static final String C_WEEKLY_BADGE_VAL = "currentWeeklyBadgeValue";


    /*public static final String EXAM_BADGE_VAL = "examBadgeValue";*/

    //Changes made for the exam imageView to set badge value
    public static final String P_EXAM_BADGE_VAL = "previousExamBadgeValue";
    public static final String C_EXAM_BADGE_VAL = "currentExamBadgeValue";


    public static final String MAT_BADGE_VAL = "matBadgeValue";
    public static final String TRANSPO_BADGE_VAL = "transpoBadgeValue";


    /*  public static final String TOPPERS_BADGE_VAL = "toppersBadgeValue";*/
    public static final String P_TOPPERS_BADGE_VAL = "previousToppersBadgeValue";
    public static final String C_TOPPERS_BADGE_VAL = "currentToppersBadgeValue";


    //WeeklyLessonPlan Activity Variables
    public static final String WEEKLY_LKG_BADGE_VAL = "weeklyLkgBadgeValue";
    public static final String WEEKLY_UKG_BADGE_VAL = "weeklyUkgBadgeValue";
    public static final String WEEKLY_FIRST_BADGE_VAL = "weeklyFirstBadgeValue";
    public static final String WEEKLY_SECOND_BADGE_VAL = "weeklySecondBadgeValue";
    public static final String WEEKLY_THIRD_BADGE_VAL = "weeklyThirdBadgeValue";
    public static final String WEEKLY_FOURTH_BADGE_VAL = "weeklyFourthBadgeValue";
    public static final String WEEKLY_FIFTH_BADGE_VAL = "weeklyFifthBadgeValue";
    public static final String WEEKLY_SIXTH_BADGE_VAL = "weeklySixthBadgeValue";
    public static final String WEEKLY_SEVENTH_BADGE_VAL = "weeklySeventhBadgeValue";


    //EXAM HUT PORTION Activity Variables
    public static final String EXAM_PORTION_LKG_BADGE_VAL = "portionLkgBadgeValue";
    public static final String EXAM_PORTION_UKG_BADGE_VAL = "portionUkgBadgeValue";
    public static final String EXAM_PORTION_FIRST_BADGE_VAL = "portionFirstBadgeValue";
    public static final String EXAM_PORTION_SECOND_BADGE_VAL = "portionSecondBadgeValue";
    public static final String EXAM_PORTION_THIRD_BADGE_VAL = "portionThirdBadgeValue";
    public static final String EXAM_PORTION_FOURTH_BADGE_VAL = "portionFourthBadgeValue";
    public static final String EXAM_PORTION_FIFTH_BADGE_VAL = "portionFifthBadgeValue";
    public static final String EXAM_PORTION_SIXTH_BADGE_VAL = "portionSixthBadgeValue";
    public static final String EXAM_PORTION_SEVENTH_BADGE_VAL = "portionSeventhBadgeValue";
    public static final String EXAM_PORTION_TAJWEED_BADGE_VAL = "portionTajweedBadgeValue";
    public static final String EXAM_PORTION_HIFD_BADGE_VAL = "portionHifdBadgeValue";



   //EXAM HUT TIME TABLE Variables
    public static final String EXAM_TIME_TABLE_LKG_BADGE_VAL = "timeTableLkgBadgeValue";
    public static final String EXAM_TIME_TABLE_UKG_BADGE_VAL = "timeTableUkgBadgeValue";
    public static final String EXAM_TIME_TABLE_FIRST_BADGE_VAL = "timeTableFirstBadgeValue";
    public static final String EXAM_TIME_TABLE_SECOND_BADGE_VAL = "timeTableSecondBadgeValue";
    public static final String EXAM_TIME_TABLE_THIRD_BADGE_VAL = "timeTableThirdBadgeValue";
    public static final String EXAM_TIME_TABLE_FOURTH_BADGE_VAL = "timeTableFourthBadgeValue";
    public static final String EXAM_TIME_TABLE_FIFTH_BADGE_VAL = "timeTableFifthBadgeValue";
    public static final String EXAM_TIME_TABLE_SIXTH_BADGE_VAL = "timeTableSixthBadgeValue";
    public static final String EXAM_TIME_TABLE_SEVENTH_BADGE_VAL = "timeTableSeventhBadgeValue";
    public static final String EXAM_TIME_TABLE_TAJWEED_BADGE_VAL = "timeTableTajweedBadgeValue";
    public static final String EXAM_TIME_TABLE_HIFD_BADGE_VAL = "timeTableHifdBadgeValue";






    //ExamHut Activity Variables
    /*public static final String EXAM_HUT_PORTION_BADGE_VAL = "examPortionBadgeValue";*/
   /* public static final String EXAM_HUT_TIME_BADGE_VAL = "examTimeTableBadgeValue";*/

    //Time Table Previous and Current Value Variable
    public static final String P_EXAM_HUT_TIME_BADGE_VAL = "previousExamTimeTableBadgeValue";
    public static final String C_EXAM_HUT_TIME_BADGE_VAL = "currentExamTimeTableBadgeValue";


    //Portion Previous and Current value variable.
    public static final String P_EXAM_HUT_PORTION_BADGE_VAL = "previousExamPortionBadgeValue";
    public static final String C_EXAM_HUT_PORTION_BADGE_VAL = "currentExamPortionBadgeValue";


    //Materials(Nasheed) Variable And It's Sub Module Activity Values
    public static final String NASHEED_BADGE_VAL = "nasheedBadgeVal";
    public static final String NASHEED_VIDEO_BADGE_VAL = "nasgeedVideoBadgeVal";
    public static final String NASHEED_AUDIO_BADGE_VAL = "nasheedAudioBadgeVal";


    //ToppersNewActivity Variables
    public static final String EXAM_TOPPERS_BADGE_VAL = "examToppersBadgeVal";
    public static final String EXAM_TALENS_BADGE_VAL = "examTalenBadgeVal";


    public UserSharedPreference(Context ct) {
        context = ct;
        sharedPreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //Setter fo Time
    public void setTimeBadgeValue(int tValue) {
        editor.putInt(PT_BADGE_VAL, tValue);
        saveChanges();
    }

    //getter for Time
    public int getTimeBadgeValue() {
        return sharedPreferences.getInt(PT_BADGE_VAL, 0);
    }

//Setter for gallery

    public void setGalleryBadgeValue(int gValue) {
        editor.putInt(GAL_BADGE_VAL, gValue);
        saveChanges();
    }

    //Getter for gallery
    public int getGalleryBadgeValue() {
        return sharedPreferences.getInt(GAL_BADGE_VAL, 0);
    }

    //setter for SpeechInfo
    public void setSpeechBadgeValue(int sValue) {
        editor.putInt(SP_BADGE_VAL, sValue);
        saveChanges();
    }

    //getter for SpeechInfo
    public int getSpeechBadgeValue() {
        return sharedPreferences.getInt(SP_BADGE_VAL, 0);
    }

    //setteing current activity
    public void setCurrentActivity(String activityName) {
        editor.putString(CUR_ACTIVITY, activityName);
        saveChanges();
    }

    //setting noticeboard value
    public void setNoticeBadgeVal(int nValue) {
        editor.putInt(NOTICE_BADGE_VAL, nValue);
        saveChanges();
    }

    //getting notice board value
    public int getNoticeBadgeValue() {

        return sharedPreferences.getInt(NOTICE_BADGE_VAL, 0);
    }


 /*   //setting weekly lesson plan value
    public void setWeeklyBadgeVal(int wValue) {
        editor.putInt(WEEKLY_BADGE_VAL, wValue);
        saveChanges();
    }*/
/*
    //getting weekly lesson plan value
    public int getWeeklyBadgeValue() {
        return sharedPreferences.getInt(WEEKLY_BADGE_VAL, 0);
    }*/


  /*  //setting exam hut value
    public void setExamBadgeVal(int eValue) {
        editor.putInt(EXAM_BADGE_VAL, eValue);
        saveChanges();
    }*/

  /*  //getting exam hut value....
    public int getExamBadgeValue() {
        return sharedPreferences.getInt(EXAM_BADGE_VAL, 0);
    }*/


    //Changes made for ExamHut Current and Previos setters and getters values.....

    public void setPrevExamBadgeValue(int eValue) {
        editor.putInt(P_EXAM_BADGE_VAL, eValue);
        saveChanges();
    }

    public int getPrevExamBadgeValue() {
        return sharedPreferences.getInt(P_EXAM_BADGE_VAL, 0);
    }

    public void setCurExamBadgeValue(int eValue) {
        editor.putInt(C_EXAM_BADGE_VAL, eValue);
        saveChanges();
    }

    public int getCurExamBadgeValue() {
        return sharedPreferences.getInt(C_EXAM_BADGE_VAL, 0);
    }


    //setting materials value
    public void setMatBadgeVal(int mValue) {
        editor.putInt(MAT_BADGE_VAL, mValue);
        saveChanges();
    }

    //getting materials badge value
    public int getMatBadgeValue() {
        return sharedPreferences.getInt(MAT_BADGE_VAL, 0);
    }

/*
    //setting toppers value
    public void setToppersBadgeVal(int toValue) {
        editor.putInt(TOPPERS_BADGE_VAL, toValue);
        saveChanges();
    }

    //getting toppers value
    public int getToppersBadgeValue() {
        return sharedPreferences.getInt(TOPPERS_BADGE_VAL, 0);
    }*/

    //Updating Toppers Image view Badges value
    public void setPrevToppersBadgeValue(int p_toValue) {
        editor.putInt(P_TOPPERS_BADGE_VAL, p_toValue);
        saveChanges();
    }

    public int getPrevToppersBadgeValue() {
        return sharedPreferences.getInt(P_TOPPERS_BADGE_VAL, 0);
    }

    public void setCurToppersBadgeValue(int p_toValue) {
        editor.putInt(C_TOPPERS_BADGE_VAL, p_toValue);
        saveChanges();
    }

    public int getCurToppersBadgeValue() {
        return sharedPreferences.getInt(C_TOPPERS_BADGE_VAL, 0);
    }

    //setting transport value

    public void setTranspoBadgeVal(int trValue) {
        editor.putInt(TRANSPO_BADGE_VAL, trValue);
        saveChanges();
    }


    //getting transport value
    public int getTranspoBadgeValue() {
        return sharedPreferences.getInt(TRANSPO_BADGE_VAL, 0);
    }


    //setting weeklyPlan LKG value
    public void setWeeklyLkgBadgeVal(int lkgWeekValue) {
        editor.putInt(WEEKLY_LKG_BADGE_VAL, lkgWeekValue);
        saveChanges();
    }

    public int getWeeklyLkgBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_LKG_BADGE_VAL, 0);
    }


    //setting weeklyPlan UKG value
    public void setWeeklyUkgBadgeVal(int ukgWeekValue) {
        editor.putInt(WEEKLY_UKG_BADGE_VAL, ukgWeekValue);
        saveChanges();
    }

    public int getWeeklyUkgBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_UKG_BADGE_VAL, 0);
    }


    //setting weeklyPlan First value
    public void setWeeklyFirstBadgeVal(int firstWeekValue) {
        editor.putInt(WEEKLY_FIRST_BADGE_VAL, firstWeekValue);
        saveChanges();
    }


    public int getWeeklyFirstBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FIRST_BADGE_VAL, 0);
    }


    //setting weeklyPlan second value
    public void setWeeklySecondBadgeVal(int secondWeekValue) {
        editor.putInt(WEEKLY_SECOND_BADGE_VAL, secondWeekValue);
        saveChanges();
    }

    public int getWeeklySecondBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SECOND_BADGE_VAL, 0);
    }


    //setting weeklyPlan Third value
    public void setWeeklyThirdBadgeVal(int thirdWeekValue) {
        editor.putInt(WEEKLY_THIRD_BADGE_VAL, thirdWeekValue);
        saveChanges();
    }

    public int getWeeklyThirdBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_THIRD_BADGE_VAL, 0);
    }

    //setting weeklyPlan Fourth value
    public void setWeeklyFourthBadgeVal(int fourthWeekValue) {
        editor.putInt(WEEKLY_FOURTH_BADGE_VAL, fourthWeekValue);
        saveChanges();
    }

    public int getWeeklyFourthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FOURTH_BADGE_VAL, 0);
    }


    //setting weeklyPlan FIFTH value
    public void setWeeklyFifthBadgeVal(int fifthWeekValue) {
        editor.putInt(WEEKLY_FIFTH_BADGE_VAL, fifthWeekValue);
        saveChanges();
    }

    public int getWeeklyFifthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FIFTH_BADGE_VAL, 0);
    }

    //setting weeklyPlan SIXTH value
    public void setWeeklySixthBadgeVal(int sixthWeekValue) {
        editor.putInt(WEEKLY_SIXTH_BADGE_VAL, sixthWeekValue);
        saveChanges();
    }

    public int getWeeklySixthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SIXTH_BADGE_VAL, 0);
    }

    //setting weeklyPlan SEVENTH value
    public void setWeeklySevenBadgeVal(int sevenWeekValue) {
        editor.putInt(WEEKLY_SEVENTH_BADGE_VAL, sevenWeekValue);
        saveChanges();
    }

    public int getWeeklySevenBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SEVENTH_BADGE_VAL, 0);
    }


    //Set and Get Value of Exam Hut Portion
    public void setPreviousExamHutPortionBadgeVal(int exmPortion) {
        editor.putInt(P_EXAM_HUT_PORTION_BADGE_VAL, exmPortion);
        saveChanges();
    }

    public int getPreviousExamHutPortionBadgeVal() {
        return sharedPreferences.getInt(P_EXAM_HUT_PORTION_BADGE_VAL, 0);
    }

    //Set and Get Value of Exam Hut Portion
    public void setCurrentExamHutPortionBadgeVal(int exmPortion) {
        editor.putInt(C_EXAM_HUT_PORTION_BADGE_VAL, exmPortion);
        saveChanges();
    }

    public int getCurrentExamHutPortionBadgeVal() {
        return sharedPreferences.getInt(C_EXAM_HUT_PORTION_BADGE_VAL, 0);
    }

    //Set and Get Value of Exam Time Table
    public void setPreviousExamHutTimeTableBadgeVal(int exmTimeTable) {
        editor.putInt(P_EXAM_HUT_TIME_BADGE_VAL, exmTimeTable);
        saveChanges();

    }

    public int getPreviousExamHutTimeTableBadgeVal() {
        return sharedPreferences.getInt(C_EXAM_HUT_TIME_BADGE_VAL, 0);
    }

    public void setCurrentExamHutTimeTableBadgeVal(int exmTimeTable) {
        editor.putInt(P_EXAM_HUT_TIME_BADGE_VAL, exmTimeTable);
        saveChanges();

    }

    public int getCurrentExamHutTimeTableBadgeVal() {
        return sharedPreferences.getInt(C_EXAM_HUT_TIME_BADGE_VAL, 0);
    }


    //Setter and getter value of Nasheed
    public void setNasheedBadgeVal(int nasheedVal) {
        editor.putInt(NASHEED_BADGE_VAL, nasheedVal);
        saveChanges();
    }

    public int getNasheedBadgeVal() {
        return sharedPreferences.getInt(NASHEED_BADGE_VAL, 0);
    }

    // Setter and Getter Value for Video
    public void setNasheedVideoBadgeVal(int videoNasheedVal) {
        editor.putInt(NASHEED_VIDEO_BADGE_VAL, 0);
        saveChanges();
    }

    public int getNasheedVideoBadgeVal() {
        return sharedPreferences.getInt(NASHEED_VIDEO_BADGE_VAL, 0);
    }

    //Setter and Getter Value for Audio
    public void setNasheedAudioBadgeVal(int audioNasheedVal) {
        editor.putInt(NASHEED_AUDIO_BADGE_VAL, 0);
        saveChanges();
    }

    public int getNasheedAudioBadgeVal() {
        return sharedPreferences.getInt(NASHEED_AUDIO_BADGE_VAL, 0);
    }

    //Setter fo Time (Main previous)
    public void setPrevWeeklyBadgeValue(int weeklyValue) {
        editor.putInt(P_WEEKLY_BADGE_VAL, weeklyValue);
        saveChanges();
    }

    //getter for Time (Main previous)
    public int getPrevWeeklyBadgeValue() {
        return sharedPreferences.getInt(P_WEEKLY_BADGE_VAL, 0);
    }

    //Setter fo Time (Current after click)
    public void setCurWeeklyBadgeValue(int weeklyValue) {
        editor.putInt(C_WEEKLY_BADGE_VAL, weeklyValue);
        saveChanges();
    }

    //getter for Time (Current after click)
    public int getCurWeeklyBadgeValue() {
        return sharedPreferences.getInt(C_WEEKLY_BADGE_VAL, 0);
    }


    //Setters and getters value for ExamToppers
    public void setExamToppersBadgeVal(int topperValue) {
        editor.putInt(EXAM_TOPPERS_BADGE_VAL, topperValue);
        saveChanges();
    }

    public int getExamToppersBadgeVal() {
        return sharedPreferences.getInt(EXAM_TOPPERS_BADGE_VAL, 0);
    }

    //Setters and Getters Value for ExamTalens
    public void setExamTalensBadgeVal(int talensValue) {
        editor.putInt(EXAM_TALENS_BADGE_VAL, talensValue);
        saveChanges();
    }

    public int getToppersTalensBadgeVal() {
        return sharedPreferences.getInt(EXAM_TALENS_BADGE_VAL, 0);
    }


    //.......................EXAM HUT PORTION CLASSES SETTER AND GETTER VALUES...................
    //setting weeklyPlan LKG value
  public void setExamPortionLkgBadgeVal(int lkgWeekValue) {
        editor.putInt(WEEKLY_LKG_BADGE_VAL, lkgWeekValue);
        saveChanges();
    }

    public int getExamPortionLkgBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_LKG_BADGE_VAL, 0);
    }


    //setting weeklyPlan UKG value
    public void setExamPortionUkgBadgeVal(int ukgWeekValue) {
        editor.putInt(WEEKLY_UKG_BADGE_VAL, ukgWeekValue);
        saveChanges();
    }

    public int getExamPortionUkgBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_UKG_BADGE_VAL, 0);
    }


    //setting weeklyPlan First value
    public void setExamPortionFirstBadgeVal(int firstWeekValue) {
        editor.putInt(WEEKLY_FIRST_BADGE_VAL, firstWeekValue);
        saveChanges();
    }


    public int getExamPortionFirstBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FIRST_BADGE_VAL, 0);
    }


    //setting weeklyPlan second value
    public void setExamPortionSecondBadgeVal(int secondWeekValue) {
        editor.putInt(WEEKLY_SECOND_BADGE_VAL, secondWeekValue);
        saveChanges();
    }

    public int getExamPortionSecondBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SECOND_BADGE_VAL, 0);
    }


    //setting weeklyPlan Third value
    public void setExamPortionThirdBadgeVal(int thirdWeekValue) {
        editor.putInt(WEEKLY_THIRD_BADGE_VAL, thirdWeekValue);
        saveChanges();
    }

    public int getExamPortionThirdBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_THIRD_BADGE_VAL, 0);
    }

    //setting weeklyPlan Fourth value
    public void setExamPortionFourthBadgeVal(int fourthWeekValue) {
        editor.putInt(WEEKLY_FOURTH_BADGE_VAL, fourthWeekValue);
        saveChanges();
    }

    public int getExamPortionFourthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FOURTH_BADGE_VAL, 0);
    }


    //setting weeklyPlan FIFTH value
    public void setExamPortionFifthBadgeVal(int fifthWeekValue) {
        editor.putInt(WEEKLY_FIFTH_BADGE_VAL, fifthWeekValue);
        saveChanges();
    }

    public int getExamPortionFifthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_FIFTH_BADGE_VAL, 0);
    }

    //setting weeklyPlan SIXTH value
    public void setExamPortionSixthBadgeVal(int sixthWeekValue) {
        editor.putInt(WEEKLY_SIXTH_BADGE_VAL, sixthWeekValue);
        saveChanges();
    }

    public int getExamPortionSixthBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SIXTH_BADGE_VAL, 0);
    }

    //setting weeklyPlan SEVENTH value
    public void setExamPortionSevenBadgeVal(int sevenWeekValue) {
        editor.putInt(WEEKLY_SEVENTH_BADGE_VAL, sevenWeekValue);
        saveChanges();
    }

    public int getExamPortionSevenBadgeVal() {
        return sharedPreferences.getInt(WEEKLY_SEVENTH_BADGE_VAL, 0);
    }








    //.............................Getter method for getting current activity
    public String getCurrentActivity() {
        return sharedPreferences.getString(CUR_ACTIVITY, "");
    }

    private void saveChanges() {
        editor.commit();
        editor.apply();
    }
}
