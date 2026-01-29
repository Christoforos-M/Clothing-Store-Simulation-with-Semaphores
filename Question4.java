package com.mycompany.question4;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Question4 {
    
    public static Semaphore xoritikotita = new Semaphore(40);// Χωρητικοτητα καταστηματος
    public static Semaphore aDokimastiria = new Semaphore(5);// Ανδρικα δοκιμαστηρια
    public static Semaphore gDokimastiria = new Semaphore(5);// Γυναικεια δοκιμαστηρια
    public static Semaphore ouraTameiou = new Semaphore(10);// Ουρα ταμειου
    public static Semaphore tamias = new Semaphore(1);// Ταμιας
    
    static Random rand = new Random();
    
    public static void main(String[] args) {
        
        System.out.println("Το μαγαζι ανοιξε!");
        
        int customerId = 1;
        
        while (true) {
            Pelatis p = new Pelatis(customerId++);
            p.start();
            
            try {
                Thread.sleep(2 + rand.nextInt(4) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
