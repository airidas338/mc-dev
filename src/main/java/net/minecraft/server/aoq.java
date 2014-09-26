package net.minecraft.server;
import java.util.Comparator;

class aoq implements Comparator {

   // $FF: synthetic field
   final CraftingManager a;


   aoq(CraftingManager var1) {
      this.a = var1;
   }

   public int a(IRecipe var1, IRecipe var2) {
      return var1 instanceof aot && var2 instanceof ShapedRecipes?1:(var2 instanceof aot && var1 instanceof ShapedRecipes?-1:(var2.a() < var1.a()?-1:(var2.a() > var1.a()?1:0)));
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.a((IRecipe)var1, (IRecipe)var2);
   }
}
