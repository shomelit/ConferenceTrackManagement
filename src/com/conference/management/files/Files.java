
package com.conference.management.files;
import com.conference.management.configuration.Configuration;
import com.conference.management.talks.Talks;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/***
 * Clase Files: Encargada de leer el archivo txt
 */
public class Files {
    /***
     * String pathFile : ruta del archivo
     */
    private static String pathFile;

    /***
     * Método constructor de la clase
     */
    public Files(){
        pathFile = Configuration.FILE;
    }

    /***
     * Sobrecarga del método constructor
     * @param pathFile ruta del archivo
     */
    public Files(String pathFile){
        Files.pathFile = pathFile;
    }

    /***
     * Método get de pathFile
     * @return String pathFile
     */
    public static String getPathFile() {
        return pathFile;
    }

    /***
     * Método readFile: Encargado de leer el archivo
     * @return listado de Talks
     */
    public List<Talks> readFile(){
        List<Talks> trackTalks = new ArrayList<>();
        try{
            int id = 0, minutes;
            String nameFile = getPathFile();
            String lines,title,textMinutes,numMinutes;
            File file = new File(nameFile);
            FileInputStream fileStream = null;
            if (checkFileExists(file)) {
                if(checkTxtFile(nameFile)){
                    try {
                        fileStream = new FileInputStream(nameFile);
                        BufferedReader buff = new BufferedReader(new InputStreamReader(fileStream));
                        try{
                            System.out.println("Test Input");
                            System.out.println(" ");
                            while ((lines = buff.readLine())!= null){
                                if(!lines.contains("//") && !lines.isEmpty()){

                                    System.out.println(lines);
                                    id++;
                                    title = lines.substring(0,lines.lastIndexOf(" "));
                                    textMinutes = lines.substring(lines.lastIndexOf(" ")+ 1);
                                    numMinutes = lines.replaceAll("\\D+","");

                                    if("lightning".equalsIgnoreCase(textMinutes)){
                                        minutes = 5;
                                    }else{
                                        minutes = Integer.parseInt(numMinutes);
                                    }
                                    Talks talks = new Talks(id,minutes,title);
                                    trackTalks.add(talks);

                                }
                            }
                            System.out.println(" ");
                            if(id==0){
                                System.out.println("El archivo está vacio, por favor escriba datos y vuelva a intentar");
                            }
                            try {
                                buff.close();
                            } catch (Exception e) {
                                System.out.println("Ha ocurrido un error de buffer al intentar cerrar el archivo: "+ e.getMessage());
                            }
                        }catch (Exception e){
                            System.out.println("Ha ocurrido un error de buffer al intentar leer el archivo: "+ e.getMessage());
                        }
                    }catch (Exception e){
                        System.out.println("Ha ocurrido un error al intentar abrir el archivo: "+ e.getMessage());
                    }
                }else{
                    System.out.println("El archivo debe ser de tipo txt, por favor valide el archivo e intente de nuevo");
                }
            }else {
                System.out.println("No existe el archivo que desea procesar, por favor valide la ruta e intente de nuevo");
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al intentar leer el archivo: " + e.getMessage());
        }
        return trackTalks;
    }

    /***
     * Método checkFileExists: verifica si existe el archivo y es un directorio valido
     * @param file
     * @return boolean
     */
    public static boolean checkFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    /***
     * Método checkTxtFile: Verifica que la extensión del archivo sea un txt
     * @param file ruta y nombre del archivo
     * @return boolean
     */
    public static boolean checkTxtFile(String file){
        return (file.substring((file.lastIndexOf(".") + 1)).equalsIgnoreCase("txt"));
    }

}






























