package chapter2;

import java.util.ArrayList;
import java.util.List;

interface ListManipulator<T>{
    void manipulate(List<T> list, T e);
}

public class ex03 {
    public static void main(String[] args) {
        ListManipulator<String> sListAdd = (list, e) -> list.add(e);

        var a = new ArrayList<String>();
        sListAdd.manipulate(a, "adicionado");
        a.forEach(System.out::println);


        ListManipulator<Integer> iListAdd = (list, e) -> list.add(e);

        var b = new ArrayList<Integer>(50);
        iListAdd.manipulate(b, 12);
        iListAdd.manipulate(b, 55);
        iListAdd.manipulate(b, 12);
        b.forEach(System.out::println);

        
        ListManipulator<Integer> iListRmv = (list, e) -> list.remove(e);

        iListRmv.manipulate(b, 12);
        b.forEach(System.out::println);
    }
}
