package com.umg;
import com.umg.clases.Estudiante;
import com.umg.clases.Profesor;
import com.umg.clases.Asignatura;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Profesor p = new Profesor();

        Estudiante e1= new Estudiante();

        e1.setNombre("Aaron");
        e1.setEdad(20);
        e1.addMateria(new Asignatura("Matematica",90,5));
        e1.addMateria(new Asignatura("Español",91,5));
        e1.addMateria(new Asignatura("Seguridad",92,5));
        e1.addMateria(new Asignatura("Inteligencia",90,5));
        e1.addMateria(new Asignatura("Java",95,5));

        Estudiante e2= new Estudiante();

        e2.setNombre("Moises");
        e2.setEdad(25);
        e2.addMateria(new Asignatura("Matematica",95,5));
        e2.addMateria(new Asignatura("Español",99,5));
        e2.addMateria(new Asignatura("Seguridad",100,5));
        e2.addMateria(new Asignatura("Inteligencia",90,5));
        e2.addMateria(new Asignatura("Java",95,5));

        Estudiante e3= new Estudiante();

        e3.setNombre("Jessica");
        e3.setEdad(20);
        e3.addMateria(new Asignatura("Matematica",80,5));
        e3.addMateria(new Asignatura("Español",89,5));
        e3.addMateria(new Asignatura("Seguridad",85,5));
        e3.addMateria(new Asignatura("Inteligencia",88,5));
        e3.addMateria(new Asignatura("Java",90,5));

        Estudiante e4= new Estudiante();

        e4.setNombre("Eleazar");
        e4.setEdad(23);
        e4.addMateria(new Asignatura("Matematica",70,5));
        e4.addMateria(new Asignatura("Español",70,5));
        e4.addMateria(new Asignatura("Seguridad",70,5));
        e4.addMateria(new Asignatura("Inteligencia",70,5));
        e4.addMateria(new Asignatura("Java",70,5));

        Estudiante e5= new Estudiante();

        e5.setNombre("Otniel");
        e5.setEdad(19);
        e5.addMateria(new Asignatura("Matematica",95,5));
        e5.addMateria(new Asignatura("Español",95,5));
        e5.addMateria(new Asignatura("Seguridad",90,5));
        e5.addMateria(new Asignatura("Inteligencia",90,5));
        e5.addMateria(new Asignatura("Java",95,5));

        Estudiante e6= new Estudiante();

        e6.setNombre("Arauto");
        e6.setEdad(20);
        e6.addMateria(new Asignatura("Matematica",93,5));
        e6.addMateria(new Asignatura("Español",100,5));
        e6.addMateria(new Asignatura("Seguridad",80,5));
        e6.addMateria(new Asignatura("Inteligencia",90,5));
        e6.addMateria(new Asignatura("Java",95,5));

        p.addEstudiante(e1);
        p.addEstudiante(e2);
        p.addEstudiante(e3);
        p.addEstudiante(e4);
        p.addEstudiante(e5);
        p.addEstudiante(e6);

        System.out.println(p.estudianteMasDestacado().getNombre());
    }
}
