public class SimpleDotCom {

    int[] locationCells;  //местоположение корабля
    int numofHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {

        //переводим в int
        int guess = Integer.parseInt(stringGuess);

        String result = "Мимо";

        for (int cell: locationCells) {
            if (guess == cell) {
                result = "Попал";
                numofHits++;
                break;
            }
        }

        //Проверим на потопление
        if (numofHits == locationCells.length) {
            result = "Потопил";
        }

        //.out.print(result);
        return result;

    }

}
