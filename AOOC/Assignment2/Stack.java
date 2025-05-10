import java.util.*;

class Stack {
    
    // Push operation
    int push(int n, int[] arr, int top) {
        if (top == n - 1) {
            System.out.println("Overflow condition");
        } else {
            Scanner s = new Scanner(System.in);
            top++;
            System.out.println("Push element at index " + top);
            int num = s.nextInt();
            arr[top] = num;
        }
        return top;
    }
    
    // Display operation
    void display(int n, int[] arr, int top) {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Elements in stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
    
    // Pop operation
    int pop(int[] arr, int top) {
        if (top == -1) {
            System.out.println("Underflow condition!");
        } else {
            System.out.println("Popped element: " + arr[top]);
            top--;
        }
        return top;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of stack");
        n = sc.nextInt();
        int[] arr = new int[n];
        int top = -1;
        
        Stack obj = new Stack();
        
        // Main menu loop
        int choice;
        do {
            System.out.println("Enter Choice");
            System.out.println("1. Perform Push");
            System.out.println("2. Display Stack");
            System.out.println("3. Perform Pop");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Push one element at a time
                    for(int i=0;i<n;i++){
                     obj.push(n, arr, top);}
                    break;
                case 2:
                    // Display elements of the stack
                    obj.display(n, arr, top);
                    break;
                case 3:
                    // Pop an element from the stack
                    if (top >= 0) {
                        top = obj.pop(arr, top);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4); // Exit condition is when user selects option 4
    }
}
