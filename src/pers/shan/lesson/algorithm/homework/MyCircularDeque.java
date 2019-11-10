package pers.shan.lesson.algorithm.homework;

/**
 * https://leetcode-cn.com/problems/design-circular-deque
 *
 * @author: shanxiao
 * @date: 2019/11/10
 */
public class MyCircularDeque {
    /**
     * 用一个数组储存双端队列数据
     */
    private int[] deque;
    /**
     * 头部指针，指向当前队首
     */
    private int head;
    /**
     * 尾部指针，指向队尾的下一个位置
     */
    private int tail;
    /**
     * 当前队列大小
     */
    private int size;
    /**
     * 队列最大大小
     */
    private int maxSize;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.deque = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.maxSize = k;
    }

    /**
     * Adds an item at the head of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        head = (head - 1 + maxSize) % maxSize;
        deque[head] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        deque[tail] = value;
        tail = (tail + 1) % maxSize;
        size++;
        return true;
    }

    /**
     * Deletes an item from the head of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % maxSize;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = (tail - 1 + maxSize) % maxSize;
        size--;
        return true;
    }

    /**
     * Get the head item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return deque[head];
    }

    /**
     * Get the tail item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return deque[(tail - 1 + maxSize) % maxSize];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.insertLast(0));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
    }

}
