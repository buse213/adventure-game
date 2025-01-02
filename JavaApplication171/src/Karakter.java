public abstract class Karakter extends Kullanici {
    
    protected String ozelYetenek;
    protected int altin;
    protected static int anahtar;
    public int ozelYetenekHakki=3;
    public abstract void ozelYetenekKullan(Canavar hedef);
  
            
    
    public Karakter(String isim, int saglik, int hasar,String ozelYetenek) {
        super(isim, saglik, hasar);
        this.ozelYetenek=ozelYetenek;
        this.altin=0;
        this.anahtar=0;
    }
    public int getAltin(){
        return altin;
    }
    public void altinEkle(int miktar){
        this.altin +=miktar;
        System.out.println(isim +" altin topladi! Toplam altin: "+altin);
    }
    public void altinEkle(){
        this.altin+=10;
    }
    
    public static void anahtarEkle(){
        Karakter.anahtar++;
        System.out.println("Tebrikler Anahtar Kazandiniz!"+"Gereken Anahtar Sayisi:"+(3-anahtar));
    }
    
    public boolean oyunKazanildiMi(){
        return anahtar >=3;
    }
    public int altınEksilt(int miktar){
        if(altin >=miktar){
            altin -=miktar;
            System.out.println(isim+" "+miktar+" altin harcadi, ekstra hasar verildi");
            
        }else{
            System.out.println("Yeterli altin yok! Daha fazla altin toplamaniz gerekiyor.");
            
        }
        return altin;
    }
    
    public void altinlaIyiles(int miktar){
        if(altin >=miktar){
            altin -=miktar;
            iyilestir(5*miktar);
            System.out.println(isim+" "+miktar+" altin harcadi, saglik iyilesti!");
        }else{
            System.out.println("Yeterli altin yok! Daha fazla altin toplamaniz gerekiyor.");
        }
    }

    
   
    
}
