public class Primes {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Primes <number>");
            return;
        }
        try {
            int n = Integer.parseInt(args[0]);
            if (n <= 1) {
                System.out.println("No primes between 2 and " + n);
                return;
            }
            System.out.println("Prime numbers up to " + n + ":");
            findPrimes(n);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide an integer.");
        }
    }
    
    public static void findPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("There are " + count + " primes between 2 and " + n + 
                           " (" + String.format("%.0f", (double)count * 100 / (n - 1)) + "% are primes)");
    }
}