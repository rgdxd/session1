package com.isp.hos.entity;

import com.isp.hos.entity.PatientHospitalization;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Hospitalization.class)
public class Hospitalization_ { 

    public static volatile SingularAttribute<Hospitalization, Date> date;
    public static volatile SingularAttribute<Hospitalization, String> reason;
    public static volatile CollectionAttribute<Hospitalization, PatientHospitalization> patientHospitalizationCollection;
    public static volatile SingularAttribute<Hospitalization, Integer> id;

}