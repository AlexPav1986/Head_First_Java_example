public class Bottle_of_beer {
    public static void main(String[] args) {
        int num_bottl = 99;
        String word = "бутылок/бутылки";

        while (num_bottl > 0) {

            System.out.println(num_bottl + " " + word + " " + "пива на стене");
            System.out.println("возьми одну. Пусти по кругу");
            num_bottl--;

            if (num_bottl == 1) {
                word = "бутылка";
            }
        }
        if (num_bottl == 0) {
            System.out.println(num_bottl + " " + word + " " +"пива на стене");
            System.out.println("Нет бутылок пива на стене");

        }

    }

}
