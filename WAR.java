import java.util.Random; // Random Import
import java.util.Scanner; // Scanner Import
import java.util.Arrays; // Arrays Inport

public class WAR {

    // Explains the game.
    public static void explainGame() {
        System.out.println(
                "Welcome to the game of WAR! In this game, you and the computer will each have a deck of cards.");
        System.out.println(
                "On each round, the top card from each deck will be drawn and compared. The card with the higher rank wins the round.");
        System.out.println(
                "If there is a tie, both cards will be added to a win pool, and the next round will be a 'war' where the winner takes all the cards in the win pool.");
        System.out.println(
                "The game will continue until one player runs out of cards, or after 100 rounds, the player with the most points wins.");
        System.out.println("Let's begin! Good luck!");
    }

    // Sets the computer and player points to 0.
    public static int ComputerPoints = 0;
    public static int PlayerPoints = 0;

    public static int triviaInput = 0;

    public static Scanner duh = new Scanner(System.in); // input

    public static int triviaAnswer = 0;

    // This method initializes the deck of cards by assigning each index a value
    // from 0 to 51
    public static void initializeCards(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
    }

    // This method shuffles the deck of cards using the random class
    public static void shuffleCards(int[] deck) {
        Random rand = new Random();
        // Generate random decks.
        for (int i = 0; i < deck.length; i++) {
            int index = rand.nextInt(deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    // This method assigns a rank to the card based on its value
    public static String valueCard(int[] deck, String[] ranks, int currentIndex) {
        // Returns the rank of the current deck.
        int card = deck[currentIndex];
        String rank = ranks[card % 13];
        return rank;
    }

    // This method divides the deck of cards into two separate decks for the player
    // and computer
    public static void divideDeck(int[] deck, int[] Playerdeck, int[] Computerdeck) {
        // Sets the player and computer decks.
        for (int i = 0; i < deck.length; i++) {
            if (i % 2 == 0) {
                Playerdeck[i / 2] = deck[i]; // Even Index Cards go to Players Deck
            } else {
                Computerdeck[i / 2] = deck[i]; // Odd Index Cards go to Computer Deck
            }
        }
    }

    // Resets the number of points in the game.
    public static void pointsreset(int roundCount) {
        // If a round count is 30 and player points are more then 15, the player points
        // will be rounded to the 0.
        if (roundCount == 30 && PlayerPoints >= 15) {
            System.out.println("Computer: You Luck is too Good, lets make it more fair by reseting your points. ");
            PlayerPoints -= PlayerPoints; // Player Points reseted.
        }
    }

    // trivia for task 2.
    public static int trivia() {
        System.out.println(
                "Computer: Before start this Level, lets conduct a trivia quiz. \n\nWhat is the Star Wars trilogy:");
        System.out.println(
                "1. Star Wars original trilogy, released from 1977 ~ 1983\n2. Star Wars prequel trilogy, released from 1999 ~ 2005.\n3. Star Wars sequel trilogy, released from 2015 ~ 2019");
        triviaInput = duh.nextInt();
        return triviaInput;

    }

    // trivia answers.
    public static void triviaReal(int triviaAnswer) {
        // Checks if the triviaAnswer is between 1 and 3.
        if (triviaAnswer >= 1 && triviaAnswer <= 3) {
            // Check if triviaAnswer is 1.
            if (triviaAnswer == 1) {
                System.out.println("A fantastic Movie trilogy which set Luke Film on their path to success.");
                // If triviaAnswer is 2
            } else if (triviaAnswer == 2) {
                System.out.println("My favorite trilogy, the Setting and the Storyline is SOOO well put together.");
                // If triviaAnswer is 3
            } else {
                System.out.println(
                        "WHY???? Just Why??\nFor starters, the films fail to honor the original characters and story arcs of the classic Star Wars films. Instead, the sequels introduce a host of new characters and subplots that are difficult to connect with the original films. There are repeated attempts to “re-imagine” iconic moments from the original films, but in a way that fails to capture the spirit and magic of the originals."
                                +
                                "\nThe films also lack a cohesive narrative structure. Instead, the films jump from one plot point to the next, and characters often seem to appear and disappear without explanation. There's a sense that the story is rushed and missing major pieces, leaving viewers confused and disappointed."
                                +
                                "\nFinally, the films fail to capture the essence of the original films. Fans were left to wonder what happened to the heroes they had grown to love, and how the story would evolve. The films failed to answer these questions, leaving many fans feeling that their beloved characters were forgotten.");
            }
        } else {
            System.out.println("Clone Wars SUCK!"); // Jk, it doesn't
            System.exit(0);
        }
    }

    // Swaps the player and computer decks.
    public static void swapDeck(int[] playerdecks, int[] Computerdeck) {
        Random rand = new Random();
        int chance = rand.nextInt(100); // Generates random number between 0 and 99
        if (chance < 10) { // if chance is less than 10, swap decks
            int[] temp = playerdecks;
            playerdecks = Computerdeck;
            Computerdeck = temp;
        }
        System.out.println("Your deck has been swap with the computer on random chance.");
    }

    // Compares the player card with the computer card.
    public static int compareCards(String playerCard, String computerCard, String[] ranks) {
        // Returns the player s card.
        int playerCardValue = Arrays.asList(ranks).indexOf(playerCard);
        // Returns the number of a computer card.
        int computerCardValue = Arrays.asList(ranks).indexOf(computerCard);
        return playerCardValue - computerCardValue;
    }

    // Adds the given computer card to the player deck.
    public static int[] addToPlayer(int[] Playerdeck, int opponentCard) {
        int[] temp = new int[Playerdeck.length + 1];
        // Returns a copy of the player deck.
        for (int i = 0; i < Playerdeck.length; i++) {
            temp[i] = Playerdeck[i];
        }
        temp[Playerdeck.length] = opponentCard;
        return temp;
    }

    // Removes card from the player deck.
    public static int[] removeFromPlayer(int[] Playerdeck, int card) {
        int[] temp = new int[Playerdeck.length - 1];
        int index = 0;
        // Returns the playerdecks that match the card.
        for (int i = 0; i < Playerdeck.length; i++) {
            if (Playerdeck[i] != card) {
                temp[index++] = Playerdeck[i];
            }
        }
        return temp;
    }

    // Adds the given player card to the computer deck.
    public static int[] addToComputer(int[] Computerdeck, int opponentCard) {
        int[] temp = new int[Computerdeck.length + 1];
        // Returns the computer played card.
        for (int i = 0; i < Computerdeck.length; i++) {
            temp[i] = Computerdeck[i];
        }
        temp[Computerdeck.length] = opponentCard;
        return temp;
    }

    // Remove card from the computer deck.
    public static int[] removeFromComputer(int[] Computerdeck, int card) {
        int[] temp = new int[Computerdeck.length - 1];
        int index = 0;
        for (int i = 0; i < Computerdeck.length; i++) {
            if (Computerdeck[i] != card) {
                temp[index++] = Computerdeck[i];
            }
        }
        return temp;
    }

    // Computer wins a round.
    public static void Computer_Win(String computerCard, String playerCard, int[] Playerdeck, int[] Computerdeck,
            int War_check) {

        if (War_check == 0) {
            // Increments the computer points.
            ComputerPoints++;
            // Displays a player win this round with a computer.
            System.out.println(
                    "Computer wins this round with a " + computerCard + " against the player's " + playerCard);
            System.out.println("Player Deck: " + Playerdeck.length + "\nComputer Deck:" + Computerdeck.length);
            System.out.println("Player Points: " + PlayerPoints + "\nComputer Points:" + ComputerPoints);
        } else {
        }
    }

    // Player wins a round.
    public static void Player_Win(String computerCard, String playerCard, int[] Playerdeck, int[] Computerdeck,
            int War_check) {

        if (War_check == 0) {
            // Increments the number of player points.
            PlayerPoints++;
            // Plays the round with a win against a computer.
            System.out.println(
                    "Player wins this round with a " + playerCard + " against the computer's " + computerCard);
            System.out.println("Player Deck: " + Playerdeck.length + "\nComputer Deck:" + Computerdeck.length);
            System.out.println("Player Points: " + PlayerPoints + "\nComputer Points:" + ComputerPoints);
        } else {
        }
    }

    // Equivalent to tying a Playerdeck Computerdeck and a Pool.
    public static void tie(int[] Playerdeck, int[] Computerdeck, int[] winPool) {
        // Both cards will be added to the win pool which will be next battle Winner!
        System.out.println("Both cards will be added to the win pool, which will be added to next battle Winner!");
        int playerCard = Playerdeck[0];
        int computerCard = Computerdeck[0];
        // Adding cards to the pool.
        winPool = addToWinPool(winPool, playerCard, computerCard);
        // Remove a playerdeck from the player deck.
        Playerdeck = removeFromPlayer(Playerdeck, playerCard);
        // Remove a computerdeck from the list of computers.
        Computerdeck = removeFromComputer(Computerdeck, computerCard);
        System.out.println("Player Deck: " + Playerdeck.length + "\nComputer Deck: " + Computerdeck.length
                + "\nWin Pool: " + winPool.length);
    }

    // Adds a card to the win pool.
    public static int[] addToWinPool(int[] winPool, int playerCard, int computerCard) {
        // Creates a new array of winPools.
        int[] temp = new int[winPool.length + 2];
        for (int i = 0; i < winPool.length; i++) {
            temp[i] = winPool[i];
        }
        // Returns a temp array containing the player card and computer card.
        temp[winPool.length] = playerCard;
        temp[winPool.length + 1] = computerCard;
        return temp;
    }

    // Returns the winPool.
    public static void winPool(int[] Playerdeck, int[] Computerdeck, int[] winPool) {
        // Adds the players in the pool to the win pool.
        if (Playerdeck.length > Computerdeck.length) {
            System.out.println("Player wins the win pool!");
            // Add all the players in the winPool to the Playerdeck.
            for (int card : winPool) {
                Playerdeck = addToPlayer(Playerdeck, card);
            }
            // Computer wins the pool
        } else {
            System.out.println("Computer wins the win pool!");
            for (int card : winPool) {
                Computerdeck = addToComputer(Computerdeck, card);
            }
        }
        // Sets the winPool to a 0 value.
        winPool = new int[0];
    }

    public static void Pointexit() {
        // Checks if the PlayerPoints is greater than ComputerPoints.
        if (PlayerPoints > ComputerPoints) {
            System.out.println("Player wins the game with " + PlayerPoints + " points!");
            // Check if ComputerPoints is greater than PlayerPoints.
        } else if (ComputerPoints > PlayerPoints) {
            System.out.println("Computer wins the game with " + ComputerPoints +
                    " points!");
            // The game ended in a tie with both players.
        } else {
            System.out.println("The game ended in a tie with both players having " +
                    PlayerPoints + " points.");
        }
    }

    // Gets the mode.
    public static int Mode() {
        // Which Mode you want this game to function in
        System.out.println("Which Mode you would like this game to function in: \n1. Easy\n 2. Hard");
        int Selection = duh.nextInt();

        // Output Easy Mode
        if (Selection == 1) {
            System.out.println("Easy Mode");
        }

        // Prints the hard mode.
        if (Selection == 2) {
            System.out.println("Hard Mode");
            // trivia time.
            triviaAnswer = trivia();
            triviaReal(triviaAnswer);

        }
        return Selection;
    }

    // Game ends with Card running out.
    public static void Cardexit(int[] Playerdeck, int[] Computerdeck) {
        // Computer wins the game
        if (Playerdeck.length == 0) {
            System.out.println("Computer wins the game!");
            // The player wins the game.
        } else if (Computerdeck.length == 0) {
            System.out.println("Player wins the game!");
        }
    }

    public static void main(String args[]) {
        // Explains the game.
        explainGame();
        // Returns the game number.
        int Game;
        // Sets the level to the mode.
        int Level = Mode();
        do {
            int War_check = 0;
            int[] deck = new int[52];
            String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
            int[] Playerdeck = new int[26];
            int[] Computerdeck = new int[26];
            int[] winPool = new int[0];

            // Initialize cards
            initializeCards(deck);

            // Shuffle cards
            shuffleCards(deck);

            // Divide the deck between the player and computer
            divideDeck(deck, Playerdeck, Computerdeck);

            // Sets the current index to 0 and resets the round count.
            int currentIndex = 0;
            int roundCount = 0;

            while (Playerdeck.length > 0 && Computerdeck.length > 0 && roundCount < 100) {
                roundCount++;
                // Making the game harder for task 2.
                if (Level == 2) {
                    pointsreset(roundCount);
                    swapDeck(Playerdeck, Computerdeck);
                }
                System.out.println("\nRound: " + roundCount + "\n");
                // Checks if the current index is within the range of Playerdeck and
                // Computerdeck

                // Press any letter to pull a card from the deck
                System.out.println("Press any letter to pull a card from the deck:");
                //String input = duh.next();

                if (currentIndex >= Playerdeck.length) {
                    currentIndex = 0;
                }
                if (currentIndex >= Computerdeck.length) {
                    currentIndex = 0;
                }
                // Get the value of the top card for the player and computer
                String playerCard = valueCard(Playerdeck, ranks, currentIndex);
                String computerCard = valueCard(Computerdeck, ranks, currentIndex);
                currentIndex++;

                // Compare the values of the cards
                int result = compareCards(playerCard, computerCard, ranks);

                // If the player's card is higher, they win the round
                if (result > 0) {
                    Playerdeck = addToPlayer(Playerdeck, Computerdeck[0]);
                    Computerdeck = removeFromComputer(Computerdeck, Computerdeck[0]);

                    Player_Win(computerCard, playerCard, Playerdeck, Computerdeck, War_check);

                }
                // If the computer's card is higher, they win the round
                else if (result < 0) {
                    Computerdeck = addToComputer(Computerdeck, Playerdeck[0]);
                    Playerdeck = removeFromPlayer(Playerdeck, Playerdeck[0]);

                    Computer_Win(computerCard, playerCard, Playerdeck, Computerdeck, War_check);

                }
                // If the cards are the same, it's a tie
                else if (result == 0) {
                    System.out.println("This round is a tie with both players having a " +
                            playerCard);
                    tie(Playerdeck, Computerdeck, winPool);
                }
                // Check if win pool needs to be resolved
                if (winPool.length > 0 && (Playerdeck.length == 0 || Computerdeck.length == 0)) {
                    winPool(Playerdeck, Computerdeck, winPool);
                }
            }

            // Stop the game if number of rounds exceeds 100.
            if (roundCount >= 100) {
                Pointexit();
            }

            // Computer wins the game
            Cardexit(Playerdeck, Computerdeck);

            // Would you like to play the game again?
            System.out.println("Would you like to Play the Game Again? \nPress 1 for No\nAnything else for Yes:");
            Game = duh.nextInt();

            // Repaet the game until stopped by the users.
        } while (Game != 1);
    }

}