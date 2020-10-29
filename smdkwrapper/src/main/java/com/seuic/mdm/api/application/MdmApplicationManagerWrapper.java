package com.seuic.mdm.api.application;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;

import com.seuic.mdm.api.base.SMDKResult;
import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

import java.util.LinkedList;
import java.util.List;

public class MdmApplicationManagerWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.application.MdmApplicationManager";
    private Object mdmApplicationManager = null;//MdmManager对象

    private MdmApplicationManagerWrapper(Object mdmApplicationManager) {
        this.mdmApplicationManager = mdmApplicationManager;
    }

    /**
     * 获取 MdmMiscellaneousManager 实例
     *
     * @param context -
     * @return MdmApplicationManagerWrapper实例。若为null，则说明设备不支持该类实例的所有方法。
     * @throws RuntimeException --- Context传入null可能会出抛出该异常
     */
    public static MdmApplicationManagerWrapper get(Context context) {
        MdmApplicationManagerWrapper mdmApplicationManagerWrapper = null;
        Object mdmApplicationManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmApplicationManager == null) return null;
        mdmApplicationManagerWrapper = new MdmApplicationManagerWrapper(mdmApplicationManager);
        return mdmApplicationManagerWrapper;
    }

    /**
     * 是否允许设置开发者选项
     *
     * @param allowed - 允许设置-true，禁止设置-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int allowChangeDevelopmentOptions(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "allowChangeDevelopmentOptions", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * 查询是否允许设置开发者选项
     *
     * @return 0 禁止设置，1 允许设置, -1 设备不支持该方法
     */
    public int isChangeDevelopmentOptionsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isChangeDevelopmentOptionsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 打开/关闭开发者选项
     *
     * @param on - 打开开发者选项-true，关闭开发者选项-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     */
    public int setDevelopmentOptions(boolean on) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "setDevelopmentOptions", new Class[]{boolean.class}, new Object[]{on});
    }

    /**
     * 是否允许对应用在后台使用移动数据的选项进行设置
     *
     * @param allowed - 允许设置-true，禁止设置-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     */
    public int allowBackgroundDataSettings(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "allowBackgroundDataSettings", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * 查询是否允许对应用在后台使用移动数据的选项进行设置
     *
     * @return 0 禁止设置，1 允许设置, SMDKResult.NOT_SUPPORT 设备不支持该方法
     */
    public int isBackgroundDataSettingsAllowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isBackgroundDataSettingsAllowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 是否禁止用户对应用权限相关选项进行修改
     *
     * @param disallowed - 禁止修改-true，允许修改-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int disallowAppAnySettings(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "disallowAppAnySettings", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     * 查询是否禁止用户对应用权限相关选项进行修改
     *
     * @return 0 允许修改,1 禁止修改 , SMDKResult.NOT_SUPPORT 设备不支持该方法
     */
    public int isAppAnySettingsDisallowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isAppAnySettingsDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 是否禁止用户进行应用移动操作
     *
     * @param disallowed - 禁止-true，允许-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int disallowMovePackages(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "disallowMovePackages", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     * 查询是否禁止用户进行应用移动操作
     *
     * @return 0 允许,1 禁止 , SMDKResult.NOT_SUPPORT 设备不支持该方法
     */
    public int isMovePackagesDisallowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isMovePackagesDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 禁止移动设备和 FLASH 设备之间进行数据传输
     *
     * @param disallowed - 禁止-true，允许-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     * @deprecated 已过时。  从 v0.0.2 开始废弃此接口，推荐使用 MdmSecurityManager.disallowFlashDiskTransfer进行替代
     */
    public int disallowFlashDiskTransfer(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "disallowFlashDiskTransfer", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     * 查询是否禁止移动设备和 FLASH 设备之间进行数据传输
     * @return 0 允许,1 禁止 , SMDKResult.NOT_SUPPORT 设备不支持该方法
     * @deprecated
     */
    public int isFlashDiskTransferDisallowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isFlashDiskTransferDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 禁止移动设备和 PC 设备之间进行数据传输
     * @param disallowed - 禁止-true，允许-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @deprecated 已过时。  从 v0.0.2 开始废弃此接口，推荐使用
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int disallowPcTransfer(boolean disallowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "disallowPcTransfer", new Class[]{boolean.class}, new Object[]{disallowed});
    }

    /**
     * @return 允许  0 禁止，-1 方法调用失败
     * @deprecated
     */
    public int isPcTransferDisallowed() {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "isPcTransferDisallowed", boolean.class);
        return ConvertUtils.booleanToInt(b);

    }
    /**
     * 设置应用可用状态
     * @param packageName - 包名
     * @param newState - 模块开启关闭状态
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int setApplicationEnabledSetting(String packageName, int newState) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "setApplicationEnabledSetting", new Class[]{String.class, int.class}, new Object[]{packageName, newState});
    }

    /**
     * 查询应用可用状态
     * @param packageName
     * @return
     */
    public int getApplicationEnabledSetting(String packageName) {
        Integer i = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getApplicationEnabledSetting", new Class[]{String.class}, new Object[]{packageName}, int.class);
        if (i == null) return SMDKResult.NOT_SUPPORT;
        return i.intValue();
    }
    /**
     * 禁止移动设备和 FLASH 设备之间进行数据传输
     *
     * @param userId - 用户ID
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int removeAllRecents(int userId) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "removeAllRecents", new Class[]{int.class}, new Object[]{userId});
    }
    /**
     * 删除应用缓存数据
     *
     * @param packageName - 包名
     * @param userId - 用户ID
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int deleteApplicationCacheFilesAsUser(String packageName, int userId) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "deleteApplicationCacheFilesAsUser", new Class[]{String.class, int.class}, new Object[]{packageName, userId});
    }
    /**
     * 清除应用数据
     *
     * @param packageName - 包名
     * @param userId - 用户ID
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int clearApplicationUserData(String packageName, int userId) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "clearApplicationUserData", new Class[]{String.class, int.class}, new Object[]{packageName, userId});
    }
    /**
     * 获取应用安装列表
     *
     * @param userId - 用户Id
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getInstalledApplicationsAsUser(int userId) {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getInstalledApplicationsAsUser", new Class[]{int.class}, new Object[]{userId}, List.class);
    }
    /**
     * 静默安装应用
     *
     * @param apkPath - 安装包路径
     * @param observer - 接口中返回安装状态
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int silentInstall(String apkPath, final MdmPackageObserverWrapper observer) {
        int status = SMDKResult.SUCCESS;
        try {
            com.seuic.mdm.application.MdmPackageObserver mdmPackageObserver = new com.seuic.mdm.application.MdmPackageObserver() {
                @Override
                public void onPackageChange(boolean b) {
                    observer.onPackageChange(b);
                }
            };
            status = ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "silentInstall", new Class[]{String.class, com.seuic.mdm.application.MdmPackageObserver.class}, new Object[]{apkPath, mdmPackageObserver});
        } catch (NoClassDefFoundError e) {
            status = SMDKResult.NOT_SUPPORT;
        }
        return status;
    }
    /**
     *
     *
     * @param packageName - 用户Id
     * @param observer - 接口中回调卸载应用状态
     * @return SMDKResult.NOT_SUPPORT - 设备不支持， SMDKResult.SUCCESS - 方法调用成功
     * @throws RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int silentUninstall(String packageName, final MdmPackageObserverWrapper observer) {
        int status = SMDKResult.SUCCESS;
        try {
            com.seuic.mdm.application.MdmPackageObserver mdmPackageObserver = new com.seuic.mdm.application.MdmPackageObserver() {
                @Override
                public void onPackageChange(boolean b) {
                    observer.onPackageChange(b);
                }
            };
            status = ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "silentUninstall", new Class[]{String.class, com.seuic.mdm.application.MdmPackageObserver.class}, new Object[]{packageName, mdmPackageObserver});
        } catch (NoClassDefFoundError e) {
            status = SMDKResult.NOT_SUPPORT;
        }
        return status;
    }

    /**
     *
     * 设置应用可用状态
     *
     * @param categories -  模块类别，可以使用“|”设置多个模块<br>
     *  MdmManager.SETTINGS_CATEGOTY_NETWORK 网络和互联网<br>
     *  MdmManager.SETTINGS_CATEGOTY_CONNECTED_DEVICE 已连接的设备<br>
     *  MdmManager.SETTINGS_CATEGOTY_POWER 电池<br>
     *  MdmManager.SETTINGS_CATEGOTY_DISPLAY 显示<br>
     *  MdmManager.SETTINGS_CATEGOTY_SOUND 声音<br>
     *  MdmManager.SETTINGS_CATEGOTY_STORAGE 存储<br>
     *  MdmManager.SETTINGS_CATEGOTY_SECURITY 安全性和位置信息<br>
     *  MdmManager.SETTINGS_CATEGOTY_ACCOUNT 账号<br>
     *  MdmManager.SETTINGS_CATEGOTY_ACCESSIBILITY 无障碍<br>
     *  MdmManager.SETTINGS_CATEGOTY_SYSTEM 系统<br>
     *  MdmManager.SETTINGS_CATEGOTY_ABOUNT 关于手机<br>
     *  MdmManager.SETTINGS_CATEGOTY_APPLICATION 应用和通知<br>
     *  MdmManager.SETTINGS_CATEGOTY_ALL 所有模块<br>
     *  传入 0 所有模块不被禁用<br>
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setSettingsCategoriesDisabled(int categories) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "setSettingsCategoriesDisabled", new Class[]{int.class}, new Object[]{categories});
    }

    /**
     *查询设置被禁用的模块
     * @return 1. SMDKResult.NOT_SUPPORT - 设备不支持<br>
     * 2. 参考 setSettingsCategoriesDisalbed 传入值<br>
     */
    public int getDisabledSettingsCategories() {
        Integer integer = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getDisabledSettingsCategories", int.class);
        if (integer == null) return SMDKResult.NOT_SUPPORT;//返回值为null，说明方法调用失败，抛出异常
        return integer.intValue();
    }

    /**
     *强制结束应用。pkg 和 userId 必须指定
     * @param pkg -
     * @param userId -
     * @param reason -
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int killApplication(String pkg, int userId, String reason) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "killApplication", new Class[]{String.class, int.class, String.class}, new Object[]{pkg, userId, reason});
    }

    /**
     * 查询系统应用保活名单
     * @param added -  添加至系统保活名单的应用列表
     * @param removed - 从系统保活名单移出的应用列表
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int alwaysAlive(List< String > added, List< String > removed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "alwaysAlive", new Class[]{List.class, List.class}, new Object[]{added, removed});
    }

    /**
     * 查询系统应用保活名单
     * @return 1. 系统保活名单列表<br>
     * 2. null - 设备不支持该方法
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getAlwaysAlive() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getAlwaysAlive", List.class);
    }

    /**
     * 开机自启动
     * @param added 添加至系统开机启动名单的应用列表
     * @param removed  从系统开机启动名单中移除的应用列表
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int launchOnBootCompleted(List< PackageBundleWrapper > added, List< String > removed) {
        List< Object > packageBundleAdded = new LinkedList<>();
        for (PackageBundleWrapper wrapper : added) packageBundleAdded.add(wrapper.packageBundle);
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "launchOnBootCompleted", new Class[]{List.class, List.class}, new Object[]{packageBundleAdded, removed});
    }

    /**
     *查询系统开机启动名单
     * @return 1. 系统开机启动名单<br>
     * 2. null - 设备不支持该方法
     */
    public List< PackageBundleWrapper > getLaunchOnBootCompletedPackages() {
        List< PackageBundleWrapper > packageBundleWrapperList = new LinkedList<>();
        List list = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getLaunchOnBootCompletedPackages", List.class);
        if (list == null) return null;
        for (Object obj : list) packageBundleWrapperList.add(new PackageBundleWrapper(obj));
        return packageBundleWrapperList;
    }

    /**
     *
     * @param packageName  应用来源的包名
     * @param enabled  允许-true，禁止-false
     * @param userId 用户 ID
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int enableInstallNonMarketApp(String packageName, boolean enabled, int userId) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "enableInstallNonMarketApp", new Class[]{String.class, boolean.class, int.class}, new Object[]{packageName, enabled, userId});
    }

    /**
     *获取有“安装未知应用”权限的应用名单
     * @param userId -
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getInstallNonMarketPackages(int userId) {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getInstallNonMarketPackages", new Class[]{int.class}, new Object[]{userId}, List.class);
    }

    /**
     *查询某应用是否有“安装未知应用”权限
     * @param packageName  应用包名
     * @param userId  用户 ID
     * @return 0 - 禁止，1 - 允许，-1 - 设备不支持该方法
     */
    public int canInstallNonMarketApp(String packageName, int userId) {
        Boolean b = ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "canInstallNonMarketApp", new Class[]{String.class, int.class}, new Object[]{packageName, userId}, boolean.class);
        return ConvertUtils.booleanToInt(b);
    }

    /**
     * 是否允许安装来自所有未知来源的应用
     * @param enabled 允许-true，仅允许 getInstallNonMarketPackages 中的应用-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int alwaysInstallNonMarketApp(boolean enabled) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "alwaysInstallNonMarketApp", new Class[]{boolean.class}, new Object[]{enabled});
    }

    /**
     * 应用安装白名单和应用安装黑名单联合判断一个应用是否被允许安装。黑名单的优先级高于白名单。
     * @param added  添加至系统安装白名单的应用列表
     * @param removed  从系统安装白名单中移除的应用列表
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int installPackageWhiteList(List< String > added, List< String > removed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "installPackageWhiteList", new Class[]{List.class, List.class}, new Object[]{added, removed});
    }

    /**
     * 查询系统安装白名单
     * @return 1. 白名单列表<br>
     * 2. null - 设备不支持该方法
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getInstallPackageWhiteList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getInstallPackageWhiteList", List.class);
    }

    /**
     * 应用安装黑名单和应用安装白名单联合判断一个应用是否被允许安装。黑名单的优先级高于白名单。如果应用为替换安装，不受黑名单管控。
     * @param added  添加至系统安装黑名单的应用列表
     * @param removed  从系统安装黑名单中移除的应用列表
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public int installPackageBlackList(List< String > added, List< String > removed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "installPackageBlackList", new Class[]{List.class, List.class}, new Object[]{added, removed});
    }
    /**
     * 查询系统安装黑名单
     * @return 1. 黑名单列表<br>
     * 2. null - 设备不支持该方法
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getInstallPackageBlackList() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getInstallPackageBlackList", List.class);
    }

    /**
     *禁止卸载的应用名单
     * @param added  添加至系统禁止卸载名单的应用列表
     * @param removed  从系统禁止卸载名单中移除的应用列表
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int disallowUninstallPackages(List< String > added, List< String > removed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "disallowUninstallPackages", new Class[]{List.class, List.class}, new Object[]{added, removed});
    }
    /**
     * 查询系统禁止卸载的应用名单
     * @return 1. 应用列表<br>
     * 2. null - 设备不支持该方法
     * @throws java.lang.RuntimeException - 调用此方法后，系统执行未达到预期结果将抛出此异常
     */
    public List< String > getDisallowUninstallPackages() {
        return ReflectionTool.invokeDynamicMethodWithReturn(mdmApplicationManager, "getDisallowUninstallPackages", List.class);
    }

    /**
     * 设置系统独占应用 独占应用的主页面需要处理以下逻辑 <br>
     * 1、 不得在 OnPause 中 finish 当前页面 <br>
     * 2、 需要复写 onBackPress，不得使用 super 或 finish 当前页面<br>
     * @param packageName -
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int setExclusiveApp(String packageName) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "setExclusiveApp", new Class[]{String.class}, new Object[]{packageName});
    }

    /**
     * 发送 Intent 信息
     * @param intent - 如果需要将信息发送到指定应用，需要指明 Package
     * @param user - 用户 Handle
     * @param receiverPermission - 需要接收应用具备的权限
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int sendAsUser(Intent intent, UserHandle user, String receiverPermission) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "sendAsUser", new Class[]{Intent.class, UserHandle.class, String.class}, new Object[]{intent, user, receiverPermission});
    }

    /**
     * 参考 sendAsUser
     * @param intent -
     * @param receiverPermission 需要接收应用具备的权限
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     */
    public int send(Intent intent, String receiverPermission) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmApplicationManager, "send", new Class[]{Intent.class, String.class}, new Object[]{intent, receiverPermission});
    }
}
