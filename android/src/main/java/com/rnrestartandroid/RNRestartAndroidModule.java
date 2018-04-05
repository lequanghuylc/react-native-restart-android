package com.rnrestartandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.app.Activity;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import static java.security.AccessController.getContext;

public class RNRestartAndroidModule extends ReactContextBaseJavaModule {
  
  private ReactContext mContext;

  public RNRestartAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRestartAndroid";
  }

  @ReactMethod
  public void restart() {
    _restart();
  }
  private void _restart() {
    Intent mStartActivity = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
    int mPendingIntentId = 123456;
    PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
    AlarmManager mgr = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
    mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
    System.exit(0);
  }
}
