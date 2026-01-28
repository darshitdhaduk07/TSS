class A{
    public A(){

    }
}
class B extends A{
    public B(){
    }
    public B(int a,int b){
        this();
    }
}
class Main{
    public static void main(String[] args) {

        B b = new B();
    }
}