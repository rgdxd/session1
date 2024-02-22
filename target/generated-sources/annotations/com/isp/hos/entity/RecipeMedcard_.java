package com.isp.hos.entity;

import com.isp.hos.entity.Medcard;
import com.isp.hos.entity.Recipe;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-09T11:51:19", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(RecipeMedcard.class)
public class RecipeMedcard_ { 

    public static volatile SingularAttribute<RecipeMedcard, Medcard> medcardId;
    public static volatile SingularAttribute<RecipeMedcard, Integer> id;
    public static volatile SingularAttribute<RecipeMedcard, Recipe> recipeId;

}