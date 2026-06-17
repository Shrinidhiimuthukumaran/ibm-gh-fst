package rps;


import java.util.Random;

public class GameService {

    private String[] choices = {"Rock", "Paper", "Scissors"};

    public String getComputerChoice() {
        Random random = new Random();
        return choices[random.nextInt(3)];
    }

    public void validateChoice(String choice)
            throws InvalidChoiceException {

        if (!choice.equalsIgnoreCase("Rock")
                && !choice.equalsIgnoreCase("Paper")
                && !choice.equalsIgnoreCase("Scissors")) {

            throw new InvalidChoiceException(
                    "Choice must be Rock, Paper or Scissors");
        }
    }

    public int determineWinner(
            String userChoice,
            String computerChoice) {

        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return 0;
        }

        if ((userChoice.equalsIgnoreCase("Rock")
                && computerChoice.equalsIgnoreCase("Scissors"))
                || (userChoice.equalsIgnoreCase("Paper")
                        && computerChoice.equalsIgnoreCase("Rock"))
                || (userChoice.equalsIgnoreCase("Scissors")
                        && computerChoice.equalsIgnoreCase("Paper"))) {

            return 1;
        }

        return -1;
    }
}