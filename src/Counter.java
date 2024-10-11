public class Counter {
    private int count;


     public synchronized void increment(){ // ek baar mai ek hi thread chale.
         count++;
     }

    public int getCount() {
        return count;
    }
}
