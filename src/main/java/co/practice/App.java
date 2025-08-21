package co.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int smax= Integer.MIN_VALUE;

        Integer[] arr = {0,0,1,1,1, 2, 3, 3,4,4, 5};
       // Integer[] arr = {8, 8, 7, 6, 5};

       // System.out.println(smax(arr));
        System.out.println(unique(arr));


    }

  static Integer smax(Integer []arr){
        Integer max= arr[0];
        Integer smax= Integer.MIN_VALUE;

        for(int i=1;i<arr.length;i++){

            if(max<arr[i]){
                smax=max;
                max=arr[i];
            }

            if(smax<arr[i] && arr[i]!=max){
                smax=arr[i];
            }


        }

        return  smax;
    }

    static Integer unique(Integer []arr){
        /*Set uniqueSet= new HashSet();
        for(int i=1;i<arr.length;i++){

           uniqueSet.add(arr[i]);


        }
        uniqueSet.stream().forEach(System.out::println);*/

        int j=0;
        for(int i=1;i<arr.length;i++){

          if(arr[i]!=arr[j]){
              j++;
              arr[j]=arr[i];
          }


        }
        for(int i=0;i<=j;i++){
            System.out.println(arr[i]);
        }

        return  0;
    }
}
