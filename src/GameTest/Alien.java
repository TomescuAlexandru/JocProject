package GameTest;

import javax.swing.*;
/**
 * Clasa Alien reprezinta inamicul Player-ului
 * Clasa Alien extinde SuperClasa Sprite ce contine metodele de initializarea imaginii , setarea coordonatelor ale imaginii , metodele ce vor returna vizibilitatea obiectului
 */
public class Alien extends Sprite {
    /**
     * Creeam o un obiect de tipul clasei Bomb pentru a obtine acces la metodele si variabilele din acea clasa
     */
    private Bomb bomb;
    /**
     * Constructorul cu parametrii ce v-a initializa obiectul Alien in functie de coordonatele x,y
     */
    public Alien(int x, int y) {

        initAlien(x, y);
    }
    /**
     * Metoda initAlien(x,y) v-a initiazila obiectul Alien cu coordonatele date prin parametrii , v-a crea un obiect de tip bomb cu pozitia pe care o are si obiectul Alien , si v-a initializa imaginea obiectului
     */
    private void initAlien(int x, int y) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);

        var alienImg = "C:\\Users\\alex\\IdeaProjects\\JocProject\\src\\images\\alien.png";
        var ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }
    /**
     * Metoda act() ce v-a actuliza pozitia obiectului Alien in functie de directia pe care o urmeaza
     */
    public void act(int direction) {

        this.x += direction;
    }
    /**
     * Metoda getBomb() v-a returna un obiect de tip bomb
     */
    public Bomb getBomb() {

        return bomb;
    }
    /**
     * Am creat o clasa interioara pentru a avea un control mai bun asupra metodei de initializare a obiectului bomba care v-a trebui sa porneasca din aceeasi pozitie ca si Alien
     * Clasa Bomb extinde SuperClasa Sprite
     */
    public class Bomb extends Sprite {
        /**
         * Variabila de tip bool v-a returna true daca este distrusa sau false daca inca nu s-a distrus
         */
        private boolean destroyed;
        /**
         * Constructorul cu argumente a obiectului bomba in functie de coordonatele x,y , ce apeleaza o metoda de initializare a obiectului bomba
         */
        public Bomb(int x, int y) {

            initBomb(x, y);
        }
        /**
         * Metoda initBomb(x,y) v-a initializa imaginea obiectului si v-a seta coordonatele in functie de pozitia obiectului Alien
         */
        private void initBomb(int x, int y) {

            setDestroyed(true);

            this.x = x;
            this.y = y;

            var bombImg = "C:\\Users\\alex\\IdeaProjects\\JocProject\\src\\images\\bomb.png";
            var ii = new ImageIcon(bombImg);
            setImage(ii.getImage());
        }
        /**
         * Metoda setDestroyed v-a seta daca obiectul a fost distrus sau nu
         */
        public void setDestroyed(boolean destroyed) {

            this.destroyed = destroyed;
        }
        /**
         * Metoda isDestroyed v-a returna o variabila de tip bool care arata daca obiectul este distrus sau nu
         */
        public boolean isDestroyed() {

            return destroyed;
        }
    }
}
