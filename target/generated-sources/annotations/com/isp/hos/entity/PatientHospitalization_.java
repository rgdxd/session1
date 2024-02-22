package com.isp.hos.entity;

import com.isp.hos.entity.Hospitalization;
import com.isp.hos.entity.Patient;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PatientHospitalization.class)
public class PatientHospitalization_ { 

    public static volatile SingularAttribute<PatientHospitalization, Hospitalization> hospitalizationId;
    public static volatile SingularAttribute<PatientHospitalization, Patient> patientId;
    public static volatile SingularAttribute<PatientHospitalization, Integer> id;

}