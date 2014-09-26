package net.minecraft.server;

public class RecipesTools {

   private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] b;


   public RecipesTools() {
      this.b = new Object[][]{{Blocks.WOOD, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.WOOD_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLD_PICKAXE}, {Items.WOOD_SPADE, Items.STONE_SPADE, Items.IRON_SPADE, Items.DIAMOND_SPADE, Items.GOLD_SPADE}, {Items.WOOD_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.GOLD_AXE}, {Items.WOOD_HOE, Items.STONE_HOE, Items.IRON_HOE, Items.DIAMOND_HOE, Items.GOLD_HOE}};
   }

   public void a(CraftingManager var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), var3});
         }
      }

      var1.a(new ItemStack(Items.be), new Object[]{" #", "# ", Character.valueOf('#'), Items.IRON_INGOT});
   }
}
