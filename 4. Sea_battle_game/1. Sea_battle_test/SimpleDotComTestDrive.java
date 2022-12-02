//для теста
public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();

        //местоположение корабля
        int[] locations = {2,3,4};

        // сеттер корабля
        dot.setLocationCells(locations);

        //ход игрока
        String userGuess = "2";

        String result = dot.checkYourself(userGuess);

        String testResult = "Неудача";

        if (result.equals("Попал") ) {
            testResult = "Пройден";
        }
        System.out.print(testResult);



    }
}
