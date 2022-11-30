public class Dog {
    int size;
    String name;

    void bark(int numOfBark) {
        if (size > 60) {
            while (numOfBark > 0) {
                System.out.println("ГАВ ГАВ");
                numOfBark--;
            }
        }
        else if (size > 40) {
            while (numOfBark > 0) {
                System.out.println("Ваф Ваф");
                numOfBark--;
            }
        }
        else {
            while (numOfBark > 0) {
                System.out.println("тяф тяф");
                numOfBark--;
            }
        }
    }

}
