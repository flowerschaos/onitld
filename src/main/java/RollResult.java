public class RollResult {

    public boolean success;
    public int failed;
    public int[] rolls;

    public RollResult(int failed, int[] rolls, boolean success) {
        this.failed = failed;
        this.rolls = rolls;
        this.success = success;
    }

    public void print() {
        if(this.success) {
            System.out.println("The roll was successful!")
        } else {
            System.out.println("The roll was NOT successful.")
        }

        System.out.println("Original rolls: ")
        for(int roll : this.rolls) {
            System.out.print(roll + " ");
        }

        System.out.println("Failed rolls: " + failed);
    }
    
}
