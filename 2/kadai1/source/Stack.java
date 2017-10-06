class Stack{
    private Object[] stack = new Object[3];
    private int top = -1;

    public void push(Object element){
        this.stack[++this.top] = element;
    }
    public Object pop(){
        return this.stack[this.top--];
    }
}
