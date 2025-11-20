public class RollResult {

    public boolean checkResult;
    public int failed;
    public int[] rolls;
    public String rolledStat;

    public RollResult(String rolledStat, int failed, int[] rolls, boolean checkResult) {
        this.failed = failed;
        this.rolls = rolls;
        this.checkResult = checkResult;
        this.rolledStat = rolledStat;
    }

    public void print() {
        System.out.println("aptitudetest."+rolledStat+".exe loaded.");
        if(this.checkResult) {
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
