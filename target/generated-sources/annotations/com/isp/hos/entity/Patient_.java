package com.isp.hos.entity;

import com.isp.hos.entity.Medcard;
import com.isp.hos.entity.PatientHospitalization;
import com.isp.hos.entity.Policy;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, Integer> passportNumber;
    public static volatile SingularAttribute<Patient, String> address;
    public static volatile SingularAttribute<Patient, String> gender;
    public static volatile SingularAttribute<Patient, Date> dateOfBith;
    public static volatile SingularAttribute<Patient, String> phonenumber;
    public static volatile SingularAttribute<Patient, String> photo;
    public static volatile SingularAttribute<Patient, Integer> passportSeries;
    public static volatile SingularAttribute<Patient, String> patronymic;
    public static volatile SingularAttribute<Patient, Medcard> medcardId;
    public static volatile SingularAttribute<Patient, Policy> policyId;
    public static volatile SingularAttribute<Patient, String> surname;
    public static volatile CollectionAttribute<Patient, PatientHospitalization> patientHospitalizationCollection;
    public static volatile SingularAttribute<Patient, String> name;
    public static volatile SingularAttribute<Patient, Integer> id;
    public static volatile SingularAttribute<Patient, String> email;

}