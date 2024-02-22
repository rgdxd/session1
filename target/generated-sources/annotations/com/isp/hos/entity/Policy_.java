package com.isp.hos.entity;

import com.isp.hos.entity.Patient;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Policy.class)
public class Policy_ { 

    public static volatile SingularAttribute<Policy, Integer> number;
    public static volatile SingularAttribute<Policy, Date> endDate;
    public static volatile CollectionAttribute<Policy, Patient> patientCollection;
    public static volatile SingularAttribute<Policy, Integer> id;

}