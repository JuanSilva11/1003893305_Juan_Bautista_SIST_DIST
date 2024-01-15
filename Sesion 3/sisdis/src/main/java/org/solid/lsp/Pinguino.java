package org.solid.lsp;

public class Pinguino extends Pajaro {
    @Override
    public void volar() {
        throw new UnsupportedOperationException("Los pingüinos no pueden volar");
    }
}
