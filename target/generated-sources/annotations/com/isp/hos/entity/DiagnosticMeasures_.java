package com.isp.hos.entity;

import com.isp.hos.entity.MeasuserDoctor;
import com.isp.hos.entity.PatientMeasures;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(DiagnosticMeasures.class)
public class DiagnosticMeasures_ { 

    public static volatile SingularAttribute<DiagnosticMeasures, Date> date;
    public static volatile CollectionAttribute<DiagnosticMeasures, PatientMeasures> patientMeasuresCollection;
    public static volatile SingularAttribute<DiagnosticMeasures, Integer> id;
    public static volatile SingularAttribute<DiagnosticMeasures, String> type;
    public static volatile SingularAttribute<DiagnosticMeasures, String> title;
    public static volatile SingularAttribute<DiagnosticMeasures, String> recommendations;
    public static volatile CollectionAttribute<DiagnosticMeasures, MeasuserDoctor> measuserDoctorCollection;

}