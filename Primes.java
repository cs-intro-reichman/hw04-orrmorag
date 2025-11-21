public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[] isPrime = new boolean[n + 1];
        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int j = p * p;
                while (j <= n) {
                    isPrime[j] = false;
                    j += p;
                }
            }
            p++;
        }

        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        int k = 2;

        while (k <= n) {
            if (isPrime[k]) {
                System.out.println(k);
                count++;
            }
            k++;
        }

        int percentage = (int) Math.round((count * 100.0) / n);
        System.out.println("There are " + count + " primes between 2 and " + n +
                           " (" + percentage + "% are primes)");
    }
}