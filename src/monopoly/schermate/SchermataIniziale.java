package monopoly.schermate;

import monopoly.utilita.Costanti;

public class SchermataIniziale implements SchermataInterface{

    @Override
    public String toString() {
        String colore = "\u001B[1;38;5;183m";
        return colore +"""
                 __       __                                                    __          \s
                |  \\     /  \\                                                  |  \\         \s
                | $$\\   /  $$  ______   _______    ______    ______    ______  | $$ __    __\s
                | $$$\\ /  $$$ /      \\ |       \\  /      \\  /      \\  /      \\ | $$|  \\  |  \\
                | $$$$\\  $$$$|  $$$$$$\\| $$$$$$$\\|  $$$$$$\\|  $$$$$$\\|  $$$$$$\\| $$| $$  | $$
                | $$\\$$ $$ $$| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$  | $$| $$| $$  | $$
                | $$ \\$$$| $$| $$__/ $$| $$  | $$| $$__/ $$| $$__/ $$| $$__/ $$| $$| $$__/ $$
                | $$  \\$ | $$ \\$$    $$| $$  | $$ \\$$    $$| $$    $$ \\$$    $$| $$ \\$$    $$
                 \\$$      \\$$  \\$$$$$$  \\$$   \\$$  \\$$$$$$ | $$$$$$$   \\$$$$$$  \\$$ _\\$$$$$$$
                                                           | $$                    |  \\__| $$
                                                           | $$                     \\$$    $$
                                                            \\$$                      \\$$$$$$\s                                              
                
                Premere invio per Iniziare...
                """+ Costanti.ANSI_RESET;
    }


}
