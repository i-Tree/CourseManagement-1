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
        //�õ���������е�����
        List<StuEntity> listExcel=StuService.getAllFromExcel("d://test.xls");
        /*//�õ����ݿ�������е�����
        List<StuEntity> listDb=StuService.getAllFromDb();*/
        
        DBhepler db=new DBhepler();
        
        for (StuEntity stuEntity :listExcel) {
            /*String grade=stuEntity.getGrade();*/
           /* if (!StuService.isExist(grade)) {*/
                //�����ھ����
                String sql="insert into course (grade,majar,majarnum,coursename,coursetype,credit,classhour,labhour,computerhour,date,teacher,notice) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                String[] str=new String[]{stuEntity.getGrade(),stuEntity.getMajar(),stuEntity.getMajarnum(),stuEntity.getCoursename(),stuEntity.getCoursetype(),stuEntity.getCredit(),stuEntity.getClasshour(),stuEntity.getLabhour(),stuEntity.getComputerhour(),stuEntity.getDate(),stuEntity.getTeacher(),stuEntity.getNotice()};
                db.AddUpdate(sql, str);
            /*}else {*/
                //���ھ͸���
                /*String sql="update course set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
                db.AddU(sql, str);*/
   
            }
        }
    }
