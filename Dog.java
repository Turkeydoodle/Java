package Java;

public class Dog {
    private int age;
    private String name;
    private String breed;

    public Dog(int dogage, String dogname, String dogbreed) {
        age = dogage;
        name = dogname;
        breed = dogbreed;
    }

    public int getage() {
        return age;
    }

    public String getname() {
        return name;
    }

    public String getbreed() {
        return breed;
    }

    public static void main(String[] arg) {
        Dog dog1 = new Dog(67, "Connor", "Retriever");
        int ageofdog = dog1.getage();
        String nameofdog = dog1.getname();
        String breedofdog = dog1.getbreed();
        System.out.println(ageofdog);
        System.out.println(nameofdog);
        System.out.println(breedofdog);
    }
}
