/*
 * COMP 2526 -- ASSIGNEMNT 2 -- CHESS GAME 
 * Author: Eva Yu * 
 * BCIT -- A00942918 -- CST2B  * 

 */
package assignment2.practice;

/**
 *
 * @author Eva
 */
public class Object1 {

    public int obj1 = 1;

    public static void main(String args[]) {
        NotAnObject nab = new NotAnObject();
        nab.setObj(new Object2());

        System.out.println((nab.getObj()).setInt());
    }
}

class Object2 extends GeneralObject {

    public int obj2 = 2;

    public void addObj2() {
        obj2++;
    }

    public int setInt() {
        return 2;
    }
}

abstract class GeneralObject {

    abstract int setInt();
}

class NotAnObject {

    GeneralObject object;

    public void setObj(GeneralObject obj) {
        this.object = obj;
    }

    public GeneralObject getObj() {
        return object;
    }
}
