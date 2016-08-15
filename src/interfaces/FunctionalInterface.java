package interfaces;

/**
 * Created by lielran on 8/15/16.
 */

/**
 * output:
 * aaaaa
 * BB
 *
 */
public class FunctionalInterface {

    public static void main(String[] args) {
        MyComponent myComponent =(String s) -> {
            if(s.length() > 2) {
                return s.toLowerCase();
            }
            return s;
        };

        System.out.println(myComponent.find("AAAAA"));
        System.out.println(myComponent.find("BB"));
    }
}

@java.lang.FunctionalInterface
interface MyComponent {
    public String find(String name);
}
