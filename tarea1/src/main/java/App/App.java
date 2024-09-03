/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.PrinController;
import Model.LeerArchivos;
import View.Principal;

/**
 *
 * @author johan
 */
public class App {
    public static void main(String[] args) {
        LeerArchivos Model = new LeerArchivos();
        Principal View = new Principal();
        PrinController Controller = new PrinController(View, Model);

        Controller.mostrarVista();
    }
}
