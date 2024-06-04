/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ttmessengerserver;

/**
 *
 * @author Rashid
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("SERVER STARTED");
        //Se//rverCore.Comm.receive();
        //Syst//em.out.println("SERVER ENDED");

/*
        for (int i = 0; i <100; i++) {
            if (i%3==2)
                continue;
            if (i%50==25)
                break;
            System.out.print(2+i+"3 ");
        }*/
        /*
        try {
            ProcessBuilder pb = new ProcessBuilder("C:\\WINDOWS\\NOTEPAD.EXE");
            pb.start();
        }
        catch (Exception e) {

        }*/
        Test ob1 = new Test(20, 15);
        System.out.println(ob1.a + " " + ob1.b);
        Test ob2 = new Test(1, 10);
        ob2 = ob1.setValue(ob1);
        System.out.println(ob2.a + " " + ob2.b);

    }

}

class Test {

    int a = 1, b = 2;
    Test (int i, int j) {a += i; b += j;}
    Test setValue (Test t) {
        Test test = new Test(13, 13);
        t.a -= 10;
        test.a -= t.a;
        t.b /= 2;
        test.b = ++t.b;
        return test;
    }
    
}
