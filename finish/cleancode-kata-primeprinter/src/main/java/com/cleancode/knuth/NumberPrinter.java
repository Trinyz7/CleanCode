package com.cleancode.knuth;

public class NumberPrinter {
    private final int linesPerPage;
    private final int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pageoffset = 1; // Explicit declaration
        int pagenumber = 1; // Explicit declaration

        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(numberOfNumbers);
            System.out.print(" Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++) {
                    if (rowoffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }

    public void print(int[] primes, int numberOfPrimes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }
}
