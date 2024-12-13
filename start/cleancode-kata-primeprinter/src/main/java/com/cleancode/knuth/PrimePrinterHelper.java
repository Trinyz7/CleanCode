package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int numberOfPrimes = 1000;
    private final int[] primes = new int[numberOfPrimes + 1];
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];

    public void print() {
        primes[1] = 2; 
        int primeIndex = 1; 
        int candidate = 1; 
        int ord = 2; 
        int square = 9; 

        boolean possiblyPrime; 

        while (primeIndex < numberOfPrimes) {
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


        printPrimes(primes, numberOfPrimes);
    }

    public void printPrimes(int[] primes, int numberOfPrimes) {
        int pageoffset = 1;
        int pagenumber = 1;

        while (pageoffset <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(numberOfPrimes);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfPrimes)
                        System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
}
