package patterns.decontainer;


import patterns.decontainer.di.Config;

@Config
public class Cat {
    private String catName;

    public Cat() {
        System.out.println("cat init");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
