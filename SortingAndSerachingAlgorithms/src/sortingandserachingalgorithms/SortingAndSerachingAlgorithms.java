/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingandserachingalgorithms;

import java.util.Arrays;

/**
 *
 * @author milan
 */
public class SortingAndSerachingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int list[] =  new int[]{1,5,4,-4,10,60,6,23,0,42};
        System.out.println(Arrays.toString(list));
        //selectionSort(list);
        list =  new int[]{1,5,4,-4,10,60,6,23,0,42};
        System.out.println("\nBubble sort: \n"+Arrays.toString(list));

       // bubbleSort(list);
        
        String[] lists = new String[]{"Fione","Dora","Alex","Jeff","Elise","Irene","Gerald","Ben"};
        quickSort(lists, 0, lists.length-1);
                System.out.println("\nBubble sort: \n"+Arrays.toString(lists));
                
        System.out.println("Index of 60 is: "+  linaerSearch(list, 60));

         
        

    }
    
    public static void swap(int[] list, int iIndex, int jIndex){
        int temp =  list[iIndex];
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;    
    }
        public static void swap(String[] list, int iIndex, int jIndex){
        String temp =  list[iIndex];
        list[iIndex] = list[jIndex];
        list[jIndex] = temp;    
    }
    public static void selectionSort(int[] listToSort){
        
        for(int i=0;i<listToSort.length;i++){
        
            for(int j= i+1; j<listToSort.length;j++){
                if(listToSort[i]>listToSort[j]){
                    swap(listToSort,i,j);
                }
            }
        }
        System.out.println(Arrays.toString(listToSort));        
    }
    
    public static void bubbleSort(int [] listToSort){
        
        for(int i=listToSort.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(listToSort[j]>listToSort[j+1]){
                    swap(listToSort, j, j+1);
                }
                
            }
        }
        System.out.println(Arrays.toString(listToSort));
        
    }
    public static void bubbleSortWithEarlyStop(int []listToSort){
        
        for(int i= listToSort.length;i>0;i++){
            
            boolean swaped = false;
            for(int j=0;j<i;j++){
                if(listToSort[j]>listToSort[j+1]){
                    swap(listToSort, j, j+1);
                    swaped=true;
                }
            }
            
            if(!swaped)
                break;
        
        }
    
    }
    public static void insertionSort(int[] listToSort){
        for(int i=0;i<listToSort.length;i++){
            
            for(int j=i+1;j>0;j--){
                if(listToSort[j]<listToSort[j-1]){
                    swap(listToSort, j, j-1);
                    
                }else
                    break;
            }
        
        }
    }
    public static void shellSort(int[] listToSort){
         int increment = listToSort.length /2;
         
         while(increment>1){
             insertionSort(listToSort,increment);
             increment= increment /2;
         }
    }

    public static void insertionSort(int[] listToSort, int increment) {
        for(int i=0;i+increment<listToSort.length;i++){
            for(int j=i +increment;j-increment>=0;j=j-increment){
                if(listToSort[j]<listToSort[j-increment]){
                    swap(listToSort, j, j-increment);
                
                }else{
                    break;
                }
            }
        }

    }
    
    public static void split(String[] listToSort,String[] firstHalf, String[] secondHalf){
        int secondHlafStartIndex = firstHalf.length;
        
        for(int index =0;index<listToSort.length;index++){
            if(index <secondHlafStartIndex){
                firstHalf[index] = listToSort[index];
            }else{
                secondHalf[index -secondHlafStartIndex]= listToSort[index];
            }
        }
    
    }
    
    public static void merge(String[] listToSort, String[] listFistHalf, String[] listSecondHalf){
        int mergeIndex =0;
        
        int firstHalfIndex = 0;
        int secondHalfINdex=0;
        
        while(firstHalfIndex<listFistHalf.length && secondHalfINdex<listSecondHalf.length){
        
            if(listFistHalf[firstHalfIndex].compareTo(listSecondHalf[secondHalfINdex])<0){
                listToSort[mergeIndex] = listFistHalf[firstHalfIndex];
                firstHalfIndex++;
            }else if(secondHalfINdex< listSecondHalf.length){
                listToSort[mergeIndex] = listSecondHalf[secondHalfINdex];
                secondHalfINdex++;
            }
            mergeIndex++;     
        }
        
        if(firstHalfIndex<listToSort.length){
            while (mergeIndex<listToSort.length){
                listToSort[mergeIndex++] = listFistHalf[firstHalfIndex++];
            }
        }
        
                if(secondHalfINdex<listToSort.length){
            while (mergeIndex<listToSort.length){
                listToSort[mergeIndex++] = listSecondHalf[secondHalfINdex++];
            }
        }
    }
    
    public static void mergeSort(String[] listToSort){
        if(listToSort.length==1)
            return;
        
        int mid = listToSort.length/2 + listToSort.length%2;
        
        String [] listFirstHalf = new String[mid];
        String[] listSecondHalf = new String[listToSort.length-mid];
        
        split(listToSort, listFirstHalf, listSecondHalf);
    
        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);
        
        merge(listToSort, listFirstHalf, listSecondHalf);
        
    }
    
    public static int partition(String[] listToSort, int low, int high){
        String pivot = listToSort[low];
        
        int l = low;
        int h = high;
        System.out.println(listToSort.length+""+high);
        
        while(l<h){
            
            while(listToSort[l].compareTo(pivot)<=0 && l<h ){
                l++;
            }
                    System.out.println(high);

            while(listToSort[h].compareTo(pivot)>0){
                h--;
            }
            
            if(l<h)
                swap(listToSort, l, h);          
        }
        
        swap(listToSort, low, h);
        
        
        return h;
    }
    //O(N * log N)
    public static void quickSort(String[] listToSort, int low, int high){
        
        if(low>=high)
            return;
                System.out.println(listToSort.length+""+high);

        int pivodIndex = partition(listToSort, low, high);
        
        quickSort(listToSort, low, pivodIndex-1);
        quickSort(listToSort, pivodIndex+1, high);
        
    }
    //O(n)
    public static int linaerSearch(int[] list, int target){
        int result =-1;
        
        for(int i=0;i<list.length;i++){
            if(list[i]==target){
                return i;
            }
        }
        
        
        return result;
    }
}
