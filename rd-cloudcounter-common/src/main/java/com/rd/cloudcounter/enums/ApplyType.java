package com.rd.cloudcounter.enums;

/**
 * 申请办理类型枚举类
 * @author
 * @create 2020-11-24-16:51
 */
public enum  ApplyType {

    GUIMAIN(1, "柜面"),
    QITA(0, "其他");

    public final Integer type;
    public final String value;

    ApplyType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValue(Integer type) {

        for (ApplyType applyType : ApplyType.values()) {
            if (applyType.type == type) {
                return applyType.value;
            }
        }
        return "";
    }
}
