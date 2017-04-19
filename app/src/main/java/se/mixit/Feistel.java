package se.mixit;

/*
        Class with the main methods for Encryption/Decryption
        Hi David
 */
public class Feistel {
    public String encrypt(String PlainText,String Key){
        if(PlainText.length()%2!=0)
            PlainText+=' ';
        char[] CipherTextArray=new char[PlainText.length()];
        char Lo,Ln=0;
        char Ro,Rn=0;
        for(int j=0;j<PlainText.length();j+=2) {
            Lo=PlainText.charAt(j);
            Ro=PlainText.charAt(j+1);
            for (int i = 0; i < Key.length(); i++) {

                Ln = Ro;
                Rn = (char) (Lo^ f(Ro,Key.charAt(i)));
                Ro=Rn;
                Lo=Ln;
            }
            if (Rn < 32)
                Rn += 200;
            if (Ln < 32)
                Ln += 200;
            CipherTextArray[j]=Rn;
            CipherTextArray[j+1]=Ln;
        }
        String CipherText=new String(CipherTextArray);
        return CipherText;
    }



    public String decrypt(String CipherText,String Key){
        String PlainText=CipherText;

        return PlainText;
    }



    //f function for the feistel network returns a modified P
    private static char f(char R,char K) {
        char P = 0;
        try {
            P = (char) ((short) ((R % K)) >> 2);
        }catch (ArithmeticException e){P=R;}
        finally {
            return P;
        }
    }
}
