import java.util.Scanner;
public class Ejderha extends Canavar {
    Scanner scanner=new Scanner(System.in);
 
    
   

    public Ejderha() {
         super("Ejderha",100,25,"Korkutucu");
    }
    @Override
    public void saldir(Kullanici hedef){
        System.out.println(isim+" alev puskurttu Hasar: "+hasar);
        hedef.hasarAl(hasar);
        if(!hedef.hayattaMi()){
             System.out.println(hedef.isim + " yanarak oldu!");
        } else {
            System.out.println(hedef.isim + " kalan saglik: " + hedef.saglik);
        }
        
        super.hasarAl(hedef.saglik*2/10);}
        
    }
    

