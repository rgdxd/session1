package com.isp.hos.entity;

import com.isp.hos.entity.DiagnosticMeasures;
import com.isp.hos.entity.Doctor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(MeasuserDoctor.class)
public class MeasuserDoctor_ { 

    public static volatile SingularAttribute<MeasuserDoctor, Doctor> doctorId;
    public static volatile SingularAttribute<MeasuserDoctor, Integer> id;
    public static volatile SingularAttribute<MeasuserDoctor, DiagnosticMeasures> measuserId;

}