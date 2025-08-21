package co.practice;



import java.util.ArrayList;
import java.util.List;

public class VotingProblem {


    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 10, 2, 1, 4,3,6};
        List<Integer> majorityElements = getmajorityElement(nums);
        System.out.println("Majority elements: "+majorityElements);


       //   int[] nums2 = {2,1,1,1,1,3,5,1,1,2};
        int[] nums2 = {2, 1, 6, 6, 6, 6, 6, 5, 5, 5, 5};

        majorityElements = getmajorityElement(nums2);
        System.out.println("Majority elements: "+majorityElements);

    }

    static List<Integer> getmajorityElement(int[] nums) {
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for (int num : nums) {
        /*    if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }*/


            if(count1==0){
                candidate1=num;
                count1=1;
            }else if(count2==0){
                candidate2=num;
                count2=1;
            } else if(candidate1==num){
                count1++;
            } else if (candidate2==num) {
                count2++;
            }else{
                count1--;
                count2--;
            }

        }

        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        if (result.size() == 2 && result.get(0) > result.get(1)) {
            int temp = result.get(0);
            result.set(0, result.get(1));
            result.set(1, temp);
        }

        return result;
    }
}

