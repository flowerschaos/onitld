import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game{

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name, please.");
        String charName = scanner.nextLine();
        StatTool myStats = new StatTool(charName);

        // explanation of the stats and what they're generally used for
        printDramaticText("Sharp: Your ability to notice small details and have quick reflexes.");
        printDramaticText("Sturdy: Your ability to continue to stand strong against the harshest of blows. Determines how many hits you can take before you collapse.");
        printDramaticText("Slick: Your ability to charm your way through the world.");
        printDramaticText("Severe: Your ability to bite back and make it hurt.");
        printDramaticText("Skilled: Your ability to use the knowledge you've learned throughout life.");
        printDramaticText("Soul: Your ability to believe in the unknown and put your trust in what's not visible.");

        myStats.printSheetWithAllowance();

        System.out.println("Type the command you'd like to use. You can do '[stat name] [higher/lower]' to increase or decrease the value of that stat by 1 or do 'finish' to finalize your character sheet.");
        String command = "";

        while (true) {
            command = scanner.nextLine();

            // if told to finish, begin finalizing the character sheet.
            if (command.equalsIgnoreCase("finish")) {
                System.out.println("Finalizing character sheet...");
                myStats.printSheet();
                break;
            }
            
            // the user should only be using "higher" or "lower" in conjunction with a stat name
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
        
        // is combs here? if she isn't, use the regular set of encounters. if she is, use the combs-aided encounter set.
        boolean combsCheck = false;
        // have you made it past The Gauntlet?
        boolean gauntletPassed = false;

        // Teehee.
        printDramaticText("BEGIN WAKEUP PROTOCOL...");
        printDramaticText("///////////////////////////////////");
        printDramaticText("The endless torrent of snow smothers the crowded street. The only thing clear to see is the holographic advertisements in the distance.");
        printDramaticText("You sit at a street market stall, eating cheap noodles. Needless to say, you desperately need this job. There are a thousand things that could go wrong here, yes, but you're desperate to make rent.");
        printDramaticText("                                  ");
        printDramaticText("In the seat next to you, a rough man-shaped figure sits down, and turns to meet you.");
        printDramaticText("He's on the taller end, with patchy stubble and wireframe glasses. His eyes are ice blue, and his hair's a murky brown. Speaking of his hair, it\'s in a very... interesting mullet.");
        printDramaticText("He clearly hasn't been sleeping well.");
        printDramaticText("\"Sorry I'm late, "+charName+". I suppose I should... formally introduce myself. My name is Miles, and I'm your... client.\"");
        printDramaticText("He takes a deep breath, taking something out of one of the pockets of his parka.");
        printDramaticText("\"To find what I'm looking for, you're.. going to need this.\"");
        printDramaticText("He hands you a small phone-sized device. On it is a dot representing you, outlines of the buildings surrounding you, and an arrow at the top of the screen. The arrow has a label: \"2M NORTH\".");
        printDramaticText("As you rise, Miles salutes.");
        printDramaticText("\"Good luck. You're gonna need it.\"");
        printDramaticText("                                  ");
        printDramaticText("You make it to the location... a derelict warehouse?");
        printDramaticText("As you enter, you can feel that something's horribly wrong here...");
        printDramaticText("                                  ");

        generateEncounter(myStats, combsCheck, gauntletPassed, myStats.health);
        generateEncounter(myStats, combsCheck, gauntletPassed, myStats.health);

        printDramaticText("You struggle through the nonsensical architecture and the visceral creations of the warehouse, leading you to a small cafeteria.");
        printDramaticText("Your tracker beeps frantically as you walk by a specific table in the cafeteria.");
        printDramaticText("From underneath the table crawls out...");;
        printDramaticText("An anthropomorphic moth-based child. She looks to be around the age of six or seven years old.");
        printDramaticText("You've heard tales of citizens coming from a lineage of those afflicted by radiation: harpies, squidpeople, even, allegedly, people with divine powers, but... here's one. In the flesh.");
        printDramaticText("She wears a navy blue poncho, and, notably, a bracelet, light flashing white, is wrapped around her upper left arm.");
        printDramaticText("Her lower arms are in her pockets and her upper left arm is nervously flexing. Staring at you with some kind of wonder, yet palpable fear, she notes your tracker and rushes forth to... hug you?");
        printDramaticText("Her voice is timid and quiet, like somebody who's not quite used to speaking yet.");
        printDramaticText("\"Are.. Are you "+charName+"? Did Mr. Miles send... send you to get me?\"");
        printDramaticText("You nod, holstering your weapon.");
        printDramaticText("\"Hi. M-My name is... is Combs. Nice... to meet... you.\"");
        printDramaticText("She trembles with fear, yet if it's from your appearance or from the whole appearance of the place, you're unsure. Regardless, she holds out her hand for you to take it.");
        printDramaticText("It's time to get out of here.");
        combsCheck = true;

        generateEncounter(myStats, combsCheck, gauntletPassed, myStats.health);
        generateEncounter(myStats, combsCheck, gauntletPassed, myStats.health);


        printDramaticText("\nThe two of you face the final barrier to cross. A door is in your way, but you don't know entirely how to open it. You put your faith in what's gotten you here, and, gently yet firmly holding the child's hand, walk forwards.");
        gauntletPassed = true;

        generateEncounter(myStats, combsCheck, gauntletPassed, myStats.health);

        printDramaticText("                                  ");
        printDramaticText("Miles rushes forward, thanking you profusely for your hard work, trading the moth child (who is hugging him very tightly) for hard cold cash.");
        printDramaticText("... This is double the listed payment. You assume it was intentional.");
        printDramaticText("                                  ");
        printDramaticText("░░░░▒█░▒█▀▀▀█░▒█▀▀▄░░░▒█▀▀▄░▒█▀▀▀█░▒█▄░▒█░▒█▀▀▀░█");
        printDramaticText("░░░░▒█░▒█░░▒█░▒█▀▀▄░░░▒█░▒█░▒█░░▒█░▒█▒█▒█░▒█▀▀▀░▀");
        printDramaticText("░▒█▄▄█░▒█▄▄▄█░▒█▄▄█░░░▒█▄▄█░▒█▄▄▄█░▒█░░▀█░▒█▄▄▄░▄");
    }

public static void faintCourage(){
    for (int i= 0; i < 10; i++) {
    System.out.println("");
    }
    printDramaticText("░▒█▀▀▀░▒█░░░░█▀▀▄░▀▀█▀▀░▒█░░░░▀█▀░▒█▄░▒█░▒█▀▀▀░▒█▀▀▄░░░");
    printDramaticText("░▒█▀▀░░▒█░░░▒█▄▄█░░▒█░░░▒█░░░░▒█░░▒█▒█▒█░▒█▀▀▀░▒█░▒█░▄▄");
    printDramaticText("░▒█░░░░▒█▄▄█▒█░▒█░░▒█░░░▒█▄▄█░▄█▄░▒█░░▀█░▒█▄▄▄░▒█▄▄█░▀▀");
    System.out.println("");
    System.out.println("");
    printDramaticText("You have failed, but failure's a temporary setback.");
    printDramaticText("Stop the program (hit the x at the top right of the window reading \"terminal\") and restart (the play button at the top right of the screen) to try again.");
    System.exit(0);
}

public static void generateEncounter(StatTool myStats, boolean combsCheck, boolean gauntletPassed, int health) {
    // random number for generation of encounters
    int r = (int)(Math.random() * 30) + 1;
    // did the user pass the gauntlet? bring in the door
    if (gauntletPassed) {
        // keep trying until the door opens.
        boolean doorCheck = false;
         while (!doorCheck) {
            RollResult rr = myStats.diceCheck("soul");
            rr.print();
            if (rr.checkResult) {
                doorCheck = true;
                System.out.println("\nWhen you open your eyes, you stand infront of an empty lot. The warehouse was never really there, was it?");
                return;
            } else {
                System.out.println("\nYou smash your face into the closed door. You have to try again, you're this close to freedom.");
            }
        }
    }
    // is combs with you? bring in the alternate encounters!
    if (combsCheck) {
        if (r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {
            printDramaticText("\nA meat monster rushes towards you, trying to attack Combs!");
            RollResult rr = myStats.diceCheck("sturdy");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nYou're able to not only dodge the oncoming attack, but dispatch the meat creature swiftly and efficiently. Combs cheers you on.");
            } 
            else {
                if (myStats.health == 0){
                    System.out.println("\nYou take the brunt of the attack, falling to your knees, no longer able to fight.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou take on the blunt force of the attack. It hurts, and you can feel yourself become weaker, but now isn't the time to stop.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }  
            }
        }
        if (r == 6 || r == 7 || r == 8 || r == 9 || r == 10) {
            printDramaticText("\nThe geometry of the building itself becomes hostile, trying to separate you and your client.");
            RollResult rr = myStats.diceCheck("severe");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nYou smash through a wall, able to keep the young girl safe and sound in your care.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYou're boxed in, disected by concrete and steel supports.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou're able to punch through the wall, but your legs give out once you get through.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 11 || r == 12 || r == 13 || r == 14 || r == 15) {
            printDramaticText("\nThere seems to be a shortcut in the distance. You begin to try and navigate...");
            RollResult rr = myStats.diceCheck("sharp");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nThe warehouse facade is starting to falter. You can see through the cracks and peer at the beating heart of the phenomenon.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nThe true nature of the building reveals itself, and you're constricted by contracting muscles.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou cut through tendon, muscle, and bone to the other side, but you are not unscathed.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 16 || r == 17 || r == 18 || r == 19 || r == 20) {
            printDramaticText("\nThere seems to be a dead end.");
            RollResult rr = myStats.diceCheck("skilled");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nThere's a false wall in here. You and Combs crawl through to the other side.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nFrom what seems to be a false wall, something crawls out, dragging you away.");
                    faintCourage();
                }
                else {
                    System.out.println("\nThere's a false wall! Something begins to crawl out, but you're able to beat it back.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 21 || r == 22 || r == 23 || r == 24 || r == 25) {
            printDramaticText("\nYou find somebody else wandering. They seem terrified, pointing their weapon towards you.");
            RollResult rr = myStats.diceCheck("slick");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nUsing Combs as a bargaining chip (which you feel only slightly bad about), you're able to convince them that you mean no harm.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYou quickly suffer a fatal wound, and you can merely watch as they drag Combs away.");
                    faintCourage();
                }
                else {
                    System.out.println("\nThey attack you, but it's not a fatal wound.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 26 || r == 27 || r == 28 || r == 29 || r == 30) {
            printDramaticText("\nYou're beginning to lose hope that you can find your way out of here.");
            RollResult rr = myStats.diceCheck("soul");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nYou have somebody to save. Just a little further.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nIt's too much to bear.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou have to get out of here. You're hurting, but this is going to end soon. You're going to make sure of it.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
    } else {
        if (r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {
            printDramaticText("\nYou can't find any windows or doors in here. It's just an endless maze of brick walls and concrete. Regardless, you try and push onward.");
            RollResult rr = myStats.diceCheck("sturdy");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nDespite the warehouse itself seeming to be against you, you manage to press onward.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nThe walls constrict, leaving you boxed in.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou slam into exposed rebar on your way through.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 6 || r == 7 || r == 8 || r == 9 || r == 10) {
            printDramaticText("\nSome kind of terrible meat monster stands in your way. You prepare to strike...");
            RollResult rr = myStats.diceCheck("severe");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nIt falls with relative ease. You continue to move forward...");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nIt's too strong for you to handle, and the scuffle quickly goes south.");
                    faintCourage();
                }
                else {
                    System.out.println("\nSomewhat disoriented, you're able to overpower the meat monster, but not without it getting a strike at you first.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 11 || r == 12 || r == 13 || r == 14 || r == 15) {
            printDramaticText("\nA meat monster blocks your path forward. It's too strong to fight, you have to outrun it!");
            RollResult rr = myStats.diceCheck("sharp");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nQuickly as you can, you route around the monster, running into the distance.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYou trip and fall, beginning to sink into the quicksand-like floor of the warehouse, never to be seen again.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou trip on what seems to be a tree trunk-sized artery on your way past, but are otherwise okay.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 16 || r == 17 || r == 18 || r == 19 || r == 20) {
            printDramaticText("\nThe signs before you don't seem to make sense, pointing in directions that you can't reach.");
            RollResult rr = myStats.diceCheck("skilled");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nYou ignore the signs and continue to walk forward, knowing where you should go.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYou become lost in the maze of misleading signs.");
                    faintCourage();
                }
                else {
                    System.out.println("\nYou go in circles for a bit, nearly walking into what looks like an open mouth, but are able to press onward.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 21 || r == 22 || r == 23 || r == 24 || r == 25) {
            printDramaticText("\nYou find somebody else wandering. They seem terrified, pointing their weapon towards you.");
            RollResult rr = myStats.diceCheck("slick");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nWith ease, you convince them that you mean no harm.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYour attempts at conversation only make them angrier, and the small talk ends with your incredibly messy end.");
                    faintCourage();
                }
                else {
                    System.out.println("\nThey stab at you a little bit, but you're able to calm them down.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
        }
        if (r == 26 || r == 27 || r == 28 || r == 29 || r == 30) {
            printDramaticText("\nEverywhere you turn, you end up at a dead end.");
            RollResult rr = myStats.diceCheck("soul");
            rr.print();
            if (rr.checkResult) {
                System.out.println("\nShutting your eyes and continuing to walk, you're able to move forward.");
            } else {
                if (myStats.health == 0){
                    System.out.println("\nYou sit down, allowing yourself to succumb.");
                    faintCourage();
                }
                else {
                    System.out.println("\nDespite hope feeling distant, you know there has to be some way out of here.");
                    myStats.health--;
                    System.out.println("\nRemaining health: "+myStats.health);
                }
            }
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
}
