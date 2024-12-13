package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int[] primes = new int[PrimePrinter.numberOfPrimes + 1];
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];

    public int[] invoke() {
        primes[1] = 2; // Initialise le tableau
        int primeIndex = 1;
        int candidate = 1;
        int ord = 2;
        int square = 9;
        boolean possiblyPrime;

        while (primeIndex < PrimePrinter.numberOfPrimes) { // Utilisation de la constante statique
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                int n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
        return primes;
    }
}
