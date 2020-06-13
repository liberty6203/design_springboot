package com.lzy.design;

import com.github.pagehelper.PageInfo;
import com.lzy.design.constcode.AuditOpinion;
import com.lzy.design.constcode.AuditStatus;
import com.lzy.design.constcode.RoleCode;
import com.lzy.design.constcode.TreatiseLevel;
import com.lzy.design.dto.person.PersonDTO;
import com.lzy.design.dto.person.PersonScoreDTO;
import com.lzy.design.dto.treatise.TreatiseCountDTO;
import com.lzy.design.mapper.PersonMapper;
import com.lzy.design.mapper.ProjectMapper;
import com.lzy.design.mapper.TreatiseMapper;
import com.lzy.design.mapstructConverter.person.PersonDtoMapper;
import com.lzy.design.po.*;
import com.lzy.design.service.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonDtoMapper personDtoMapper;

    @Autowired
    private TreatiseAuditService treatiseAuditService;

    @Autowired
    private TreatiseMapper treatiseMapper;

    @Autowired
    TreatiseService treatiseService;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectAuditService projectAuditService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuditService bookAuditService;

    @Test
    void contextLoads() {
//        PersonExample example = new PersonExample();
//
//        PersonExample.Criteria criteria = example.createCriteria();
//        criteria.andIdcardEqualTo("210102199801256910")
//                .andPasswordEqualTo("111111");
//        List<Person> people = personMapper.selectByExample(example);
//        System.out.println(people.get(0).getEmail());
//        PersonDTO dto = personDtoMapper.toDto(people.get(0));
//
//        System.out.println(dto.getIdcard());

//        TreatiseExample example = new TreatiseExample();
//        TreatiseExample.Criteria criteria = example.createCriteria();
//        criteria.andTitleLike("%题目3%");
//        List<Treatise> treatises = treatiseMapper.selectByExample(example);
//        System.out.println(treatises.size());


    }

    @Test
    public void testPageHelper(){
//        System.out.println(treatiseAuditService.listTreatiseNeedAudit(1,20).toString());
//        PageInfo info = personService.getPersonInfo(1, 10, "李");
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("张三");
        person.setRole(RoleCode.USER.getRoleCode());
        person.setPosition("教授");
        person.setDepartment("计算机学院");
        person.setPhone("13811111111");
        person.setEmail("1@qq.com");
        person.setPassword("111111");
        person.setDegree("博士");
        person.setIdcard("130101199001011110");
        personList.add(person);
        Person person2 = new Person();
        person2.setName("李四");
        person2.setRole(RoleCode.USER.getRoleCode());
        person2.setPosition("教授");
        person2.setDepartment("计算机学院");
        person2.setPhone("13811111111");
        person2.setEmail("1@qq.com");
        person2.setPassword("111111");
        person2.setDegree("博士");
        person2.setIdcard("140101199001011110");
        personList.add(person2);
        Person person3 = new Person();
        person3.setName("王二麻子");
        person3.setRole(RoleCode.USER.getRoleCode());
        person3.setPosition("教授");
        person3.setDepartment("计算机学院");
        person3.setPhone("13811111111");
        person3.setEmail("1@qq.com");
        person3.setPassword("111111");
        person3.setDegree("博士");
        person3.setIdcard("140102199001011110");
        personList.add(person3);

        personService.addPerson(personList);
    }


    @Test
    public void initData() throws ParseException {

        for (int i = 1; i < 10; i++) {
            Project project = new Project();
            project.setpId(3);
            project.setAuditStatus(0);
            project.setCreateTime(new Date());
            project.setDepartment("计算机学院");
            project.setEndTime(DateUtils.parseDate("2020-07-04","yyyy-MM-dd"));
            project.setLevel(((int)(Math.random()*3)+1)+"");
            project.setMoney(2000f);
            project.setStartTime(DateUtils.parseDate("2020-06-04","yyyy-MM-dd"));
            project.setSubject("计算机");
            project.setTitle("3的项目课题"+i);
            project.setUpdateTime(new Date());
            projectMapper.insertSelective(project);
        }

    }

    @Test
    public void testScoreService(){
//        List<TreatiseCountDTO> treatiseCountDTOList = scoreService.getTreatiseTotalCount("");
//        System.out.println(treatiseCountDTOList);

        for (int i=0;i<500;i++){
//            treatiseService.addTreatise((int)(Math.random()*6+1),"题目"+i,((int)(Math.random()*4+0))+"",((int)(Math.random()*5+1))+"","计算机",((int)(Math.random()*5+2016))+"","简介");
//            treatiseAuditService.treatiseAudit(151+i, AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
//            treatiseAuditService.treatiseAudit(151+i, AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
//            projectService.addProject(getRandom(6,1),"项目名称"+i,"计算机","计算机学院",getRandom(4,1)+"",20000f,new Date(),new Date(),getRandom(5,2016)+"","这是一段简介");
//            projectAuditService.projectAudit(120+i,AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
//            projectAuditService.projectAudit(120+i,AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
//            bookService.addBook(getRandom(6,1),"书名"+i,"出版社","isbn465456"+getRandom(46546,31213),getRandom(5,2016)+"","简介");
            bookAuditService.bookAudit(4+i,AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
            bookAuditService.bookAudit(4+i,AuditOpinion.AUDIT_PASS.getAuditStatus(),"审核通过");
        }
    }


    public static int getRandom(int limit,int start){
        return ((int)(Math.random()*limit+start));
    }
}
