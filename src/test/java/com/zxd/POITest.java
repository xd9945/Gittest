package com.zxd;

import com.zxd.bean.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xudongzhou
 * @date 2022 -06 -09
 * @description
 */
public class POITest {
    /**
     *  1. 创建一个 xls  (2003)  xlsx (2007)
     *            HSSF操作 (2003)
     *            XSSF操作 (2007)
     */
    @Test
    public void demo01() throws IOException{
        //1.创建一个工作本
        Workbook wb = new HSSFWorkbook();
        //输出流
        FileOutputStream fos = new FileOutputStream(new File("a.xls"));

        wb.write(fos);
    }

    /**
     * 创建一个sheet
     *
     * 01 创建工作本
     * 02 创建一个sheet
     *
     * 03 把工作本写到文件中进行保存
     *
     */
    @Test
    public void demo02()throws IOException{
        Workbook wb = new HSSFWorkbook();

        //创建一个sheet
        Sheet sh1 = wb.createSheet("学生成绩");
        Sheet sh2 = wb.createSheet("我的好友");
        Sheet sh3 = wb.createSheet("我的学习计划");

        FileOutputStream fos = new FileOutputStream(new File("b.xls"));
        wb.write(fos);
    }

    /**
     * 通过对象  进行操作
     */
    @Test
    public void demo04() throws IOException {

        Workbook wb=new HSSFWorkbook();

        // 创建一个sheet
        Sheet sh1 = wb.createSheet("学生信息");

        // 第一行
        Row row = sh1.createRow(0);

        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("性别");
        row.createCell(2).setCellValue("手机");

        List<User> list = new ArrayList<>();

        User u1 = new User();
        u1.setRealName("乔峰");
        u1.setSex(1);
        u1.setPhone("1234");

        list.add(u1);

        User u2 = new User();
        u2.setRealName("聂小雨");
        u2.setSex(2);
        u2.setPhone("1234");

        list.add(u2);

        User u3 = new User();
        u3.setRealName("PDD");
        u3.setSex(1);
        u3.setPhone("1234");

        list.add(u3);

        for (int i = 0; i < list.size(); i++) {

            Row row1 = sh1.createRow(i + 1);
            User user = list.get(i);

            row1.createCell(0).setCellValue(user.getRealName());
            row1.createCell(1).setCellValue(user.getSex() ==1  ? "男":"女");
            row1.createCell(2).setCellValue(user.getPhone());
        }

        FileOutputStream fos = new FileOutputStream(new File("d.xls"));
        wb.write(fos);
    }
}
