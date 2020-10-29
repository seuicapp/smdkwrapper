package com.seuic.mdm.api.miscellaneous;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

public class MdmMiscellaneousManagerWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.miscellaneous.MdmMiscellaneousManager";
    private Object mdmMiscellaneousManager = null;

    private MdmMiscellaneousManagerWrapper(Object mdmMiscellaneousManager) {
        this.mdmMiscellaneousManager = mdmMiscellaneousManager;
    }

    public static MdmMiscellaneousManagerWrapper get(Context context) {
        MdmMiscellaneousManagerWrapper mdmMiscellaneousManagerWrapper = null;
        Object mdmMiscellaneousManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmMiscellaneousManager == null) return null;
        mdmMiscellaneousManagerWrapper = new MdmMiscellaneousManagerWrapper(mdmMiscellaneousManager);
        return mdmMiscellaneousManagerWrapper;
    }

    /**
     * 是否允许操作字体大小选项
     * @param allowed 允许-true,禁止-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated 已过时。 从 v0.0.2 开始废弃此接口，请使用 MdmDisplayManager.allowChangeFontScale 替代
     */
    public int allowChangeFontScale(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowChangeFontScale", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * 查询是否允许设置字体大小
     * @deprecated
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isChangeFontScaleAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isChangeFontScaleAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);

    }

    /**
     * 设置字体大小
     * @param scale - 具体值参考具体机型
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int setFontScale(float scale) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setFontScale", new Class[]{float.class}, new Object[]{scale});
    }

    /**
     *是否允许操作显示大小选项
     * @param allowed - 允许-true，禁止-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int allowDisplayScaleSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowDisplayScaleSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * 查询是否允许操作显示大小选项
     * @deprecated
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isDisplayScaleSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isDisplayScaleSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 设置显示大小
     * @param scale - 具体值参考具体机型
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int setDisplayScale(int scale) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setDisplayScale", new Class[]{int.class}, new Object[]{scale});
    }

    /**
     * 设置显示密度
     * @param density - 密度
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int setDisplayDensity(int density) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setDisplayDensity", new Class[]{int.class}, new Object[]{density});
    }

    /**
     * 允许设置省电模式
     * @param allowed 允许-true,禁止-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int allowPowerSaveingModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowPowerSaveingModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * @deprecated
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isPowerSaveingModeSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isPowerSaveingModeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * @param on  false-关闭，true-开启
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int setPowerSaveingMode(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setPowerSaveingMode", new Class[]{boolean.class}, new Object[]{on});
    }

    /**
     * @deprecated
     * @return 0 未开启，1 已开启，-1 方法调用失败
     */
    public int isPowerSavingMode() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isPowerSavingMode", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int allowStorageManagerSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowStorageManagerSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isStorageManagerSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isStorageManagerSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setStorageManager(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setStorageManager", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowMagnifyWithTripleTapSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowMagnifyWithTripleTapSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }
    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isMagnifyWithTripleTapSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isMagnifyWithTripleTapSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setMagnifyWithTripleTap(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setMagnifyWithTripleTap", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowMagnifyWithButtonSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowMagnifyWithButtonSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isMagnifyWithButtonSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isMagnifyWithButtonSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setMagnifyWithButton(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setMagnifyWithButton", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowDonotDisturbSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowDonotDisturbSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isDonotDisturbSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isDonotDisturbSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    public int setDonotDisturbOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setDonotDisturbOn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int setStreamVolume(int stream, int volume) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "setStreamVolume", new Class[]{int.class, int.class}, new Object[]{stream, volume});
    }

    public int allowAddAccounts(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmMiscellaneousManager, "allowAddAccounts", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 禁止，1 允许，-1 方法调用失败
     */
    public int isAddAccountsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmMiscellaneousManager, "isAddAccountsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }


}
