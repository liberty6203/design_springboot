package com.lzy.design.dto.book;

import com.lzy.design.po.Book;
import com.lzy.design.po.BookAudit;
import com.lzy.design.po.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookAuditDetailDTO {
    private Book book;
    private Person person;
    private List<BookAudit> bookAuditList;
}
