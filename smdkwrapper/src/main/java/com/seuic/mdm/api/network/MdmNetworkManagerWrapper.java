package com.seuic.mdm.api.network;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

import java.util.List;

public class MdmNetworkManagerWrapper {

    private static String CLASS_PATH = "com.seuic.mdm.network.MdmNetworkManager";

    private Object mdmNetworkManager = null;

    private MdmNetworkManagerWrapper(Object mdmNetworkManager){
        this.mdmNetworkManager = mdmNetworkManager;
    }

    public static MdmNetworkManagerWrapper get(Context context){
        MdmNetworkManagerWrapper mdmNetworkManagerWrapper = null;
        Object mdmNetworkManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmNetworkManager == null) return null;
        mdmNetworkManagerWrapper = new MdmNetworkManagerWrapper(mdmNetworkManager);
        return mdmNetworkManagerWrapper;
    }

    public int allowChangeCountryCodeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowChangeCountryCodeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeCountryCodeSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isChangeCountryCodeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setCountryCode(String country) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setCountryCode", new Class[]{String.class}, new Object[]{country});
    }

    public int allowChangeFrequencyBandSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowChangeFrequencyBandSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeFrequencyBandSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isChangeFrequencyBandSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setFrequencyBand(int id) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setFrequencyBand", new Class[]{int.class}, new Object[]{id});
    }

    public int allowAirplaneModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowAirplaneModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isAirplaneModeSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isAirplaneModeSettingsAllowed",boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setAirplaneModeOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setAirplaneModeOn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowWifiRoamingTrigerSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiRoamingTrigerSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiRoamingTrigerSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiRoamingTrigerSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiRoamingTriger(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiRoamingTriger", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiRoamingDeltaSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiRoamingDeltaSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiRoamingDeltaSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiRoamingDeltaSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiRoamingDelta(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiRoamingDelta", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiPhyModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiPhyModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiPhyModeSettingsAllowed() {
        Boolean re =  ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiPhyModeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiPhyMode(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiPhyMode", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiDataRateSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiDataRateSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiDataRateSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiDataRateSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiDataRate(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiDataRate", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiSURTimeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiSURTimeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiSURTimeSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiSURTimeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiSURTime(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiSURTime", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowWifiWorkAtHDESettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiWorkAtHDESettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiWorkAtHDESettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiWorkAtHDESettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiWorkAtHDE(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiWorkAtHDE", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowWifiAgcModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiAgcModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiAgcModeSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiAgcModeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiAgcMode(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiAgcMode", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiPowerSaveModeSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiPowerSaveModeSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiPowerSaveModeSettingsAllowed() {
        Boolean re =  ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiPowerSaveModeSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiPowerSaveMode(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiPowerSaveMode", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiSsidFilterSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiSsidFilterSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiSsidFilterSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiSsidFilterSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiSsidFilter(int value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiSsidFilter", new Class[]{int.class}, new Object[]{value});
    }

    public int allowWifiSsidConfigSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiSsidConfigSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiSsidConfigSettingsAllowed() {
        Boolean re =  ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiSsidConfigSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public String loadSSIDBlackList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "loadSSIDBlackList", String.class);
    }

    public int addBlackSSID(String value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "addBlackSSID", new Class[]{String.class}, new Object[]{value});
    }

    public int removeBlackSSID(String value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "removeBlackSSID", new Class[]{String.class}, new Object[]{value});
    }

    public int clearSSIDBlackList() {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "clearSSIDBlackList", new Class[]{}, new Object[]{});
    }

    public String loadSSIDWhiteList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "loadSSIDWhiteList", String.class);
    }

    public int addWhiteSSID(String value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "addWhiteSSID", new Class[]{String.class}, new Object[]{value});
    }

    public int removeWhiteSSID(String value) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "removeWhiteSSID", new Class[]{String.class}, new Object[]{value});
    }

    public int clearSSIDWhiteList() {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "clearSSIDWhiteList", new Class[]{}, new Object[]{});
    }

    public int allowBluetoothSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowBluetoothSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isBluetoothSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isBluetoothSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setBluetoothOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setBluetoothOn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowWifiSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int setWifiOn(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "setWifiOn", new Class[]{boolean.class}, new Object[]{on});
    }

    public int allowWifiProfilesSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowWifiProfilesSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isWifiProfilesSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isWifiProfilesSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int allowAutoConnectSavedNetwork(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowAutoConnectSavedNetwork", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isAutoConnectSavedNetworkAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isAutoConnectSavedNetworkAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int allowConnectUnsecureNetwork(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowConnectUnsecureNetwork", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isConnectUnsecureNetworkAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isConnectUnsecureNetworkAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 配置特定 SSID
     * @param ssid SSID 名称
     * @param psw 密码
     * @param type 类型
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setSSID(String ssid, String psw, int type) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setSSID",
                new Class[]{String.class, String.class, int.class},
                new Object[]{ssid, psw, type}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * @param ssid -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int removeSSID(String ssid) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "removeSSID",
                new Class[]{String.class},
                new Object[]{ssid}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * @param disabled -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setWifiApDisabled(boolean disabled) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setWifiApDisabled",
                new Class[]{boolean.class},
                new Object[]{disabled}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *
     * @return 0 启用， 1 禁用， -1 方法调用失败
     */
    public int getWifiApDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "getWifiApDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *是否操作 NFC 开关
     * @param disabled - 禁止-true，允许-false
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setNfcDisabled(boolean disabled) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setNfcDisabled",
                new Class[]{boolean.class},
                new Object[]{disabled}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *查询是否操作 NFC 开关
     * @return 0 允许， 1 不允许， -1 方法调用失败
     */
    public int getNfcDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "getNfcDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *开启/关闭 NFC
     * @param on - 开启-true，关闭-false
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setNfcOn(boolean on) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setNfcOn", new Class[]{boolean.class}, new Object[]{on}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *添加网络保活名单。其和网络黑名单联合使用，黑名单优先
     * @param packageNames - 保活名单列表
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int addNetworkWhiteList(List<String> packageNames) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "addNetworkWhiteList",
                new Class[]{List.class}, new Object[]{packageNames}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *移除指定的网络保活名单。其和网络黑名单联合使用，黑名单优先
     * @param packageNames - 保活名单列表
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int removeNetworkWhiteList(List<String> packageNames) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "removeNetworkWhiteList",
                new Class[]{List.class}, new Object[]{packageNames}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public List<String> getNetworkWhiteList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "getNetworkWhiteList", List.class);
    }

    /**
     *指定应用是否包含在网络保活名单
     * @param packageName -
     * @return 0 否， 1 是， -1 方法调用失败
     */
    public int isInNetworkWhiteList(String packageName) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isInNetworkWhiteList",
                new Class[]{String.class},
                new Object[]{packageName}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *添加网络黑名单
     * @param packageNames -
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int addNetworkBlackList(List<String> packageNames) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "addNetworkBlackList",
                new Class[]{List.class}, new Object[]{packageNames}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *移除指定的网络黑名单
     * @param packageNames -  黑名单列表
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int removeNetworkBlackList(List<String> packageNames) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "removeNetworkBlackList",
                new Class[]{List.class}, new Object[]{packageNames}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 获取系统网络黑名单
     * @return null - 设备不支持该方法，或网络黑名单列表
     */
    public List<String> getNetworkBlackList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "getNetworkBlackList", List.class);
    }

    /**
     *指定应用是否包含在网络黑名单
     * @param packageName -
     * @return 0 否， 1 是， -1 方法调用失败
     */
    public int isInNetworkBlackList(String packageName) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isInNetworkBlackList",
                new Class[]{String.class},
                new Object[]{packageName}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *开启/关闭移动数据网络
     * @param enabled - 开启-true，关闭-false
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setMobileDataEnabled(boolean enabled) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setMobileDataEnabled",
                new Class[]{boolean.class},
                new Object[]{enabled}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *是否禁止操作移动数据网络开关
     * @param disallowed - 禁止-true，允许-false
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setMobileDataDisallowed(boolean disallowed) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "setMobileDataDisallowed",
                new Class[]{boolean.class},
                new Object[]{disallowed}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *
     * @return 0 允许， 1 不允许， -1 方法调用失败
     */
    public int isMobileDataDisallowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isMobileDataDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int allowUsbTethering(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmNetworkManager, "allowUsbTethering", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isUsbTetheringAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmNetworkManager, "isUsbTetheringAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }
}
