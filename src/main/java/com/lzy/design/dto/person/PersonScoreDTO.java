package com.lzy.design.dto.person;

import com.lzy.design.dto.book.BookCountDTO;
import com.lzy.design.dto.project.ProjectCountDTO;
import com.lzy.design.dto.treatise.TreatiseCountDTO;
import com.lzy.design.po.Person;

import java.util.List;

public class PersonScoreDTO {


    private Person person;
    private String year;
    private List<TreatiseCountDTO> treatiseCountDTOList;
    private List<ProjectCountDTO> projectCountDTOList;
    private List<BookCountDTO> bookCountDTOList;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<TreatiseCountDTO> getTreatiseCountDTOList() {
        return treatiseCountDTOList;
    }

    public void setTreatiseCountDTOList(List<TreatiseCountDTO> treatiseCountDTOList) {
        this.treatiseCountDTOList = treatiseCountDTOList;
    }

    public List<ProjectCountDTO> getProjectCountDTOList() {
        return projectCountDTOList;
    }

    public void setProjectCountDTOList(List<ProjectCountDTO> projectCountDTOList) {
        this.projectCountDTOList = projectCountDTOList;
    }

    public List<BookCountDTO> getBookCountDTOList() {
        return bookCountDTOList;
    }

    public void setBookCountDTOList(List<BookCountDTO> bookCountDTOList) {
        this.bookCountDTOList = bookCountDTOList;
    }
}
