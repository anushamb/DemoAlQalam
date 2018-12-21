package com.frocerie.demoalqalam.service_pack;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.frocerie.demoalqalam.MySingletonLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    //Web Server URL
    public static final String SERVICE_URL = "http://alqalamtrust.com/notification";

    UserSharedPreference userPrefs;

    public static final String ACTION_UPDATE_BROADCAST = MyIntentService.class.getName() + "UpdateBroadcast";

    public static final String ACTION_UPDATE_LOG_BROADCAST = MyIntentService.class.getName() + "UpdateLogBroadcast";

    public static final String ACTION_UPDATE_WEEKLY_BROADCAST = MyIntentService.class.getName() + "UpdateWeeklyBroadcast";

    public static final String ACTION_EXMHUT_UPDATE_BROADCAST = MyIntentService.class.getName() + "UpdateExamHutBroadcast";

    public static final String ACTION_UPDATE_NASHEED = MyIntentService.class.getName() + "UpdateNasheedBroadcast";

    public static final String ACTION_UPDATE_VIDEO_AUDIO = MyIntentService.class.getName() + "UpdateVideoAudio";

    public static final String ACTION_UPDATE_EXAM_TOPPER_TALE = MyIntentService.class.getName() + "UpdateExamTopperTalens";


    public MyIntentService() {
        super("MyIntentService");
    }

    //It will call after the service is triggered by the intent

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {

            if (new InternetDetector(getApplicationContext()).isConnectedToInternet()) {

                StringRequest stringRequest = null;
                // Get a RequestQueue
                RequestQueue queue = MySingletonLog.getInstance(getApplicationContext()).getRequestQueue();
                stringRequest = new StringRequest(Request.Method.POST, SERVICE_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            try {



                                JSONObject resObj = new JSONObject(response);

                                //Changes made in this flow...

                                userPrefs = new UserSharedPreference(getApplicationContext());

                                //Getting FrontPage Activity Values
                                int tValue = userPrefs.getTimeBadgeValue();
                                int gValue = userPrefs.getGalleryBadgeValue();
                                int sValue = userPrefs.getSpeechBadgeValue();

                                //Getting PageLogActivity Badges Values
                                int nValue = userPrefs.getNoticeBadgeValue();
                                //int wValue = userPrefs.getWeeklyBadgeValue();
                                //int eValue = userPrefs.getExamBadgeValue();

                                int mValue = userPrefs.getMatBadgeValue();
                                int trValue = userPrefs.getTranspoBadgeValue();


                           /*     int toValue = userPrefs.getToppersBadgeValue();*/
                                int p_toValue = userPrefs.getPrevToppersBadgeValue();


                                //Updation For weeklyPlan Main module
                                int p_weeklyValue = userPrefs.getPrevWeeklyBadgeValue();

                                //Updation foe Exam Hut badge value
                                int p_eValue = userPrefs.getPrevExamBadgeValue();


                                //Getting WeeklyPlan Badges Values
                                int lkgWeekValue = userPrefs.getWeeklyLkgBadgeVal();
                                int ukgWeekValue = userPrefs.getWeeklyUkgBadgeVal();
                                int firstWeekValue = userPrefs.getWeeklyFirstBadgeVal();
                                int secondWeekValue = userPrefs.getWeeklySecondBadgeVal();
                                int thirdWeekValue = userPrefs.getWeeklyThirdBadgeVal();
                                int fourthWeekValue = userPrefs.getWeeklyFourthBadgeVal();
                                int fifthWeekValue = userPrefs.getWeeklyFifthBadgeVal();
                                int sixthWeekValue = userPrefs.getWeeklySixthBadgeVal();
                                int sevenWeekValue = userPrefs.getWeeklySevenBadgeVal();

                                //Getting ExamHut Portion and Time Table Values
                               /* int exmPortion = userPrefs.getExamHutPortionBadgeVal();*/

                                int p_exmPortion = userPrefs.getPreviousExamHutPortionBadgeVal();


                                /*int exmTimeTable = userPrefs.getExamHutTimeTableBadgeVal();*/
                                int p_exmTimeTable = userPrefs.getPreviousExamHutTimeTableBadgeVal();


                                //Getting Nasheed Badge Value
                                int nasheedVal = userPrefs.getNasheedBadgeVal();
                                //Nasheed Video and Audio Value
                                int videoNasheedVal = userPrefs.getNasheedVideoBadgeVal();
                                int audioNasheedVal = userPrefs.getNasheedAudioBadgeVal();

                                //Getting EXAM_TOPPER and talensday value
                                int topperValue = userPrefs.getExamToppersBadgeVal();
                                int talensValue = userPrefs.getToppersTalensBadgeVal();


//      Code for Response like ->{"details":[{"from":"prayertime","count":2},{"from":"gallery","count":5},{"from":"speechinfo","count":0}]}
                                if (resObj != null) {
                                    JSONArray resArray = resObj.getJSONArray("details");
                                    for (int i = 0; i < resArray.length(); i++) {
                                        JSONObject rObj = resArray.getJSONObject(i);
                                        if (rObj.getString("module").equals("prayertime") || rObj.getString("module").equals("time")) {
                                            tValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("gallery")) {
                                            gValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("speechinfo")) {
                                            sValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("noticeboard")) {
                                            nValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklylesson") && p_weeklyValue != rObj.getInt("count")) {
                                            p_weeklyValue = rObj.getInt("count");
                                            userPrefs.setCurWeeklyBadgeValue(p_weeklyValue);

                                        }
                                       /* else if (rObj.getString("module").equals("weeklylesson")){
                                            wValue = rObj.getInt("count");
                                        }*/
                                        else if (rObj.getString("module").equals("examhut") && p_eValue != rObj.getInt("count")) {
                                            p_eValue = rObj.getInt("count");
                                            userPrefs.setCurExamBadgeValue(p_eValue);
                                        } else if (rObj.getString("module").equals("materials")) {
                                            mValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("toppers") && p_toValue != rObj.getInt("count")) {
                                            p_toValue = rObj.getInt("count");
                                            userPrefs.setCurToppersBadgeValue(p_toValue);
                                        } else if (rObj.getString("module").equals("transport")) {
                                            trValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklylkg")) {
                                            lkgWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklyukg")) {
                                            ukgWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklyfirst")) {
                                            firstWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklysecond")) {
                                            secondWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklythird")) {
                                            thirdWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklyfourth")) {
                                            fourthWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklyfifth")) {
                                            fifthWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklysixth")) {
                                            sixthWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("weeklyseven")) {
                                            sevenWeekValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("examhutportion") && p_exmPortion != rObj.getInt("count")) {
                                            p_exmPortion = rObj.getInt("count");
                                            userPrefs.setCurrentExamHutPortionBadgeVal(p_exmPortion);
                                        } else if (rObj.getString("module").equals("examhuttime")&& p_exmTimeTable != rObj.getInt("count")) {
                                            p_exmTimeTable = rObj.getInt("count");
                                            userPrefs.setCurrentExamHutTimeTableBadgeVal(p_exmTimeTable);
                                        } else if (rObj.getString("module").equals("nasheed")) {
                                            nasheedVal = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("nasheedVideo")) {

                                            videoNasheedVal = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("nasheedAudio")) {
                                            audioNasheedVal = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("examtopper")) {
                                            topperValue = rObj.getInt("count");
                                        } else if (rObj.getString("module").equals("examtalens")) {
                                            talensValue = rObj.getInt("count");
                                        }


                                    }

                                    //FrontPage Activity
                                    userPrefs.setTimeBadgeValue(tValue);
                                    userPrefs.setGalleryBadgeValue(gValue);
                                    userPrefs.setSpeechBadgeValue(sValue);

                                    //PageLogActivity
                                    userPrefs.setNoticeBadgeVal(nValue);
                                    //userPrefs.setWeeklyBadgeVal(wValue);..Bellow
                                    userPrefs.setPrevWeeklyBadgeValue(p_weeklyValue);
                                    userPrefs.setCurWeeklyBadgeValue(p_weeklyValue);

                                   /* userPrefs.setExamBadgeVal(eValue);*/
                                    //Updated Methods for EXam hut.
                                    userPrefs.setPrevExamBadgeValue(p_eValue);
                                    userPrefs.setCurExamBadgeValue(p_eValue);

                                    //Setting Previous and Currrent value For Toppes ImageView
                                    userPrefs.setPrevToppersBadgeValue(p_toValue);
                                    userPrefs.setCurToppersBadgeValue(p_toValue);


                                    userPrefs.setMatBadgeVal(mValue);
                                    userPrefs.setTranspoBadgeVal(trValue);


                                    //WeeklyLessonPlan Activity
                                    userPrefs.setWeeklyLkgBadgeVal(lkgWeekValue);
                                    userPrefs.setWeeklyUkgBadgeVal(ukgWeekValue);
                                    userPrefs.setWeeklyFirstBadgeVal(firstWeekValue);
                                    userPrefs.setWeeklySecondBadgeVal(secondWeekValue);
                                    userPrefs.setWeeklyThirdBadgeVal(thirdWeekValue);
                                    userPrefs.setWeeklyFourthBadgeVal(fourthWeekValue);
                                    userPrefs.setWeeklyFifthBadgeVal(fifthWeekValue);
                                    userPrefs.setWeeklySixthBadgeVal(sixthWeekValue);
                                    userPrefs.setWeeklySevenBadgeVal(sevenWeekValue);

                                    //ExamHut Activity Badges Values
                                   /* userPrefs.setExamHutPortionBadgeVal(exmPortion);*/
                                    userPrefs.setPreviousExamHutPortionBadgeVal(p_exmPortion);
                                    userPrefs.setCurrentExamHutPortionBadgeVal(p_exmPortion);


                                  /*  userPrefs.setExamHutTimeTableBadgeVal(exmTimeTable);*/
                                    userPrefs.setCurrentExamHutTimeTableBadgeVal(p_exmTimeTable);
                                    userPrefs.setCurrentExamHutTimeTableBadgeVal(p_exmTimeTable);



                                    //Materials(Nasheed) Activity
                                    userPrefs.setNasheedBadgeVal(nasheedVal);

                                    //Nasheed Video Audio Actvity.
                                    userPrefs.setNasheedVideoBadgeVal(videoNasheedVal);
                                    userPrefs.setNasheedAudioBadgeVal(audioNasheedVal);


                                    //EXAM TALENSDAY and TOPPERS Activity
                                    userPrefs.setExamToppersBadgeVal(topperValue);
                                    userPrefs.setExamTalensBadgeVal(talensValue);

                                    updateDataUI();
                                }


//      Code for Response like ->  {"details":{"count":1,"module":"speech_info"}}
                        /*        if(resObj != null) {
                                    JSONObject rObj = resObj.getJSONObject("details");
                                    if(rObj.getString("module").equals("speech_info")) {
                                        sValue = rObj.getInt("count");
                                    }
                                    else if(rObj.getString("module").equals("prayertime") || rObj.getString("module").equals("time")) {
                                        tValue = rObj.getInt("count");
                                    }
                                    else if(rObj.getString("module").equals("gallery")) {
                                        gValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("noticeboard")){
                                        nValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("weeklylesson")){
                                        wValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("examhut")){
                                        eValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("materials")){
                                        mValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("toppers")){
                                        toValue = rObj.getInt("count");
                                    }
                                    else if (rObj.getString("module").equals("transport")){
                                        trValue = rObj.getInt("count");
                                    }
                                    userPrefs.setTimeBadgeValue(tValue);
                                    userPrefs.setGalleryBadgeValue(gValue);
                                    userPrefs.setSpeechBadgeValue(sValue);
                                    userPrefs.setNoticeBadgeVal(nValue);
                                    userPrefs.setWeeklyBadgeVal(wValue);
                                    userPrefs.setExamBadgeVal(eValue);
                                    userPrefs.setMatBadgeVal(mValue);
                                    userPrefs.setToppersBadgeVal(toValue);
                                    userPrefs.setTranspoBadgeVal(trValue);
                                    updateDataUI();
                                }*/

                                //----------- Temporary URL Code  --------------------//
                               /* String timeValue = resObj.getString("time");
                                String hourValue = timeValue.substring(0,2);
                                String minuteValue = timeValue.substring(3,5);
                                String secondValue = timeValue.substring(6,8);

                                tValue = Integer.parseInt(hourValue);
                                gValue = Integer.parseInt(minuteValue);
                                sValue = Integer.parseInt(secondValue);

                                userPrefs.setTimeBadgeValue(tValue);
                                userPrefs.setGalleryBadgeValue(gValue);
                                userPrefs.setSpeechBadgeValue(sValue);
                                updateDataUI();*/
                                //----------------------------------------------------//

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        Log.e("Update Service: ", "Success");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String strError = "";
                        if (error instanceof ServerError) {
                            strError = "Server Error.";
                        } else {
                            strError = "Other error.";
                        }
                        Log.e("Update Service: ", strError);
                    }
                });


                //using the below line we have change RetryPolicy of volley.

                stringRequest.setRetryPolicy(new DefaultRetryPolicy(3 * 1000, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                MySingletonLog.getInstance(getApplicationContext()).addToRequestQueue(stringRequest, MySingletonLog.TAG);
            }
        }
    }


    public void updateDataUI() {

        if (userPrefs.getCurrentActivity().equals("FRONT_PAGE")) {

            Intent intent = new Intent(ACTION_UPDATE_BROADCAST);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

        } else if (userPrefs.getCurrentActivity().equals("PAGE_LOG")) {
            Intent intent = new Intent(ACTION_UPDATE_LOG_BROADCAST);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

        } else if (userPrefs.getCurrentActivity().equals("WEEKLY_LESSON_PLAN")) {
            Intent intent = new Intent(ACTION_UPDATE_WEEKLY_BROADCAST);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } else if (userPrefs.getCurrentActivity().equals("EXM_HUT")) {
            Intent intent = new Intent(ACTION_EXMHUT_UPDATE_BROADCAST);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } else if (userPrefs.getCurrentActivity().equals("MATERIALS")) {
            Intent intent = new Intent(ACTION_UPDATE_NASHEED);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } else if (userPrefs.getCurrentActivity().equals("VIDEO_AUDIO")) {

            Intent intent = new Intent(ACTION_UPDATE_VIDEO_AUDIO);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

        } else if (userPrefs.getCurrentActivity().equals("TOPPERS_TALENS")) {
            Intent intent = new Intent(ACTION_UPDATE_EXAM_TOPPER_TALE);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } else {
            return;
        }


    }


}
