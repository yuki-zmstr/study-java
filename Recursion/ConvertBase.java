public class ConvertBase {
    public static void displayInBase(int n, int base) {
        if (n > 0) {
            displayInBase(n / base, base); // integer division. will reach 0 eventually.
            // want to display from largest digit -> want to divide until cannot divide,
            // then display.
            System.out.print(n % base);
        }
    }

    public static void main(String[] args) {
        displayInBase(123, 8);
        ;
    }
}
