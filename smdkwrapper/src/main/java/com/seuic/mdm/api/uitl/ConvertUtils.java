package com.seuic.mdm.api.uitl;

import com.seuic.mdm.api.base.SMDKResult;

public class ConvertUtils {
    /**
     *将 boolean 类型值转换为 int 类型
     * @param b -
     * @return -
     */
    public static int booleanToInt(Boolean b) {
        if (b == null) return SMDKResult.NOT_SUPPORT;
        return b ? SMDKResult.TRUE : SMDKResult.FALSE;
    }
}
