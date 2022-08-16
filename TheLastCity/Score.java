import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score;
    int dinero;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score(){
        //crear la imagen para el "Score" y "Dinero"
        setImage(new GreenfootImage("Score: " + score + "\n Dinero: "+ dinero +"$", 35, Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Score: " + score + "\n Dinero: "+ dinero+"$", 35, Color.BLACK, new Color(0,0,0,0)));
    }
}
