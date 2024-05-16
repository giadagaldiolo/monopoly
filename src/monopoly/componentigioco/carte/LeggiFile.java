package monopoly.componentigioco.carte;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class LeggiFile {


    static List<Carta> readFromFile(File file) {
        List<Carta> carte = new ArrayList<>();

        if (file == null)
            return carte;

        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(";");
                if (tokens.length != 3)
                    continue;

                Carta carta = trovaTipo(tokens[1]);
                carta.setDescrizione(tokens[0]);
                carta.setAzione(tokens[1]);
                carta.setTerzaInformazione(tokens[2]);

                carte.add(carta);
            }
        } catch (final IOException e) {
            System.out.println("Some errors occurred while reading the desired file");
            System.out.println(e.getMessage());
            return null;
        }
        return carte;
    }

    private static Carta trovaTipo(String stringa) {
        return switch (stringa) {
            case "vai a" -> new VaiA();
            case "paga" -> new Paga();
            default -> new Ricevi();
        };
    }
}
