package com.mycompany.question4;

import java.util.Random;

public class Pelatis extends Thread {
    
    private int id;
    private boolean einaiGinaika;
    private Random rand = new Random();
    
    public Pelatis(int id) {
        this.id = id;
        this.einaiGinaika = rand.nextBoolean();
    }
    
    @Override
    public void run() {
        try {
            Question4.xoritikotita.acquire();
            System.out.println("Πελατης " + id + "μπηκε στο μαγαζι. Φυλο: " + (einaiGinaika ? "Γυναικα" : "Αντρας"));
            
            if (einaiGinaika) {
                Question4.gDokimastiria.acquire();
                System.out.println("Γυναικα " + id + " ξεκινησε δοκιμη.");
            } else {
                Question4.aDokimastiria.acquire();
                System.out.println("Αντρας " + id + " ξεκινησε δοκιμη.");
            }
            
            Thread.sleep((3 + rand.nextInt(8)) * 1000);
            
            if (einaiGinaika) {
                Question4.gDokimastiria.release();
                System.out.println("Γυναικα " + id + " τελειωσε και φευγει προς το ταμειο.");
            } else {
                Question4.aDokimastiria.release();
                System.out.println("Αντρας " + id + " τελειωσε και φευγει προς το ταμειο.");
            }
            
            Question4.ouraTameiou.acquire();
            System.out.println("Πελατης " + id + " μπηκε στην ουρα ταμειου.");
            
            Question4.tamias.acquire();
            System.out.println("Πελατης " + id + " πληρωνει.");
            
            Thread.sleep(5000);
            
            Question4.tamias.release();
            Question4.ouraTameiou.release();
            
            System.out.println("Πελατης " + id + " πληρωσε και εφυγε απο το μαγαζι");
            
            Question4.xoritikotita.release();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
