/**
 * HandleClick is used to get the event from clicking on an object, it is used to get object
 * data and return it in a useful format
 *
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;


public class HandleClick implements EventHandler<MouseEvent>{
    private static String fxid;
    
    @Override
    public void handle(MouseEvent event) {
        Node target = (Node) event.getTarget();
        fxid = target.getId();
        
    }
    
    public String getObjectId(MouseEvent event){
        handle(event);
        return fxid;
    }
    
}
