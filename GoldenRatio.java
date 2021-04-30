/**
 * To execute this file, you'll have to compile this file within your command line with:
 * 
 *      javac GoldenRatio.java
 *
 *  Then run in your command line with:
 * 
 *      java GoldenRatio <value>
 * 
 * @author Erick Saenz-Gardea
 * @version 1.0
 * @since 2021-04-29
 */

/**
 * 
 */
public class GoldenRatio{
    static double a = 0;
    static double b = 1;

    public static void main(String[] args){
        int sequenceLength = extractSequenceLengthIntFromArg(args);
        sequenceCheck(sequenceLength);
        findLastTwoValues(sequenceLength);
        PrintSequenceValues();
        calcRatio();        
    }


    private static void PrintSequenceValues(){
        System.out.print("The second to last value in the sequence is: ");
        System.out.println(a);
        System.out.print("The last value in the sequence is ");
        System.out.println(b);
    }

    /**
     * This method will set the global variables "a" and "b" to their respective values within 
     * the fibonacci sequence
     * Example:
     *          0, 1, 1, 2 ,3 ,4
     *                   a  b
     * @param seqLength
     */
    private static void findLastTwoValues(int seqLength){
        double c;
        while(seqLength - 2 > 0){
            c = a + b;
            a = b;
            b = c;
            seqLength--;
        }
    }

    /**
     * This method determines if the sequence value in in range
     *      where n > 1
     * If the sequence is not in range then the program will exit 
     * @param arg
     */
    private static void sequenceCheck(int arg){
        if(arg < 2){
            System.out.println("*********************** Uh oh ***********************");
            System.out.println("Please enter an integer greater than 1 next time!");
            System.out.println("Exiting!");
            System.out.println("*********************** Uh oh ***********************");
            System.exit(0);
        }        

        if(arg == 2){
            System.out.println("*********************** Infinity Warning ***********************");
            System.out.println("You are dividing by 0!");
            System.out.println("*********************** Infinity Warning ***********************");
        }
    }

    /**
     * This method will extract the user-specified sequence in from the command line
     * @param cmdArg the string array from the command line
     * @exception NumberFormatException is caused by either trying to parse non-numeric charachters or integers larger than 2147483648
     * @exception ArrayIndexOutOfBoundsException is caused by entering a " " (space) instead of an integer
     * @return the integer from the command line 
     */
    private static int extractSequenceLengthIntFromArg(String[] cmdArg){
        int temp = 0;
        try{
            temp = Integer.parseInt(cmdArg[0]);            
        } catch(NumberFormatException e){
            System.out.println("*********************** Uh oh ***********************");
            System.out.println("Please enter a numeric character next time!");
            System.out.println("Also make sure your integer is less than '2147483648'!");
            System.out.println("Exiting!");
            System.out.println("*********************** Uh oh ***********************");
            System.exit(0);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("*********************** Uh oh ***********************");
            System.out.println("Please enter an integer next time!");
            System.out.println("Exiting!");
            System.out.println("*********************** Uh oh ***********************");
            System.exit(0);
        } 
        return(temp);
    }

    /**
     * This method will print and determine the ratio between the second to last number
     * and the last number in the sequence given
     */
    private static void calcRatio(){
        System.out.println(b / a);
    }
}