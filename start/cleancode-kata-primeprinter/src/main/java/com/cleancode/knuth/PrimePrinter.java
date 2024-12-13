package com.cleancode.knuth;

public class PrimePrinter {

    public static final int numberOfPrimes = 1000; 

    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper(); 
        int[] primes = helper.invoke(); 
        printNumbers(primes, numberOfPrimes); 
    }

    public static void printNumbers(int[] numbers, int numberOfNumbers) {
        int linesPerPage = 50;
        int columns = 4;
        int pageoffset = 1;
        int pagenumber = 1;

        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(numberOfNumbers);
            System.out.print(" Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
}
