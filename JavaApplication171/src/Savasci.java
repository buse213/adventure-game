public class Savasci extends Karakter {

    

     
    public Savasci() {
          super("Savasci",100,20,"Guclu Darbe");
    
    }
    @Override
    public void ozelYetenekKullan(Canavar hedef) {
        System.out.println(isim+" ozel yetenegini kullandi: "+ozelYetenek);
        hedef.saglik -= hasar*2; // Özel yetenekle cift hasar verir.
        if(hedef.saglik<=0){
            System.out.println("Tebrikler "+hedef.isim+" Olduruldu");
            
        }
        else{
            System.out.println(hedef.isim+" agir hasar aldi! Kalan saglik: "+hedef.saglik);
    }}

    @Override
    public void saldir(Kullanici hedef) {
        System.out.println(isim +" saldiriyor! Hedef: "+hedef.isim);
        hedef.saglik -=hasar;
        if(hedef.saglik<=0){
            System.out.println("Tebrikler "+hedef.isim+" Olduruldu");
            
        }
        else{
            System.out.println(hedef.isim+"  hasar aldi! Kalan saglik: "+hedef.saglik);
    }
    }
   
    
}
