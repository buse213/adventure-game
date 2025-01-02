public class Okcu extends Karakter {

    
    
   public  Okcu() {
         super("Okcu",80,15,"Keskin Nisan");
    }
        

   

    @Override
    public void ozelYetenekKullan(Canavar hedef) {
        System.out.println(isim + " ozel yetenegini kullandi: " + ozelYetenek);
        hedef.saglik -= hasar * 3; // Özel yetenekle üçlü hasar verir.
        if(hedef.saglik<=0){
            System.out.println("Tebrikler "+hedef.isim+" Olduruldu");
            
        }else{
        System.out.println(hedef.isim + " agir bir darbe aldi! Kalan saglik: " + hedef.saglik);}
    }

    @Override
    public void saldir(Kullanici hedef) {
       System.out.println(isim + " ok firlatiyor! Hedef: " + hedef.isim);
        hedef.saglik -= hasar;
        if (hedef.saglik <= 0) {
            System.out.println(hedef.isim + " okla olduruldu!");
        } else {
            System.out.println(hedef.isim + " kalan saglik: " + hedef.saglik);
        }
    }
    
}
