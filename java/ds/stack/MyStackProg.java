package ds.stack;

import java.io.IOException;
import java.util.Scanner;

public class MyStackProg {

  public static class MyStack {
    private int TOP_OF_STACK = -1;
    private int[] array;
    private int size;

    public MyStack(int size) {
      this.size = size;
      array = new int[size];
    }

    public void push(int val) {
      if (!isFull()) {
        array[TOP_OF_STACK++] = val;
      }
      else {
        System.out.println("Stack overflow !");
      }
    }

    public int pop() {
      int val = -1;
      if (!isEmpty()) {
        val = array[TOP_OF_STACK];
        TOP_OF_STACK--;
      }
      else {
        System.out.println("Stack underflow !");
      }
      return val;
    }

    public boolean isEmpty() {
      return TOP_OF_STACK == -1 ? true : false;
    }

    public boolean isFull() {
      return TOP_OF_STACK == size - 1 ? true : false;
    }

    public int peek() {
      return array[TOP_OF_STACK];
    }
  }


  public static void main(String[] args) {
      MyStack myStack = new MyStack(5);
  }
}
