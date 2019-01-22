/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Calendar;
import model.Alumno;
import model.Nombre;
import model.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Alumno alum1 = new Alumno(1, "Josh", (float) 1500, false, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "No el conec");
        Profesor prof1=new Profesor(1,new Nombre("Maite","Chirivella","Quesada"));

// CREAMOS UN OBJETO
        //Profesor profesor=new Profesor(7,"Pepe","Garcia","Perez");

        //CREAR UNA SESION
        Session session = factory.openSession();
        session.beginTransaction();

        //GUARDAR OBJETO
        session.saveOrUpdate(alum1);
        session.saveOrUpdate(prof1);

        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();

    }

}
