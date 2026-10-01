import java.util.Scanner;


public class temperature  {

    public static void main(String[] args) {
        System.out.println("Dnevna tjelesna temperatura u Celzijima: ");

        Scanner input = new Scanner(System.in);

        String name;
        do{
            System.out.print("Kako se zovete? ");
            name = input.nextLine();
        } while(name.length() == 0);

        System.out.println("Zdravo " + name.toUpperCase() + "!");

        System.out.print("Dnevna temperaturau Celzijima: ");
        double temperature = input.nextDouble();

        double average = 0;
        int count = 0;
        double min = 0;
        double max = 0;
        double bigTemperatura = 0;
        double total = 0;

        System.out.println("Unesite tjelesnu temperaturu, 0 za kraj: ");

        while (true) {
            System.out.print("Tjelesna temperatura: ");
            double amount = input.nextDouble();
            if (amount == 0) {
                break;
            }
            total += amount;
            count++;
            if (count == 1) {
                min = amount;
                max = amount;
            } else {
                if (amount < min) {
                    min = amount;
                }
                if (amount > max) {
                    max = amount;
                }
            }
        }
        if (count > 0) {
            average = total / count;
        }
        System.out.printf("Prosječna temperature: %8.2f%n", average);
        System.out.printf("Najniža temperature: %8.2f%n", min);
        System.out.printf("Najviša temperature: %8.2f%n", max);

        if(count == 0){
            System.out.println("Nije uneseno nijedno mjerenje.");
        } else {
            System.out.println("");
            System.out.print("");
            System.out.println("Uneseno je " + count + " mjerenja.");
            System.out.println("Većih od 37.0 Celzijusa je " + bigTemperatura + " mjerenja.");
        }
        if (average > 37.0) {
            System.out.println("Povišena tjelesna temperature zabilježena.");
        } else {
            System.out.println("Tjelesna temperature je u granicama normale.");
        }

        input.nextLine();

        System.out.print("Želite li savjete za snižavanje temperature? (da/ne): ");
        String answer = input.nextLine();

        boolean wantsTips = answer.equals("da");

        if (wantsTips) {
            String[] tips = {
                "1. Pijte puno tekućine.",
                "2. Odmarajte se i izbjegavajte naporne aktivnosti.",
                "3. Nosite laganu odjeću.",
                "4. Koristite hladne obloge ili tuširanje mlakom vodom.",
                "5. Ostanite u hladnom okruženju."
            };

            System.out.println("Savjeti (" + tips.length + "):");

            for (String tip : tips) {
                System.out.println(" - " + tip);
            }
        }

        input.close();
    }

    static void printRow(String label, double value) {
        System.out.printf("%-12s: %8.2f%n", label, value);
    }
}