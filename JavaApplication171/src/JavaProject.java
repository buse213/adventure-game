import java.util.Scanner;

public class JavaProject {

    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       
        System.out.println("Karakter secin: ");
        System.out.println("1 - Savasci");
        System.out.println("2 - Okcu");
        System.out.println("3 - Buyucu");
        
        int secim=scanner.nextInt();
        Karakter karakter;
        
        if(secim==1) karakter=new Savasci();
        else if(secim==2) karakter=new Okcu();
        else karakter=new Buyucu();
        
        Harita harita =new Harita(3);
        
        while(karakter.hayattaMi()&& !karakter.oyunKazanildiMi()){
            System.out.println("Nereye gitmek istiyorsunuz?(ileri/geri/sag/sol)");
            String yon=scanner.next();
            
            
            try{
                System.out.println("Adim Sayisi Secmek Ister Misiniz?");
                String tercih=scanner.next();
                if(tercih.equalsIgnoreCase("evet")){
                    System.out.println("Adım sayisini giriniz");
                    int adımSayısı=scanner.nextInt();
                    harita.hareketEt(yon,adımSayısı);
                }
                else{
                    harita.hareketEt(yon);
                    
                } 
                
                Harita.Oda oda=harita.mevcutOda();
                Canavar canavar= oda.getCanavar();
                
                if(canavar !=null && canavar.isAlive()){
                    System.out.println("Bir "+canavar.isim+" ile karsilastiniz!");
                    System.out.println("Savasmak mi, kacmak mi istiyorsunuz?(savas/kac)");
                    String karar=scanner.next();
                    
                    if(karar.equalsIgnoreCase("savas")){
                     //Savaş başlatma
                     while(karakter.hayattaMi() && canavar.isAlive()){
                         
                         System.out.println("Ozel Yetenegini Kullanmak Ister Misin?");
                         String karar2=scanner.next();
                         if(karar2.equalsIgnoreCase("evet") && karakter.ozelYetenekHakki>0){
                             karakter.ozelYetenekKullan(canavar);
                             karakter.ozelYetenekHakki--;
                         }else if(karakter.getAltin()>=0){
                             System.out.println(" Altin kullanarak ekstra hasar vermek ister misiniz?");
                             String tercih3=scanner.next();
                             if(tercih3.equalsIgnoreCase("evet")){
                                 System.out.println("Harcamak istediginiz Altin Miktarini Giriniz");
                                 int miktar=scanner.nextInt();
                                 canavar.hasarAl(canavar.hasar,miktar);}
                             else{
                                 System.out.println("Normal Saldiri Gerceklestiriliyor");
                                 karakter.saldir(canavar);
                             }
                         }
                         
                          if (!karakter.hayattaMi() || !canavar.isAlive()) {
                                break;
                            }
                            System.out.println("savasmak mi kacmak mi istersin");
                            karar = scanner.next();
                            if(karar.equalsIgnoreCase("kac")){
                                break;
                    }
                    }
                     //Canavar öldü mü kontrol et
                     if(!canavar.isAlive()){
                         //System.out.println(canavar.isim+" olduruldu!");
                         karakter.altinEkle(canavar.hasar*5/10);
                         oda.canavarYokEt();
                     }
                    //Karakter öldü mü kontrol et
                     else if(!karakter.hayattaMi()){
                         break;
                     }
                    }else{
                    System.out.println("Kacıyorsunuz...");
                    karakter.saglik -= 10; // Kaçarken hasar alır.}
                }
            }else if(canavar==null){
                  System.out.println("Bu odada canavar yok.");
            }
            else{
                  System.out.println("Oda boş!");
                       if (oda.anahtarVarMi()) {
                           System.out.println("Anahtar Buldunuz");
                           karakter.anahtarEkle();
            }}
                //Altınla iyilesme
                 System.out.println("Altin harcayarak iyilesmek ister misiniz? (evet/hayir)");
                String iyilesmeCevap = scanner.next();
                 if (iyilesmeCevap.equalsIgnoreCase("evet")) {
                    System.out.println("Ne kadar altin harcamak istersiniz?");
                    int harcamaMiktari = scanner.nextInt();
                    karakter.altinlaIyiles(harcamaMiktari);
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }}
         // Oyun bitiş durumu
        if (karakter.hayattaMi()) {
            if (karakter.oyunKazanildiMi()) {
                System.out.println(karakter.isim + " oyunu kazandı!");
            } else {
                //System.out.println(karakter.isim + " öldü.");
            }
        } else {
           // System.out.println(karakter.isim + " öldü.");
        }
    }
}
   
