package com.seuic.mdm.api.battery;

import android.content.Context;

import com.seuic.mdm.api.base.SMDKResult;
import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

public class MdmBatteryManagerWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.battery.MdmBatteryManager";
    private Object mdmBatteryManager = null;//MdmBatteryManager对象

    private MdmBatteryManagerWrapper(Object mdmBatteryManager) {
        this.mdmBatteryManager = mdmBatteryManager;
    }

    public static MdmBatteryManagerWrapper get(Context context) {
        MdmBatteryManagerWrapper mdmBatteryManagerWrapper = null;
        Object mdmBatteryManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmBatteryManager == null) return null;
        mdmBatteryManagerWrapper = new MdmBatteryManagerWrapper(mdmBatteryManager);
        return mdmBatteryManagerWrapper;
    }

    /**
     * @return 一般返回一个正值，若返回一个负数则说明方法调用失败
     */
    public double getBatteryCapacity() {
        Double d = ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "getBatteryCapacity", double.class);
        if (d == null) return SMDKResult.NOT_SUPPORT;
        return d;
    }

    public int getBatteryLevel() {
        Integer i = ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "getBatteryLevel", int.class);
        if (i == null) return SMDKResult.NOT_SUPPORT;
        return i;
    }

    public int getBatteryTemperature() {
        Integer i = ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "getBatteryTemperature", int.class);
        if (i == null) return SMDKResult.NOT_SUPPORT;
        return i;
    }

    public int getLowPowerTriggerLevel() {
        Integer i = ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "getLowPowerTriggerLevel", int.class);
        if (i == null) return SMDKResult.NOT_SUPPORT;
        return i;
    }

    public int reboot() {
        return ReflectionTool.invokeDynamicVoidMethod(mdmBatteryManager, "reboot", new Class[]{}, new Object[]{});
    }

    public int allowPowerSaveingModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmBatteryManager, "allowPowerSaveingModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isPowerSaveingModeSettingsAllowed() {
        Boolean b=ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "isPowerSaveingModeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setPowerSaveingMode(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmBatteryManager, "setPowerSaveingMode", new Class[]{boolean.class}, new Object[]{on});
    }

    /**
     * @return 0 未开启，1 已开启，-1 方法调用失败
     */
    public int isPowerSavingMode() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmBatteryManager, "isPowerSavingMode", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

}
