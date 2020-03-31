package projectCode20280;

public class BoundedStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;//default array capacity
    private int max_size;

    private ArrayStack<E> stack; //we use an arrayStack to create a stack

    public BoundedStack(){//constructing a stack with default capacity
        stack = new ArrayStack<>(CAPACITY);
        max_size = CAPACITY;
    }

    public BoundedStack(int capacity){
        stack = new ArrayStack<>(capacity);
        max_size = capacity;
    }

    public static void main(String[] args) {
        BoundedStack<Integer> boundedStack = new BoundedStack<>();
        boundedStack.push(1);
        boundedStack.push(2);
        boundedStack.push(3);
        boundedStack.push(4);
        System.out.println(boundedStack);

        System.out.println("Top: " + boundedStack.top());

        boundedStack.pop();
        System.out.println(boundedStack);
        boundedStack.pop();
        System.out.println(boundedStack);
        System.out.println("Top: " + boundedStack.top());

    }
    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(E e) throws StackOverflowError {//an error is thrown if the stack is full
        if(stack.size() == max_size){
            throw new StackOverflowError("The stack is full");
        }
        else{
            stack.push(e);
        }
    }

    @Override
    public E top() {
        return stack.top();
    }

    @Override
    public E pop() {
        return stack.pop();
    }

    @Override
    public String toString() {
        return "BoundedStack{" +
                "max_size=" + max_size +
                ", stack=" + stack +
                '}';
    }
}
