package com.javen.service;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import com.javen.db.DBhepler;
import com.javen.entity.StuEntity;


public class StuService {
    /**
     * @return 
     */
    public static List<StuEntity> getAllFromDb(){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            DBhepler db=new DBhepler();
            String sql="select * from course";
            ResultSet rs= db.getAllinformation(sql, null);
            while (rs.next()) {
            	String grade=rs.getString("grade");
            	String majar=rs.getString("majar");
                String majarnum=rs.getString("majarnum");
                String coursename=rs.getString("coursename");
                String coursetype=rs.getString("coursetype");
                String credit=rs.getString("credit");
                String classhour=rs.getString("classhour");
                String labhour=rs.getString("labhour");
                String computerhour=rs.getString("computerhour");
                String date=rs.getString("date");
                String teacher=rs.getString("teacher");
                String notice=rs.getString("notice");

                
                list.add(new StuEntity(grade,majar,majarnum,coursename,coursetype,credit,classhour,labhour,computerhour,date,teacher,notice));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<StuEntity> getAllFromExcel(String file){
        List<StuEntity> list=new ArrayList<StuEntity>();
        try {
        	WorkbookSettings set=new WorkbookSettings();
        	set.setEncoding("UTF-8");
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String grade=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String majar=rs.getCell(j++, i).getContents();
                    String majarnum=rs.getCell(j++, i).getContents();
                    String coursename=rs.getCell(j++, i).getContents();
                    String coursetype=rs.getCell(j++, i).getContents();
                    String credit=rs.getCell(j++, i).getContents();
                    String classhour=rs.getCell(j++, i).getContents();
                    String labhour=rs.getCell(j++, i).getContents();
                    String computerhour=rs.getCell(j++, i).getContents();
                    String date=rs.getCell(j++, i).getContents();
                    String teacher=rs.getCell(j++, i).getContents();
                    String notice=rs.getCell(j++, i).getContents();
                    
                    System.out.println("grade=" +grade +", majar=" + majar + ", majarnum=" + majarnum +", coursename="+ coursename +",coursetype"+ coursetype +",credit="+credit+",classhour=" + classhour + ",labhour=" + labhour + ",computerhour=" + computerhour + ",date=" + date + ",teacher=" + teacher + ",notice=" + notice);
                    list.add(new StuEntity(grade,majar,majarnum,coursename,coursetype,credit,classhour,labhour,computerhour,date,teacher,notice));
                }
            } 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * @return
     */
    //以后用来完善功能
    /*public static boolean isExist(int grade){
        try {
            DBhepler db=new DBhepler();
            ResultSet rs=db.getAllinformation("select * from  where course=?", new String[]{grade+""});
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }*/
    
    public static void main(String[] args) {
        /*List<StuEntity> all=getAllFromDb();
        for (StuEntity stuEntity : all) {
            System.out.println(stuEntity.toString());
        }*/
        
        /*System.out.println(isExist(2012));*/
        
    }
    
}