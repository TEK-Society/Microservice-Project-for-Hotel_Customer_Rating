package HotelReview.Exception;

public class ResourceNotFind extends RuntimeException{

    public ResourceNotFind(String m){
        super(m);
    }
    public ResourceNotFind(){
        super("resource not find !!!!");
    }
}
