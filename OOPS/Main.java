import java.util.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        //compareBinVsLin();
        exercise();

    }

    //Exercise for the team.
    private static void exercise() {

        //Create a random list of 1 million integers
        int size = 1000000;
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);

        long startTime = System.currentTimeMillis();

        //Do linear search for a record 230000
        int searchVal = 230000;

        for(int i = 0; i < size; i++) {
            if(searchVal == arr[i])
                break;
        }
        //Time it
        System.out.println("Total time for linearSearch: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();

        //Calculate the time to sort this list
        Arrays.sort(arr);
        System.out.println("Total time for sort: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();

        //Use binary search to find the same 230000 number
        int retVal = Arrays.binarySearch(arr, searchVal);
        //Time it
        System.out.println("Total time for binarySearch: " + (System.currentTimeMillis() - startTime));


    }

    private static void compareBinVsLin() {
        int size = 1000000;
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);

        System.out.println("******" + arr[0]);

        Arrays.sort(arr);

        // entering the value to be searched
        int searchVal = 220000;

        long startTime = System.currentTimeMillis();

        int retVal = Arrays.binarySearch(arr, searchVal);

        Collections.shuffle(list);

        if (retVal > -1) {
            System.out.println("Object Found!!!! ");
        } else {
            System.out.println("Object Not Found!!!!");
        }

        System.out.println("Total time to search: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();

        boolean found = false;
        for(int i = 0; i < size; i++) {
            if(searchVal == arr[i]) {
                found = true;
            }
        }

        if(found) {
            System.out.println("Object Found!!!! ");
        } else {
            System.out.println("Object Not Found!!!!");
        }

        System.out.println("Total time to search: " + (System.currentTimeMillis() - startTime));
    }
}
