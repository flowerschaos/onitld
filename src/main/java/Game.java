import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game{

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name, please.");
        String charName = scanner.nextLine();
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
        printDramaticText("In the seat next to you, a rough man-shaped figure sits down, and turns to meet you. He's on the taller end, with patchy stubble and wireframe glasses. His eyes are ice blue, and his hair's a murky brown in a very bad mullet.");
        printDramaticText("\"Sorry I'm late, "+charName+". The name's Miles, I'm your... client.\"");
        printDramaticText("\"To find what I'm looking for, you're.. going to need this.\"");
        printDramaticText("He hands you a small phone-sized device. On it is a dot representing you, outlines of the buildings surrounding you, and an arrow at the top of the screen. The arrow has a label: \"2M NORTH\".");
        printDramaticText("As you rise, Miles salutes.");
        printDramaticText("\"Good luck! You're gonna need it.\"");
        printDramaticText("                                  ");
        printDramaticText("You make it to the location... a derelict warehouse?");
        printDramaticText("As you enter, you can feel that something's horribly wrong here...");
        printDramaticText("                                  ");

        generateEncounter(myStats);
        generateEncounter(myStats);

        printDramaticText("You struggle through the nonsensical architecture and the visceral creations of the warehouse, leading you to a small cafeteria.");
        printDramaticText("Your tracker beeps frantically as you walk by a specific table in the cafeteria.");
        printDramaticText("From underneath the table crawls out...");
        printDramaticText("An anthropomorphic moth-based child, who looks to be around the age of six or seven years old. You've heard tales of citizens coming from a lineage of those afflicted by radiation: harpies, squidpeople, allegedly people with ties to gods, but... here's one. In the flesh.");
        printDramaticText("She wears a navy blue poncho, a bracelet with flashing light on one of her four arms. Staring at you with some kind of wonder, yet palpable fear, she notes your tracker and rushes forth to... hug you.");
        printDramaticText("Her voice is timid and quiet, like somebody who's not quite used to speaking yet.");
        printDramaticText("\"Are.. Are you "+charName+"? Did Mr. Miles send... send you to get me?\"")
        printDramaticText("You nod, holstering your weapon.")
        printDramaticText("\"Hi. M-My name is... is Combs. Nice... to meet... you.\"")
        printDramaticText("She trembles with fear, yet if it's from your appearance or from the whole appearance of the place, you're unsure. Regardless, she holds out her hand for you to take it.")
        printDramaticText("It's time to get out of here.")
        
    }

    public static void generateEncounter(StatTool myStats, boolean combsCheck) {
        int r = (int)(Math.random() * 30) + 1;
        if(r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {

            printDramaticText("\nYou can't find any windows or doors in here. It's just an endless maze of brick walls and concrete. Regardless, you try and push onward.");

            RollResult rr = myStats.diceCheck("sturdy");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nDespite the warehouse itself seeming to be against you, you manage to press onward.");
            }
            else{
                System.out.println("\nYou can't see here from there, and you soon find yourself trapped within the maze, another lost soul damned to wander in the halls of this monster.");
                return;
            }
        }
        if(r == 6 || r == 7 || r == 8 || r == 9 || r == 10) {

            printDramaticText("\nSome kind of terrible meat monster stands in your way. You prepare to strike...");

            RollResult rr = myStats.diceCheck("severe");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nIt falls with relative ease. You continue to move...");
            }
            else{
            System.out.println("\nThe figure's too powerful for you, and you are quickly enveloped.");
            return;
            }
        }
        if(r == 11 || r == 12 || r == 13 || r == 14 || r == 15) {

            printDramaticText("\nA meat monster blocks your path forward. It's too strong to fight, you have to outrun it!");

            RollResult rr = myStats.diceCheck("sharp");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nQuickly as you can, you route around the monster, running into the distance.");
            }
            else{
                System.out.println("\nYou trip and fall, sinking into the floor of the warehouse, never to be seen again.");
                return;
            }
        }
        if(r == 16 || r == 17 || r == 18 || r == 19 || r == 20) {

            printDramaticText("\nThe signs before you don't seem to make sense, pointing in directions that you can't reach.");

            RollResult rr = myStats.diceCheck("skilled");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nYou ignore the signs and continue to walk forward, knowing where you should go.");
            }
            else{
            System.out.println("\nYou begin to follow the signs, forever lost, running in circles.");
            return;
            }
        }
        if(r == 21 || r == 22 || r == 23 || r == 24 || r == 25) {

            printDramaticText("\nYou find somebody else wandering. They seem terrified, pointing their weapon towards you.");

            RollResult rr = myStats.diceCheck("slick");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nWith ease, you convince them that you mean no harm.");
            }
            else{
                System.out.println("\nYour talking makes them only angrier, and your exploration is brought to an abrupt end.");
                return;
            }
        }
        if(r == 26 || r == 27 || r == 28 || r == 29 || r == 30) {

            printDramaticText("\nEverywhere you turn, you end up at a dead end.");

            RollResult rr = myStats.diceCheck("soul");
            rr.print();
            
            if (rr.checkResult){
                System.out.println("\nShutting your eyes and continuing to walk, you're able to move forward.");
            }
            else{
            System.out.println("\nYou sit down, allowing your fate to consume you.");
            return;
            }
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
