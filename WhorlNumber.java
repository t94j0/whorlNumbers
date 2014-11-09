import java.util.Scanner;
import java.util.*;
public class WhorlNumber{
  private static final int[] whorl = {16,8,4,2,1};
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    
    //Getting Input formatted correctly
    System.out.print("Enter 2 numbers seperated by \', \':");
    String numsRaw = s.nextLine();
    String[] nums = numsRaw.split(", ");
    int[] num = {Integer.parseInt(nums[0]), Integer.parseInt(nums[1])};
    
    //Starting with the process of parsing numbers
    int[] numerator = autoMagic(findWhorl(num[0]), true), denominator = autoMagic(findWhorl(num[1]), false);
    if(numerator.length == 0 && denominator.length == 0){
      System.out.println("None");
    }
    String t = "";
    for(int f : numerator){
      t += f + ", ";
    }
    for(int f : denominator){
      t += f+ ", ";
    }
    String finalnum = t.substring(0, t.length() - 2);
    System.out.println(finalnum);
  }
  
  //true = even
  public static int[] autoMagic(int[] arr, boolean eoro){
    ArrayList<Integer> t = new ArrayList<Integer>();
    if(eoro){
      for(int f : arr){
        switch(f){
          case 16:
            t.add(2);
            break;
          case 8:
            t.add(4);
            break;
          case 4:
            t.add(6);
            break;
          case 2:
            t.add(8);
            break;
          case 1:
            t.add(10);
            break;
        }
      }
    }else{
      for(int f : arr){
        switch(f){
          case 16:
            t.add(1);
            break;
          case 8:
            t.add(3);
            break;
          case 4:
            t.add(5);
            break;
          case 2:
            t.add(7);
            break;
          case 1:
            t.add(9);
            break;
        }
      }
    }
    return convertInt(t);
  }
  
  public static int[] findWhorl(int num){
    num--;
    ArrayList<Integer> l = new ArrayList<Integer>();
    for(int a = 0; a<whorl.length; a++){
      if(num-whorl[a]>=0){
        num-=whorl[a];
        l.add(whorl[a]);
      }
    }
    return convertInt(l);
    
  }
  public static int[] convertInt(List<Integer> integer){
    int[] arr = new int[integer.size()];
    Iterator<Integer> i = integer.iterator();
    for(int k = 0; k < arr.length; k++){
      arr[k] = i.next().intValue();
    }
    return arr;
  }
}