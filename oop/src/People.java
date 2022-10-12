public class People extends Creature implements Livable{
    //一些基本属性
   
    private People father;

    //构造器 
    public People(){

    }

    //行为
    public void write(){
        System.out.println("write");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void speak() {
        // TODO Auto-generated method stub
        
    }
}