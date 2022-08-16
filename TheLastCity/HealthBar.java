import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public HealthBar(){
        //imagen de la barra de vida
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        
    }
    public void act()
    {
        setImage(new GreenfootImage(52,12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world; 
        setLocation(myWorld.getJugador().getX()-5, myWorld.getJugador().getY() -50);
        LoseHealth();
    }
    public void LoseHealth(){
        //si hurt es true, perder vida, cuando se pierda toda la vida detener el juego.
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world; 
        if(myWorld.getJugador().Hurt()){
            health--;
        }
        if(health<=0){
            getWorld().showText("Perdiste... \n Sobreviviste por: " + (myWorld.getJugador().TSobrevivido/60) + "segundos.", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
