import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name.");
        String charName = scanner.nextLine();
        System.out.println("Enter side gig.");
        String gigName = scanner.nextLine();
        System.out.println("Enter background.");
        String bgName = scanner.nextLine();

        System.out.println("Character Name: " + charName);
        System.out.println("Side Gig: " + gigName);
        System.out.println("Background: " + bgName);
        StatTool myStats = new StatTool(charName,gigName,bgName);

        myStats.printSheetWithAllowance();

        System.out.println("Type the command you'd like to use. You can do '[stat name] [higher/lower]' to increase or decrease the value of that stat by 1 or do 'finish' to finalize your character sheet.");
        String command = "";

        while (true) {
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("finish")) {
                System.out.println("Finalizing character sheet...");
                myStats.printSheet();
                break;
            }

            String commandChunks[] = command.split("\\s+");
            if (commandChunks.length == 2) {
                String stat = commandChunks[0].toLowerCase();
                int value = 0;
                if (commandChunks[1].equalsIgnoreCase("higher")) value = 1;
                else if (commandChunks[1].equalsIgnoreCase("lower")) value = -1;
                else {
                    System.out.println("ERROR: Use 'higher' or 'lower' after the stat name.");
                    continue;
                }
                myStats.statAdjust(stat, value);
                myStats.printSheetWithAllowance();
            } else {
                System.out.println("Unclear command. Enter '[stat name]' '[higher/lower]' (ex: sharp lower, slick higher) to adjust ratings, or enter 'finish' to finalize your character sheet.");
            }
        }

        // Start the adventure.
        printDramaticText("BEGIN WAKEUP PROTOCOL...");
        printDramaticText("///////////////////////////////////");
        printDramaticText("The endless torrent of snow smothers the crowded street. The only thing clear to see is the holographic advertisements in the distance.");
        printDramaticText("You sit at a street market stall, eating cheap noodles. Needless to say, you desperately need this job. There are a thousand things that could go wrong here, yes, but you're desperate to make rent.");
        printDramaticText("                                  ");
        printDramaticText("Next to you sits down a man. He's on the taller end, with patchy stubble and wireframe glasses. His eyes are ice blue, and his hair's a murky brown in a very bad mullet.");
        printDramaticText("He looks towards you, and a small smile appears on his face, but his eyes are full of sorrow.");
        printDramaticText("\"Sorry I'm late, "+charName+". The name's Miles, I'm your... client, I guess.\"");
        printDramaticText("\"I've, er, heard a lot about your capabilities when it comes to... what is it you do?\"");

        // TODO Continue ...
    }
        
    public static void printDramaticText(String text) {
        // Delay in milliseconds
        int delay = 100;

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // Draws a monster and returns an int which represents the difficulty of roll required.
    public static int generateMonster() {
        int r = (int)(Math.random() * 6) + 1;
        if(r == 1 || r == 2 || r == 3) {
            String zombie = Character.toString(0x1F9DF);
            System.out.println("++++++++ " + zombie + " A HORDE OF ZOMBIES " + zombie + " ++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  8            +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 8;
        }
        if(r == 4 || r == 5) {
            String mask = Character.toString(0x1F3AD);
            System.out.println("++++++++++ " + mask + " DISGUISED MIMIC " + mask + " +++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  12           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 12;
        }
        if(r == 6) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + " ++++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");

            return 18;
        }
        return -1;
    } 
}
