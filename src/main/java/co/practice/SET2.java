package co.practice;


import java.util.Arrays;

public class SET2 {


    public static void main(String[] args) {

        permutationQuestion();
        //stockBuyAndSellWithNoLimit();
        //stockBuyAndSellWithOneLimit();

        //System.out.println( "minimumHeightDifference() "+minimumHeightDifference());


    }

    private static int minimumHeightDifference() {

      //  int arr[] = {12, 6, 4, 15, 17, 10};
        int arr[] = {3, 9, 12, 16, 20};
        Arrays.sort(arr);
        int k=3;
        int len=arr.length;
        int res= arr[len-1]-arr[0];

        for(int i=1;i<len;i++){
                if(arr[i]-k<0){
                    continue;
                }

                int minH= getMin(arr[0]+k,arr[i]-k);

                int maxH= getMax(arr[i-1]+k,arr[len-1]-k);

                res = getMin(res,maxH-minH);
        }

        return res;
    }


    private static  <T extends Comparable<T>>  T getMin( T a, T b){
        if( a.compareTo(b) > 0)
            return b;
        return a;
    }

    private static <T extends Comparable<T>>  T getMax( T a, T b){
        if( a.compareTo(b) > 0)
            return a;
        return b;
    }

    private static void stockBuyAndSellWithOneLimit() {
        //int arr[] = {100, 180, 260, 310, 40, 535,695};
       // int arr[] = {5, 4, 3, 2, 1};
       int arr[] = {7, 1, 5, 3, 6,4 };
       // System.out.println("profit: " +stockBuySellWithOneLimit(arr));
        System.out.println("profit: " +stockBuySellWithOneLimitApp2(arr));

    }

    private static int stockBuySellWithOneLimitApp2(int[] arr) {

        int min=arr[0];
        int profit;
        int res=0;
        for(int i=1;i<arr.length-1;i++){

            profit= arr[i]-min;
            if(profit>res){
                res=profit;
            }else if(profit<0){
                min=arr[i];
            }
        }

        return res;


    }

    private static int  stockBuySellWithOneLimit(int[] arr) {
        boolean desc=true;
        int profit=0;
        for(int i = 0; i< arr.length-1; i++){
            if(arr[i+1]> arr[i]){
                desc=false;
                break;
            }
        }

        if(desc){
            return profit;
        }

        int temmax;
        for(int i = 0; i< arr.length-2; i++){
            temmax = arr[i+1];
            for(int j = i+2; j< arr.length; j++){
                if(arr[j]> temmax && temmax != arr[i]){
                    temmax= arr[j];
                }
            }

            int diff= temmax- arr[i];
            if(diff>profit)
                profit=diff;

        }

        return profit;
    }

    private static void stockBuyAndSellWithNoLimit() {
        //int arr[] = {100, 180, 260, 310, 40, 535,695};
       //int arr[] = {4, 2, 2, 2, 4};
        int arr[] = {1, 5, 3, 8, 12};

       // System.out.println(maxProfit(arr,0,arr.length));
       // System.out.println(maxProfitLocalMinMax(arr));
       // System.out.println(maxProfitAccumulative(arr));

    }




    static int maxProfitLocalMinMax(int price[]){

        int res=0;


        int i=0;
        int n=price.length;
        int lmin=0;
        int lmax=0;


        while(i < n-1){

            while(i < n-1 &&  price[i]>=price[i+1]){
                i++;
            }
            lmin=price[i];

            while(i < n-1 &&  price[i] <=price[i+1]){
                i++;
            }
            lmax=price[i];

            res+=lmax-lmin;

        }

        return res;

    }

    static int maxProfit(int price[],int start,int end){
        int res=0;
        int curr;
        for(int i=start;i<end;i++){
            for(int j=i+1;j<end;j++){
                if(price[j]>price[i]){
                    curr= (price[j]-price[i])
                            + maxProfit(price,start,i-1)
                            + maxProfit(price,j+1,end);

                    if(curr>res)
                        res=curr;
                }

            }

        }
        return res;
    }


    static int maxProfitAccumulative(int price[]){

        int res=0;
        for( int i=0;i<price.length-1;i++){

            if(price[i+1]>price[i]){
                res+=price[i+1]-price[i];
            }
        }
        return res;
    }

    private static void permutationQuestion() {
        // Additional logic can be added here
        System.out.println(findRightMostSmallestNUmber(new int[]{2, 4, 1, 7, 5, 0}));
        System.out.println(findRightMostSmallestNUmber(new int[]{5, 2, 4, 3, 1}));

        int arr[] = {2, 4, 1, 7, 5, 0};
        System.out.println("Array before swapping and sorting: " + Arrays.toString(arr));
        int index = findRightMostSmallestNUmber(arr);


        if (index != -1) {

            int max = Integer.MIN_VALUE;
            int nextGreater= Integer.MAX_VALUE;
            int nextGreaterIndex = -1;
            for (int i = index; i < arr.length; i++) {
                if (arr[i] > arr[index]) {
                    if( arr[i] < nextGreater) {
                        nextGreater = arr[i];
                        nextGreaterIndex= i;
                    }

                }
            }
            System.out.println("Next greater element after index " + index + " is: " + nextGreater);
            System.out.println("Next greater element index is: " + nextGreaterIndex);
           int temp =arr[nextGreaterIndex];
           arr[nextGreaterIndex] = arr[index];
              arr[index] = temp;
            Arrays.sort(arr,index+1, arr.length);
        }

        System.out.println("Array after swapping and sorting: " + Arrays.toString(arr));
        //  int arr2[] = {5, 2, 4, 3, 1};
        int arr2[] = {3,2,1};
        permutationQuestion(arr2);
        System.out.println("Array after permutation: " +
                Arrays.toString(arr2));
    }

    static int findRightMostSmallestNUmber(int arr[]){

        //find the right most element smallest than the next number in the array
        //2 ,4, 1, 7, 5, 0  -->from right to left 1 is the right most smallest number than 7
        //like 1 breaks the sequence of increasing order

        for(int i=arr.length-1; i>0;i--){

            if(arr[i-1]<arr[i]){
                return i-1;
            }
        }
        return -1; // if no such element found


    }
    static void permutationQuestion(int arr[]){
        int index = findRightMostNextSmallestNUmber(arr);
        if(index != -1){
           int nearestNum= findNearestGreaterElementAfterGivenIndex(arr,index);
               {
                int temp = arr[nearestNum];
                arr[nearestNum] = arr[index];
                arr[index] = temp;
              }
            Arrays.sort(arr,index+1, arr.length);
        } else{
            // If no such index found, it means the array is in descending order
            // Reverse the entire array to get the smallest permutation
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }


    }

    private static int findNearestGreaterElementAfterGivenIndex(int[] arr,int index) {
        int nextGreater= Integer.MAX_VALUE;
        int nextGreaterIndex = -1;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                if( arr[i] < nextGreater) {
                    nextGreater = arr[i];
                    nextGreaterIndex= i;
                }

            }
        }
        return nextGreaterIndex;
    }

    static int findRightMostNextSmallestNUmber(int arr[]){
        for(int i=arr.length-1; i>0;i--){
            if(arr[i-1]<arr[i]){
                return i-1;
            }
        }
        return -1;


    }

}