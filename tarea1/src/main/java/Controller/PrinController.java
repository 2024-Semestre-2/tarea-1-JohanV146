package Controller;

import View.Principal;

/**
 *
 * @author johan
 */
public class PrinController {
    private Principal view;
    
    public PrinController(Principal view){
        this.view = view;
    }
    
    public void mostrarVista() {
        view.setVisible(true);
    }
}
