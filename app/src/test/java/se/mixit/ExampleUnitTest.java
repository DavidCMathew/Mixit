package se.mixit;

import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Parameterized.class)
public class ExampleUnitTest{
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[10][0]);
    }
    @Test
    public void Mixit_Text() throws Exception {
        Feistel F=new Feistel();
        String Plaintext="Hello";
        String Key="Bye";
        String Ciphertext=F.encrypt(Plaintext,Key);
        String PlaintextCheck=F.decrypt(Ciphertext,Key);
        assertEquals(PlaintextCheck,Plaintext);

    }

}