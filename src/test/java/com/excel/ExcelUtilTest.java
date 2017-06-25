package com.excel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 22938 on 2017/6/25.
 */
public class ExcelUtilTest {


    @Test
    public void test1(){
        ExcelUtils.ExcelExportData exportData = new ExcelUtils.ExcelExportData();
        // 标题
        String[] title = {"序号", "名称"};
        // columns
        List<String[]> list = new ArrayList<>();
        String[] s1 = new String[]{"1","张三"};
        String[] s2 = new String[]{"2","李四"};
        list.add(s1);
        list.add(s2);
        // tableDetail
        HashMap<String, Object> map = new HashMap<>();
        map.put("班主任","老王");
        // 赋值
        exportData.setTitles(title);
        exportData.setColumns(list);
        exportData.setTableDetail(map);
        Map<String,ExcelUtils.ExcelExportData> data = new HashMap<>();
        data.put("aaa",exportData);
        String path = ExcelUtils.exportExcelFile("F:\\1工作\\3项目\\4测试项目\\util\\src\\test\\java\\com\\excel", "aa", data);
        System.out.println(path);
    }

}
