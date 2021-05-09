package top.dean0731.util.program;
import top.dean0731.util.tools.PrintUtil;
/**
 * @author Dean0731
 * @date 2021/04/06
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 *
 */
public class Program2 {
    public static void main(String[] args) {
        int a[] = {1,1,1,2,2,2,2,2,3,3,3,4};
        System.out.println(getLength(a));
        PrintUtil.print(a);
    }
    public static int  getLength(int[] num){
        int index=0;
        if(num.length<3){
            return num.length;
        }
        int k=0;
        for(int i=0;i<num.length;i++){
            if(i==num.length-2){
                k+=2;
                num[index]=num[i];
                num[index+1]=num[i+1];
                break;
            }
            if(i==num.length-1){
                k++;
                num[index]=num[i];
                break;
            }
            if(num[i]!=num[i+1]){
                k++;
                num[index]=num[i];
                index++;
                continue;
            }else{
                k+=2;
                num[index]=num[i];
                num[index+1]=num[i+1];
                index = index+2;
                if(num[i]==num[i+2]){
                    i = getNext(num,i+2)-1;
                }else{
                    i=i+2-1;
                }
            }
        }
        return k;
    }
    public static int getNext(int num[],int start){
        for(int i=start+1;i<num.length;i++){
            if(num[i]!=num[start]){
                return i;
            }
        }
        return num.length;
    }
}
// 1ms 38.8
// 1ms 38.2