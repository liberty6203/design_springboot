package com.lzy.design.service;

import com.github.pagehelper.PageInfo;

public interface BookService {

    void addBook(int pId, String title, String publisher, String isbn, String year, String introduction);

    PageInfo listBook(int page, int limit, String title, boolean isPersonal, boolean isAuditing, boolean isBlocked);

    void removeBook(int bId);

    void updateBook(int bId, String title, String publisher, String isbn, String year, String introduction);

}
