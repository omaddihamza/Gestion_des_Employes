public class Employe {
    private static int count=0;
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    public Employe() {
    }

    public Employe(String nom, String poste, double salire) {
        this.id = ++count;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salire;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employe.count = count;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", salire=" + salaire +
                '}';
    }

    // Méthode statique pour comparer par salaire
    public static int compareParSalaire(Employe e1, Employe e2) {
        return Double.compare(e1.getSalaire(), e2.getSalaire());
    }

}
