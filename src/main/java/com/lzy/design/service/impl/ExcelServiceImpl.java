package com.lzy.design.service.impl;

import com.lzy.design.constcode.TreatiseLevel;
import com.lzy.design.constcode.TreatiseType;
import com.lzy.design.exception.DataImportException;
import com.lzy.design.po.Person;
import com.lzy.design.po.Treatise;
import com.lzy.design.service.ExcelService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<Treatise> getTreatiseListFromExcel(InputStream inputStream) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        List<Treatise> treatiseList = new LinkedList<>();
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

            // XSSFRow 代表一行数据
            XSSFRow row = sheet.getRow(rowIndex);
            Treatise treatise = new Treatise();
            //获取单元格信息
            treatise.setTitle(row.getCell(0).getStringCellValue());
            treatise.setSubject(row.getCell(1).getStringCellValue());
            String level = row.getCell(2).getStringCellValue();
            int levelCode = 0;
            switch (level){
                case "EI": levelCode = TreatiseLevel.EI.getCode();break;
                case "SCI": levelCode = TreatiseLevel.SCI.getCode();break;
                case "核心刊": levelCode = TreatiseLevel.CORE.getCode();break;
                case "其他": levelCode = TreatiseLevel.OTHER.getCode();break;
                default: throw new DataImportException("论文级别错误");
            }
            treatise.setLevel(levelCode+"");
            String type = row.getCell(3).getStringCellValue();
            int typeCode = 0;
            switch (type){
                case "学位": typeCode = TreatiseType.DRGREE.getCode();break;
                case "期刊": typeCode = TreatiseType.JOURNALS.getCode();break;
                case "会议": typeCode = TreatiseType.MEETINGS.getCode();break;
                case "其他": typeCode = TreatiseType.OTHER.getCode();break;
                default: throw new DataImportException("论文类别错误");
            }
            treatise.setType(typeCode+"");
            row.getCell(4).setCellType(CellType.STRING);
            treatise.setYear(row.getCell(4).getStringCellValue());
            treatise.setIntroduction(row.getCell(5).getStringCellValue());

            ((LinkedList<Treatise>) treatiseList).addLast(treatise);
        }
        return treatiseList;
    }

    @Override
    public List<Person> getPersonListFromExcel(InputStream inputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        List<Person> personList = new LinkedList<>();
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

            // XSSFRow 代表一行数据
            XSSFRow row = sheet.getRow(rowIndex);

            Person person = new Person();
            //获取单元格信息
            person.setName(row.getCell(0).getStringCellValue());
            person.setIdcard(row.getCell(1).getStringCellValue());
            person.setPassword(row.getCell(2).getStringCellValue());
            person.setEmail(row.getCell(3).getStringCellValue());
            person.setPhone(row.getCell(4).getStringCellValue());
            person.setDegree(row.getCell(5).getStringCellValue());
            person.setDepartment(row.getCell(6).getStringCellValue());
            person.setPosition(row.getCell(7).getStringCellValue());
            person.setRole((int)row.getCell(8).getNumericCellValue());

            ((LinkedList<Person>) personList).addLast(person);
        }
        return personList;
    }
}
