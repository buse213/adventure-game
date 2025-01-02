import java.util.Random;
import java.util.Scanner;

public class Harita {
   
   private Oda[][] odalar;
   private int boyut;
   private int oyuncuX,oyuncuY;
   
   public Harita(int boyut){
       this.boyut=boyut;
       this.odalar=new Oda[boyut][boyut];
       this.oyuncuX=0;
       this.oyuncuY=0;
   
   
   //Haritayı rastgele doldur
   Random rand=new Random();
   for(int i=0; i <boyut; i++){
       for(int j=0; j <boyut; j++){
           Canavar canavar =null;
           int rastgele =rand.nextInt(4);
           if(rastgele==0) canavar =new KurtAdam();
           else if(rastgele==1) canavar= new Ork ();
           else if(rastgele==2) canavar = new Ejderha();
           
           boolean anahtarVar=rand.nextInt(10) < 3; //%30 İhtimalle anahtar
           odalar[i][j]=new Oda(canavar,anahtarVar,rand.nextInt(20)); //Altın 0-20 arasi
        } 
    }
}

   
    
        
        
        
   public void hareketEt(String yon) throws Exception {
        switch (yon.toLowerCase()) {
            case "geri":
                if (oyuncuX > 0) oyuncuX--;
                else throw new Exception("Geriye gidemezsiniz!");
                break;
            case "ileri":
                if (oyuncuX < boyut - 1) oyuncuX++;
                else throw new Exception("Ileri gidemezsiniz!");
                break;
            case "sag":
                if (oyuncuY < boyut - 1) oyuncuY++;
                else throw new Exception("Saga gidemezsiniz!");
                break;
            case "sol":
                if (oyuncuY > 0) oyuncuY--;
                else throw new Exception("Sola gidemezsiniz!");
                break;
            default:
                throw new Exception("Gecersiz yon!");
        }
        System.out.println("Yeni konum:(" + oyuncuX + "," + oyuncuY + ")");
    }

    // Overload: Birden fazla adım hareket
    public void hareketEt(String yon, int adimSayisi) throws Exception {
        for (int i = 0; i < adimSayisi; i++) {
            hareketEt(yon);
        }
        System.out.println(adimSayisi + " adim " + yon + " yonunde hareket edildi.");
    }
/*
    // Overload: Farklı yönlerde hareket
    public void hareketEt(String... yonler) throws Exception {
        for (String yon : yonler) {
            hareketEt(yon);
        }
        System.out.println("Birden fazla yon hareket edildi: " + String.join(", ", yonler));
    }

   */
 /* 
   public void savas(){
       Oda oda= mevcutOda();
       if(oda.canavarAlive()){
           Canavar canavar= oda.getCanavar();
           System.out.println("Canavarla savas basladı:"+canavar.getIsim());
           Scanner scanner=new Scanner(System.in);
           boolean devamEt=true;
           while(devamEt && canavar.isAlive()){
               //Oyuncuya saldır ve hayatta olup olmadığını kontrol et
               System.out.println("Saldirmak icin 's' tuslayin, kacmak icin 'k' tuslayın");
               String secim=scanner.nextLine();
               if(secim.equalsIgnoreCase("s")){
                   //oyuncu saldırıyor
                   //1int oyuncuHasar=15; //Örnek olarak sabit bir değer
                   //canavar.hasarAl(oyuncuHasar);
                   if(!canavar.isAlive()){
                       System.out.println("Canavar oldu! Anahtar kazandiniz.");
                       //Anahtar kazandırma işlemi yapılır
                       devamEt=false; //Savaş bitti
                   }else {
                       System.out.println("Canavar hayatta! Savas devam ediyor.");
                   }
               }else if(secim.equalsIgnoreCase("k")){
                   //oyuncu kaçıyor
                   System.out.println("Kaciyorsunuz");
                   devamEt=false; // Kaçma seçeneği ile savaş bitiyor
                    // Oyuncuyu yeni bir odaya yönlendir
                    // Harita üzerinde yeni bir oda seçilebilir.
                    // Bu örnekte oyuncuyu rastgele başka bir odaya taşıyoruz.
                    rastgeleOdayaGit();
               }else{
                   System.out.println("Gcersiz secim.Lutfen tekrar deneyin.");
               }
           }
           if(!canavar.isAlive()){
           //Anahtar verilebilir burada
           oda=mevcutOda();
           if(oda.anahtarVarMi()){
               System.out.println("Anahtar kazandiniz");
               //Anahtar oyuncuya ver
               //Anahtar akındıktan sonra odada bir değişiklik yapılabilir
           }
        }
    }else{
           System.out.println("Bu odada canavar kalmadı");}
}
   
    //Savaş devam ediyor
   
   //Oyuncuyu rastgele başka bir odaya yönlendiren metod
   public void rastgeleOdayaGit(){
       Random rand=new Random();
       int yeniX=rand.nextInt(boyut);
       int yeniY=rand.nextInt(boyut);
       oyuncuX = yeniX;
       oyuncuY = yeniY;
       System.out.println("Yeni odada: (" + oyuncuX + ", " + oyuncuY + ")");
   }
   
   public Oda mevcutOda(){
    return odalar[oyuncuX][oyuncuY];
   }
*/
  public void rastgeleOdayaGit(){
       Random rand=new Random();
       int yeniX=rand.nextInt(boyut);
       int yeniY=rand.nextInt(boyut);
       oyuncuX = yeniX;
       oyuncuY = yeniY;
       System.out.println("Yeni odada: (" + oyuncuX + ", " + oyuncuY + ")");
   }
   
   public Oda mevcutOda(){
    return odalar[oyuncuX][oyuncuY];
   }
   
    // Oda sınıfı harita sınıfının bir iç sınıfı olarak tanımlanır
   public class Oda{
       private Canavar canavar;
       private boolean anahtar;
       private int altin;
       
       public Oda(Canavar canavar, boolean anahtar,int altin){
           this.canavar=canavar;
           this.anahtar=anahtar;
           this.altin=altin;
       }
       public Canavar getCanavar(){
           return canavar;
       }
       public void canavarYokEt(){
           this.canavar=null; //Canavar öldüğünde null yapıyoruz
       }
       
       public boolean anahtarVarMi(){
           return anahtar;
       }
       
       public int getAltin(){

           return altin;
       }
       
       public boolean canavarAlive(){
           return canavar !=null && canavar.isAlive();
       }

      
   }}




