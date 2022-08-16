import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeWeaponButton extends Actor
{
    /**
     * Act - do whatever the UpgradeWeapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Score score;
    int weaponUpgrade = 1;
    public UpgradeWeaponButton(Score score){
        //crear la imagen para la opcion de mejorar tu arma
        this.score = score;
        setImage(new GreenfootImage("Mejora tu Arma! $$$", 25, Color.BLACK, new Color(0,0,0,0)));
        
    }
    public void act()
    {
        //si el dinero es mayor a 149 y se presiona el boton, mejorar el arma. Cuando se realizen 3 mejoras, todas las siguientes seran igualadas a 3.
        if(Greenfoot.mousePressed(this)&& score.dinero > 149){
            score.dinero -= 150;
            weaponUpgrade++;
        }
        if(weaponUpgrade > 3)
        weaponUpgrade = 3;
    }
}
