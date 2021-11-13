package main;

import delegate.Delegate;
import model.Model;

/**
 * The VectorMain class is used to initialise the program.
 * @author: 210017984
 */
public class VectorMain {
    public static void main(String[] args){
        Model model = new Model();
        Delegate delegate = new Delegate(model); // pass the model object to the delegate, so that it can observe, display, and change the model
    }
}
