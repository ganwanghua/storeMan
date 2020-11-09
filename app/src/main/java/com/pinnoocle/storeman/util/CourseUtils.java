package com.pinnoocle.storeman.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import com.pinnoocle.storeman.MyApp;

import java.util.List;

/**
 * Created by zhanghai on 2018/7/10.
 */

public class CourseUtils {

    public static boolean resultProcess(String pid) {
        String processName = getProcessName(MyApp.getInstanse(), android.os.Process.myPid());
        return (!TextUtils.isEmpty(processName) && pid.equals(processName));

    }

    private static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }
}
