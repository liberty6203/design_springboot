package com.lzy.design.mapper;

import com.lzy.design.po.BookAudit;
import com.lzy.design.po.BookAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuditMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    long countByExample(BookAuditExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    int deleteByExample(BookAuditExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    int insert(BookAudit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    int insertSelective(BookAudit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    List<BookAudit> selectByExample(BookAuditExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") BookAudit record, @Param("example") BookAuditExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_audit
     *
     * @mbg.generated Mon May 18 16:32:01 CST 2020
     */
    int updateByExample(@Param("record") BookAudit record, @Param("example") BookAuditExample example);
}