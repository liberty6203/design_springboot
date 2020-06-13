package com.lzy.design.service;

import com.lzy.design.dto.book.BookCountDTO;
import com.lzy.design.dto.person.PersonScoreDTO;
import com.lzy.design.dto.project.ProjectCountDTO;
import com.lzy.design.dto.treatise.TreatiseCountDTO;

import java.util.List;

public interface ScoreService {

    List<TreatiseCountDTO> getTreatiseCount(String year, int pId);

    List<TreatiseCountDTO> getTreatiseTotalCount(String year);

    List<ProjectCountDTO> getProjectCount(String year, int pId);

    List<ProjectCountDTO> getProjectTotalCount(String year);

    List<BookCountDTO> getBookCount(String year, int pId);

    List<BookCountDTO> getBookTotalCount(String year);

    List<PersonScoreDTO> getPersonScore(String year,String name);

    List<PersonScoreDTO> getPersonScoreByPid(int pId);

}
