public class RollResult {

    public boolean success;
    public int failed;
    public int[] rolls;
    public String rolledStat;

    public RollResult(String rolledStat, int failed, int[] rolls, boolean success) {
        this.failed = failed;
        this.rolls = rolls;
        this.success = success;
        this.rolledStat = rolledStat;
    }

    public void print() {
        System.out.println("aptitudetest."+rolledStat+".exe loaded.");
        if(this.success) {
            System.out.println("Check cleared. Congratulations.");
        } else {
            System.out.println("Check missed. Good luck.");
        }

        System.out.println("Original rolls: ");
        for(int roll : this.rolls) {
            System.out.print(roll + " ");
        }
    }
}
