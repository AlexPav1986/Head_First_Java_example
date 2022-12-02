public class SimpleDotComGame {
    public static void main(String[] args) {

        int numOfGuesses = 0; //кол-во ходов пользователя

        GameHelper helper = new GameHelper(); // для ввода пользователем ячейки

        SimpleDotCom dot = new SimpleDotCom();

        int randomNum = (int) (Math.random() * 5); //местоположение 1й ячейки корабля
        int[] locations = {randomNum, randomNum+1, randomNum+2}; //корабль из 3х ячеек

        dot.setLocationCells(locations); // сеттер корабля

        boolean isAlive = true; //для проверки цикла

        while (isAlive == true) {
            String guess = helper.getUserInput("Введите число:"); //получаем строку от пользователя
            String result = dot.checkYourself(guess); // проверяем и возвращаем результат
            numOfGuesses++;

            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.print("Вам потребовалось" + " " + numOfGuesses + " " + "попыток(и)");
            }
        }
    }
}
