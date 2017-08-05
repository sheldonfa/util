package com.createdata;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 22938 on 2017/8/3.
 */
public class CreateDataUtil {
    public static String[]                          chars      = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2",
            "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    public static String generateShortUUID() {
        return (UUID.randomUUID().toString()).substring(0,36-1);
    }
    public static String getTTaskStr() throws IOException {
        StringBuffer sb = new StringBuffer("INSERT INTO `t_task` (`id_`, `company_id`, `task_name`, `description_`, `start_time`, `end_time`, `calling_no`, `robot_id`, `knowledge_domain`, `dispatch_type`, `dispatch_id`, `task_type`, `status_`, `create_time`, `user_id`, `update_user_id`, `update_time`, `status_extend`, `status_cause`, `finish_time`, `analysisFinishTime`, `is_delete`, `businessId`, `businessCode`, `robotFlowId`, `jobTotalCount`, `jobFinishCount`, `jobConnectCount`, `businessFlowId`) VALUES (");
        Random randGen = new Random();
        randGen.nextInt();
        String taskId = generateShortUUID();
        String company_id  = "37";
        String task_name  = "承保回访-20170601-9";
        String description_  =  "";
        String  start_time = "2017-07-10 16:26:20";
        String  end_time = "2017-07-10 16:26:20";
        String  calling_no = "E1";
        String robot_id  =  "NULL";
        String knowledge_domain  =  "NULL";
        String dispatch_type = String.valueOf(randGen.nextInt(3)+1);
        String dispatch_id = String.valueOf(randGen.nextInt(200)+100);
        String task_type = "1";
        String status_ = String.valueOf(randGen.nextInt(4)+1);
        String create_time =  "2017-07-10 16:26:20";
        String  user_id = "138";
        String update_user_id = "138";
        String update_time  = "2017-07-10 16:26:20";
        String status_extend = String.valueOf(randGen.nextInt(2)+2);
        String status_cause  = "";
        String  finish_time = "2017-07-10 16:26:20";
        String analysisFinishTime  = "2017-07-10 16:26:20";
        String is_delete  = "0";
        String businessId  = String.valueOf(randGen.nextInt(36)+1);
        String businessCode  = "59215" +String.valueOf(randGen.nextInt(3))+String.valueOf(randGen.nextInt(9))+"0";
        String robotFlowId  = String.valueOf(randGen.nextInt(500)+1);
        String jobTotalCount = "0";
        String jobFinishCount =  "0";
        String jobConnectCount =  "0";
        String businessFlowId  =  "NULL";

        sb.append("'").append(taskId).append("',")
                .append("'").append(company_id).append("',")
                .append("'").append(task_name).append("',")
                .append("'").append(description_).append("',")
                .append("'").append(start_time).append("',")
                .append("'").append(end_time).append("',")
                .append("'").append(calling_no).append("',")
                .append(robot_id).append(",")
                .append(knowledge_domain).append(",")
                .append("'").append(dispatch_type).append("',")
                .append("'").append(dispatch_id).append("',")
                .append("'").append(task_type).append("',")
                .append("'").append(status_).append("',")
                .append("'").append(create_time).append("',")
                .append("'").append(user_id).append("',")
                .append("'").append(update_user_id).append("',")
                .append("'").append(update_time).append("',")
                .append("'").append(status_extend).append("',")
                .append("'").append(status_cause).append("',")
                .append("'").append(finish_time).append("',")
                .append("'").append(analysisFinishTime).append("',")
                .append("'").append(is_delete).append("',")
                .append("'").append(businessId).append("',")
                .append("'").append(businessCode).append("',")
                .append("'").append(robotFlowId).append("',")
                .append("'").append(jobTotalCount).append("',")
                .append("'").append(jobFinishCount).append("',")
                .append("'").append(jobConnectCount).append("',")
                .append(businessFlowId).append(");\r\n");


        StringBuffer sbTD = new StringBuffer("INSERT INTO `t_task_details` (`id`, `parentId`, `company_id`, `task_id`, `calling_no`, `businessId`, `transferUri`, `type`, `prefix`, `phone`, `name`, `sex`, `city`, `job_status`, `call_success`, `answer`, `outcall_status`, `robotFlowId`, `lineInfoParam`, `info`, `businessInfo`, `outcall_count`, `create_time`, `update_time`, `next_time`, `call_time`, `complete`, `complete2`, `call_duration`, `conclution_code`, `conclution`, `conclution_consuming`, `call_failure_cause`, `remark`) VALUES (");
        String tdId = generateShortUUID();
        String parentId  =  "NULL";
        String transferUri = "59215" +String.valueOf(randGen.nextInt(3))+String.valueOf(randGen.nextInt(9))+"0";
        String type  =  "NULL";
        String prefix  =  "NULL";
        String phone  =  "13683335555";
        String name = "zhu";
        String sex = "1";
        String city = "北京,北京";
        String job_status =  String.valueOf(randGen.nextInt(5));
        String call_success =String.valueOf(randGen.nextInt(3));
        String answer = String.valueOf(randGen.nextInt(2));
        String outcall_status =String.valueOf("UserWill_Accepted");
        String lineInfoParam = "XXX";
        String info = "xxxx";
        String businessInfo = "";
        String outcall_count =  String.valueOf(randGen.nextInt(2));
        String next_time = "NULL";
        String call_time =  "2017-07-10 16:26:20";
        String complete = "0";
        String complete2 = "0";
        String call_duration = "44600";
        String conclution_code = "NULL";
        String conclution = "NULL";
        String conclution_consuming = "NULL";
        String call_failure_cause = "NULL";
        String remark = "NULL";


        sbTD.append("'").append(tdId).append("',")
                .append(parentId).append(",")
                .append("'").append(company_id).append("',")
                .append("'").append(taskId).append("',")
                .append("'").append(calling_no).append("',")
                .append("'").append(businessId).append("',")
                .append("'").append(transferUri).append("',")
                .append(type).append(",")
                .append(prefix).append(",")
                .append("'").append(phone).append("',")
                .append("'").append(name).append("',")
                .append("'").append(sex).append("',")
                .append("'").append(city).append("',")
                .append("'").append(job_status).append("',")
                .append("'").append(call_success).append("',")
                .append("'").append(answer).append("',")
                .append("'").append(outcall_status).append("',")
                .append("'").append(robotFlowId).append("',")
                .append("'").append(lineInfoParam).append("',")
                .append("'").append(info).append("',")
                .append("'").append(businessInfo).append("',")
                .append("'").append(outcall_count).append("',")
                .append("'").append(create_time).append("',")
                .append("'").append(update_time).append("',")
                .append(next_time).append(",")
                .append("'").append(call_time).append("',")
                .append("'").append(complete).append("',")
                .append("'").append(complete2).append("',")
                .append("'").append(call_duration).append("',")
                .append(conclution_code).append(",")
                .append(conclution).append(",")
                .append(conclution_consuming).append(",")
                .append(call_failure_cause).append(",")
                .append(remark).append(");\r\n");


        StringBuffer sbCall = new StringBuffer("INSERT INTO `call` (`id`, `call_id`, `fsId`, `task`, `campaign`, `job_id`, `companyId`, `state`, `isOutbound`, `answer`, `complete`, `complete2`, `begin_timestamp`, `end_timestamp`, `call_duration`, `answer_duration`, `recordSize`, `maxSilence`, `dialogRound`, `isTransfer`, `isLanjie`, `isService`, `enterpriseId`, `transferEnterprise`, `lanjieFlag`, `user_will`, `province`, `city`, `outbound`, `transfer`, `input`, `output`, `bleg_id`, `hangup_cause`, `asr_result`, `asr_hangup`, `content`, `is_filed`, `remark`, `speechStage`, `is_master`, `notify_success`, `is_bussy`, `isInteract`, `isReview`, `reviewUserId`, `reviewUserName`, `isSuccess`, `robotFlowId`, `asrLabelResult`, `asrLabelUser`, `nluLabelResult`, `nluLabelUser`, `audioChecked`) VALUES (");
        String callId = generateShortUUID();
        String call_id  =  "";
        String fsId = "";
        String task  =  tdId;
        String campaign  =  "";
        String job_id  =  "";
        String companyId  =  "37";
        String state  =  "";
        String isOutbound  =   String.valueOf(randGen.nextInt(2));
        String begin_timestamp  =  "1496219610405";
        String end_timestamp  =  "1496219610405";
        String answer_duration  =  "0";
        String recordSize  =  "0";
        String maxSilence  =  String.valueOf(randGen.nextInt(7));
        String dialogRound  =  String.valueOf(randGen.nextInt(21));
        String isTransfer  =  "0";
        String isLanjie  =  "0";
        String isService  =  "0";
        String enterpriseId  =  "";
        String transferEnterprise  =  "";
        String lanjieFlag  =  "";
        String user_will  =  "UserWill_NotSure";
        String province  =  "北京";
        String outbound  =  "18514254195";
        String transfer  =  "59215100";
        String input  =  "XXX";
        String output  =  "xxx";
        String bleg_id  =  "";
        String hangup_cause  =  "NORMAL_CLEARING";
        String asr_result  =  "无录音";
        String asr_hangup  =  "HangupCause_UNKNOWN";
        String content  =  "aaaaaa";
        String is_filed  =  "0";
        String speechStage  =  "0";
        String is_master  =  "0";
        String notify_success  =  "0";
        String is_bussy  =  "0";
        String isInteract  =  "0";
        String isReview  =  "0";
        String reviewUserId  =  "0";
        String reviewUserName  =  "0";
        String isSuccess  =  "0";
        String asrLabelResult  = String.valueOf(randGen.nextInt(8 ));
        String asrLabelUser  =  "0";
        String nluLabelResult  =  "0";
        String nluLabelUser  =  "0";
        String audioChecked  =  "0";


        sbCall.append("'").append(callId).append("',")
                .append("'").append(call_id).append("',")
                .append("'").append(fsId).append("',")
                .append("'").append(task).append("',")
                .append("'").append(campaign).append("',")
                .append("'").append(job_id).append("',")
                .append("'").append(companyId).append("',")
                .append("'").append(state).append("',")
                .append("'").append(isOutbound).append("',")
                .append("'").append(answer).append("',")
                .append("'").append(complete).append("',")
                .append("'").append(complete2).append("',")
                .append("'").append(begin_timestamp).append("',")
                .append("'").append(end_timestamp).append("',")
                .append("'").append(call_duration).append("',")
                .append("'").append(answer_duration).append("',")
                .append("'").append(recordSize).append("',")
                .append("'").append(maxSilence).append("',")
                .append("'").append(dialogRound).append("',")
                .append("'").append(isTransfer).append("',")
                .append("'").append(isLanjie).append("',")
                .append("'").append(isService).append("',")
                .append("'").append(enterpriseId).append("',")
                .append("'").append(transferEnterprise).append("',")
                .append("'").append(lanjieFlag).append("',")
                .append("'").append(user_will).append("',")
                .append("'").append(province).append("',")
                .append("'").append(city).append("',")
                .append("'").append(outbound).append("',")
                .append("'").append(transfer).append("',")
                .append("'").append(input).append("',")
                .append("'").append(output).append("',")
                .append("'").append(bleg_id).append("',")
                .append("'").append(hangup_cause).append("',")
                .append("'").append(asr_result).append("',")
                .append("'").append(asr_hangup).append("',")
                .append("'").append(content).append("',")
                .append("'").append(is_filed).append("',")
                .append("'").append(remark).append("',")
                .append("'").append(speechStage).append("',")
                .append("'").append(is_master).append("',")
                .append("'").append(notify_success).append("',")
                .append("'").append(is_bussy).append("',")
                .append("'").append(isInteract).append("',")
                .append("'").append(isReview).append("',")
                .append("'").append(reviewUserId).append("',")
                .append("'").append(reviewUserName).append("',")
                .append("'").append(isSuccess).append("',")
                .append("'").append(robotFlowId).append("',")
                .append("'").append(asrLabelResult).append("',")
                .append("'").append(asrLabelUser).append("',")
                .append("'").append(nluLabelResult).append("',")
                .append("'").append(nluLabelUser).append("',")
                .append("'").append(audioChecked).append("');\r\n");

        return sb.append(sbTD).append(sbCall).toString();

    }
    public static void main(String[] args) {
        String dirPath = "F:\\1工作\\3项目\\4测试项目\\util\\src\\main\\java\\com\\createdata";
        Integer num = 3000000;
        createSql(dirPath,num);
    }

    private static void createSql(String dirPath,Integer count) {
        try {
            File dir = new File(dirPath);
            // 清除file，重新创建
            if (dir.exists()) {
                if(dir.isDirectory()){
                    String name = Long.toString(new Date().getTime());
                    File file = new File(dir.getPath() + "/" + name);
                    file.createNewFile();
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                        for (int i = 0; i < count; i++) {
                            bw.write(getTTaskStr());
                        }
                        bw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else {
                System.out.println("没有这个文件夹");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
