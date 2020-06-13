package com.lzy.design.service;

import com.lzy.design.po.Person;
import com.lzy.design.po.Treatise;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ExcelService {

    List<Treatise> getTreatiseListFromExcel(InputStream inputStream) throws IOException;

    List<Person> getPersonListFromExcel(InputStream inputStream) throws IOException;

}
