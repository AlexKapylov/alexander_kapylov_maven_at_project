package classwork.day21;

import java.util.List;
import java.util.Objects;

public class Recipe {

    private String recipename;
    private List<Ingredient> ingredlist;
    private int preptime;

    public Recipe(String recipeName, List<Ingredient> ingredList, int preptime) {
        this.recipename = recipeName;
        this.ingredlist = ingredList;
        this.preptime = preptime;
    }

    public String getRecipename() {
        return recipename;
    }

    public List<Ingredient> getIngredlist() {
        return ingredlist;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setRecipename(String recipeName) {
        this.recipename = recipeName;
    }

    public void setIngredlist(List<Ingredient> ingredList) {
        this.ingredlist = ingredList;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return preptime == recipe.preptime && Objects.equals(recipename, recipe.recipename) && Objects.equals(ingredlist, recipe.ingredlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipename, ingredlist, preptime);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeName='" + recipename + '\'' +
                ", ingredList=" + ingredlist +
                ", prepTime=" + preptime +
                '}';
    }
}
