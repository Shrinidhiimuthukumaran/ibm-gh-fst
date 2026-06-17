package rps;

import java.util.Scanner;


public class RockPaperScissorApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GameService service = new GameService();

        Player user = new Player("User");
        Player computer = new Player("Computer");

        char playAgain = 'Y';

        while (playAgain == 'Y' || playAgain == 'y') {

            try {

                System.out.print(
                        "\nEnter Choice (Rock/Paper/Scissors): ");

                String userChoice = sc.nextLine();

                service.validateChoice(userChoice);

                String computerChoice =
                        service.getComputerChoice();

                System.out.println(
                        "Computer Choice : "
                                + computerChoice);

                int result =
                        service.determineWinner(
                                userChoice,
                                computerChoice);

                if (result == 1) {

                    System.out.println("You Win!");
                    user.incrementScore();

                } else if (result == -1) {

                    System.out.println("Computer Wins!");
                    computer.incrementScore();

                } else {

                    System.out.println("Match Draw!");
                }

                System.out.println("\nCurrent Score");
                System.out.println(
                        "User     : "
                                + user.getScore());

                System.out.println(
                        "Computer : "
                                + computer.getScore());

            }

            catch (InvalidChoiceException e) {

                System.out.println(
                        "Invalid Input : "
                                + e.getMessage());
            }

            System.out.print(
                    "\nPlay Again? (Y/N): ");

            playAgain = sc.next().charAt(0);
            sc.nextLine();
        }

        System.out.println("\nFinal Score");
        System.out.println(
                "User     : "
                        + user.getScore());

        System.out.println(
                "Computer : "
                        + computer.getScore());
        System.out.println("\n Thank you");
        

        sc.close();
    }
}