import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name.");
        String charName = scanner.nextLine();

        System.out.println("Character Name: " + charName);
        StatTool myStats = new StatTool(charName);

        printDramaticText("Sharp: Your ability to notice small details and have quick reflexes.");
        printDramaticText("Sturdy: Your ability to continue to stand strong against the harshest of blows.");
        printDramaticText("Slick: Your ability to charm your way through the world.");
        printDramaticText("Severe: Your ability to bite back and make it hurt.");
        printDramaticText("Skilled: Your ability to use the knowledge you've learned throughout life.");
        printDramaticText("Soul: Your ability to believe in the unknown and put your trust in what's not visible.");

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
        printDramaticText("\"Sorry I'm late, "+charName+". The name's Miles, I'm your... client.\"");
        printDramaticText("\"Here is the tracking device you'll need to find what I'm looking for.\"");
        printDramaticText("He hands you a small phone-sized device. On it is a dot representing you, outlines of the buildings surrounding you, and an arrow at the top of the screen.");
        printDramaticText("The arrow has a label: \"2M NORTH\".");
        printDramaticText("As you rise, Miles waves.");
        printDramaticText("\"Good luck out there!\"");
        printDramaticText("                                  ");
        printDramaticText("You make it to the location... a derelict warehouse?");
        printDramaticText("As you enter, you can feel that something's horribly wrong here...");
        // encounterRoll();

        generateEncounter(myStats);
    }
        // TODO Continue ...
    
        
    public static void generateEncounter(StatTool myStats) {
        int r = (int)(Math.random() * 5) + 1;
        if(r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {

            printDramaticText("You can't find any windows or doors in here. It's just an endless maze of brick walls and concrete. Regardless, you try and push onward.");

            RollResult rr = myStats.diceCheck("sturdy");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("Despite the warehouse itself seeming to be against you, you manage to press onward.");
            }
            System.out.println("You can't see here from there, and you soon find yourself trapped within the maze, another lost soul damned to wander in the halls of this monster.");
            return;
        }
        if(r == 6 || r == 7 || r == 8 || r == 9 || r == 10) {

            printDramaticText("You can't find any windows or doors in here. It's just an endless maze of brick walls and concrete. Regardless, you try and push onward.");

            RollResult rr = myStats.diceCheck("sturdy");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("Despite the warehouse itself seeming to be against you, you manage to press onward.");
            }
            System.out.println("You can't see here from there, and you soon find yourself trapped within the maze, another lost soul damned to wander in the halls of this monster.");
            return;
        }
        if(r == 9 || r == 10 || r == 11 || r == 12) {
            String eye = Character.toString(0x1F441);
            System.out.println("+++++++++++ " + eye +  " EVIL BEHOLDER " + eye + " ++++++++++++");
            System.out.println("+                                        +");
            System.out.println("+           roll required:  18           +");
            System.out.println("+                                        +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        }
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
}
