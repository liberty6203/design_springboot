package com.lzy.design.controller;


import com.lzy.design.common.R;
import com.lzy.design.po.Person;
import com.lzy.design.po.Treatise;
import com.lzy.design.service.ExcelService;
import com.lzy.design.service.PersonService;
import com.lzy.design.service.TreatiseService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/Data")
@CrossOrigin(allowCredentials = "true")
public class DataController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private TreatiseService treatiseService;
    @Autowired
    private PersonService personService;


    @RequestMapping("TreatiseExcelDownload")
    public void downExcel(HttpServletResponse response) throws IOException {

        Resource resource = new ClassPathResource("/excel/TreatiseImport.xlsx");
        File file = resource.getFile();

        // 如果文件存在，则进行下载
        if (file.exists()) {
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("TreatiseImport.xlsx", "UTF-8"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            bis.close();
            fis.close();
        }
    }


    @RequestMapping("TreatiseImport")
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R treatiseImport(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<Treatise> treatiseList = excelService.getTreatiseListFromExcel(inputStream);
        treatiseService.multiAddTreatise(treatiseList);
        return R.ok();
    }

    @RequestMapping("PersonExcelDownload")
    public void PersonExcelDownload(HttpServletResponse response) throws IOException {

        Resource resource = new ClassPathResource("/excel/user.xlsx");
        File file = resource.getFile();
        // 如果文件存在，则进行下载
        if (file.exists()) {
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("user.xlsx", "UTF-8"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            bis.close();
            fis.close();
        }
    }
    @RequestMapping("PersonImport")
    @RequiresRoles(value = {"system_admin","department_admin"},logical = Logical.OR)
    public R PersonImport(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<Person> personList = excelService.getPersonListFromExcel(inputStream);
        personService.addPerson(personList);
        return R.ok();
    }
}
