
/**
 * Třída popisuje trojúhelník. Pro získání instance existuje větší množství statických
 * metod, které vytvářejí trojúhelník na základě jednotlivých známých parametrů.
 * 
 * @author  Luboš Pavlíček 
 * @version 1.0 srpen 2004
 */
public class Trojuhelnik
{
    // datové atributy trojúhelníku
    private double stranaA;
    private double stranaB;
    private double stranaC;

    /**
     * Vytvoření trojúhelníku při znalosti všech tří stran.
     */
    
    private Trojuhelnik(double stranaA, double stranaB, double stranaC)
    {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;
    }
    
    /**
     * Statická metoda pro získání instance pravoúhlého trojúhelníku (tj. úhel
     * gama je 90°) při zadání velikosti strany A a strany B (tj. obou odvěsen).
     * 
     * @param  stranaA  délka strany A
     * @param  stranaB  délka strany B
     * @return instance třídy Trojuhelnik, která má úhel gama 90° a zadanou délku strany
     *                  A a strany B
     */
    public static Trojuhelnik getPravouhlyAB (double stranaA, double stranaB) {
        return new Trojuhelnik(stranaA, stranaB, Math.sqrt(stranaA*stranaA + stranaB*stranaB));
        
    }
    
    /**
     * Statická metoda pro získání instance pravoúhlého trojúhelníku (tj. úhel
     * gama je 90°) při zadání velikosti strany A a strany C (tj. jedné odvěsny a přepony).
     * 
     * @param  stranaA  délka strany A (odvěsna)
     * @param  stranaC  délka strany C (přepona)
     * @return instance třídy Trojuhelnik, která má úhel gama 90° a zadanou délku strany
     *                  A a strany C
     */
    
    public static Trojuhelnik getPravouhlyAC (double stranaA, double stranaC) {
        if (stranaC <= stranaA) {
            return null;
        }
        else {
            return new Trojuhelnik(stranaA, Math.sqrt(stranaC*stranaC - stranaA*stranaA), stranaC);
        }
    }

    /**
     * staticka metoda pro ziskani instance obecneho trojuhelnika zadanim tri stran
     *
     * @param stranaA delka strany A
     * @param stranaB delka strany B
     * @param stranaC delka strany C
     * @return instance tridy trojuhelnik, ktery ma strany podle toho jak jsou zadane
     */
    public static Trojuhelnik getObecnyABC (double stranaA, double stranaB, double stranaC){
        if (stranaA + stranaB > stranaC && stranaA + stranaC > stranaB && stranaB + stranaC > stranaA){
            return new Trojuhelnik(stranaA, stranaB, stranaC);
        }
        return null;
    }

    /**
     * staticka metoda pro ziskani instance obecneho trojuhelnika sus uzitim cosinove vety
     *
     * @param stranaB delka strany B
     * @param stranaC delka strany C
     * @param uhelAlpha velikost uhlu Alpha
     * @return instance trojuhelnik podle zadani
     */
    public static Trojuhelnik getObecnyBCAlpha(double stranaB, double stranaC, double uhelAlpha){
        if (uhelAlpha < 180){
            return new Trojuhelnik(Math.sqrt(Math.pow(stranaB, 2)), Math.pow(stranaC, 2), 2*stranaB*stranaC*Math.cos(uhelAlpha));
        }
        return null;
    }

    public static Trojuhelnik getObecnyAlphaBetaC(double uhelAlpha, double uhelBeta, double stranaC){
        if (uhelAlpha+uhelBeta < 180){
            double uhelGama = 180 - uhelAlpha - uhelBeta;
            return new Trojuhelnik(uhelAlpha*(stranaC/uhelGama), uhelBeta*(stranaC/uhelGama), stranaC);
        }
        return null;
    }
    /**
     * metoda pro ziskani instance rovnostranneho trojuhelnika
     *
     * @param stranaA delka strany A
     * @return instrance tridy Trojuhelnik
     */

    public static Trojuhelnik getRovnostranny(double stranaA){
        return new Trojuhelnik(stranaA, stranaA, stranaA);
    }

    /**
     * Obecná statická metoda pro získání instance trojúhelníku, kdy je zadán typ trojúhelníku
     * (viz konstanty v této třídě) a pole s potřebnými parametry.
     * 
     * @param  typ      typ trojúhelníku
     * @param  parametry pole s parametry pro příslušný typ trojúhelníku
     * @return instance třídy Trojuhelnik příslušného typu a odpovídající zadaným parametrům
     */
    
    public static Trojuhelnik getTrojuhelnik (TypTrojuhelnika typ, double [] parametry) {
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_B) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAB(parametry[0], parametry[1]);
        }
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_C) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAC(parametry[0], parametry[1]);
        }
        if (typ == TypTrojuhelnika.ROVNOSTRANNY){
            if (parametry.length < 1){
                return null;
            }
            return getRovnostranny(parametry[0]);
        }
        if (typ == TypTrojuhelnika.OBECNY_A_B_C){
            if (parametry.length < 3){
                return null;
            }
            return getObecnyABC(parametry[0], parametry[1], parametry[2]);
        }
        if (typ == TypTrojuhelnika.OBECNY_B_C_ALPHA){
            if (parametry.length < 3){
                return null;
            }
            return getObecnyBCAlpha(parametry[0], parametry[1], parametry[2]);
        }
        if (typ == TypTrojuhelnika.OBECNY_ALPHA_BETA_C){
            if (parametry.length < 3){
                return null;
            }
            return getObecnyAlphaBetaC(parametry[0], parametry[1], parametry[2]);
        }
        return null;
    }
    
    /**
     * Vrací délku strany A trojúhelníku
     * 
     * @return  délka strany A trojúhelníku
     */
    public double getStranaA() {
        return stranaA;
    }
    
    /**
     * Vrací délku strany B trojúhelníku
     * 
     * @return  délka strany B trojúhelníku
     */
    public double getStranaB() {
        return stranaB;
    }
    
    /**
     * Vrací délku strany C trojúhelníku
     * 
     * @return  délka strany C trojúhelníku
     */
    public double getStranaC() {
        return stranaC;
    }
    
    /**
     * Vrací velikost úhlu alfa (proti straně A) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu alfa trojúhelníku.
     */
    public double getAlfa() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaC*stranaC - stranaA*stranaA)
                /(2*stranaB*stranaC)));
    }
    
    /**
     * Vrací velikost úhlu beta (proti straně B) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu beta trojúhelníku.
     */
    public double getBeta() {
        return Math.toDegrees(Math.acos( (stranaA*stranaA + stranaC*stranaC - stranaB*stranaB)
                /(2*stranaA*stranaC)));
    }
    
    /**
     * Vrací velikost úhlu gama (proti straně C) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu gama trojúhelníku.
     */
    public double getGama() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaA*stranaA - stranaC*stranaC)
                /(2*stranaB*stranaA)));
    }

    /**
     * Vypočte obvod trojúhelníku.
     * 
     * @return obvod trojúhelníku
     */
    public double obvod () {
        return (stranaA + stranaB + stranaC);
    }

    /**
     * Vypočte obsah trojúhelníku.
     * 
     * @return obsah trojúhelníku
     */
    public double obsah () {
        double polObvod=obvod()/2;
        return Math.sqrt(polObvod*(polObvod-stranaA) *(polObvod-stranaB) * (polObvod - stranaC));
    }
}
