class Dog {
    private int size;

    public int getSize() {
        return size;
    }
    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
            System.out.println("ГАВ ГАВ");
        }
        else if (size > 40) {
            System.out.println("Ваф Ваф");
             }
        else if (size < 10) {
            System.out.println("Я слишком маленькая, меня не существует");
        }
        else {
            System.out.println("тяф тяф");
           }
      }
}

