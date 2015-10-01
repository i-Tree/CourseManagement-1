package com.javen.excel;

import java.util.List;

import com.javen.db.DBhepler;
import com.javen.entity.StuEntity;
import com.javen.service.StuService;

/**
 * 
 */
public class TestExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<StuEntity> listExcel=StuService.getAllFromExcel("d://test.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllFromDb();*/
        
        DBhepler db=new DBhepler();
        
        for (StuEntity stuEntity :listExcel) {
            /*String grade=stuEntity.getGrade();*/
           /* if (!StuService.isExist(grade)) {*/
                //不存在就添加
                String sql="insert into course (grade,majar,majarnum,coursename,coursetype,credit,classhour,labhour,computerhour,date,teacher,notice) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                String[] str=new String[]{stuEntity.getGrade(),stuEntity.getMajar(),stuEntity.getMajarnum(),stuEntity.getCoursename(),stuEntity.getCoursetype(),stuEntity.getCredit(),stuEntity.getClasshour(),stuEntity.getLabhour(),stuEntity.getComputerhour(),stuEntity.getDate(),stuEntity.getTeacher(),stuEntity.getNotice()};
                db.AddUpdate(sql, str);
            /*}else {*/
                //存在就更新
                /*String sql="update course set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
                db.AddU(sql, str);*/
   
            }
        }
    }
