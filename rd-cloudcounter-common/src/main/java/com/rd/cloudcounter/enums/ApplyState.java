package com.rd.cloudcounter.enums;

/**
 * 申请办理类型枚举类
 * @author
 * @create 2020-11-24-16:51
 */
public enum ApplyState {

    APPLYING(0, "申请中"),
    PROCESSED(1, "已处理");

    public final Integer type;
    public final String value;

    ApplyState(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValue(Integer type) {

        for (ApplyState applyType : ApplyState.values()) {
            if (applyType.type == type) {
                return applyType.value;
            }
        }
        return "";
    }
}
