import java.util.*;
public class DotShip {
    private ArrayList<String> locationCells;
    private String name;

    public void setlocationCells(ArrayList<String> loc) {
        locationCells = loc; // сеттер обновляет местоположение корабля
    }
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput); //Если ход совпадет с одним из элементов массива, то метод вернет его координату или вернет -1

        if (index >= 0) {
            locationCells.remove(index); // чтобы не было повторов;

            if (locationCells.isEmpty()) { // все ли адреса разгаданы?
                result = "Потопил";
                System.out.println("Ой, вы потопили" + " " + name + "  : (( ");
            } else {
                result = "Попал";
            }
        }
        return result; //возвращаем Мимо, попал или потопил

    }
}
