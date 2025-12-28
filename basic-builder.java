// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
  public static void main(String[] args) {
    BurgerClass burger = new BurgerClass.BuilderClass("Wheat", "chicken").build();
    burger.printBurgers();

    BurgerClass extraLargeBurger = new BurgerClass.BuilderClass("Wheat", "chicken").burgerWithExtraCheese(true).build();
    extraLargeBurger.printBurgers();
  }
}


class BurgerClass {
  public String bunType;
  public String patty;

  public Boolean hasExtraCheese;

  private BurgerClass(BuilderClass builder) {
    this.bunType = builder.bunType;
    this.patty = builder.patty;
    this.hasExtraCheese = builder.hasExtraCheese;
  }

  public void printBurgers() {
    System.out.println(this.bunType+ " " + this.patty + " " + this.hasExtraCheese + " " + "Burger");
  }


  public static class BuilderClass {
    private String bunType;
    private String patty;

    private Boolean hasExtraCheese;

    BuilderClass(String bunType, String patty) {
      this.bunType = bunType;
      this.patty = patty;
    }

    public BuilderClass burgerWithExtraCheese(Boolean hasExtraCheese) {
      this.hasExtraCheese = hasExtraCheese;
      return this;
    }

    public BurgerClass build() {
      return new BurgerClass(this);
    }
  }
}
