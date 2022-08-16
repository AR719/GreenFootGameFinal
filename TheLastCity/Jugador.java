import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //velocidad del actor, tiempo sobrevivido
    int speed = 3;
    int TSobrevivido = 0;
    UpgradeWeaponButton weaponButton;
    public Jugador(){
        //Colocar la imagen del personaje
        setImage("MainCharacter.png");
        getImage().scale(50,50);
    }
    public Jugador(UpgradeWeaponButton weaponButton){
        this.weaponButton = weaponButton;
        setImage("MainCharacter.png");
        getImage().scale(50,50);
    }
    public void act()
    {
        TSobrevivido++;
        Girar();
        Movimiento();
        Disparo();
        Hurt();
    }
    public void Girar(){
        //girar el actor hacia la direccion del mouse cuando esta este en pantalla
        if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void Movimiento(){
        //controlador del personaje
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed,getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed,getY()); 
    }
    public void Disparo(){
        //Cuando el mouse es presionado crear una nueva bala y si dependiendo del estado de weaponUpgrade crear mas balas.
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1){
            CodeBullet bullet = new CodeBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            bullet.move(25);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2){
            CodeBullet bullet = new CodeBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation()-5);
            bullet.move(20);
            CodeBullet bullet2 = new CodeBullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation()+5);
            bullet2.move(20);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3){
            CodeBullet bullet = new CodeBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation()-5);
            bullet.move(20);
            CodeBullet bullet2 = new CodeBullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation()+5);
            bullet2.move(20);
            CodeBullet bullet3 = new CodeBullet();
            getWorld().addObject(bullet3, getX(), getY());
            bullet3.setRotation(getRotation());
            bullet3.move(20);
        }
    }
    public boolean Hurt(){
        //si hay un enemigo sobre el actor hacer que Hurt sea true
        Actor fallen = getOneObjectAtOffset(0,0, TheFallen.class);
        if(fallen != null){
            return true;
        }
        else
        return false;
    }
}
