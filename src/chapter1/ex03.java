package chapter1;

import java.util.ArrayList;
import java.util.List;

interface ListManipulator<T>{
    void manipulate(List<T> list, T e);

    default List<T> create(){
        return new ArrayList<T>(); 
    }
}

public class ex03 {
    public static void main(String[] args) {

        ListManipulator sListAdd = new ListManipulator<String>() {
            @Override
            public void manipulate(List<String> list, String e) {
                list.add(e);
            }
        };

        List a = sListAdd.create();
        sListAdd.manipulate(a, "adicionado");
        a.forEach(System.out::println);


        ListManipulator iListAdd = new ListManipulator<Integer>() {
            @Override
            public List<Integer> create() {
                return new ArrayList<Integer>(50);
            }

            @Override
            public void manipulate(List<Integer> list, Integer e) {
                list.add(e);
            }
        };

        var b = iListAdd.create();
        iListAdd.manipulate(b, 12);
        iListAdd.manipulate(b, 55);
        iListAdd.manipulate(b, 12);
        b.forEach(System.out::println);


        ListManipulator iListRmv = new ListManipulator<Integer>() {
            @Override
            public void manipulate(List<Integer> list, Integer e) {
                list.remove(e);
            }
        };

        iListRmv.manipulate(b, 12);
        b.forEach(System.out::println);
    }
}
