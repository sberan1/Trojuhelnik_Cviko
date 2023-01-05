import javax.swing.*;

/**
 * Vyctovy typ TypTrojuhelnika ... představuje jednotlivé typy trojúhelníků,
 * se kterými umí pracovat třídy aplikace Trojuhelniky. 
 *
 * @author     Jarmila Pavlíčková
 * @version    1.0, duben 2005
 */
public enum TypTrojuhelnika {
    PRAVOUHLY_A_B,
    PRAVOUHLY_A_C,
    ROVNOSTRANNY,
    OBECNY_A_B_C,
    OBECNY_B_C_ALPHA,
    OBECNY_ALPHA_BETA_C;

    public static class Varianta {
        private TypTrojuhelnika typ;            // typ trojuhelniku
        private String popis;       // popis varianty - objevi se v nabidce
        private String dotaz1;      // dotaz na první parametr
        private String dotaz2;      // dotaz na druhý parametr
        private String dotaz3;      // dotaz na třetí parametr

        /**
         * Vytvoření jedné varianty nabídky.
         *
         * @param typ    typ trojúhelníku, viz emun TypTrojuhelnika
         * @param popis  popis varianty - objeví se v menu
         * @param dotaz1 řetězec s dotazem na první parametr či hodnota null, pokud není
         *               potřeba první parametr (a tím pádem ani dotaz)
         * @param dotaz2 řetězec s dotazem na druhý parametr či hodnota null, pokud není
         *               potřeba druhý parametr (a tudíž ani dotaz)
         * @param dotaz3 řetězec s dotazem na třetí parametr či hodnota null, pokud není
         *               potřeba třetí parametr (a tudíž ani dotaz)
         */
        public Varianta(TypTrojuhelnika typ, String popis, String dotaz1, String dotaz2, String dotaz3) {
            // initialise instance variables
            this.typ = typ;
            this.popis = popis;
            this.dotaz1 = dotaz1;
            this.dotaz2 = dotaz2;
            this.dotaz3 = dotaz3;
        }

        /**
         * Vrací typ trojuhelníku
         *
         * @return typ trojúhelníku, jednotlivé typy jsou definovány ve třídě Trojuhelnik
         */
        public TypTrojuhelnika getTyp() {
            return typ;
        }

        /**
         * Vrací popis varianty.
         *
         * @return popis varianty.
         */
        public String getPopis() {
            return popis;
        }

        /**
         * Vrací dotaz na první parametr.
         * Pokud není potřeba první parametr (což je velmi neobvyklé), vrací hodnotu null.
         *
         * @return dotaz (prompt) na první parametr či hodnota null, pokud není potřeba.
         */
        public String getDotaz1() {
            return dotaz1;
        }

        /**
         * Vrací dotaz na druhý parametr.
         * Pokud není potřeba druhý parametr (např. u rovnoramenného trojúhelníku),
         * vrací hodnotu null.
         *
         * @return dotaz (prompt) na druhý parametr či hodnota null, pokud není potřeba.
         */
        public String getDotaz2() {
            return dotaz2;
        }

        /**
         * Vrací dotaz na třetí parametr.
         * Pokud není potřeba třetí parametr, vrací hodnotu null
         *
         * @return dotaz (prompt) na třetí parametr či hodnota null, pokud není potřeba
         */
        public String getDotaz3() {
            return dotaz3;
        }
        public int getPocetParametru() {
            if (dotaz3 != null) {
                return 3;
            }
            else {
                if (dotaz2 != null) {
                    return 2;
                }
                else {
                    if (dotaz1 != null) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
    }
}
