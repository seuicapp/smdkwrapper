package com.seuic.mdm.api;

import android.content.Context;

import com.seuic.mdm.api.uitl.ReflectionTool;

public class MdmManagerWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.MdmManager";

    public static final String PERMISSION_MDM_APPLICATION_MANAGEMENT = "com.seuic.permission.MDM_APPLICATION_MANAGEMENT";
    public static final String PERMISSION_MDM_DISPLAY_MANAGEMENT = "com.seuic.permission.MDM_DISPLAY_MANAGEMENT";
    public static final String PERMISSION_MDM_MISCELLANEOUS_MANAGEMENT = "com.seuic.permission.MDM_MISCELLANEOUS_MANAGEMENT";
    public static final String PERMISSION_MDM_SECURITY_MANAGEMENT = "com.seuic.permission.MDM_SECURITY_MANAGEMENT";
    public static final String PERMISSION_MDM_DATE_TIME_MANAGEMENT = "com.seuic.permission.MDM_DATE_TIME_MANAGEMENT";
    public static final String PERMISSION_MDM_NETWORK_MANAGEMENT = "com.seuic.permission.MDM_NETWORK_MANAGEMENT";
    public static final String PERMISSION_MDM_BATTERY_MANAGEMENT = "com.seuic.permission.MDM_BATTERY_MANAGEMENT";
    public static final String PERMISSION_MDM_DEVICE_MANAGEMENT = "com.seuic.permission.MDM_DEVICE_MANAGEMENT";
    /** @deprecated */
    public static final String PERMISSION_MDM_TETHERING_MANAGEMENT = "com.seuic.permission.MDM_TETHERING_MANAGEMENT";
    public static final int USAGE_TYPE_SYSTEM = 0;
    public static final int USAGE_TYPE_WIFI = 1;
    public static final int STATUS_INSTALL_CERT_SUCCESS = 0;
    public static final int STATUS_INSTALL_CERT_NEED_LOCK = 1;
    public static final int STATUS_INSTALL_CERT_PSW_ERROR = 2;
    public static final int STATUS_INSTALL_CERT_DATA_INVALID = 3;
    public static final int STATUS_INSTALL_CERT_MIME_INVALID = 4;
    public static final int STATUS_INSTALL_CERT_ALIAS_INVALID = 5;
    public static final int STATUS_INSTALL_CERT_USAGE_INVALID = 6;
    public static final int STATUS_INSTALL_CERT_KEYSTORE_PSW_ERROR = 7;
    public static final int STATUS_INSTALL_CERT_SAVE_ERROR = 8;
    public static final int STATUS_INSTALL_CERT_UNKNOWN = 9;
    public static final int SETTINGS_CATEGORY_NETWORK = 1;
    public static final int SETTINGS_CATEGORY_CONNECTED_DEVICE = 2;
    public static final int SETTINGS_CATEGORY_POWER = 4;
    public static final int SETTINGS_CATEGORY_DISPLAY = 8;
    public static final int SETTINGS_CATEGORY_SOUND = 16;
    public static final int SETTINGS_CATEGORY_STORAGE = 32;
    public static final int SETTINGS_CATEGORY_SECURITY = 64;
    public static final int SETTINGS_CATEGORY_ACCOUNT = 128;
    public static final int SETTINGS_CATEGORY_ACCESSIBILITY = 256;
    public static final int SETTINGS_CATEGORY_SYSTEM = 512;
    public static final int SETTINGS_CATEGORY_ABOUT = 1024;
    public static final int SETTINGS_CATEGORY_APPLICATION = 2048;
    public static final int SETTINGS_CATEGORY_ALL = 65535;
    public static final String FUNCTION_NONE = "none";
    public static final String FUNCTION_MTP = "mtp";
    public static final String FUNCTION_PTP = "ptp";
    public static final String FUNCTION_RNDIS = "rndis";
    public static final String FUNCTION_MIDI = "midi";

    private Object mdmManager = null;//MdmManager对象

    private MdmManagerWrapper(Object mdmManager) {
        this.mdmManager = mdmManager;
    }

    /**
     * 获取 MdmManagerWrapper 实例
     * @param context -
     * @return -
     */
    public static MdmManagerWrapper get(Context context) {
        MdmManagerWrapper mdmManagerWrapper = null;
        Object mdmManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmManager == null) return null;
        mdmManagerWrapper = new MdmManagerWrapper(mdmManager);
        return mdmManagerWrapper;
    }

}
