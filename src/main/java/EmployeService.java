import java.awt.desktop.AboutEvent;
import java.util.Arrays;

public class EmployeService {

    private static final int MAX_EMPLOYES = 50;
    private static Employe[] employes = new Employe[MAX_EMPLOYES];
    private static int nombreEmployes = 0;

    // Affiche le menu pour gérer les employés
    public static void printMenu() {
        System.out.println("=== Gestion des Employés ===");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher des employés");
        System.out.println("5. Rechercher un employé par nom ou poste");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier et afficher les employés par salaire");
        System.out.println("0. Quitter");
        System.out.print("Choisissez une option : ");
    }

    // Ajouter un employé à la liste
    public static boolean ajouterEmploye(Employe employe) {
        if (nombreEmployes < MAX_EMPLOYES) { // Correction de l'opérateur <= à <
            employes[nombreEmployes++] = employe;
            System.out.println("Employé ajouté : " + employe.toString());
            return true;
        }
        System.out.println("Impossible d'ajouter l'employé : la liste est pleine.");
        return false;
    }

    // Rechercher un employé par son ID
    public static Employe rechercherEmployeParId(int id) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                return employes[i];
            }
        }
        return null;
    }

    // Modifier les informations d'un employé
    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("L'employé a été modifié.");
            }
        }
    }

    // Supprimer un employé de la liste par son ID
    public static void supprimerEmploye(int id) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i] = null;
            }
        }
    }

    // Afficher tous les employés
    public static void afficherEmployes() {
        if (nombreEmployes == 0) {
            System.out.println("Aucun employé n'existe.");
        } else {
            for (int i = 0; i < nombreEmployes; i++) {
                System.out.println(employes[i]);
            }
        }
    }

    // Rechercher un employé par nom ou poste
    public static void rechercherEmploye(String critere) {
        boolean found = false;
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getNom().equals(critere) || employes[i].getPoste().equals(critere)) {
                System.out.println(employes[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun employé ne correspond au critère : " + critere);
        }
    }

    // Calculer la masse salariale totale
    public static void calculerMasseSalariale() {
        double somme = 0;

        if (nombreEmployes == 0) {
            System.out.println("Aucun employé enregistré, masse salariale = 0.");
            return;
        }

        for (int i = 0; i < nombreEmployes; i++) {
            somme += employes[i].getSalaire(); // Correction de "getSalire()" à "getSalaire()"
        }

        System.out.println("Masse salariale totale : " + somme + " DHS");
    }

    // Trier les employés par salaire, selon l'ordre (croissant ou décroissant)
    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        // Tri des employés en utilisant la méthode compareParSalaire
        Arrays.sort(employes, 0, nombreEmployes, (e1, e2) -> {
            int comparison = Employe.compareParSalaire(e1, e2);
            return ordreCroissant ? comparison : -comparison;
        });

        // Afficher les employés triés
        System.out.println("Liste des employés triée par salaire :");
        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println(employes[i]);
        }
    }
}
