package UserService.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(){
        super("Resource not Found!!!");

    }
    public ResourceNotFoundException(String msg){
           super(msg);
    }
}
