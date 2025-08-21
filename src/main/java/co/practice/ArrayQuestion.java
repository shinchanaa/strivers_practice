package co.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayQuestion {



    public static void main(String[] args) {


       // int[] arr = {0,0,1,1,1, 2, 3, 3,4,4, 5};
        //int[] arr = {8, 8, 7, 6, 5};
        int[] arr = {3, 5, 0, 0, 4};

        Arrays.sort(arr);
        System.out.println("*******");
        Arrays.stream(arr).forEach(System.out::println);



       // System.out.println("Second: "+secondLargestElement(arr));

       // int sum = findMaxInArray(arr);
       // System.out.println("Max of the array elements: " + sum);

        int secondMax = findSecondMaxInArrayOptimal(arr);
        System.out.println("Second max number would be : "+secondMax);

        System.out.println("ISSORTED: " + isArraySorted(arr));

        removeDuplicateElementFromsortedArray(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static int secondLargestElement(int[] nums) {
        int max=nums[0];
        for(int n:nums){
            if(n>max){
                max=n;
            }
        }

        System.out.println("Max: "+max);

        int smax=-1;

        for(int n:nums){
            if(n>smax && n!=max){
                smax=n;
            }
        }

        return smax;
    }

    private static int findMaxInArray(int[] arr){

        int max=0;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];

            }
        }
        System.out.println("Max number would be : "+max);
        return max;

    }

    private static int findSecondMaxInArray(int[] arr){

        int max=arr[0]; int secondMax=0;
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];

            }
        }
        for(int i=1;i<arr.length;i++){
           if(secondMax < arr[i] && arr[i]!=max)
                secondMax=arr[i];
        }

        return secondMax;

    }


    private static int findSecondMaxInArrayOptimal(int[] arr){

        int max=arr[0]; int secondMax=-1;  //INT_MIN
        for(int i=1;i<arr.length;i++){
            if(max<arr[i] ){
                secondMax=max;
                max=arr[i];
            }
            if(arr[i]>secondMax && arr[i]!=max)   //we can also use condition as if(arr[i]<max && arr[i]>secondMax)  secondMax=arr[i];
                secondMax=arr[i];
        }

        return secondMax;

    }


    private static  boolean isArraySorted(int [] arr){
        boolean isArraySorted=true;
        for (int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                return false;            }
        }
        return isArraySorted;

    }

    private static void removeDuplicateElementFromsortedArray(int arr[]){

        Set<Integer> sortedUniqueSet = new HashSet<>();

        for (int i=0;i<arr.length;i++){
            sortedUniqueSet.add(arr[i]);

        }

        int index=0;
        for( Integer it:sortedUniqueSet){
            arr[index]=it;
            index++;
        }


        System.out.println(sortedUniqueSet);

        int j=0;

        for (int i=1;i<arr.length;i++){
           if(arr[i]!=arr[j]){
               j++;
               arr[j]=arr[i];
            }

        }




    }




}
