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
import java.util.Scanner;

public class VanocniProjekt {
    
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";
public static String barva;
public static String pokryvka;
public static String puntiky;
static boolean end = false;
static boolean orn1 = false;
static boolean orn2 = false;
static Scanner sc = new Scanner(System.in);   

    public static void menu() {
        
        int choice;                     
        do{
            displayMenu();
            choice = sc.nextInt();
            
            switch(choice){
                case 1: show();break; 
                case 2: ornaments();break; 
                case 3: colour();break;
                case 0: end = true; break;                                                    
            }       
        }while(!end); //end == false
       
    }

    private static void displayMenu() {  //hlavni menu
       System.out.println("Vanocni ozdoba: koule");     
       System.out.println("1. zobrazit");
       System.out.println("2. Ornamenty");
       System.out.println("3. Barva");       
       System.out.println("0. Konec");
    }

    private static void colour() {   //nastaveni barev            
        char odpoved = 'r';
        do{
            displayMenu2();
                         
            odpoved = sc.next().charAt(0);
            //odpovedi uzivatele
            if(odpoved == 'r'){
            barva = ANSI_RED;           
            }else if(odpoved == 'g'){
            barva = ANSI_GREEN;            
            }else if(odpoved == 'y'){
            barva = ANSI_YELLOW;
            
            }else if(odpoved == 'b'){
            barva = ANSI_BLUE;
            
            }else if(odpoved == 'p'){
            barva = ANSI_PURPLE;
            
            }else if(odpoved == 'c'){
            barva = ANSI_CYAN;
            
            }else if(odpoved == 'e'){                 
            
            }                                                                                                                
        }while(odpoved == 'e'); //end == false                           
    }
    
    private static void displayMenu2() { //menu barev
       System.out.println("Nastavení barev");     
       System.out.println("moznosti: r, g, y, b, p, c");      
       System.out.println("e. exit");
    }

    private static void ornaments() {  //nastaveni ornamentu     
        int odpoved2 = 1;
        do{
            displayMenu3();
            odpoved2 = sc.nextInt();
            
            if(odpoved2 == 1){                      
                puntiky = ANSI_WHITE;
            }if(odpoved2 == 2){
                pokryvka = ANSI_WHITE; 
             }if(odpoved2 == 3){
                pokryvka = barva; 
                puntiky = barva;
            }if(odpoved2 == 0){
                break;
            }
            
           }while(odpoved2 == 0); //end == false
    }

    private static void show() { //ukazka       
        if(puntiky == ANSI_WHITE){                      
           orn1 = true;
           }else{
           orn1 = false;
        }if(pokryvka == ANSI_WHITE){                      
           orn2 = true;
          } else{
           orn2 = false;                                    
        }       
       System.out.println("Barva: "+barva+ "⬤");
       System.out.println("Pokryvka: "+(orn2?"ANO,":"NE,")+" Puntiky: "+(orn1?"ANO":"NE"));
      
       int gap = 100;
       int textura1=15;
       int a=0;
       int b=1;
       int c = 8;
       
      for(int m = 0;m<12;m++){
      for(int j = 0;j<gap;j++){           
          a++;
          System.out.print(" ");
          if(a == gap){ 
              if(b%2==1){
                textura1=textura1+c;
                gap = gap-c+1;
                c--;
                b++;
                a = 0;               
              }else{
                  a=0;
                  b++;                  
              } 
              }
              }          
          for(int i = 0;i<textura1;i++){                
              if(m<4){
               System.out.print(pokryvka+"xx");               
               a++;
              }else{
               System.out.print(barva+"x"+puntiky+"x");               
               a++;
              }
             if(a == textura1){
                 System.out.println();
                 System.out.println();
                 a=0;
                 b++;
                 }
          }                  
         } 
      System.out.println();         
      } 
    
    

    private static void displayMenu3() { //menu pro ornamenty
       System.out.println("Nastaveni ornamentu");     
       System.out.println("1. puntiky");
       System.out.println("2. pokryvka");
       System.out.println("3. reset");
       System.out.println("0. exit");
    }
}
    

