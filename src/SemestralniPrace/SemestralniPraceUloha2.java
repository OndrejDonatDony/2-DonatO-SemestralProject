/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SemestralniPrace;

/**
 *
 * @author ondrej.donat
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SemestralniPraceUloha2 {

    static Scanner sc;

    public static void konzole(){
        //program, ktery testu 
        sc = new Scanner(System.in);
        boolean end = false;
        char odpoved;
        while (!end) {
            boolean test = false;
            System.out.println("Pokracovat ve zpracovani (a/n):");
            odpoved = sc.next().charAt(0);
            if (odpoved == 'a' || odpoved == 'A') {
                test = true; //prejde k dalsi casti programu
            } else if (odpoved == 'n' || odpoved == 'N') {
                break; //konec programu
            }//(pokud ani jedna podminka nebyla splnena, program se zacne ptat znovu)

            if (test == true) {
                System.out.println("Zadej prvni posloupnost:");
                //1. pole
                ArrayList<Integer> posloupnostA = NacitaniPosloupnosti();
                System.out.println("Zadej drouhou posloupnost:");
                //2. pole
                ArrayList<Integer> posloupnostB = NacitaniPosloupnosti();
                //nejdelsi spolecny usek(vysledek)
                int spolecnyUsek = delka(posloupnostA, posloupnostB);
                System.out.println("Nejdelsi spolecny usek obou posloupnosti ma delku " + spolecnyUsek);
            }
        }
    }

    //vytvareni pole ukoncena zapornym cislem
    public static ArrayList<Integer> NacitaniPosloupnosti() {

        //deklarace dynamickeho pole
        ArrayList<Integer> posloupnost = new ArrayList();
        boolean konec = false;
        //cyklus pro vytvoreni pole
        while (!konec) {
            posloupnost.add(sc.nextInt());

            //podminka pro ukonceni cyklu pokud je cislo na konci pole zaporne
            if (posloupnost.get(posloupnost.size() - 1) < 0) {
                posloupnost.remove(posloupnost.size() - 1); //odstrani zaporne cislo z pole
                konec = true;
            }
        }
        //vraci pole 
        return posloupnost;
    }

    //nejdelsi spolecny usek
    public static int delka(ArrayList<Integer> a, ArrayList<Integer> b) {

        int nejdelsiUsek = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                int usek = 0;
                do {
                    //pokud je pole mensi nez soucet indexu -> break;  
                    if (a.size() <= (i + usek) || b.size() <= (j + usek)) {
                        break;
                    }
                    //pokud se hodnoty pole na pozici indexu nerovnaji -> break;
                    if (b.get(j + usek) != a.get(i + usek)) {
                        break;
                    }
                    //pokud se rovnaji hodnoty v poli, zvysi se k o 1;
                    usek++;
                } while (true);
                //pokud spolecny usek je delsi nez predchozi
                if (usek > nejdelsiUsek) {
                    nejdelsiUsek = usek;
                }
            }
        }
        //vraci nejdelsi spolecny usek typu int
        return nejdelsiUsek;
    }

}
