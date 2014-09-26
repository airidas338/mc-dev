package net.minecraft.server;

public class RecipesCrafting {

   public void a(CraftingManager var1) {
      var1.a(new ItemStack(Blocks.CHEST), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.WOOD});
      var1.a(new ItemStack(Blocks.TRAPPED_CHEST), new Object[]{"#-", Character.valueOf('#'), Blocks.CHEST, Character.valueOf('-'), Blocks.TRIPWIRE_HOOK});
      var1.a(new ItemStack(Blocks.ENDER_CHEST), new Object[]{"###", "#E#", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('E'), Items.bH});
      var1.a(new ItemStack(Blocks.FURNACE), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      var1.a(new ItemStack(Blocks.CRAFTING_TABLE), new Object[]{"##", "##", Character.valueOf('#'), Blocks.WOOD});
      var1.a(new ItemStack(Blocks.SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, bac.a.a())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, bac.b.a())});
      var1.a(new ItemStack(Blocks.SANDSTONE, 4, bae.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SANDSTONE, 1, bae.a.a())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE, 4, azr.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.RED_SANDSTONE, 1, azr.a.a())});
      var1.a(new ItemStack(Blocks.SANDSTONE, 1, bae.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STEP1, 1, bbg.b.a())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE, 1, azr.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STEP2, 1, aym.a.a())});
      var1.a(new ItemStack(Blocks.QUARTZ_BLOCK, 1, azn.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STEP1, 1, bbg.h.a())});
      var1.a(new ItemStack(Blocks.QUARTZ_BLOCK, 2, azn.c.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.QUARTZ_BLOCK, 1, azn.a.a())});
      var1.a(new ItemStack(Blocks.SMOOTH_BRICK, 4), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, bbb.a.a())});
      var1.a(new ItemStack(Blocks.SMOOTH_BRICK, 1, BlockSmoothBrick.O), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STEP1, 1, bbg.f.a())});
      var1.b(new ItemStack(Blocks.SMOOTH_BRICK, 1, BlockSmoothBrick.M), new Object[]{Blocks.SMOOTH_BRICK, Blocks.VINE});
      var1.b(new ItemStack(Blocks.MOSSY_COBBLESTONE, 1), new Object[]{Blocks.COBBLESTONE, Blocks.VINE});
      var1.a(new ItemStack(Blocks.IRON_FENCE, 16), new Object[]{"###", "###", Character.valueOf('#'), Items.IRON_INGOT});
      var1.a(new ItemStack(Blocks.THIN_GLASS, 16), new Object[]{"###", "###", Character.valueOf('#'), Blocks.GLASS});
      var1.a(new ItemStack(Blocks.REDSTONE_LAMP_OFF, 1), new Object[]{" R ", "RGR", " R ", Character.valueOf('R'), Items.aC, Character.valueOf('G'), Blocks.GLOWSTONE});
      var1.a(new ItemStack(Blocks.BEACON, 1), new Object[]{"GGG", "GSG", "OOO", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('S'), Items.bZ, Character.valueOf('O'), Blocks.OBSIDIAN});
      var1.a(new ItemStack(Blocks.NETHER_BRICK, 1), new Object[]{"NN", "NN", Character.valueOf('N'), Items.cf});
      var1.a(new ItemStack(Blocks.STONE, 2, bbb.d.a()), new Object[]{"CQ", "QC", Character.valueOf('C'), Blocks.COBBLESTONE, Character.valueOf('Q'), Items.cg});
      var1.b(new ItemStack(Blocks.STONE, 1, bbb.b.a()), new Object[]{new ItemStack(Blocks.STONE, 1, bbb.d.a()), Items.cg});
      var1.b(new ItemStack(Blocks.STONE, 2, bbb.f.a()), new Object[]{new ItemStack(Blocks.STONE, 1, bbb.d.a()), Blocks.COBBLESTONE});
      var1.a(new ItemStack(Blocks.DIRT, 4, avd.b.a()), new Object[]{"DG", "GD", Character.valueOf('D'), new ItemStack(Blocks.DIRT, 1, avd.a.a()), Character.valueOf('G'), Blocks.GRAVEL});
      var1.a(new ItemStack(Blocks.STONE, 4, bbb.e.a()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, bbb.d.a())});
      var1.a(new ItemStack(Blocks.STONE, 4, bbb.c.a()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, bbb.b.a())});
      var1.a(new ItemStack(Blocks.STONE, 4, bbb.g.a()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, bbb.f.a())});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.b), new Object[]{"SS", "SS", Character.valueOf('S'), Items.cC});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.M), new Object[]{"SSS", "SSS", "SSS", Character.valueOf('S'), Items.cC});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.N), new Object[]{"SSS", "SIS", "SSS", Character.valueOf('S'), Items.cC, Character.valueOf('I'), new ItemStack(Items.aW, 1, akv.p.b())});
      var1.a(new ItemStack(Blocks.SEA_LANTERN, 1, 0), new Object[]{"SCS", "CCC", "SCS", Character.valueOf('S'), Items.cC, Character.valueOf('C'), Items.cD});
   }
}
