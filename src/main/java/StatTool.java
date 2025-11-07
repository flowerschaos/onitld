public class StatTool {
        //stats
        public int sharp = 4;
        public int sturdy = 4;
        public int slick = 4;
        public int severe = 4;
        public int smart = 4;
        public int soul = 4;

        public String name;
        public String sideGig;
        public String bg;

        public int temp;

        //stat value stuff
        public final int parameter_point_max = 24;
        public int parameter_point_current = sharp+sturdy+slick+severe+smart+soul;
        public int totalStatPoints() {
                return sharp + sturdy + slick + severe + smart + soul;
        }
        public int availablePoints() {
                return parameter_point_max - totalStatPoints();
        }


        public StatTool(String name, String sideGig, String bg) {
                this.name = name;
                this.sideGig = sideGig;
                this.bg = bg;
        }

        public void printSheet(){
                System.out.println(this.name+", "+this.bg+" "+this.sideGig);
                System.out.println("==========================");
                System.out.println("Sharp // " + this.sharp);
                System.out.println("Sturdy // " + this.sturdy);
                System.out.println("Slick // " + this.slick);
                System.out.println("Severe // " + this.severe);
                System.out.println("Smart // " + this.smart);
                System.out.println("Soul // " + this.soul);
        }
        public void printSheetWithAllowance(){
                System.out.println(this.name+", "+this.bg+" "+this.sideGig);
                System.out.println("==========================");
                System.out.println("Sharp // " + this.sharp);
                System.out.println("Sturdy // " + this.sturdy);
                System.out.println("Slick // " + this.slick);
                System.out.println("Severe // " + this.severe);
                System.out.println("Smart // " + this.smart);
                System.out.println("Soul // " + this.soul);
                System.out.println("==========================");
                System.out.println("Available Points: "+availablePoints());
        }

        public void statAdjust(String stat, int value) {
                int changeValue = 0;
                // what statistic are you trying to change?
                switch(stat) {
                        case "sharp": changeValue = sharp; break;
                        case "sturdy": changeValue = sturdy; break;
                        case "slick": changeValue = slick; break;
                        case "severe": changeValue = severe; break;
                        case "smart": changeValue = smart; break;
                        case "soul": changeValue = soul; break;
                        default:
                        System.out.println("ERROR: Unknown stat.");
                        return;
                }
                //is your proposed value outside of the parameters for the stat?
                int newValue = changeValue + value;
                if (newValue < 1 || newValue > 8) {
                        System.out.println("ERROR: Stat value must be between 1 and 8.");
                        return;
                }
                //does this go over the allowance?
                int allowanceCheck = sharp + sturdy + slick + severe + smart + soul - changeValue + newValue;
                if (allowanceCheck > 24 || allowanceCheck < 0) {
                        System.out.println("ERROR: Total stat points must be exactly 24. Current total would be " + allowanceCheck);
                        return;
                }
                // if the above checks have passed, Send It
                switch(stat) {
                        case "sharp": sharp = newValue; break;
                        case "sturdy": sturdy = newValue; break;
                        case "slick": slick = newValue; break;
                        case "severe": severe = newValue; break;
                        case "smart": smart = newValue; break;
                        case "soul": soul = newValue; break;
                }
        }
}