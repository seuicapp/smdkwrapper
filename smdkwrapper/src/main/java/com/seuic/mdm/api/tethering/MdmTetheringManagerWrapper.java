package com.seuic.mdm.api.tethering;

import android.content.Context;

import com.seuic.mdm.api.uitl.ConvertUtils;
import com.seuic.mdm.api.uitl.ReflectionTool;

/**
 * @deprecated
 */
public class MdmTetheringManagerWrapper {
    private static String CLASS_PATH = "com.seuic.mdm.tethering.MdmTetheringManager";

    private Object mdmTetherManager = null;

    private MdmTetheringManagerWrapper(Object mdmTetherManager) {
        this.mdmTetherManager = mdmTetherManager;
    }

    public static MdmTetheringManagerWrapper get(Context context) {
        MdmTetheringManagerWrapper mdmTetheringManagerWrapper = null;
        Object mdmTetherManager = ReflectionTool.invokeStaticMethodWithReturn(CLASS_PATH, "get", new Class[]{Context.class}, new Object[]{context});
        if (mdmTetherManager == null) return null;
        mdmTetheringManagerWrapper = new MdmTetheringManagerWrapper(mdmTetherManager);
        return mdmTetheringManagerWrapper;
    }

    /**
     *是否允许设置 USB 网络共享
     * @param allowed - 允许-true，禁用-false
     * @return SMDKResult.NOT_SUPPORT - 设备不支持 ，SMDKResult.SUCCESS - 方法调用成功
     * @deprecated
     */
    public int allowUsbTethering(boolean allowed) {
        return ReflectionTool.invokeDynamicVoidMethod(mdmTetherManager, "allowUsbTethering", new Class[]{boolean.class}, new Object[]{allowed});
    }

    /**
     * @return 0 不允许， 1 允许， -1 方法调用失败
     * @deprecated
     */
    public int isUsbTetheringAllowed() {
        Boolean re = ReflectionTool.invokeDynamicMethodWithReturn(mdmTetherManager, "isUsbTetheringAllowed", boolean.class);
        return ConvertUtils.booleanToInt(re);
    }

}
