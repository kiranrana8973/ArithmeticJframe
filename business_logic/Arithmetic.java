package business_logic;

public class Arithmetic{

    private int first;
    private int second;

    public Arithmetic(int first,int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst(){
        return first;
    }

    public int getSecond(){
        return second;
    }

    public int add(){
        return first + second;
    }

    public int sub(){
        return first - second;
    }

    public int mul(){
        return first * second;
    }

    public int div(){
        return first / second;
    }
}