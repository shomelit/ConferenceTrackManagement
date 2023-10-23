package com.conference.management;

import com.conference.management.conference.Conference;
import com.conference.management.files.Files;
import com.conference.management.talks.Talks;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static String menu(){
        Scanner read = new Scanner (System.in);
        String option;
        do {
            System.out.println("╔═════════════════════════════════════════════════════════╗");
            System.out.println("║                                                         ║");
            System.out.println("║              CONFERENCE TRACK MANAGEMENT                ║");
            System.out.println("╠═════════════════════════════════════════════════════════╣");
            System.out.println("║                                                         ║");
            System.out.println("║          Seleccione una opción de procesamiento:        ║");
            System.out.println("║          1) Archivo precargado                          ║");
            System.out.println("║          2) Cargar nuevo archivo                        ║");
            System.out.println("║          0) Salir                                       ║");
            System.out.println("║                                                         ║");
            System.out.println("╚═════════════════════════════════════════════════════════╝");
            System.out.println("Ingrese el número de opción para comenzar: ");

            option = read.next();
            if(!option.equals("0") && !option.equals("1") && !option.equals("2")){
                System.out.println("Opción no valida. Por favor verifique e intente nuevamente:");
            }else {
                switch (option){
                    case "0":
                        System.out.println("Hasta Luego.");
                        break;
                    case "1":
                    case "2":
                        Files files;
                        if(option.equals("1")){
                            files = new Files();
                        }else{
                            System.out.println("Ingrese el path y nombre del archivo a leer (Ejemplo: C:\\Users\\AdaLovelace\\Downloads\\TestInput.txt");
                            String path = read.next();
                            files = new Files(path);
                        }
                        List<Talks> list2 = files.readFile();
                        Conference confer = new Conference(list2);
                        confer.createConference();
                        menu();
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
            }
        } while (!option.equals("0") && !option.equals("1") && !option.equals("2"));
        return option;
    }
}
