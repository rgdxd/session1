package com.isp.hos.entity;

import com.isp.hos.entity.RecipeMedcard;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Recipe.class)
public class Recipe_ { 

    public static volatile SingularAttribute<Recipe, String> receptionFormat;
    public static volatile SingularAttribute<Recipe, String> medication;
    public static volatile CollectionAttribute<Recipe, RecipeMedcard> recipeMedcardCollection;
    public static volatile SingularAttribute<Recipe, Integer> id;

}