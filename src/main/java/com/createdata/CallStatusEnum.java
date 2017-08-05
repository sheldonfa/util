package com.createdata;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chao on 2016/11/24.
 * 呼叫状态 枚举类
 */
public enum CallStatusEnum {

    UserWill_Accepted("明确接受"),//明确接受
    UserWill_Rejected("明确拒绝"),//明确拒绝
    UserWill_Busy("用户忙"),//
    UserWill_NotMe("不是本人"),//
    UserWill_Other("其他"),//其他
    UserWill_NotSure("意愿不确定"),//不确定

    HangupCause_CALL_FAILURE("呼叫失败"),
    HangupCause_USERS_REJECT("用户拒接"),
    HangupCause_NO_ANSWER("无人接听"),
    HangupCause_NO_CONNECTED("暂时无法接通"),
    HangupCause_CALLING("通话中"),
    HangupCause_NON_LOCAL("外地号码"),
    HangupCause_WRONG_LOCAL("本地号码不需加拨0"),
    HangupCause_EMPTY_NUMBER("空号"),
    HangupCause_PHONE_OFF("已关机"),
    HangupCause_SHUT_DOWN("停机"),
    HangupCause_OUT_OF_SERVICE("暂停服务"),
    HangupCause_WRONG_NUMBER("号码错误"),
    HangupCause_USER_BUSY("用户忙碌"),
    HangupCause_RESTRICTED("通话被限制"),
    HangupCause_UNKNOWN("不确定");

    private String value;

    CallStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        for (CallStatusEnum callStatusEnum : CallStatusEnum.values()) {
            map.put(callStatusEnum.toString(), callStatusEnum.getValue());
        }
        return map;
    }

    public static Map<String, String> getUserWillMap() {
        Map<String, String> map = new HashMap<>();
        for (CallStatusEnum callStatusEnum : CallStatusEnum.values()) {
            if (callStatusEnum.toString().startsWith("UserWill")) {
                map.put(callStatusEnum.toString(), callStatusEnum.getValue());
            }
        }
        return map;
    }

    public static Map<String, String> getHangupCauseMap() {
        Map<String, String> map = new HashMap<>();
        for (CallStatusEnum callStatusEnum : CallStatusEnum.values()) {
            if (callStatusEnum.toString().startsWith("HangupCause")) {
                map.put(callStatusEnum.toString(), callStatusEnum.getValue());
            }
        }
        return map;
    }

    public static CallStatusEnum valueOfUserWill(String value) {
        return CallStatusEnum.valueOf("UserWill_" + value);
    }

    public static CallStatusEnum valueOfHangupCause(String value) {
        return CallStatusEnum.valueOf("HangupCause_" + value);
    }

    public static String getResult(String result) {
        if (StringUtils.isBlank(result)) {
            return null;
        }

        String job_result_str = "";
        String text;
        String lastText = "";
        String[] results = result.split(" ");
        for (int i = 3; i < results.length; i+=6) {
            text = results[i];
            if (text.startsWith("SIL") || "NULL".equals(text) || text.startsWith("TONE")){
                continue;
            }

            if (!StringUtils.equals(lastText, text)){
                job_result_str += " ";
                job_result_str += text;
                lastText = text;
            }

        }

        return job_result_str;
    }

    public static CallStatusEnum analysis(String result) {
        if (StringUtils.isBlank(result) || StringUtils.equals(result, "[]")) {
            return HangupCause_UNKNOWN;
        }
        result = result.replace("DHY", "");//，
        result = result.replace("FHY", "");//；
        result = result.replace("GTY", "");//！
        result = result.replace("JHY", "");//。
        result = result.replace("WHY", "");//？

        //拒接
        if (
                (StringUtils.startsWithAny(result, "[嘟", "[都", "彩铃")
                        &&
                        StringUtils.containsAny(result, "通话中", "用户正忙", "关机", "正在通"))
                        || (
                        result.matches("[\\[嘟都\\]]+") && result.length() < 6
                )
                ) {
            return HangupCause_USERS_REJECT;
        }
        //呼叫失败
        else if (StringUtils.containsAny(result, "呼叫不能完成", "线路故障", "网络忙", "线故障", "线路忙", "忙音", "无权接受呼叫")) {
            return HangupCause_CALL_FAILURE;
        }
        //空号
        else if (StringUtils.containsAny(result, "空号", "不存在")) {
            return HangupCause_EMPTY_NUMBER;
        }
        //停机
        else if (StringUtils.containsAny(result, "停机", "已停")) {
            return HangupCause_SHUT_DOWN;
        }
        //暂停服务
        else if (StringUtils.containsAny(result, "暂停服务", "尚未启用")) {
            return HangupCause_OUT_OF_SERVICE;
        }
        //号码错误
        else if (StringUtils.containsAny(result, "号码错误", "查证后", "号码不正确", "号码升位", "号码过期")) {
            return HangupCause_WRONG_NUMBER;
        }

        //用户忙
        else if (StringUtils.containsAny(result, "用户正忙", "用户忙")) {
            return HangupCause_USER_BUSY;
        }
        //通话中
        else if (StringUtils.containsAny(result, "通话中", "正在通", "不要挂机") || result.matches(".*正在.*话.*")) {
            return HangupCause_CALLING;
        }
        //无法接通0
        else if (StringUtils.containsAny(result, "无法接", "暂未接通", "来电提醒", "呼叫转移", "用户不在")) {
            return HangupCause_NO_CONNECTED;
        }
        //关机0
        if (StringUtils.containsAny(result, "关机", "已关")) {
            return HangupCause_PHONE_OFF;
        }

        //无人接听
        else if (result.matches("[\\[嘟都\\]]+")
                || StringUtils.endsWith(result, "嘟嘟]")
                || StringUtils.containsAny(result, "无人接听", "彩铃", "振铃音")) {
            return HangupCause_NO_ANSWER;
        }
        //占线
        /*else if(StringUtils.contains(result, "占线")) {
            return HANGUP_CAUSE_tonghuazhong.value;
        }*/
        //本地不需加0
        else if (StringUtils.containsAny(result, "本地", "加拨0", "本地不需加零")) {
            return HangupCause_WRONG_LOCAL;
        }
        //外地号码0
        else if (StringUtils.contains(result, "加拨0")) {
            return HangupCause_NON_LOCAL;
        }
        //通话被限制
        else if (StringUtils.containsAny(result, "被限制", "呼入限制")) {
            return HangupCause_RESTRICTED;
        }
        //未知
        else {
            return HangupCause_UNKNOWN;
        }
    }

}
