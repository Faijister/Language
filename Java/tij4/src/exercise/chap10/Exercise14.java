package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Modify interfaces/HorrorShow.java to implement
 * DangerousMonster and Vampire using anonymous classes.
 *
 * @author Leo
 * @since 2016/10/24
 */
public class Exercise14 {
    public DangerousMonster getDragonZilla() {
        return new DangerousMonster() {
            @Override
            public void destroy() {
                print("DragonZilla is destroying...");
            }

            @Override
            public void menace() {
                print("DragonZilla is menacing...");
            }
        };
    }

    public Vampire getVeryBadVampire() {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                print("Very bad vampire is drinking blood...");
            }

            @Override
            public void destroy() {
                print("Very bad vampire is destroying...");
            }

            @Override
            public void kill() {
                print("Very bad vampire is killing...");
            }

            @Override
            public void menace() {
                print("Very bad vampire is menacing...");
            }
        };
    }

    static void showM(Monster m) {
        m.menace();
    }

    static void showD(DangerousMonster d) {
        d.destroy();
    }

    static void showV(Vampire v) {
        v.drinkBlood();
    }

    static void showL(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        Exercise14 horrorShow = new Exercise14();
        showM(horrorShow.getDragonZilla());
        showD(horrorShow.getDragonZilla());
        showM(horrorShow.getVeryBadVampire());
        showD(horrorShow.getVeryBadVampire());
        showV(horrorShow.getVeryBadVampire());
        showL(horrorShow.getVeryBadVampire());
    }
}

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}