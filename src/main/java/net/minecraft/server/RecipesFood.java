package net.minecraft.server;

public class RecipesFood {

   public void a(CraftingManager var1) {
      var1.b(new ItemStack(Items.MUSHROOM_SOUP), new Object[]{Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Items.BOWL});
      var1.a(new ItemStack(Items.bc, 8), new Object[]{"#X#", Character.valueOf('X'), new ItemStack(Items.aW, 1, akv.m.b()), Character.valueOf('#'), Items.WHEAT});
      var1.a(new ItemStack(Items.bq), new Object[]{" R ", "CPM", " B ", Character.valueOf('R'), new ItemStack(Items.bp), Character.valueOf('C'), Items.bR, Character.valueOf('P'), Items.bT, Character.valueOf('M'), Blocks.BROWN_MUSHROOM, Character.valueOf('B'), Items.BOWL});
      var1.a(new ItemStack(Items.bq), new Object[]{" R ", "CPD", " B ", Character.valueOf('R'), new ItemStack(Items.bp), Character.valueOf('C'), Items.bR, Character.valueOf('P'), Items.bT, Character.valueOf('D'), Blocks.RED_MUSHROOM, Character.valueOf('B'), Items.BOWL});
      var1.a(new ItemStack(Blocks.MELON), new Object[]{"MMM", "MMM", "MMM", Character.valueOf('M'), Items.bf});
      var1.a(new ItemStack(Items.bh), new Object[]{"M", Character.valueOf('M'), Items.bf});
      var1.a(new ItemStack(Items.bg, 4), new Object[]{"M", Character.valueOf('M'), Blocks.PUMPKIN});
      var1.b(new ItemStack(Items.ca), new Object[]{Blocks.PUMPKIN, Items.aY, Items.aP});
      var1.b(new ItemStack(Items.bC), new Object[]{Items.bB, Blocks.BROWN_MUSHROOM, Items.aY});
      var1.b(new ItemStack(Items.bD, 2), new Object[]{Items.bv});
      var1.b(new ItemStack(Items.bE), new Object[]{Items.bD, Items.aM});
   }
}
