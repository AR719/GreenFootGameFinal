import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CodeBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodeBullet extends Actor
{
    /**
     * Act - do whatever the CodeBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CodeBullet(){
        //las propiedades fisicas de la bala
        setImage(new GreenfootImage(10, 2));
        getImage().setColor(Color.MAGENTA);
        getImage().fillRect(0, 0, 10, 2);
    }
    public void act()
    {
        //velocidad de la bala y si esta se encuentra en el fin del canvas, quitar el objeto.
        move(10);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
