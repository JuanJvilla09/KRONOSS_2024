package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String userId = null, userName = null, userEmail = null, userPhone = null, userPassword = null;
            int userAge = 0;
            String reminderTitle = null, reminderDateTime = null, reminderRepeat = null;

            int choice;
            do {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Registro de usuario");
                System.out.println("2. Crear recordatorio");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (choice) {
                    case 1:
                        // Registro de usuario
                        System.out.println("\n--- Registro de Usuario ---");

                        // ID único
                        System.out.print("Ingrese un ID único: ");
                        userId = scanner.nextLine();

                        // Nombre completo
                        System.out.print("Ingrese su nombre completo: ");
                        userName = scanner.nextLine();

                        // Edad
                        System.out.print("Ingrese su edad: ");
                        userAge = scanner.nextInt();
                        scanner.nextLine();

                        // Teléfono
                        System.out.print("Ingrese su teléfono: ");
                        userPhone = scanner.nextLine();

                        // Correo electrónico
                        boolean validEmail = false;
                        do {
                            System.out.print("Ingrese su correo electrónico: ");
                            userEmail = scanner.nextLine();
                            validEmail = Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$", userEmail);
                            if (!validEmail) {
                                System.out.println("Correo electrónico inválido. Inténtelo de nuevo.");
                            }
                        } while (!validEmail);

                        // Contraseña
                        boolean validPassword = false;
                        do {
                            System.out.print("Ingrese su contraseña: ");
                            userPassword = scanner.nextLine();
                            validPassword = userPassword.length() >= 8 &&
                                    userPassword.matches(".*[A-Z].*") &&
                                    userPassword.matches(".*[a-z].*") &&
                                    userPassword.matches(".*\\d.*") &&
                                    userPassword.matches(".*[!@#$%^&*].*");

                            if (!validPassword) {
                                System.out.println("La contraseña debe tener al menos 8 caracteres, incluir una letra mayúscula, una minúscula, un número y un carácter especial.");
                            }
                        } while (!validPassword);

                        System.out.println("Usuario registrado con éxito.");
                        break;

                    case 2:
                        // Crear recordatorio
                        if (userId == null) {
                            System.out.println("Debe registrarse antes de crear recordatorios.");
                            break;
                        }

                        System.out.println("\n--- Crear Recordatorio ---");

                        // Título
                        System.out.print("Ingrese el título del recordatorio: ");
                        reminderTitle = scanner.nextLine();

                        // Fecha y hora
                        boolean validDateTime = false;
                        do {
                            System.out.print("Ingrese la fecha y hora del recordatorio (formato AAAA-MM-DD HH:mm): ");
                            reminderDateTime = scanner.nextLine();
                            validDateTime = Pattern.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$", reminderDateTime);

                            if (!validDateTime) {
                                System.out.println("Formato de fecha y hora inválido. Inténtelo de nuevo.");
                            }
                        } while (!validDateTime);

                        // Repetición
                        System.out.println("Seleccione una opción de repetición:");
                        System.out.println("1. Diario");
                        System.out.println("2. Semanal");
                        System.out.println("3. Mensual");
                        System.out.println("4. Intervalo personalizado");
                        int repeatOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (repeatOption) {
                            case 1:
                                reminderRepeat = "Diario";
                                break;
                            case 2:
                                reminderRepeat = "Semanal";
                                break;
                            case 3:
                                reminderRepeat = "Mensual";
                                break;
                            case 4:
                                System.out.print("Ingrese el intervalo personalizado (por ejemplo, cada 2 días): ");
                                reminderRepeat = scanner.nextLine();
                                break;
                            default:
                                System.out.println("Opción inválida. No se asignó repetición.");
                                reminderRepeat = "Sin repetición";
                                break;
                        }

                        System.out.println("Recordatorio creado con éxito.");
                        break;

                    case 3:
                        System.out.println("Saliendo de Kronoss. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                        break;
                }
            } while (choice != 3);

            scanner.close();



        }









}