public class Main {
    public static void main(String[] args) {
        System.out.println(Math.abs(calculateDate(1, 1, 2018) - calculateDate(1, 1, 2019)));
    }
    public static int calculateDate ( int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

}