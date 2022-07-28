package com.feng.newline.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L232用栈实现队列
 * @author: Ladidol
 * @description: 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * @date: 2022/7/27 14:47
 * @version: 1.0
 */
public class L232用栈实现队列 {

    //理解错题意了, 题是让我们用stack模拟一个队列出来.
//    class MyQueue {
//
//        Deque<Integer> stack;
//        public MyQueue() {
//            stack = new ArrayDeque<>();
//        }
//
//        public void push(int x) {
//            stack.push(x);
//        }
//
//        public int pop() {
//            return stack.removeLast();
//        }
//
//        public int peek() {
//            return stack.getLast();
//        }
//
//        public boolean empty() {
//            return stack.isEmpty();
//        }
//    }

    /*使用栈来模式队列的行为，如果仅仅用一个栈，是一定不行的，所以需要两个栈一个输入栈，一个输出栈，这里要注意输入栈和输出栈的关系。*/
    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>(); // 负责进栈
            stackOut = new Stack<>(); // 负责出栈
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            dumpstackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpstackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        private void dumpstackIn() {
            if (!stackOut.isEmpty()) return;//出栈不为空, 就不执行该方法.
            while (!stackIn.isEmpty()) {//将「进栈」中的元素全部 取出在压入「出栈」中
                stackOut.push(stackIn.pop());
            }
        }
    }


}
