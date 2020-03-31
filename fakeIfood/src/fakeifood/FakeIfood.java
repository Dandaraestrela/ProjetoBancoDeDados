
package fakeifood;

import db.*;
public class FakeIfood {
    public static void main(String[] args) {
        
        CreateDB.createNewDatabase("fakeIfood.db");
        CreateTables.main();
        //InsereDados.main();
        BuscaDados.main();
        FrameInicial FI = new FrameInicial();
        FI.setVisible(true);
    }
    
}


