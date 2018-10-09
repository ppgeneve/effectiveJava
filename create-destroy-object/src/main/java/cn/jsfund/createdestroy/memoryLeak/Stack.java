package cn.jsfund.createdestroy.memoryLeak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author ppgeneve
 * @Description:
 * @Date 2018/10/9 18:36
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 注意：这里会可能会有内存泄露。
     * 如果一个栈先增长再收缩，那么栈中弹出的对象将不会被GC，即使程序不在引用这些对象。
     * 这是因为栈内部维护这些对象的过期引用，这样elements中大于size的那些元素就会
     * 被保护起来。
     */
    public Object memoryLeakPop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * 正确写法如下，这和ArrayList中的ensureCapacity的处理是一样的。
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;

        return result;
    }


    /**
     * 确保容量足够，每次都将容量翻倍。
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
