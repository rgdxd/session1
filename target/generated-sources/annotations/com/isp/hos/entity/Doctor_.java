package com.isp.hos.entity;

import com.isp.hos.entity.MeasuserDoctor;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, Integer> passportNumber;
    public static volatile SingularAttribute<Doctor, String> patronymic;
    public static volatile SingularAttribute<Doctor, String> password;
    public static volatile SingularAttribute<Doctor, String> gender;
    public static volatile SingularAttribute<Doctor, String> surname;
    public static volatile SingularAttribute<Doctor, Date> dateOfBith;
    public static volatile SingularAttribute<Doctor, String> phonenumber;
    public static volatile SingularAttribute<Doctor, String> name;
    public static volatile SingularAttribute<Doctor, Integer> id;
    public static volatile SingularAttribute<Doctor, String> login;
    public static volatile SingularAttribute<Doctor, Integer> passportSeries;
    public static volatile CollectionAttribute<Doctor, MeasuserDoctor> measuserDoctorCollection;

}