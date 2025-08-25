package com.empresa.proyecto.functional.util.collections.functional;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class ListDemo {
    public static void main(String[] args) {
        ListFun<Integer> list = ListFun.list(3, 6, 9);
        list.forEach(System.out::println);

        ListFun<Integer> newList = list.addEle(56);
        newList.forEach(System.out::println);

        ListFun<Integer> removeEle = newList.removeEle(9);
        System.out.println();
        removeEle.forEach(System.out::println);

        System.out.println();
        ListFun<Integer> reverseList = removeEle.reverseList();
        reverseList.forEach(System.out::println);

        ListFun<Integer> list1 = ListFun.list(3, 6, 9, 8);
        ListFun<Integer> list2 = ListFun.list(35, 78, 90);

        System.out.println();
        ListFun.concat(list1, list2).forEach(System.out::println);

        System.out.println();

        List<Integer> l = List.of(2, 5, 8, 6);
        list1.addAllEle(l).forEach(System.out::println);
    }

}

abstract class ListFun<T> {

    public abstract T head();

    public abstract ListFun<T> tail();

    public abstract boolean isEmpty();

    @SuppressWarnings("rawtypes")
    public static final ListFun NIL = new Nil();

    private static class Nil<T> extends ListFun<T> {

        private Nil() {
        }

        @Override
        public T head() {
            return null;
        }

        @Override
        public ListFun<T> tail() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    public int length() {
        int l = 0;

        ListFun<T> temp = this;
        while (!temp.equals(NIL)) {
            l++;
            temp = temp.tail();
        }

        return l;
    }

    private static class Const<T> extends ListFun<T> {
        private final T head;
        private final ListFun<T> tail;

        Const(T element, ListFun<T> list) {
            this.head = element;
            this.tail = list;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public ListFun<T> tail() {
            return tail;
        }

        @Override
        public boolean isEmpty() {
            return length() == 0 ? true : false;
        }
    }

    public static <T> ListFun<T> list() {
        return NIL;
    }

    public static <T> ListFun<T> list(T... t) {
        ListFun<T> temp = list();

        for (int i = t.length - 1; i >= 0; i--) {
            temp = new Const<T>(t[i], temp);
        }

        return temp;

    }

    public ListFun<T> addEle(T e) {
        return new Const<T>(e, this);
    }

    //method to add element at specific position
    public ListFun<T> addEle(int pos, T ele) {
        if (pos < 1 || pos > length())
            throw new IndexOutOfBoundsException();
        if (pos == 1)
            return this.tail().addEle(ele);
        return new Const<T>(head(), tail().addEle(pos - 1, ele));
    }

    public void forEach(Consumer<? super T> action) {
        T current = this.head();
        ListFun<T> temp = this;

        for (int i = 0; i < length(); i++) {
            action.accept(current);
            temp = temp.tail();
            current = temp.head();
        }
    }

    public ListFun<T> removeEle(T ele) {
        if (this.length() == 0)
            return this;
        else if (ele.equals(this.head()))
            return tail();
        else {
            ListFun<T> newTail = tail().removeEle(ele);
            if(newTail.equals(tail()))
                return this;
            return new Const<T>(head(), newTail);
        }
    }

    //to remove from specific position
    /*public ListFun<T> removeEle(int pos) {
        if (pos < 0 || pos > length())
            throw new IndexOutOfBoundsException();
        if (pos == 0)
            return tail();
        return new Const<T>(head(), tail().removeEle(pos - 1));
    }*/

    public ListFun<T> reverseList() {
        ListFun<T> list = list();
        T current = this.head();
        ListFun<T> temp = this;

        while (!temp.equals(NIL)) {
            list = list.addEle(current);
            temp = temp.tail();
            current = temp.head();
        }
        return list;
    }

    public static <T> ListFun<T> concat(ListFun<T> list1, ListFun<T> list2) {
        return list1.isEmpty()
                ? list2
                : new Const<>(list1.head(), concat(list1.tail(), list2));
    }

    public ListFun<T> addAllEle(final Collection<? extends T> list) {
        ListFun<T> result = this;
        for (T t : list) {
            result = result.addEle(t);
        }
        return result;
    }

    public ListFun<T> clear() {
        return list();
    }
}