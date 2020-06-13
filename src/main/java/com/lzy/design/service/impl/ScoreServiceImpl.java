package com.lzy.design.service.impl;

import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.constcode.ProjectLevel;
import com.lzy.design.constcode.TreatiseLevel;
import com.lzy.design.dto.book.BookCountDTO;
import com.lzy.design.dto.person.PersonScoreDTO;
import com.lzy.design.dto.project.ProjectCountDTO;
import com.lzy.design.dto.treatise.TreatiseCountDTO;
import com.lzy.design.mapper.BookMapper;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.mapper.ProjectMapper;
import com.lzy.design.mapper.TreatiseMapper;
import com.lzy.design.po.*;
import com.lzy.design.service.ScoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private TreatiseMapper treatiseMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<TreatiseCountDTO> getTreatiseCount(String year, int pId) {
        List<TreatiseCountDTO> treatiseCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            TreatiseCountDTO treatiseCountDTO = new TreatiseCountDTO();
            treatiseCountDTO.setYear(year);
            treatiseCountDTO.setEiCount(getTreatiseCountByType(year,pId,TreatiseLevel.EI.getCode()));
            treatiseCountDTO.setSciCount(getTreatiseCountByType(year,pId,TreatiseLevel.SCI.getCode()));
            treatiseCountDTO.setCoreCount(getTreatiseCountByType(year,pId,TreatiseLevel.CORE.getCode()));
            treatiseCountDTO.setCommonJournalCount(getTreatiseCountByType(year,pId,TreatiseLevel.COMMON_JOURNALS.getCode()));
            treatiseCountDTO.setOtherCount(getTreatiseCountByType(year,pId,TreatiseLevel.OTHER.getCode()));
            ((LinkedList<TreatiseCountDTO>) treatiseCountDTOList).addLast(treatiseCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                TreatiseCountDTO treatiseCountDTO = new TreatiseCountDTO();
                treatiseCountDTO.setYear(year);
                treatiseCountDTO.setEiCount(getTreatiseCountByType(year,pId,TreatiseLevel.EI.getCode()));
                treatiseCountDTO.setSciCount(getTreatiseCountByType(year,pId,TreatiseLevel.SCI.getCode()));
                treatiseCountDTO.setCoreCount(getTreatiseCountByType(year,pId,TreatiseLevel.CORE.getCode()));
                treatiseCountDTO.setCommonJournalCount(getTreatiseCountByType(year,pId,TreatiseLevel.COMMON_JOURNALS.getCode()));
                treatiseCountDTO.setOtherCount(getTreatiseCountByType(year,pId,TreatiseLevel.OTHER.getCode()));
                ((LinkedList<TreatiseCountDTO>) treatiseCountDTOList).addLast(treatiseCountDTO);
            }
        }
        return treatiseCountDTOList;
    }

    @Override
    public List<TreatiseCountDTO> getTreatiseTotalCount(String year) {
        List<TreatiseCountDTO> treatiseCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            TreatiseCountDTO treatiseCountDTO = new TreatiseCountDTO();
            treatiseCountDTO.setYear(year);
            treatiseCountDTO.setEiCount(getTreatiseTotalCountByType(year,TreatiseLevel.EI.getCode()));
            treatiseCountDTO.setSciCount(getTreatiseTotalCountByType(year,TreatiseLevel.SCI.getCode()));
            treatiseCountDTO.setCoreCount(getTreatiseTotalCountByType(year,TreatiseLevel.CORE.getCode()));
            treatiseCountDTO.setCommonJournalCount(getTreatiseTotalCountByType(year,TreatiseLevel.COMMON_JOURNALS.getCode()));
            treatiseCountDTO.setOtherCount(getTreatiseTotalCountByType(year,TreatiseLevel.OTHER.getCode()));
            ((LinkedList<TreatiseCountDTO>) treatiseCountDTOList).addLast(treatiseCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                TreatiseCountDTO treatiseCountDTO = new TreatiseCountDTO();
                treatiseCountDTO.setYear(year);
                treatiseCountDTO.setEiCount(getTreatiseTotalCountByType(year,TreatiseLevel.EI.getCode()));
                treatiseCountDTO.setSciCount(getTreatiseTotalCountByType(year,TreatiseLevel.SCI.getCode()));
                treatiseCountDTO.setCoreCount(getTreatiseTotalCountByType(year,TreatiseLevel.CORE.getCode()));
                treatiseCountDTO.setCommonJournalCount(getTreatiseTotalCountByType(year,TreatiseLevel.COMMON_JOURNALS.getCode()));
                treatiseCountDTO.setOtherCount(getTreatiseTotalCountByType(year,TreatiseLevel.OTHER.getCode()));
                ((LinkedList<TreatiseCountDTO>) treatiseCountDTOList).addLast(treatiseCountDTO);
            }
        }
        return treatiseCountDTOList;
    }

    @Override
    public List<ProjectCountDTO> getProjectCount(String year, int pId) {
        List<ProjectCountDTO> projectCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            ProjectCountDTO projectCountDTO = new ProjectCountDTO();
            projectCountDTO.setYear(year);
            projectCountDTO.setCountryCount(getProjectCountByType(year,pId, ProjectLevel.COUNTRY.getStatus()));
            projectCountDTO.setCityCount(getProjectCountByType(year,pId, ProjectLevel.CITY.getStatus()));
            projectCountDTO.setSchoolCount(getProjectCountByType(year,pId, ProjectLevel.SCHOOL.getStatus()));
            projectCountDTO.setOtherCount(getProjectCountByType(year,pId, ProjectLevel.OTHER.getStatus()));
            ((LinkedList<ProjectCountDTO>) projectCountDTOList).addLast(projectCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                ProjectCountDTO projectCountDTO = new ProjectCountDTO();
                projectCountDTO.setYear(year);
                projectCountDTO.setCountryCount(getProjectCountByType(year,pId, ProjectLevel.COUNTRY.getStatus()));
                projectCountDTO.setCityCount(getProjectCountByType(year,pId, ProjectLevel.CITY.getStatus()));
                projectCountDTO.setSchoolCount(getProjectCountByType(year,pId, ProjectLevel.SCHOOL.getStatus()));
                projectCountDTO.setOtherCount(getProjectCountByType(year,pId, ProjectLevel.OTHER.getStatus()));
                ((LinkedList<ProjectCountDTO>) projectCountDTOList).addLast(projectCountDTO);
            }
        }
        return projectCountDTOList;
    }

    @Override
    public List<ProjectCountDTO> getProjectTotalCount(String year) {
        List<ProjectCountDTO> projectCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            ProjectCountDTO projectCountDTO = new ProjectCountDTO();
            projectCountDTO.setYear(year);
            projectCountDTO.setCountryCount(getProjectTotalCountByType(year, ProjectLevel.COUNTRY.getStatus()));
            projectCountDTO.setCityCount(getProjectTotalCountByType(year,ProjectLevel.CITY.getStatus()));
            projectCountDTO.setSchoolCount(getProjectTotalCountByType(year, ProjectLevel.SCHOOL.getStatus()));
            projectCountDTO.setOtherCount(getProjectTotalCountByType(year, ProjectLevel.OTHER.getStatus()));
            ((LinkedList<ProjectCountDTO>) projectCountDTOList).addLast(projectCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                ProjectCountDTO projectCountDTO = new ProjectCountDTO();
                projectCountDTO.setYear(year);
                projectCountDTO.setCountryCount(getProjectTotalCountByType(year, ProjectLevel.COUNTRY.getStatus()));
                projectCountDTO.setCityCount(getProjectTotalCountByType(year,ProjectLevel.CITY.getStatus()));
                projectCountDTO.setSchoolCount(getProjectTotalCountByType(year, ProjectLevel.SCHOOL.getStatus()));
                projectCountDTO.setOtherCount(getProjectTotalCountByType(year, ProjectLevel.OTHER.getStatus()));
                ((LinkedList<ProjectCountDTO>) projectCountDTOList).addLast(projectCountDTO);
            }
        }
        return projectCountDTOList;
    }

    @Override
    public List<BookCountDTO> getBookCount(String year, int pId) {
        List<BookCountDTO> bookCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            BookCountDTO bookCountDTO = new BookCountDTO();
            bookCountDTO.setYear(year);
            BookExample example = new BookExample();
            example.createCriteria()
                    .andYearEqualTo(year)
                    .andPidEqualTo(pId)
                    .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
            bookCountDTO.setBookCount(bookMapper.countByExample(example));
            ((LinkedList<BookCountDTO>) bookCountDTOList).addLast(bookCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                BookCountDTO bookCountDTO = new BookCountDTO();
                bookCountDTO.setYear(year);
                BookExample example = new BookExample();
                example.createCriteria()
                        .andYearEqualTo(year)
                        .andPidEqualTo(pId)
                        .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
                bookCountDTO.setBookCount(bookMapper.countByExample(example));
                ((LinkedList<BookCountDTO>) bookCountDTOList).addLast(bookCountDTO);
            }
        }
        return bookCountDTOList;
    }

    @Override
    public List<BookCountDTO> getBookTotalCount(String year) {
        List<BookCountDTO> bookCountDTOList = new LinkedList<>();
        if (!StringUtils.isBlank(year)){
            BookCountDTO bookCountDTO = new BookCountDTO();
            bookCountDTO.setYear(year);
            BookExample example = new BookExample();
            example.createCriteria()
                    .andYearEqualTo(year)
                    .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
            bookCountDTO.setBookCount(bookMapper.countByExample(example));
            ((LinkedList<BookCountDTO>) bookCountDTOList).addLast(bookCountDTO);
        }else{
            for (int i=2016;i<2021;i++){
                year = i+"";
                BookCountDTO bookCountDTO = new BookCountDTO();
                bookCountDTO.setYear(year);
                BookExample example = new BookExample();
                example.createCriteria()
                        .andYearEqualTo(year)
                        .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus());
                bookCountDTO.setBookCount(bookMapper.countByExample(example));
                ((LinkedList<BookCountDTO>) bookCountDTOList).addLast(bookCountDTO);
            }
        }
        return bookCountDTOList;
    }


    @Override
    public List<PersonScoreDTO> getPersonScore(String year, String name) {

        List<PersonScoreDTO> personScoreDTOList = new LinkedList<>();
        List<Person> personList;

        if (StringUtils.isBlank(name)){
            personList = personMapper.selectByExample(new PersonExample());
        }else{
            PersonExample example = new PersonExample();
            example.createCriteria().andNameLike("%"+name+"%");
            personList = personMapper.selectByExample(example);
        }
        for (Person p: personList) {
            PersonScoreDTO personScoreDTO = new PersonScoreDTO();
            personScoreDTO.setYear(year);
            personScoreDTO.setPerson(p);
            personScoreDTO.setTreatiseCountDTOList(getTreatiseCount(year,p.getId()));
            personScoreDTO.setProjectCountDTOList(getProjectCount(year,p.getId()));
            personScoreDTO.setBookCountDTOList(getBookCount(year,p.getId()));
            ((LinkedList<PersonScoreDTO>) personScoreDTOList).addLast(personScoreDTO);
        }
        return personScoreDTOList;
    }

    @Override
    public List<PersonScoreDTO> getPersonScoreByPid(int pId) {

        List<PersonScoreDTO> personScoreDTOList = new LinkedList<>();

        Person person = personMapper.selectByPrimaryKey(pId);
        if (person == null){
            throw new RuntimeException();
        }
        PersonScoreDTO personScoreDTO = new PersonScoreDTO();
        personScoreDTO.setPerson(person);
        personScoreDTO.setTreatiseCountDTOList(getTreatiseCount("",person.getId()));
        personScoreDTO.setProjectCountDTOList(getProjectCount("",person.getId()));
        personScoreDTO.setBookCountDTOList(getBookCount("",person.getId()));
        ((LinkedList<PersonScoreDTO>) personScoreDTOList).addLast(personScoreDTO);

        return personScoreDTOList;
    }

    private long getTreatiseCountByType(String year, int pId, int levelCode){
        TreatiseExample example = new TreatiseExample();
        example.createCriteria()
                .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus())
                .andPIdEqualTo(pId)
                .andYearEqualTo(year)
                .andLevelEqualTo(levelCode+"");
        return treatiseMapper.countByExample(example);
    }

    private long getTreatiseTotalCountByType(String year,int levelCode){
        TreatiseExample example = new TreatiseExample();
        example.createCriteria()
                .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus())
                .andYearEqualTo(year)
                .andLevelEqualTo(levelCode+"");
        return treatiseMapper.countByExample(example);
    }

    private long getProjectCountByType(String year,int pId,int levelCode){
        ProjectExample example = new ProjectExample();
        example.createCriteria()
                .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus())
                .andYearEqualTo(year)
                .andPIdEqualTo(pId)
                .andLevelEqualTo(levelCode+"");
        return projectMapper.countByExample(example);
    }

    private long getProjectTotalCountByType(String year,int levelCode){
        ProjectExample example = new ProjectExample();
        example.createCriteria()
                .andAuditStatusEqualTo(AuditStatus.AUDIT_COMPLETE.getStatus())
                .andYearEqualTo(year)
                .andLevelEqualTo(levelCode+"");
        return projectMapper.countByExample(example);
    }
}
