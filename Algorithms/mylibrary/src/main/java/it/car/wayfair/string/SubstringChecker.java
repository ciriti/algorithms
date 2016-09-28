package it.car.wayfair.string;

/**
 * Created by carmeloiriti, 28/09/16.
 */
public class SubstringChecker {

    /**
     * Verify is S is a substring of T where T.length() > S.length()
     *
     *
     * a s d f g
     *
     */

    public static void printAllIndexOf(String s, char c){

        int index = s.indexOf(c);

        while(index!=-1){
            System.out.print( index + " ");

            index = s.indexOf(c, index + 1);
        }
        System.out.println("finish");

    }


    public static boolean isSubstring(String s, String t){

        if(s.length() == 0 || (s.length() == 0 && t.length() == 0)) return true;
        if(t.length() == 0) return false;


       for(int index = 0; index <= (t.length() - s.length()); index++){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == t.charAt(index + i)){
                    if(i == s.length()-1)
                        return true;
                }else{
                    break;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){
        System.out.println(isSubstring("abcd","78162691_abc_82763498127_abd_64861941_abcd") == true?"SUCCESS":"ERROR");
        System.out.println(isSubstring("abcd","187256abd898732696abc2396076982609abc") == false?"SUCCESS":"ERROR");
        System.out.println(isSubstring("","asdf") == true?"SUCCESS":"ERROR");


        printAllIndexOf("aaaaxaaaaaxaaaaaaax", 'x');

    }

}
