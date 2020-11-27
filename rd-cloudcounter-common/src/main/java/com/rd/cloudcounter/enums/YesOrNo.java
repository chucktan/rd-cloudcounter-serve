package com.rd.cloudcounter.enums;

/**
 * 申请办理类型枚举类
 * @author
 * @create 2020-11-24-16:51
 */
public enum YesOrNo {

    NO(0, "否"),
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static String getValue(Integer type) {

        for (YesOrNo applyType : YesOrNo.values()) {
            if (applyType.type == type) {
                return applyType.value;
            }
        }
        return "";
    }
}
