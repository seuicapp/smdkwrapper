package com.seuic.mdm.api.security;

import android.content.ComponentName;
import android.content.Context;

import com.seuic.mdm.api.base.SMDKResult;
import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

public class MdmSecurityManagerWrapper {
    private static String CLASS_PATH = "com.seuic.mdm.security.MdmSecurityManager";

    private Object mdmSecurityManager = null;

    private MdmSecurityManagerWrapper(Object mdmSecurityManager){
        this.mdmSecurityManager = mdmSecurityManager;
    }

    public static MdmSecurityManagerWrapper get(Context context){
        MdmSecurityManagerWrapper mdmSecurityManagerWrapper = null;
        Object mdmSecurityManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmSecurityManager == null) return null;
        mdmSecurityManagerWrapper = new MdmSecurityManagerWrapper(mdmSecurityManager);
        return mdmSecurityManagerWrapper;
    }

    public int allowChangeScreenLock(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "allowChangeScreenLock", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isChangeScreenLockAllowed(){
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isChangeScreenLockAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int lockScreenAfter(int timeout) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "lockScreenAfter", new Class[]{int.class}, new Object[]{timeout});
    }

    public int allowSecureStartUpSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "allowSecureStartUpSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     *
     * @return 0 不允许， 1 允许， -1 方法调用失败
     */
    public int isSecureStartUpSettingsAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isSecureStartUpSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *禁用/启用相机
     * @param disabled 禁用-true，启用-false
     * @return 0 设置失败， 1 设置成功， -1 方法调用失败
     */
    public int setCameraDisabled(boolean disabled) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "setCameraDisabled", new Class[]{boolean.class}, new Object[]{disabled}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *查询相机是否被禁用
     * @return 0 启用， 1 禁用， -1 方法调用失败
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int isCameraDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isCameraDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *安装证书
     * @param data - 证书字节数组
     * @param PKCS12 - 是否是 PKCS12 证书
     * @param alias - 证书别名
     * @param password - 证书密码（PKCS12 有效）
     * @param usage -  证书用途 MdmManager.USAGE_TYPE_SYSTEM MdmManager.USAGE_TYPE_WIFI
     * @return SMDKResult.NOT_SUPPORT（-1，设备不支持该方法） ，其他返回值参考 MdmManager.STATUS_INSTALL_CERT_*
     */
    public int installCertificate(byte[] data, boolean PKCS12, String alias, String password, int usage) {
        Integer re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "installCertificate",
                new Class[]{byte[].class, boolean.class, String.class, String.class, int.class},
                new Object[]{data, PKCS12, alias, password, usage}, int.class);
        if(re==null){
            return SMDKResult.NOT_SUPPORT;
        }
        return re;
    }

    /**
     * 卸载指定证书
     * @param alias - 证书别名
     * @param usage - 证书用途
     * @return 0 卸载失败， 1 卸载成功， -1 方法调用失败
     */
    public int uninstallCertificate(String alias, int usage) {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "uninstallCertificate", new Class[]{String.class, int.class},
                new Object[]{alias, usage}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int disallowLocationSettings(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "disallowLocationSettings", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     *
     * @return 0 允许， 1 禁止， -1 方法调用失败
     */
    public int isLocationSettingsDisallowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isLocationSettingsDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *开启/关闭位置信息开关
     * @param enabled - 开启-true，关闭-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setLocationEnabled(boolean enabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "setLocationEnabled", new Class[]{boolean.class}, new Object[]{enabled});
    }

    /**
     *查询位置信息开关是否开启
     * @return 0 关闭， 1 开启， -1 方法调用失败
     */
    public int isLocationEnabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isLocationEnabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *
     * @param provider - 模式
     * @param enabled - 启用-true，停用-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setProviderEnabledForUser(String provider, boolean enabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "setProviderEnabledForUser", new Class[]{String.class, boolean.class},
                new Object[]{provider, enabled});
    }

    /**
     *查询 GPS 定位模式是否启用
     * @param provider - 模式
     * @return 0 停用， 1 启用， -1 方法调用失败
     */
    public int isProviderEnabled(String provider) {
        Boolean re =  ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isProviderEnabled", new Class[]{String.class},
                new Object[]{provider}, boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     *是否禁用截屏
     * @param disabled - 禁用-true，允许-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setScreenCaptureDisabled(boolean disabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "setScreenCaptureDisabled", new Class[]{boolean.class}, new Object[]{disabled});
    }

    /**
     *查询是否禁用截屏
     * @return 0 允许， 1 禁用， -1 方法调用失败
     */
    public int isScreenCaptureDisabled() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isScreenCaptureDisabled", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    /**
     * 静默激活/停用设备管理器
     * @param admin - 设备管理器
     * @param actived - 激活-true，停用-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setSilentActiveAdmin(ComponentName admin, boolean actived) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "setSilentActiveAdmin",
                new Class[]{ComponentName.class, boolean.class},
                new Object[]{admin, actived});
    }

    /**
     * 恢复出厂
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int factoryReset() {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "factoryReset", new Class[]{}, new Object[]{});
    }

    public int disallowFlashDiskTransfer(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "disallowFlashDiskTransfer", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     *
     * @return 0 允许， 1 禁止， -1 方法调用失败
     */
    public int isFlashDiskTransferDisallowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isFlashDiskTransferDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

    public int disallowPcTransfer(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmSecurityManager, "disallowPcTransfer", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     *
     * @return 0 允许， 1 禁止， -1 方法调用失败
     */
    public int  isPcTransferDisallowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmSecurityManager, "isPcTransferDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }


}
