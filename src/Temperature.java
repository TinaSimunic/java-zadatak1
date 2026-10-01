import java.util.Scanner;

public class Temperature {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name;
        do {
            System.out.print("Kako se zovete? ");
            name = input.nextLine();
        } while (name.length() == 0);

        System.out.println("Zdravo " + name.toUpperCase() + "!");

        double average = 0;
        int count = 0;
        double min = 0;
        double max = 0;
        int bigTemperatura = 0; 
        double total = 0;

        while (true) {
            System.out.print("Tjelesna temperatura: ");
            double amount = input.nextDouble();
            if (amount == 0) {
                break;
            } else {
                total += amount;
                count++;
                
                if (amount > 37.0) {
                    bigTemperatura++;
                }
            }
            
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

        if (count == 0) {
            System.out.println("Nije uneseno nijedno mjerenje.");
        } else {
            System.out.println();
            System.out.println("Uneseno je " + count + " mjerenja.");
            System.out.printf("Najniža temperatura: %8.2f%n", min);
            System.out.printf("Najviša temperatura: %8.2f%n", max);
            
            average = total / count;
            System.out.printf("Prosječna temperatura: %8.2f%n", average);
            
            System.out.println("Većih od 37.0 Celzijusa je " + bigTemperatura + " mjerenja.");

            // Zaključna poruka prema zahtjevu zadatka
            if (bigTemperatura > 0) {
                System.out.println("Povišena temperatura zabilježena.");
            } else {

                System.out.println("Sva mjerenja u granicama normale.");
            }
        }

        input.nextLine(); 
        System.out.print("Želite li savjete za snižavanje temperature? (da/ne): ");
        String answer = input.nextLine();

        boolean wantsTips = answer.equalsIgnoreCase("da");

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
}