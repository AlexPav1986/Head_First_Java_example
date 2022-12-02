import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int shipCount = 0;

    public String getUserInput(String promt) { //prompt - незамедлительный

        String inputLine = null;
        System.out.print(promt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.print("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotShip(int shipSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphaCoords = new String[shipSize]; //хранит координаты типа f6
        String temp = null;                           //временная строка для конкатенации
        int[] coords = new int[shipSize];             //координаты текущего корабля
        int attempts = 0;                             //attempts - попытки
        boolean success = false;                      // нашли подходящее местоположение?
        int location = 0;                             // текущее начальное местоположение

        shipCount++;                                  // Энный корабль для размещения
        int incr = 1;                                 //Устанавливаем горизонгтальный инкримент
        if ( (shipCount%2) == 1) {                    // Если нечетный - размещаем вертикально
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {          // Главный поисковой цикл
            location = (int) (Math.random() * gridSize); //ПОлучаем случайную стартовую точку
            //System.out.print("Пробуем" + location);
            int x = 0;
            success = true;                                 //предполагаем успешный исход
            while (success && x < shipSize) {               //ищем соседнюю неиспользуемую ячеку
                if (grid[location] == 0) {                  // если еще не используется
                    coords[x++] = location;                 //сохраняем местоположение
                    location += incr;                       //пробуем сосоеднюю ячейку
                    if (location >= gridSize) {             //выщли за рамки - низ
                        success = false;                    //неудача
                    }
                    if (x > 0 && (location % gridSize == 0)) { //вышли за рамки - правый край
                        success = false;
                    }
                }else {                                     //нашли уже используемое местоположение
                    //System.out.print("Использыется" + location);
                    success = false;
                }
            }
        }
        int x = 0;                                    //переводим местоположение в символьные координаты
        int row = 0;
        int col = 0;
        //System.out.print("\n");
        while (x < shipSize) {
            grid[coords[x]] = 1;                     //помечаем ячейки на главной сетке как использованные
            row = (int) (coords[x] / gridLength);    //получаем значение строки
            col = coords[x] % gridLength;            //получем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(col)); //преобразуем его в строковый символ

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

        }
        return alphaCells;

    }



}
