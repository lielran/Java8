package interfaces;

/**
 * Created by lielran on 8/15/16.
 */

/**
 * output:
 * Init
 * Default
 */
public class interfaceUnlocking {

    public static void main(String[] args) {
        Component myComponent = new Component() {
            @Override
            public String find(String name) {
                return name;
            }
        };


        myComponent.init();
        System.out.println(myComponent.find(myComponent.getName()));

    }

}


interface Component {

    public String find(String name);

    //default  Function
    default public String getName(){
        return "Default";
    }

    //default  interface
    default public void init() {
        System.out.println("Init");
    }
}