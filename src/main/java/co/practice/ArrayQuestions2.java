package co.practice;

import java.util.*;

public class ArrayQuestions2 {

    public static void main(String[] args){

        // int[] arr = {0,0,1,1,1, 2, 3, 3,4,4, 5};
       // int[] arr = {8, 7, 6, 5,4};
       // int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
       // int[] arr = {4, 2, 2, 2, 4};
        //int[] arr = {86 ,92, 24 ,5 ,34, 72 ,68 ,52 ,27 ,95, 41, 28, 35};
        int[] arr = {1,2,3,4,5,6};
      //  rotateByKTimes(arr,7);
       // Arrays.stream(arr).forEach(System.out::print);
        reverse(arr, 2, arr.length-1);
//        for(Integer i:findMajority(arr)){
//            System.out.println(i);
//        }
        System.out.println("Reversed Array: ");
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();

        // Example usage of maximumProfit
        // int[] prices = {7, 1, 5, 3, 6, 4};
        // System.out.println(maximumProfit(prices));

        // Example usage of findMajority
        // int[] arr = {3, 2, 3};
        // System.out.println(findMajority(arr));

        // Example usage of rotateByKTimes
        // int[] arr = {1, 2, 3, 4, 5};
        // rotateByKTimes(arr, 2);
     //   System.out.println(maximumProfit(arr));

    }

    static void reverse(int arr[],int right,int left){

        while(right<left){
            int temp= arr[right];
            arr[right]=arr[left];
            arr[left]=temp;
            right++;
            left--;
        }


    }

    static void rotateByKTimes(int []arr,int k){

        int [] result = new int[arr.length];
        int index=0;
        k=k % arr.length;
        for(int i=k;i<arr.length;i++){
            result[index++]=arr[i];
        }
        for (int j=0;j<k;j++){
            result[index++]=arr[j];
        }

        index=0;
       for(int data:result){
           arr[index++]=data;
       }

    }

    //void rotateByOneStep

    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.

        List<Integer> result= new ArrayList<>();
        Map<Integer,Integer> voteCount = new HashMap<>();
        int count;
        for(int i=0;i<nums.length;i++){

            if(!voteCount.containsKey(nums[i])){
                voteCount.put(nums[i],0);
            }else{
                count=voteCount.get(nums[i]);
                voteCount.put(nums[i],count+1);
            }

        }
        System.out.println(voteCount);

        int maxVote=nums.length/3;
        System.out.println(maxVote);
        for (Map.Entry<Integer,Integer> entry:voteCount.entrySet()){
            if(entry.getValue()>=maxVote){
                result.add(entry.getKey());
            }

        }

        return result;

    }


    public static int maximumProfit(int prices[]) {

        int first=prices[0];
        int profit=0;

        for(int i=1;i<prices.length;i++){

            if(prices[i]>first){
                continue;
            }else{
                profit = profit + (prices[i-1]-first);
                first=prices[i];

            }
        }
        if(prices[prices.length-1]>first){
            profit = profit + (prices[prices.length-1]-first);
        }

        return profit;
        // code here

    }


    }

