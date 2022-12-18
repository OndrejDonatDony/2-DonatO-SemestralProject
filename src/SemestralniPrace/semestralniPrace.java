/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SemestralniPrace;

/**
 *
 * @author ondrej.donat
 */
import static SemestralniPrace.VanocniProjekt.end;
import java.util.Scanner;
public class semestralniPrace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        boolean konec = false;
         int choice;                     
        do{
            displayMenu();
            choice = sc.nextInt();
            
            switch(choice){
                case 1: semeUloha();break; 
                case 2: vanProj();break;                
                case 0: konec = true; break;                                                    
            }       
        }while(!konec); //end == false
       
    
        
       
    }

    private static void displayMenu() {
       System.out.println("       Semestralni prace");  
       System.out.println("         Ondrej Donat\n"); 
       System.out.println("1. semestralni uloha");
       System.out.println("2. Vanocni projekt");              
       System.out.println("0. Konec");
    }

    private static void semeUloha() { //semestralni uloha 2
        SemestralniPraceUloha2 obj1 = new SemestralniPraceUloha2();
        obj1.konzole();
    }

    private static void vanProj() { //vanocni uloha
        VanocniProjekt obj2 = new VanocniProjekt();
        obj2.menu();
    }
    
}
