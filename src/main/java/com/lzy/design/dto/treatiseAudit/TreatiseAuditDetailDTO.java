package com.lzy.design.dto.treatiseAudit;

import com.lzy.design.po.Person;
import com.lzy.design.po.Treatise;
import com.lzy.design.po.TreatiseAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TreatiseAuditDetailDTO {

    private Treatise treatise;
    private Person person;
    private List<TreatiseAudit> treatiseAuditList;

}
