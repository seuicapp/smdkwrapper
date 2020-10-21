package com.seuic.mdm.api.datetime;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

public class MdmDateTimeManagerWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.datetime.MdmDateTimeManager";
    private Object mdmDateTimeManager = null;

    private MdmDateTimeManagerWrapper(Object mdmDateTimeManager) {
        this.mdmDateTimeManager = mdmDateTimeManager;
    }

    public static MdmDateTimeManagerWrapper get(Context context) {
        MdmDateTimeManagerWrapper mdmDateTimeManagerWrapper = null;
        Object mdmDateTimeManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmDateTimeManager == null) return null;
        mdmDateTimeManagerWrapper = new MdmDateTimeManagerWrapper(mdmDateTimeManager);
        return mdmDateTimeManagerWrapper;
    }

    public int allowAutoTimeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "allowAutoTimeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isAutoTimeSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "isAutoTimeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setAutoTimeOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "setAutoTimeOn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowAutoTimeZoneSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "allowAutoTimeZoneSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }
    /**
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isAutoTimeZoneSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "isAutoTimeZoneSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);

    }

    public int setAutoTimeZoneOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "setAutoTimeZoneOn", new Class[]{boolean.class}, new Object[]{on});

    }

    public int allowSelectTimeZone(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "allowSelectTimeZone", new Class[]{boolean.class}, new Object[]{allowed});
    }
    /**
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isSelectTimeZoneAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "isSelectTimeZoneAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);

    }

    public int setRegionZone(String tzId) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "setRegionZone", new Class[]{String.class}, new Object[]{tzId});
    }

    public int allowNtpServerSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "allowNtpServerSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }
    /**
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isNtpServerSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "isNtpServerSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setNtpServer(String server) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "setNtpServer", new Class[]{String.class}, new Object[]{server});
    }

    public int forceRebootForNtpChanged(boolean force) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "forceRebootForNtpChanged", new Class[]{boolean.class}, new Object[]{force});
    }
    /**
     * @return 0 不会在ntp更改后强制重启，1 强制重启，-1 方法调用失败
     */
    public int isForceRebootForNtpChanged() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "isForceRebootForNtpChanged", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setNtpInterval(long interval) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "setNtpInterval", new Class[]{long.class}, new Object[]{interval});
    }

    public int setDate(int year, int month, int day) {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "setDate", new Class[]{int.class, int.class, int.class}, new Object[]{year, month, day}, boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setTime(int hourOfDay, int minute) {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "setTime", new Class[]{int.class, int.class}, new Object[]{hourOfDay, minute}, boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setDateTime(int year, int month, int day, int hourOfDay, int minute) {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "setDateTime", new Class[]{int.class, int.class, int.class, int.class, int.class}, new Object[]{year, month, day, hourOfDay, minute}, boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int set24Hour(boolean is24Hour) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "set24Hour", new Class[]{boolean.class}, new Object[]{is24Hour});
    }

    public int disallow24HourSettings(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDateTimeManager, "disallow24HourSettings", new Class[]{boolean.class}, new Object[]{disallowed});
    }
    /**
     * @return 0 允许24小时设置，1 禁止，-1 方法调用失败
     */
    public int is24HourSettingsDisallowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmDateTimeManager, "is24HourSettingsDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }


}