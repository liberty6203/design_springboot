package com.lzy.design.dto.book;

public class BookCountDTO {

    private String year;

    private long bookCount;

    private long bookScore;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }

    public long getBookScore() {
        bookScore = bookCount*15;
        return bookScore;
    }
}
