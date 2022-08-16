import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    int cuenta = 0;
    //velocidad a la que aparecen los enemigos.
    int spawner = 50;
    int randSpawn;
    public Jugador MJugador = new Jugador();
    Score score = new Score();
    HealthBar healthbar = new HealthBar();
    UpgradeWeaponButton weaponButton = new UpgradeWeaponButton(score);

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1);
        MJugador = new Jugador(weaponButton);
        addObject(MJugador, getWidth()/2, getHeight()/2);
        addObject(score, 90, 50);
        addObject(healthbar, MJugador.getX() - 5, MJugador.getY() -50);
        addObject(weaponButton, 800 ,50);
    }
    public Jugador getJugador(){
        return MJugador;
    }
    public void act(){
        cuenta++;
        //cuanto pasen 600 frames (aprox 10sec) reducir el tiempo para spawnear.
        if(cuenta % 600 == 0){
            spawner--;
        }
        //Mientras se presiona p crear un delay lo cual causa que el juego se pause.
        while(Greenfoot.isKeyDown("p")){
            Greenfoot.delay(1);
        }
        spawnFallen();
    }
    public void spawnFallen(){
        if(cuenta % spawner == 0){
            //spawnear a los enemigos con diferentes propiedades dependiendo del numero (0 a 7)
            randSpawn = Greenfoot.getRandomNumber(8);
            switch(randSpawn){
                case 0 : addObject(new TheFallen(MJugador, score), 0, 0); break;
                case 1 : addObject(new TheFallen(MJugador, score), getWidth()/2, 0); break;
                case 2 : addObject(new TheFallen(MJugador, score), getWidth(), 0); break;
                case 3 : addObject(new TheFallen(MJugador, score), 0, getHeight()/2); break;
                case 4 : addObject(new TheFallen(MJugador, score), getWidth(), getHeight()/2); break;
                case 5 : addObject(new TheFallen(MJugador, score), 0, getHeight()); break;
                case 6 : addObject(new TheFallen(MJugador, score), getWidth()/2, getHeight()); break;
                case 7 : addObject(new TheFallen(MJugador, score), getWidth(), getHeight()); break;
            }
        }
    }
}
