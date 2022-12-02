import java.util.*;

public class DotShipBust {  //объявляем и инициалилзируем нужные переменные
    private GameHelper helper = new GameHelper();
    private ArrayList<DotShip> dotShipsList = new ArrayList<DotShip>(); //ArrayList только для объектов DotShip
    private int numOfGuesses = 0;

    private void setUpGame() {
        //создадим корабли и присвоим им имена
        DotShip one = new DotShip();
        one.setName("Титан");
        DotShip two = new DotShip();
        one.setName("Марс");
        DotShip three = new DotShip();
        one.setName("Плутон");
        //помещаем корабли в ArrayList
        dotShipsList.add(one);
        dotShipsList.add(two);
        dotShipsList.add(three);
        //инструкции для игрока
        System.out.println("Ваша цель - потопить три корабля");
        System.out.println("Титан, Марс и Плутон");
        System.out.println("Попытайтесь потопить за минимальное количество ходов");

        for (DotShip dotShipsToSet : dotShipsList) { //повторяем с каждым объектом dotShips в списке
            ArrayList<String> newLocation = helper.placeDotShip(3); //запрашиваем координаты корабля
            dotShipsToSet.setlocationCells(newLocation); //Вызываем сеттер из DotShip для передачи ему полученных координат
        }
    }

    private void startPlaying() {
        while(!dotShipsList.isEmpty()) { // пока список объектов не станет пустым
            String userGuess = helper.getUserInput("Сделай ход"); //получаем пользовательский ввод
            checkUserGuess(userGuess); // вызываем checkUserGuess
        }
        finishGame(); // вызываем finishGame
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо"; //подразумеваем постоянные промахи

        for (DotShip dotShipsToTest : dotShipsList) {//повторяем с каждым объектом dotShips в списке
            result = dotShipsToTest.checkYourself(userGuess); //просим DotShip проверить ход, ищем попадение(потопление)
            if (result.equals("Попал")) {
                break; //другие нет смысла проверять
            }
            if (result.equals("Потопил")) {
                dotShipsList.remove(dotShipsToTest); //ему конец, удаляем из списка кораблей и выходим из списка
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        //выводим сообщения о том, как пользователь провел игру
        System.out.println("Все корабли ушли ко дну. Ваши акции теперь ничего не стоит");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у Вас всего" + " " + numOfGuesses + " " + "попыток");
            System.out.println("Вы успели выбратьс ячдо того, как Ваши вложения потонули");
        } else {
            System.out.println("Это заняло у Вас много времени" + " " + numOfGuesses + " " + "попыток");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotShipBust game = new DotShipBust(); // создаем игровой объект
        game.setUpGame(); // говорим ему, чтоб подготовил игру
        game.startPlaying(); // гооврим, чтоб начал игровой процесс до победного
    }
}
