import java.util.*;

public class ConvertisseurNombresRomains {
    private static final String I = "I";
    private static final String V = "V";
    private static final String X = "X";
    private static final String L = "L";
    private static final String C = "C";
    private static final String D = "D";
    private static final String M = "M";
    private static final String MERCI_DE_RENTRER_LE_NOMBRE_A_CONVERTIR = "Merci de rentrer le nombre à convertir";

    private static Map<Integer, String> bases = new TreeMap<>(Collections.reverseOrder());

    static {
        bases.putAll(Map.of(
                5, V,
                10, X,
                50, L,
                100, C,
                500, D,
                1000, M
        ));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombre = 0;
        while (true) {
            System.out.println("Entrer un nombre :");
            try {
                nombre = scanner.nextInt();
            } catch (InputMismatchException ie) {
                System.out.println(MERCI_DE_RENTRER_LE_NOMBRE_A_CONVERTIR + " : " + scanner.next() + " n'est pas un nombre");
                scanner.close();
                System.exit(0);
            }
            ConvertisseurNombresRomains convertisseur = new ConvertisseurNombresRomains();
            System.out.println(String.format("Conversion de %d en chiffres romains", nombre));
            System.out.println(convertisseur.enChiffresRomains(nombre));
        }

    }

    public String enChiffresRomains(int nombre) {
        String chiffreRomain = bases.get(nombre);
        if (chiffreRomain != null) {
            return chiffreRomain;
        }
        chiffreRomain = enUnitesRomaines(nombre);
        chiffreRomain = remplacerUnitesRomainesEnNombresDeBase(chiffreRomain);
        chiffreRomain = reNormaliserSiQuatreUnites(chiffreRomain);

        return chiffreRomain;
    }

    private String enUnitesRomaines(int nombre) {
        return I.repeat(nombre);
    }

    private String remplacerUnitesRomainesEnNombresDeBase(String chiffreRomain) {
        for (Map.Entry<Integer, String> baseEntry : bases.entrySet()) {
            Integer nombre = baseEntry.getKey();
            String nombreRomain = baseEntry.getValue();
            chiffreRomain = chiffreRomain.replace(enUnitesRomaines(nombre), nombreRomain);
        }
        return chiffreRomain;
    }

    private String reNormaliserSiQuatreUnites(String chiffreRomain) {
        chiffreRomain = renormaliserSiQuatreUnites(chiffreRomain, C, D, M);
        chiffreRomain = renormaliserSiQuatreUnites(chiffreRomain, X, L, C);
        chiffreRomain = renormaliserSiQuatreUnites(chiffreRomain, I, V, X);
        return chiffreRomain;
    }

    private String renormaliserSiQuatreUnites(String chiffreRomain, String un, String cinq, String dix) {
        chiffreRomain = chiffreRomain
                .replace(un.repeat(4), un + cinq)
                .replace(cinq + un + cinq, un + dix)
        ;
        return chiffreRomain;
    }
}
