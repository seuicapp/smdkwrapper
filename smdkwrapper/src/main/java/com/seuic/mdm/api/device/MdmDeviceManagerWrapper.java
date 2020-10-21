package com.seuic.mdm.api.device;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;


public class MdmDeviceManagerWrapper {
    private static String CLASS_PATH = "com.seuic.mdm.device.MdmDeviceManager";

    private Object mdmDeviceManager = null;

    private MdmDeviceManagerWrapper(Object mdmDeviceManager) {
        this.mdmDeviceManager = mdmDeviceManager;
    }

    public static MdmDeviceManagerWrapper get(Context context) {
        MdmDeviceManagerWrapper mdmDeviceManagerWrapper = null;
        Object mdmDeviceManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmDeviceManager == null) return null;
        mdmDeviceManagerWrapper = new MdmDeviceManagerWrapper(mdmDeviceManager);
        return mdmDeviceManagerWrapper;
    }

    public int setAdbDebuggable(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "setAdbDebuggable", new Class[]{boolean.class}, new Object[]{on});
    }

    /**
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isAdbDebuggable() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "isAdbDebuggable", boolean.class);
        return ConvertUtils.booleanToInt(re);

    }

    public int setUsbFunction(String function) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "setUsbFunction", new Class[]{String.class}, new Object[]{function});
    }

    /**
     * 设置日期
     * @param year -
     * @param month -
     * @param day -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     * @deprecated
     */
    public int setDate(int year, int month, int day) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "setDate", new Class[]{int.class, int.class, int.class},
                new Object[]{year, month, day}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 设置时间
     * @param hourOfDay -
     * @param minute -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     * @deprecated
     */
    public int setTime(int hourOfDay, int minute) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "setTime", new Class[]{int.class, int.class},
                new Object[]{hourOfDay, minute}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 设置日期和时间
     * @param year -
     * @param month -
     * @param day -
     * @param hourOfDay -
     * @param minute -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     * @deprecated
     */
    public int setDateTime(int year, int month, int day, int hourOfDay, int minute) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "setDateTime", new Class[]{int.class, int.class, int.class, int.class, int.class},
                new Object[]{year, month, day, hourOfDay, minute}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 是否使用 24 小时制
     * @param is24Hour - 是-true，否-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int set24Hour(boolean is24Hour) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "set24Hour", new Class[]{boolean.class}, new Object[]{is24Hour});
    }

    /**
     * 是否禁止操作使用 24 小时制选项
     * @param disallowed - 是-true，否-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int disallow24HourSettings(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "disallow24HourSettings", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     * 查询是否禁止操作使用 24 小时制选项
     * @return 0 允许， 1 不允许， -1 方法调用失败
     * @deprecated
     */
    public int is24HourSettingsDisallowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "is24HourSettingsDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 设置默认桌面
     *
     * @param pkg - 桌面应用包名
     * @param cls -类名
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setupDefaultLauncher(String pkg, String cls) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "setupDefaultLauncher", new Class[]{String.class, String.class}, new Object[]{pkg, cls});
    }

    /**
     * 是否禁止状态栏下拉
     * @param disabled - 是-true，否-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int disableStatusBar(boolean disabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "disableStatusBar", new Class[]{boolean.class}, new Object[]{disabled});
    }

    /**
     * @return 0 允许， 1 不允许， -1 方法调用失败
     */
    public int isStatusBarDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "isStatusBarDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * @return 0 不允许，1 允许， -1 方法调用失败
     */
    public int isShowImeWithHardKeyboardEnabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "isShowImeWithHardKeyboardEnabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setShowImeWithHardKeyboard(boolean show) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "setShowImeWithHardKeyboard", new Class[]{boolean.class}, new Object[]{show});
    }

    public int setHomeKeyDisabled(boolean disabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmDeviceManager, "setHomeKeyDisabled", new Class[]{boolean.class}, new Object[]{disabled});
    }

    /**
     * @return 0 允许， 1 不允许， -1 方法调用失败
     */
    public int isHomeKeyDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmDeviceManager, "isHomeKeyDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }


}
