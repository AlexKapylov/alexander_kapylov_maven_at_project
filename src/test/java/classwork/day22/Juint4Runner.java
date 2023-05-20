package classwork.day22;

import org.junit.runner.JUnitCore;

public class Juint4Runner {

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new MyJunit4Listener());
        runner.run(Day22Tests.class);
    }

}
