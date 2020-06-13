package com.lzy.design.dto.projectAudit;

import com.lzy.design.po.Person;
import com.lzy.design.po.Project;
import com.lzy.design.po.ProjectAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectAuditDetailDTO {
    private Project project;
    private Person person;
    private List<ProjectAudit> projectAuditList;
}
