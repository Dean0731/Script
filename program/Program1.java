/**
 * @author Dean0731
 * @date 2020/09/11
 * 最大字段和的升级版，子段只允许有2个数
 * 分治法
 */
package top.dean0731.util.program;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Program1 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        int a[] = {1,1,2,3,2,3,2,3,2,1,1,1,3,1,3,1,3};
        int a[] = {1,2,2,2,2,2,2,1,1,1,1,1,3,3,3};
        Res res = getMax(a,0, a.length-1);

    }
    public static Res getMax(int arr[],int start,int end){
        /*

         */
        if(start==end){
            return new Res(start,end,arr[start]);
        }
        int mid_index = (end+start)/2;
        Res left = getMax(arr,start,mid_index);
        Res right = getMax(arr,mid_index+1,end);
        Res mid = new Res();
        mid.max += arr[mid_index];
        mid.max += arr[mid_index+1];
        if(arr[mid_index]==arr[mid_index+1]){
            Set<Integer> set = new HashSet<>();
            set.add(arr[mid_index]);
            set.add(arr[mid_index+1]);
            int t1 = 0;
            int t1_l = 0;
            for(int i = mid_index-1;i>=0;i--){
                set.add(arr[i]);
                if(set.size()<=1){
                    t1_l = i;
                }
                if(set.size()<=2){
                    mid.l=i;
                    t1 += arr[i];
                }else {
                    break;
                }
            }
            int t2 = 0;
            int t2_r = 0;
            set = new HashSet<>();
            set.add(arr[mid_index]);
            set.add(arr[mid_index+1]);
            for(int i = mid_index+2;i<=end;i++){
                set.add(arr[i]);
                if(set.size()<=1){
                    t2_r = i;
                }
                if(set.size()<=2){
                    mid.r = i;
                    t2 += arr[i];
                }else{
                    break;
                }
            }
            if(t1>t2){
                mid.r = t2_r;
            }else{
                mid.l = t1_l;
            }
            for(int i=mid.l;i<=mid.r;i++) {
                mid.max += arr[i];
            }
        }else{
            mid.l = mid_index;
            mid.r = mid_index+1;
            for(int i = mid_index-1;i>=0;i--){
                if((arr[i]==arr[mid_index])||(arr[i]==arr[mid_index+1])){
                    mid.max += arr[i];
                    mid.l = i;
                }else{
                    break;
                }

            }

            for(int i = mid_index+2;i<=end;i++){
                if(arr[i]==arr[mid_index+1]||arr[i]==arr[mid_index]){
                    mid.max += arr[i];
                    mid.r = i;
                }else{
                    break;
                }
            }

        }


        Res max = left.compareTo(right)?left:right;
        return mid.compareTo(max)?mid:max;
    }
    // 可以用map替代，用于返回多个值
    static class Res{
        int l;
        int r;
        int max;
        public Res(int l,int r,int max){
            this.l = l;
            this.r = r;
            this.max = max;
        }
        public Res(){}

        public boolean compareTo(Object o) {
            if(this.max>((Res)o).max){
                return true;
            }else if(this.max<((Res)o).max){
                return false;
            }
            return false;
        }

    }
}
