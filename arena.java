package projeler;
import java.util.Scanner;
import java.util.Random;
public class arena {
    public static void main(String[] args) {
        
        Scanner scanner= new Scanner(System.in);
        Random random=new Random();
        canavar sovalye = new canavar("Şovalye",2500,200,"Saldırı gücü ve fiziksel savunma artışı");
        canavar nisancı=new canavar("Nişancı",2000,150,"BS azalması");
        canavar tank= new canavar("Tank",6000,50,"Max. can artışı");
        canavar[] canavarlar = {sovalye, nisancı, tank};
        karakter karakter = new karakter();
        System.out.println("Karakter isminizi girin: ");
        karakter.name=scanner.nextLine();
        boolean aksiyon_durumu=true;
        while(true){
            aksiyon_durumu = true;
            int canavar_seçim_zar = random.nextInt(3);
            canavar seçilen_canavar = canavarlar[canavar_seçim_zar];
            int counter_s1, counter_s2, counter_s3;
            System.out.println("Karşına bir düşman çıktı! Ne yapacaksın?");
            System.out.println("Düşmanın bilgilerini analiz etmek için: 1, kaçmaya çalışmak için: 2(%1 ihtimal), savaşmak için: 3 ");
            int secim=scanner.nextInt();
            while(aksiyon_durumu){
            if(secim==1){
                System.out.println(seçilen_canavar.toString()); 
                System.out.println();
                System.out.println("Düşmanın bilgilerini analiz etmek için: 1, kaçmaya çalışmak için: 2(%50 ihtimal), savaşmak için: 3");
                secim=scanner.nextInt();
            }
            else if(secim==2){
                int kacma_sansi = 100 /karakter.level;
                int sayi=random.nextInt(kacma_sansi);
                if(sayi==0){
                    System.out.println("Savaştan başarıyla kaçtınız.");
                    aksiyon_durumu=false;
                    break;
                }
                else{
                    System.out.println("Savaştan kaçamadınız.");
                    secim=3;
                }
            }
            else if(secim==3){
                int verilen_hasar = 0;
                int hareket_zarı;
                while(karakter.hp>0 && seçilen_canavar.hp>0){
                hareket_zarı = random.nextInt(3);
                System.out.println("Ne yapmak istersiniz?: ");
                System.out.println("Temel saldırı için: 0, 1. yetenek için: 1, 2. yetenek için: 2, 3. yetenek için: 3");
                int hareket_secimi=scanner.nextInt();
                System.out.println();
                switch(hareket_zarı){
                    case 0: System.out.println("ne yazık ki yapmak istediğiniz hareketi gerçekleştiremediniz.");
                    break;
                    case 1: ;
                    break;
                    case 2: System.out.println("Hareketinizi mükemmel bir biçimde gerçekleştirdiniz");
                    break;
                }
                System.out.println();
                if(hareket_secimi==0){
                    verilen_hasar = karakter.basic_attack * hareket_zarı;
                    System.out.println("Rakibe "+verilen_hasar+" hasar verdiniz.");
                    seçilen_canavar.hp-=verilen_hasar;
                    System.out.println("Rakibin kalan canı: "+seçilen_canavar.hp);
                    System.out.println();
                }
                else if(hareket_secimi==1){
                    verilen_hasar = karakter.skill1()*hareket_zarı;
                    System.out.println("Rakibe "+verilen_hasar+" hasar verdiniz");
                    seçilen_canavar.hp-=verilen_hasar;
                    System.out.println("Rakibin kalan canı: "+seçilen_canavar.hp);
                    counter_s1=3;
                    System.out.println();
    
                }
                else if(hareket_secimi==2){
                    System.out.println("Kendinize "+karakter.skill2()*hareket_zarı+" can bastınız.");
                    karakter.hp+=karakter.skill2();
                    System.out.println("Güncel canınız: "+karakter.hp);
                    counter_s2=3;
                    System.out.println();
    
                }
                else if(hareket_secimi==3){
                    System.out.println("Kendinize "+karakter.skill3()*hareket_zarı+" fiziksel defans bastınız.");
                    karakter.physical_defense+=karakter.skill3()*hareket_zarı;
                    System.out.println("Güncel fiziksel defans: "+karakter.physical_defense);
                    counter_s3=3;
                    System.out.println();
                }
                else{
                    System.out.println("Geçersiz bir değer girdiniz.");
                }
                int alınan_hasar = 0;
                int canavar_hareket_zarı = random.nextInt(3);
                switch(canavar_hareket_zarı){
                    case 0: System.out.println("Şanslısınız. Rakip saldırısını ıskaladı");
                    break;
                    case 1: ;
                    break;
                    case 2: System.out.println("Şansınıza küsün. Rakibin saldırısı kritik bir etki bıraktı");
                    break;
                }
                alınan_hasar = seçilen_canavar.basic_attack*canavar_hareket_zarı - karakter.physical_defense ;
                karakter.hp=karakter.hp-alınan_hasar;
                System.out.println("Rakip size saldırdı ve "+alınan_hasar+" hasar verdi.");
                System.out.println("Güncel can: "+karakter.hp);
            }
            aksiyon_durumu = false;


        }

        }
    }
    }
}
