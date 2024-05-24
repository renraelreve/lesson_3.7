public class CallStackDemo {
  public static void main(String[] args) {
    System.out.println("main");
    // methodA();
    recuriveMethod(6);
  }

  public static void recuriveMethod(int n) {
    if (n == 0) {
      return;
    }

    if (n == 5) {
      int x = 1 / 0;
    }

    System.out.println("n = " + n);
    recuriveMethod(n - 1);
  }

  public static void methodA() {
    System.out.println("Method A");
    methodB();
  }

  public static void methodB() {
    int x = 1 / 0;
    System.out.println("Method B");
    methodC();
  }

  public static void methodC() {

    System.out.println("Method C");
    methodD();
  }

  public static void methodD() {

    System.out.println("Method D");

  }
}
