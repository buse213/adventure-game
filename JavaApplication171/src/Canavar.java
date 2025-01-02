public abstract class Canavar extends Kullanici {
    
    protected String ozellik;
    protected boolean alive; //Canavarın hayatta olup olmadığını tutacak
    
    public Canavar(String isim, int saglik, int hasar, String ozellik) {
        super(isim, saglik, hasar);
        this.ozellik = ozellik;
        this.alive = true; // Başlangıçta canavar hayatta
    }
    
    @Override
    public void saldir(Kullanici hedef){
        if(this.alive){
            System.out.println(isim+" saldiriyor! Hedef: "+hedef.getIsim());
            hedef.hasarAl(hasar);
        }
    }
  
    
    //Canavarın sağlığını düşüren metod
    
    
    // Canavarın özelliğini al
    public String getOzellik(){
        return ozellik;
    }

   public  boolean isAlive() {
       if(this.saglik <=0){
            alive=false;
        }
        return alive;
   }

}
