import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * Created by sutao on 14/11/20.
 */
public class Candy {


    public static class Solution1{

        public int candy(int[] ratings){
            int[] ret = new int[ratings.length];

            for (int i = 0; i < ret.length; ++i) {
                ret[i] = 1;
            }
            for(int i = 1; i < ret.length;++i){
                if (ratings[i] > ratings[i-1]){
                    ret[i] = ret[i-1]+1;
                }
            }

            for (int i = ret.length-2; i >= 0; --i){
                if (ratings[i] >  ratings[i+1]){
                    ret[i] = Math.max(  ret[i+1]+1,  ret[i]);
                }
            }

             int sum = 0;
            for (int i = 0; i < ret.length; ++i) {
                 sum += ret[i];
            }
            return sum;
        }

    }


    public static void main(String a[]){

        Solution1 s = new Solution1();
        s.candy(new int[]{2, 1});
    }




}
