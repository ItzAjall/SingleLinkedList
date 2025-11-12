public class SingleLinkedList {
    private int size;
    private ListNode first;
    private ListNode last;

    public SingleLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    public SingleLinkedList(int... args){
        for (int i : args) {
            add(i);
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return size;
    }

    public int length(){
        return getSize();
    }

    private void checkIndex(int index, int size){
        if( !(0 <= index && index < size ))
            throw new IndexOutOfBoundsException();
    }

    private ListNode getNode(int index){
        ListNode p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public int get(int index){
        if (isEmpty())
            throw new EmptyListException();
        if (index == -1)
            return last.data;
        checkIndex(index, size);
        ListNode p = getNode(index);
        return p.data;
    }

    public int set(int index, int number){
        if (isEmpty())
            throw new EmptyListException();
        ListNode p;
        if (index == -1){
            p = last;
        }
        else{
            checkIndex(index, size);
            p = getNode(index);
        }
        int old_value = p.data;
        p.data = number;
        return old_value;
    }

    public void addFirst(int number){
        ListNode num = new ListNode(number);
        num.next = first;
        first = num;
        if (last == null)
            last = num;
        size++;
    }

    public void addLast(int number) {
        ListNode num = new ListNode(number);
        if (isEmpty()){
            first = num;
        }
        else{
            last.next = num;
        }
        last = num;
        size++;
    }

    public void push(int number){
        addLast(number);
    }

    public void add(int number){
        addLast(number);
    }

    public void add(int index, int number){
        if (index == -1){
            ListNode num = new ListNode(number);
            if (isEmpty()){
                first = num;
                last = num;
            }
            else{
            num.next = last.next;
            last.next = num;
            }
        }
        else {
            checkIndex(index, size + 1);
            ListNode num = new ListNode(number);
            if (index == 0) {
                num.next = first;
                first = num;
            } else {
                ListNode p = getNode(index - 1);
                num.next = p.next;
                p.next = num;
            }
        }
        size++;
    }

    public int removeFirst(){
        if (isEmpty())
            throw new EmptyListException();
        int old_value = first.data;
        first = first.next;
        size--;
        return old_value;
    }

    public int removeLast(){
        if (isEmpty())
            throw new EmptyListException();

        int item;
        if (first.next == null){
            item = first.data;
            first = null;
        }
        else {
            item = last.next.data;
            last.next = null;
        }
        size--;
        return item;
    }

    public int pop(){
        return removeLast();
    }

    public int remove(int index){
        if (index == -1)
            return removeLast();
        checkIndex(index, size);
        int item;

        if (index == 0){
            item = first.data;
            first = first.next;
        }
        else{
            ListNode prev = getNode(index - 1);
            item = prev.next.data;
            prev.next = prev.next.next;
        }

        size--;
        return item;
    }


    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        ListNode p=first;
        while (p!=null)
        {
            s.append(p.data);
            if (p.next != null)
                s.append(", ");
            p = p.next;
        }
        s.append("]");
        return s.toString();
    }

    private static class ListNode {
        int data;
        ListNode next;


        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static class EmptyListException extends RuntimeException{
        public EmptyListException(){
            super();
        }

        public EmptyListException(String message){
            super(message);
        }
    }
}