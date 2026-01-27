
public class Temp {

    public static class Box{
        public static int a = 0;

        public static void sayHello()
        {
            System.out.println("Hello");
        }

        public void display()
        {
            sayHello();
        }
    }

    public static void main(String[] args) {
        Box b = new Box();
        b.display();

    }
}
