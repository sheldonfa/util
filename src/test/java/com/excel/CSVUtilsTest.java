package com.excel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 22938 on 2017/6/25.
 */
public class CSVUtilsTest {


    @Test
    public void test1(){
        // 标题
        List<Object> title = new ArrayList<>();
        title.add("序号");
        title.add("名称");
        // columns
        List<Object> list = new ArrayList<>();
        String s1 = "1";
        String s2 = "张三";
        list.add(s1);
        list.add(s2);
        List<Object> list2 = new ArrayList<>();
        String s3 = "2";
        String s4 = "李四";
        list2.add(s3);
        list2.add(s4);
        List<List<Object>> columns = new ArrayList<>();
        columns.add(list);
        columns.add(list2);
        // tableDetail
        HashMap<String, Object> map = new HashMap<>();
        map.put("班主任","老王");
        // 赋值
        CSVUtils.createCSVFile(title,columns,"F:\\1工作\\3项目\\4测试项目\\util\\src\\test\\java\\com\\excel","bb");
    }

}
