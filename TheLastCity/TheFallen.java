import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheFallen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheFallen extends Actor
{
    /**
     * Act - do whatever the TheFallen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int vida = 2;
    Jugador jugador;
    Score cuenta;
    public TheFallen(Jugador MJugador, Score cuenta){
        this.cuenta = cuenta;
        jugador = MJugador;
        setImage("Enemy.png");
        getImage().scale(30,30);
    }
    public void act()
    {
        movimiento();
        recibirDaño();
    }
    public void movimiento(){
        //moverse a hacia la posicion x Y y del jugador
        move(1);
        turnTowards(jugador.getX(), jugador.getY());  
    }
    public void recibirDaño(){
        //si una bala intersecta con un enemigo, quitar una vida. cuando la vida sea 0 remover al enemigo
        Actor bullet = getOneIntersectingObject(CodeBullet.class);
        if(bullet != null){
            vida--;
            getWorld().removeObject(bullet); 
        }
        if(vida ==0){
            cuenta.score++;
            cuenta.dinero+=5;
            getWorld().removeObject(this);
        }
    }
}
