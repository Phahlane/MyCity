package com.entersekt.mycity.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class Utils {

    /**
     * Checks for Network & Internet Connectivity
     *
     * @param mContext current context
     * @return true if internet available
     */

    public static final Locale LOCALE;

    static {
        LOCALE = Locale.US;
    }

    public boolean isNetworkAvailable(Context mContext) {
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = null;
            if (cm != null) {
                activeNetwork = cm.getActiveNetworkInfo();
            }
            return activeNetwork != null && activeNetwork.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





    public static void showDialog(final Context aContext, String aTitle, String aMessage) {
        new AlertDialog.Builder(aContext)
                .setTitle(aTitle)
                .setMessage(aMessage)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
