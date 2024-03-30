public class UserBmi {

    private int id;
    private String name;
    private int birthYear;
    private int height;
    private int weight;
    private double bmi;
    private String category;

    /**
     * Initializes the UserBmi object with provided data and calculates BMI.
     *
     * @param id        unique identifier for the user
     * @param name      name of the user
     * @param birthYear birth year of the user
     * @param height    height of the user in centimeters
     * @param weight    weight of the user in kilograms
     */
    public UserBmi(int id, String name, int birthYear, int height, int weight) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.height = height;
        this.weight = weight;
        calculateBmi();
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Calculates the BMI and sets the category.
     */
    private void calculateBmi() {
        double heightInMeters = height / 100.0;
        bmi = weight / (heightInMeters * heightInMeters);
        determineCategory();
    }

    /**
     * Determines the BMI category based on the calculated BMI.
     */
    private void determineCategory() {
        if (bmi < 18.5) category = "Underweight";
        else if (bmi < 25) category = "Normal";
        else if (bmi < 30) category = "Overweight";
        else category = "Obese";
    }

    /**
     * Displays user's BMI information.
     */
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + birthYear);
        System.out.println("Height: " + height + "cm");
        System.out.println("Weight: " + weight + "kg");
        System.out.println("BMI: " + bmi);
        System.out.println("Category: " + category);
    }

    /**
     * Calculates user's age.
     *
     * @param currentYear current year
     * @return user's age
     */
    public int calculateAge(int currentYear) {
        return currentYear - birthYear;
    }

    /**
     * Retrieves the BMI category.
     *
     * @return BMI category
     */
    public String getCategory() {
        return category;
    }
}
