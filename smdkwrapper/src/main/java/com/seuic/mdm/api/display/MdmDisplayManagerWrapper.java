package com.seuic.mdm.api.display;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;


public class MdmDisplayManagerWrapper {
    private static String CLASS_PATH = "com.seuic.mdm.display.MdmDisplayManager";

    private Object mdmDisplayManager = null;

    public MdmDisplayManagerWrapper(Object mdmDisplayManager){
        this.mdmDisplayManager = mdmDisplayManager;
    }

    public static MdmDisplayManagerWrapper get(Context context){
        MdmDisplayManagerWrapper mdmDisplayManagerWrapper = null;
        Object mdmDisplayManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmDisplayManager == null) return null;
        mdmDisplayManagerWrapper = new MdmDisplayManagerWrapper(mdmDisplayManager);
        return mdmDisplayManagerWrapper;
    }

    /**
     * 是否允许修改休眠延时
     * @param allowed - 允许-true，禁止-false
     * @return SMDKResult.NOT_SUPPORT ,SMDKResult.SUCCESS
     */
    public int allowChangeScreenTimeout(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "allowChangeScreenTimeout", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeScreenTimeoutAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDisplayManager, "isChangeScreenTimeoutAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setScreenTimeout(int timeout) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "setScreenTimeout", new Class[]{int.class}, new Object[]{timeout});
    }

    public int allowChangeAutoRotationSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "allowChangeAutoRotationSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeAutoRotationSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDisplayManager, "isChangeAutoRotationSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int rotationLock(boolean lock) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "rotationLock", new Class[]{boolean.class}, new Object[]{lock});
    }

    public int allowChangeStayAwakeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "allowChangeStayAwakeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeStayAwakeSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDisplayManager, "isChangeStayAwakeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int stayAwakeWhilePlugIn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "stayAwakeWhilePlugIn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowChangeFontScale(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "allowChangeFontScale", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeFontScaleAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDisplayManager, "isChangeFontScaleAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setFontScale(float scale) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "setFontScale", new Class[]{float.class}, new Object[]{scale});
    }

    public int allowDisplayScaleSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "allowDisplayScaleSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isDisplayScaleSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDisplayManager, "isDisplayScaleSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setDisplayScale(int scale) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "setDisplayScale", new Class[]{int.class}, new Object[]{scale});
    }

    public int setDisplayDensity(int density) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDisplayManager, "setDisplayDensity", new Class[]{int.class}, new Object[]{density});
    }
}
