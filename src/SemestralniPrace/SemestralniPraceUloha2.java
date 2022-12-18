/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SemestralniPrace;

/**
 *
 * @author ondrej.donat
 */


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
                int[] posloupnostA = NacitaniPosloupnosti();
                System.out.println("Zadej drouhou posloupnost:");
                //2. pole
                int[] posloupnostB = NacitaniPosloupnosti();
                //nejdelsi spolecny usek(vysledek)
                int spolecnyUsek = delka(posloupnostA, posloupnostB);
                System.out.println("Nejdelsi spolecny usek obou posloupnosti ma delku " + spolecnyUsek);
            }
        }
    }

    //vytvareni pole ukoncena zapornym cislem
    public static int[] NacitaniPosloupnosti() {

        //deklarace dynamickeho pole
        int i = 0;
        int velikost = 4;
        int[] posloupnost = new int[4];
        int[] temp = null;
        int[] finalPosloupnost = null;
        boolean konec = false;
        
        //cyklus pro vytvoreni pole      
        while (!konec) {          
            posloupnost[i] = sc.nextInt();
            
            if(i == velikost-1){
                temp = new int[velikost*2];
                for(int j =0;j<velikost; j++){
                    temp[j] = posloupnost[j];
                }
                posloupnost = temp;
                velikost = velikost*2;
            }           
            //podminka pro ukonceni cyklu pokud je cislo na konci pole zaporne
            if (posloupnost[i] < 0) {                                   
                int a = i;                              
                finalPosloupnost = new int[a];    
                for(int f = 0;f<a;f++){
                    finalPosloupnost[f] = posloupnost[f];                       
                    }                                  
                konec = true;
            }
            i++;
        }       
        //vraci pole 
        return finalPosloupnost;
    }

    //nejdelsi spolecny usek
    public static int delka(int[] a, int[] b) {

        int nejdelsiUsek = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int usek = 0;
                do {
                    //pokud je pole mensi nez soucet indexu -> break;  
                    if (a.length <= (i + usek) || b.length <= (j + usek)) {
                        break;
                    }
                    //pokud se hodnoty pole na pozici indexu nerovnaji -> break;
                    if (b[j + usek] != a[i + usek]) {
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
