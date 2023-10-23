package com.conference.management.talks;

/***
 * Clase Talks
 */
public class Talks {

    /***
     * id del talks
     */
    private int id;
    /***
     * title del talks
     */
    private  String title;
    /***
     * minutes del talks
     */
    private  int minutes;

    /***
     * Método constructor
     * @param id
     * @param minutes
     * @param title
     */
    public Talks(int id, int minutes, String title){
        this.id = id;
        this.minutes = minutes;
        this.title = title;
    }

    /***
     * Método get title
     * @return string title
     */
    public String getTitle() {
        return title;
    }

    /***
     * Método set title
     * @param title string
     */
    public void setTitle(String title){
        this.title = title;
    }

    /***
     * Método get minutes
     * @return int minutes
     */
    public int getMinutes() {
        return minutes;
    }

}
