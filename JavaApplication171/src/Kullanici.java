public abstract class Kullanici {
    protected String isim;
    protected int saglik;
    protected int hasar;
    
    public Kullanici(String isim, int saglik, int hasar){
        this.isim = isim;
        this.saglik = saglik;
        this.hasar = hasar;
    }
    
    public abstract void saldir(Kullanici hedef);
    
    
    public boolean hayattaMi(){
        return saglik>0;
    }
    
   
       public void iyilestir(int miktar) {
    try {
        if (miktar < 0) {
            throw new IllegalArgumentException("Iyilestirme miktarı negatif olamaz!");
        }
        this.saglik += miktar;
        System.out.println(isim + " iyilesti! Yeni saglik: " + saglik);
    } catch (IllegalArgumentException e) {
        System.out.println("Hata: " + e.getMessage());
    }
    
    }
    
    public String getIsim(){
        return isim;
    }
    
    public void hasarAl(int miktar){
        this.saglik -=miktar;
        if(saglik <=0){
            saglik=0;
           // System.out.println(isim+" oldu!");
        }else{
            System.out.println(isim+" kalan saglik: "+saglik);
        }
    }
    public void hasarAl(int miktar, int altınSayısı){
        this.saglik -=(miktar*altınSayısı/5);
        if(saglik <=0){
            saglik=0;
           // System.out.println(isim+" oldu!");
        }else{
            System.out.println(isim+" kalan saglik: "+saglik);
        }
    }
    
}
