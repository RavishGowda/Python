//https://gist.github.com/zuch/6375994


import java.util.Random;

class Main
{
    public static void merge(int[] A, int left, int mid, int right)
    {
	int[] Temp = new int[right-left+1];
        int i=left; 
        int j=mid+1; 
        int count=0;
        while(i<=mid && j<=right)
	{
	    if(A[i]<A[j]) 
	    {
		Temp[count]=A[i]; 
                i = i+1;
            }
            else 
            {   
                Temp[count]=A[j]; 
                j = j+1;
            }
            count = count+1;
	}        
        while(i<=mid)
	{
	    Temp[count]=A[i]; 
            i = i+1; 
            count = count+1;
	}


        while(j<=right)
	{
	    Temp[count]=A[j]; 
            j = j+1; 
            count = count+1;
	}
	for(i=0; i<count;i=i+1)
	    A[i+left]=Temp[i];
    }

    public static void mergesort(int[] A, int left, int right)
    {
	if(left!=right)
	{
            int mid = (left+right)/2;
            mergesort(A, left, mid);
	    mergesort(A, mid+1, right);
	    merge(A,left,mid,right);
	} 
    }
    public static void main(String args[])
    {
	int[] A = new int[100];
        Random rand = new Random();

        int value;
        for(int i = 0; i<100;i=i+1)
        {
            value = rand.nextInt();
            value = Math.abs(value);
            value = value%1000;
            A[i] = value;
        }
         System.out.println("\n");
        System.out.println("Entries of array A are : ");
         System.out.println("\n");
        for(int i = 0; i<100;i=i+1)
        {
           
            System.out.print("\t"+A[i]);
        }

	mergesort(A,0,A.length-1);
     System.out.println("\n");
	System.out.println("Entries of array A after sorting are : ");
	 System.out.println("\n");
        for(int i = 0; i<100;i=i+1)
        {
           
            System.out.print("\t"+A[i]);
        }


    }
}
