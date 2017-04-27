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
class Addition implements Command {
    private final Undo undo;

    public Addition(Undo Undo) {
        this.undo = Undo;
    }
    @Override
    public int execute(int input) {
        return undo.add(undo.get() + input);
    }
}
