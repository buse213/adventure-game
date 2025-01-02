public class KurtAdam extends Canavar {
    
    

   public  KurtAdam() {
         super("KurtAdam",50,10,"Hizli");
    }

    @Override
    public void saldir(Kullanici hedef){
        System.out.println(isim+" pencesini gecirdi! Hedef: "+hedef.isim);
        hedef.hasarAl(hasar);//karakterin aldığı hasar
        if(!hedef.hayattaMi()){
            System.out.println(hedef.isim+" kan kaybindan oldu!");
        }else {
            
            System.out.println(hedef.isim+" kalan saglik: "+hedef.saglik);
        }
        super.hasarAl(hedef.saglik*2/10);//Canavarın aldığı hasar
    
    }
    
}
