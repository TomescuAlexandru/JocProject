package GameTest;

import java.awt.*;
/**
 * Sprite este o SuperClasa ce contine metode de initializare a imaginii , setarea coordonatelor x,y , metode ce returneaza varibile de tip bool
 * SuperClasa are ca fii clasele Alien , Shot , Player si Bomb.
 */
public class Sprite {
    /**
     * Variabila de tip bool , visible v-a returna true sau false daca un obiect este vizibil sau nu
     * Variabila image de tip Image v-a incarca o imagine dintr-un fisier sursa
     * Variabila dying este de tip bool si v-a returna true sau false daca obiectul a fost distrus sau nu
     */
    private boolean visible;
    private Image image;
    private boolean dying;
    /**
     * Variabilele x,y sunt coordonatele obiectelor aflate pe ecran
     * Variabila dx v-a avea rolul de a face update pozitiei x
     */
    int x;
    int y;
    int dx;
    /**
     * Constructorul fara parametrii a SuperClasei v-a initializa variabila visible cu true
     */
    public Sprite() {

        visible = true;
    }
    /**
     * Metoda die() v-a initializa variabila visible cu false in caz ca obiectul a disparut
     */
    public void die() {

        visible = false;
    }
    /**
     * Metoda isVisible() v-a returna variabila visible
     */
    public boolean isVisible() {

        return visible;
    }
    /**
     * Metoda setVisible v-a initializa variabila visible cu o valoare true sau false in functie de necesitati
     */
    protected void setVisible(boolean visible) {

        this.visible = visible;
    }
    /**
     * Metoda setImage v-a initializa imaginea dintr-un fisier precizat
     */
    public void setImage(Image image) {

        this.image = image;
    }
    /**
     * Metoda getImage v-a returna imaginea in functie de obiectul apelat
     */
    public Image getImage() {

        return image;
    }
    /**
     * Metoda setX(x) v-a initializa coordonata x cu o alta valoare
     */
    public void setX(int x) {

        this.x = x;
    }
    /**
     * Metoda setY(Y) v-a initializa coordonata Y cu o alta valoare
     */
    public void setY(int y) {

        this.y = y;
    }
    /**
     * Metoda getY(Y) v-a returna valoare lui Y
     */
    public int getY() {

        return y;
    }
    /**
     * Metoda getX(x) v-a returna valoare lui X
     */
    public int getX() {

        return x;
    }
    /**
     * Metoda setDying initializa cu o alta valoare de tip bool pe dying
     */
    public void setDying(boolean dying) {

        this.dying = dying;
    }
    /**
     * Metoda isDying v-a returna o variabila de tip bool daca obiectul a disparut sau nu
     */
    public boolean isDying() {

        return this.dying;
    }

}
