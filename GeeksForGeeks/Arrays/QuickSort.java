package GeeksForGeeks.Arrays;
//QuickSort program
public class QuickSort {
    private int partition(int[]arr,int low,int high) {
        int x = arr[high];
        int i=low-1;
        for (int j = low; j<=high-1; j++) {
            if(arr[j]<=x){
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public void quickSort(int[]a,int low,int high){
        if(low<high){
            int p= partition(a,low,high);
            quickSort(a,1,p-1);
            quickSort(a,p+1,high);
        }
    }

    public static void main(String[] args) {
        int[]arr ={15,8,1,4,2};
        QuickSort quick = new QuickSort();
        quick.quickSort(arr,0,4);
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }

    }
}
