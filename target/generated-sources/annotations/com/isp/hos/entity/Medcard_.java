package com.isp.hos.entity;

import com.isp.hos.entity.MedcardDiseases;
import com.isp.hos.entity.Patient;
import com.isp.hos.entity.PatientMeasures;
import com.isp.hos.entity.RecipeMedcard;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Medcard.class)
public class Medcard_ { 

    public static volatile SingularAttribute<Medcard, Integer> number;
    public static volatile SingularAttribute<Medcard, String> anamnesis;
    public static volatile CollectionAttribute<Medcard, PatientMeasures> patientMeasuresCollection;
    public static volatile CollectionAttribute<Medcard, Patient> patientCollection;
    public static volatile CollectionAttribute<Medcard, RecipeMedcard> recipeMedcardCollection;
    public static volatile SingularAttribute<Medcard, Integer> id;
    public static volatile SingularAttribute<Medcard, Date> dateOfIssue;
    public static volatile SingularAttribute<Medcard, Date> dateOfTheNextVisit;
    public static volatile SingularAttribute<Medcard, String> recommendations;
    public static volatile CollectionAttribute<Medcard, MedcardDiseases> medcardDiseasesCollection;
    public static volatile SingularAttribute<Medcard, Date> dateOfLastRequest;

}