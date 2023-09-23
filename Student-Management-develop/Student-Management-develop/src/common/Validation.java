/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author Acer
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    // get an integer value that greater than a min value
    public int getIntData(String msg, int minValue) {
        int data = 0;

        while (true) {
            try {
                System.out.print(msg);
                data = sc.nextInt();
                if (data >= minValue) {
                    break;
                } else {
                    System.out.println("An error happens because the value < " + minValue + "\n");
                }
            } catch (Exception e) {
                System.out.println("An error happens because  the integer number format is invalid\n");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return data;
    }

    // get an integer value
    public int getIntData(String msg) {
        int data = 0;

        while (true) {
            try {
                System.out.print(msg);
                data = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("An error happens because  the integer number format is invalid\n");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return data;
    }

    // get an integer value that greater than or equal  a min value and less than or equal max value
    public int getIntData(String msg, int minValue, int maxValue) {
        int data = 0;

        if (minValue > maxValue) {
            int temp = minValue;
            minValue = maxValue;
            maxValue = temp;
        }

        while (true) {
            try {
                System.out.print(msg);
                data = sc.nextInt();
                if (data >= minValue && data <= maxValue) {
                    break;
                } else {
                    System.out.println("An error happens because the value < " + minValue + " or > " + maxValue + "\n");
                }
            } catch (Exception e) {
                System.out.println("An error happens because  the integer number format is invalid\n");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return data;
    }

    // get an double value that greater than a min value
    public double getDoubleData(String msg, double minValue) {
        double data = 0;

        while (true) {
            try {
                System.out.print(msg);
                data = sc.nextDouble();
                if (data >= minValue) {
                    break;
                } else {
                    System.out.println("An error happens because the value < " + minValue + "\n");
                }
            } catch (Exception e) {
                System.out.println("An error happens because  the double number format is invalid\n");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return data;
    }

    // get a string with a format[];
    public String getString(String msg, String regex) {
        String str = "";

        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();

                if (str.trim().length() == 0 || !str.matches(regex)) {
                    System.out.println("The length is 0 or string format is invalid with the condition ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("The string is INVALID");
            }
        }

        return str;
    }

    // get a string ;
    public String getString(String msg) {
        String str = "";

        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();

                if (str.trim().length() == 0) {
                    System.out.println("The length is 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("The string is INVALID");
            }
        }

        return str;
    }

    // get a string and length string can be equal 0
    public String getStringDataCanBlank(String msg) {
        String str = "";

        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("The string is INVALID");
            }
        }

        return str;
    }

    // get a string, length string can be equal 0, can use regex
    public String getStringDataCanBlank(String msg, String regex) {
        String str = "";

        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();

                if (str.trim().length() != 0 && !str.matches(regex)) {
                    System.out.println("The string format is invalid with the condition ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("The string is INVALID");
            }
        }

        return str;
    }

    // get Boolean data 
    public boolean getBooleanData(String msg) {
        boolean choice = true;

        while (true) {
            try {
                System.out.print(msg);
                choice = sc.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Your input is invalid. Trying again.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        return choice;
    }

    public boolean idIsExisting(ArrayList<Student> list, String id) {
        for (Student st : list) {
            if (st.getId().equalsIgnoreCase(id)) {
                System.out.println("Id is existing. Try again!");
                return true;
            }
        }
        return false;
    }
}
