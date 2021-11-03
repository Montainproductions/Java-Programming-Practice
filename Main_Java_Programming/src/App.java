import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class App{
    public App(){}

    /* Start of methods for challenges. */

    public void Homework(String numRange){
        /*
        * Problem: https://open.kattis.com/problems/heimavinna
        * Date Started: 07/05/2021
        * Finished: 07/05/2021
        */

        //Seperates all the numbers into an array
        String[] numbers = numRange.split(";");
        int amountOfProblems = 0;
        for(int i = 0; i < numbers.length; i++){

            //If the number is a continuase set from x-y then do the split it and find the amount of problems that have to be solved.
            if(numbers[i].contains("-")) {
                String[] rangeNumbers = numbers[i].split("-");
                for (int v = 0; v < rangeNumbers.length; v+=2) {
                    int highNumber = Integer.parseInt(rangeNumbers[v+1]);
                    int lowNumber = Integer.parseInt(rangeNumbers[v]);
                    int rangeOfProblems = (highNumber - lowNumber)+1;
                    amountOfProblems = amountOfProblems + rangeOfProblems;
                }
            } else {
                amountOfProblems++;
            }
        }
        System.out.println("Amount of Problems: " + amountOfProblems);
    }

    public void Tarifa(int megaBytes, int months, int[] array){
        /*
        * Problem: https://open.kattis.com/problems/tarifa
        * Date Started: 07/05/2021
        * Date Finished: 07/05/2021
        */

        int totalAmountOfMB = megaBytes * months + megaBytes;
        for(int i = 0; i<array.length;i++){totalAmountOfMB = totalAmountOfMB-array[i];}
        System.out.println(totalAmountOfMB);
    }

    public void Inflation(int ballonAmount, ArrayList<Integer> gasArray){
        /*
        * Problem: https://open.kattis.com/problems/inflation
        * Date Started: 09/05/2021
        * Date Finished: 10/05/2021
        */
        
        Collections.sort(gasArray);
        float fraction = 1;

        //Goes through each of the ballons sizes and then goes through each of the gas amount in canasters
        outerloop:
        for(float i=1; i<(ballonAmount+1); i++){
            for(int v = 0; v<gasArray.size();v++){
                int currentGas = gasArray.get(v);
                //Checks if it is possible to fill the ballon and does it.
                if (currentGas<=i){
                    float placeHolder = currentGas/i;
                    if (placeHolder <= fraction){
                        //Find and prints the lowest possible amount that a ballon will be inflated.
                        System.out.println("Final fraction: " + fraction);
                        fraction = placeHolder;
                    }
                    gasArray.remove(v);
                }else if(currentGas > 1){
                    System.out.println("Impossible");
                    break outerloop;
                }
            }
        }
    }

    public void MixedFractions(int [] allFractions){
        /*
        * Problem: https://open.kattis.com/problems/mixedfractions
        * Date Started: 30/07/2021
        * Date Ended: 30/07/2021
        */

        for (int i = 0; i < allFractions.length; i = i+2){
            int numerator = allFractions[i];
            int denominator = allFractions[i+1];
            if (numerator == 0 && denominator == 0){ //End Of Array
                //System.out.println("Array has finished.");
                break;
            } else if(numerator < denominator){ //If its a proper fraction
                System.out.println("0 " + numerator + " / " + denominator);
            } else if(numerator > denominator){ //Mixed Fraction
                int decimalFullValue = numerator/denominator; //First find the whole number.
                int numeratorWholeValue = decimalFullValue * denominator; //Find the numerator size value of the whole number
                numerator = numerator - numeratorWholeValue; //Subtract the larger whole number from the numerator to find the remaing numerator.
                System.out.println(decimalFullValue + " " + numerator + " / " + denominator);
            }else if(numerator == denominator){ //if fraction is 1
                System.out.println("1");
            }
        }

    }

    public int min(int[] array){
        //Will find the lowest number in an array
        int lowestNumb = Double.POSITIVE_INFINITY;
        for (int i : array) {
            if(i < lowestNumb){lowestNumb = i;}
        }

        return lowestNumb;
    }

    public int max(int[] array){
        //Will find the lowest number in an array
        int largestNumb = Double.NEGATIVE_INFINITY;
        for (int i : array) {
            if(i > largestNumb){largestNumb = i;}
        }
        return largestNumb;
    }

    public int range(int largestNumb, int lowestNumb){
        //Will find the range inbetween two numbers
        int rangeNumb = largestNumb - lowestNumb;

        return rangeNumb;
    }

    public void stirlingAproximation(int N){
        /*
        * Problem: https://open.kattis.com/problems/stirlingsapproximation
        * Date Started: 14/08/2021
        * Date Ended: 14/08/2021
        */
        int factNumber = factorialOfN(N);
        double stirEqu = stirlingsEquation(N);

    }

    public int factorialOfN(int N){
        //Will recursivly find the factorial of N (Though this does have the big notation of O(N!))
        if (N == 0){return 1;}
        else{return(N * factorialOfN(N-1));}
    }

    public double stirlingsEquation(int N) {
        //Will find the stirling number which is a extreamly close aproximination of a factorial N but has a faster big notaion of O(n)
        double sqrRoot = Math.sqrt(2*Math.PI*N);
        double exponential = Math.pow(N, N)/Math.exp(N);
        double sOfN = sqrRoot * exponential;
        return sOfN;
    }
}