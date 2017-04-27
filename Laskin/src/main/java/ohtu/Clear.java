/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author saskeli
 */
class Clear implements Command {
    private final Undo undo;
    
    public Clear(Undo undo) {
        this.undo = undo;
    }

    @Override
    public int execute(int input) {
        return undo.add(0);
    }
}
