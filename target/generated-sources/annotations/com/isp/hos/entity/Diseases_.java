package com.isp.hos.entity;

import com.isp.hos.entity.MedcardDiseases;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Diseases.class)
public class Diseases_ { 

    public static volatile SingularAttribute<Diseases, String> disease;
    public static volatile SingularAttribute<Diseases, Integer> id;
    public static volatile CollectionAttribute<Diseases, MedcardDiseases> medcardDiseasesCollection;

}