
public class Buyucu extends Karakter {

   

   public  Buyucu() {
         super("Buyucu",70,25,"Alev Topu");
    }

    @Override
    public void ozelYetenekKullan(Canavar hedef) {
       System.out.println(isim + " ozel yetenegini kullandi: " + ozelYetenek);
       hedef.saglik -= hasar * 2 + 10; // Ekstra hasar ile saldırır.
       if(hedef.saglik<=0){
            System.out.println("Tebrikler "+hedef.isim+" Olduruldu");
            
        }else{
       System.out.println(hedef.isim + " buyuden etkilendi! Kalan saglik: " + hedef.saglik);}
    }

    @Override
    public void saldir(Kullanici hedef) {
        System.out.println(isim + " buyu ile saldiriyor! Hedef: " + hedef.isim);
        hedef.saglik -= hasar;
        if (hedef.saglik <= 0) {
            System.out.println(hedef.isim + " oldu!");
        } else {
            System.out.println(hedef.isim + " kalan saglik: " + hedef.saglik);
        }
    }
    
}
