/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.isp.hos.gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 207380
 */
public class Hos {

    public EntityManager em;

    public static void main(String[] args) {
        new reg().setVisible(true);
    }

    public void Session() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.isp_hos_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

}
