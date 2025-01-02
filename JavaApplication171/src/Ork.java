public class Ork extends Canavar {
    
    
    public Ork() {
         super("Ork",70,15,"Guclu");
    }

    @Override
    public void saldir(Kullanici hedef){
        System.out.println(isim+"ok atti! Hedef: "+hedef.isim);
        hedef.hasarAl(hasar);
        if(!hedef.hayattaMi()){
            System.out.println(hedef.isim+" kan kaybindan oldu!");
        }else{
            System.out.println(hedef.isim+" kalan saglik: "+hedef.saglik);
        }
        super.hasarAl(hedef.saglik*2/10);
    }
}
