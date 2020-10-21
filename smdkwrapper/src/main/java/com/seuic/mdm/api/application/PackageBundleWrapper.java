package com.seuic.mdm.api.application;

import com.seuic.mdm.api.uitl.ReflectionTool;

public class PackageBundleWrapper {
    private static final String CLASS_PATH = "com.seuic.mdm.application.PackageBundle";
    Object packageBundle = null;

    /**
     *
     * @param packageName - 包名
     * @param priority - 优先级
     */
    public PackageBundleWrapper(String packageName, int priority) {
        packageBundle = ReflectionTool.invokeConstructorMethod(CLASS_PATH, new Class[]{String.class, int.class}, new Object[]{packageName, priority});
    }

    /**
     * 限制包内访问
     * @param packageBundle -
     */
    PackageBundleWrapper(Object packageBundle){
        this.packageBundle=packageBundle;
    }
    public String getPackageName() {
        return ReflectionTool.invokeDynamicMethodWithReturn(packageBundle, "getPackageName", String.class);
    }

    public int getPriority() {
        return ReflectionTool.invokeDynamicMethodWithReturn(packageBundle, "getPriority", int.class);
    }

    /**
     *
     * @param priority 优先级
     */
    public void setPriority(int priority) {
        ReflectionTool.invokeDynamicVoidMethod(packageBundle, "setPriority", new Class[]{int.class}, new Object[]{priority});
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("mPackageName = " + this.getPackageName());
        sb.append(" mPriority = " + this.getPriority());
        sb.append(']');
        return sb.toString();
    }
}
