package com.example.administrator.androidpractice;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoginTest {
    public Instrumentation instrumentation;
    public UiDevice uiDevice;
    public Context context;
    @Before
    public void setup(){
        instrumentation=InstrumentationRegistry.getInstrumentation();
        uiDevice=UiDevice.getInstance(instrumentation);
        context=instrumentation.getContext();
        Intent intent=context.getPackageManager().getLaunchIntentForPackage("com.example.administrator.androidpractice");
        context.startActivity(intent);
    }
    @Test
    public void testA() throws InterruptedException {
       uiDevice.findObject(By.res("com.example.administrator.androidpractice:id/account")).setText("admin");
       uiDevice.findObject(By.res("com.example.administrator.androidpractice:id/password")).setText("admin");
       uiDevice.findObject(By.res("com.example.administrator.androidpractice:id/login_button")).click();
       Thread.sleep(1000);
        Assert.assertEquals("欢迎登录成功！",uiDevice.findObject(By.res("com.example.administrator.androidpractice:id/textView")).getText());
        }
        @After
    public void teardown()  {
        uiDevice.pressHome();
        }
    }



