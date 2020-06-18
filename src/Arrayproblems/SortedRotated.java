package Arrayproblems;

class SortedRotated {

    // Function to check if array is sorted and rotated
    // arr[]: input array
    // num: size of array
    public static boolean checkAsendingSorted(int arr[], int n) {

        // Your code
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] >= arr[i]) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkdesendingSorted(int arr[], int n) {

        // Your code
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] <= arr[i]) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void rotateClock(int arr[], int n) {

        // Your code
        int last = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = last;
    }


    public static boolean checkRotatedAndSorted(int arr[], int num) {

        // Your code
        int i = 0;
        int n = arr.length;
        if (checkdesendingSorted(arr, n) || checkAsendingSorted(arr, n)) {
            return false;
        }
        while (i < num) {
            rotateClock(arr, n);
            if (checkdesendingSorted(arr, n) || checkAsendingSorted(arr, n)) {
                return true;
            }
            i++;
        }
        return false;

    }
    public static boolean checkRotatedAndSortedBetterSolution(int arr[], int num){
        int countup = 0, countdown = 0;
        for (int i = 1; i < num; i++) {
            countup = (arr[i] > arr[i -1]) ? countup + 1 : countup;
            countdown = (arr[i] < arr[i -1]) ? countdown + 1 : countdown;

        }
        System.out.println(countup +" " +countdown );
        return ((countup == num - 2 && countdown == 1 && arr[0] > arr[num - 1])
                || (countdown == num - 2 && countup == 1 && arr[0] < arr[num - 1])) ? true : false;
    }
    static boolean ifSequenceIsIncreasing (int arr[], int n)
    {
    	int i = 0;
        //increase i untill you get min element,
    	while (i < n - 1 && arr[i] <= arr[i + 1]) i++;

        //if no min element found and i==last idx .return false
    	if (i == n - 1) return false;
        //cross min element nad check 
    	i++;
        // now ckeck if sequence is increasing
    	while (i < n - 1 && arr[i] <= arr[i + 1]) i++;
        //if we reached last and arr[0]>=arr[n-1] return true else false
    	if (i == n - 1 && arr[n - 1] <= arr[0])
    		return true;
    	else
    		return false;
    }

    static boolean ifSequenceIsDecreasing (int arr[], int n)
    {   //algo is same as above .simple check monotonic sequence or not
    	int i = 0;
    	while (i < n - 1 && arr[i] >= arr[i + 1]) i++;
    	if (i == n - 1) return false;

    	i++;
    	while (i < n - 1 && arr[i] >= arr[i + 1]) i++;
    	if (i == n - 1 && arr[n - 1] >= arr[0])
    		return true;
    	else
    		return false;
    }

    static boolean checkRotatedAndSortedeffcient(int arr[], int n) {
    	return (ifSequenceIsIncreasing (arr, n) || ifSequenceIsDecreasing (arr, n));
    }	
    
    
    
    static int effiecientSolution(int a[],int n,int key) {
    	int s=0,e=n-1;
    	while(e>=s) {
    		int m=(s+e)/2;
    		
    		if(a[m]==key) {
    			return m;
    		}
    		//lies on left side of pivot
    		else if(a[s]<=a[m]) {
    			if(key>=a[s]&&key<=a[m]) {
    				e=m-1;
    			}else {
    				s=m+1;
    			}
    		}
    		//right side of pivot
    		else {
    			if(key<=a[e]&&key>=a[m]) {
    				s=m+1;
    			}else {
    				e=m-1;
    			}
    		}
    		
    	}
    	return -1;
    }
   

    public static void main(String[] args) {
        int arr[] = {30 ,20, 10, 50, 35};

        System.out.println(effiecientSolution(arr,arr.length,10));
    }

}