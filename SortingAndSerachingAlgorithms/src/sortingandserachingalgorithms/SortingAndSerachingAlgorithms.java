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
        selectionSort(list);
        list =  new int[]{1,5,4,-4,10,60,6,23,0,42};
        System.out.println("\nBubble sort: \n"+Arrays.toString(list));

        bubbleSort(list);
         
        

    }
    
    public static void swap(int[] list, int iIndex, int jIndex){
        int temp =  list[iIndex];
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
}
