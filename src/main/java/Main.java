import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        while (continuer) {
            EmployeService.printMenu();
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("---- Ajouter un employé ----");
                    System.out.print("Entrez le nom de l'employé : ");
                    String nom = scanner.next();
                    System.out.print("Entrez le poste de l'employé : ");
                    String poste = scanner.next();
                    System.out.print("Entrez le salaire de l'employé : ");
                    int salaire = scanner.nextInt();
                    Employe employe = new Employe(nom, poste, salaire);
                    EmployeService.ajouterEmploye(employe);
                    System.out.println(nom + " " + poste + " " + salaire);
                    break;
                case 2:
                    System.out.println("---- modifier un employé ----");
                    System.out.print("Entrez l'ID de l'employé : ");
                    int id = scanner.nextInt();
                    Employe employe1 = EmployeService.rechercherEmployeParId(id);

                    if (employe1 == null) {
                        System.out.println("Employé introuvable. Opération annulée.");
                        break;
                    }

                    System.out.println(employe1);
                    System.out.print("Entrez le nouveau nom de l'employé : ");
                    String nouveauNom = scanner.next();
                    System.out.print("Entrez le nouveau poste de l'employé : ");
                    String nouveauPoste = scanner.next();
                    System.out.print("Entrez le nouveau salaire de l'employé : ");
                    int nouveauSalaire = scanner.nextInt();
                    EmployeService.modifierEmploye(id, nouveauNom, nouveauPoste, nouveauSalaire);
                    break;
                case 3:
                    System.out.println("----- Supprimer un employé ------");
                    System.out.print("Entrez l'ID de l'employé que vous souhaitez supprimer : ");
                    id = scanner.nextInt();

                    Employe employeASupprimer = EmployeService.rechercherEmployeParId(id);
                    if (employeASupprimer == null) {
                        System.out.println("Employé introuvable. Opération annulée.");
                        break;
                    }

                    System.out.print("Êtes-vous sûr ? (1 pour confirmer, 0 pour annuler) : ");
                    int confirmation = scanner.nextInt();

                    if (confirmation == 1) {
                        EmployeService.supprimerEmploye(id);
                        System.out.println("Employé supprimé avec succès.");
                    } else {
                        System.out.println("Suppression annulée.");
                    }
                    break;
                case 4:
                    System.out.println("---- afficher des employés ----");
                    EmployeService.afficherEmployes();
                    break;
                case 5:
                    System.out.println("---- Chercher des employés ----");
                    System.out.print("Entrez un nom ou un poste pour chercher un employé : ");
                    String value = scanner.next();
                    EmployeService.rechercherEmploye(value);
                    break;
                case 6:
                    System.out.println("----- La somme des salaires des employés ------");
                    EmployeService.calculerMasseSalariale();
                    break;
                case 7:
                    System.out.println("---- Trier les employés par salaire ----");
                    System.out.print("Voulez-vous trier par salaire croissant ? (1 pour oui, 0 pour non) : ");
                    int choixOrdre = scanner.nextInt();
                    boolean ordreCroissant = choixOrdre == 1;
                    EmployeService.trierEmployesParSalaire(ordreCroissant);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}
