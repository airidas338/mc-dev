package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CraftingManager {

   private static final CraftingManager a = new CraftingManager();
   private final List recipes = Lists.newArrayList();


   public static CraftingManager getInstance() {
      return a;
   }

   private CraftingManager() {
      (new RecipesTools()).a(this);
      (new RecipesWeapons()).a(this);
      (new RecipeIngots()).a(this);
      (new RecipesFood()).a(this);
      (new RecipesCrafting()).a(this);
      (new RecipesArmor()).a(this);
      (new RecipesDyes()).a(this);
      this.recipes.add(new RecipeArmorDye());
      this.recipes.add(new RecipeBookClone());
      this.recipes.add(new RecipeMapClone());
      this.recipes.add(new RecipeMapExtend());
      this.recipes.add(new RecipeFireworks());
      this.recipes.add(new aor());
      (new RecipesBanner()).a(this);
      this.a(new ItemStack(Items.aK, 3), new Object[]{"###", Character.valueOf('#'), Items.aJ});
      this.b(new ItemStack(Items.aL, 1), new Object[]{Items.aK, Items.aK, Items.aK, Items.aF});
      this.b(new ItemStack(Items.BOOK_AND_QUILL, 1), new Object[]{Items.aL, new ItemStack(Items.aW, 1, akv.p.b()), Items.FEATHER});
      this.a(new ItemStack(Blocks.FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.b.a())});
      this.a(new ItemStack(Blocks.JUNGLE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.f.a() - 4)});
      this.a(new ItemStack(Blocks.COBBLE_WALL, 6, bby.a.a()), new Object[]{"###", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.COBBLE_WALL, 6, bby.b.a()), new Object[]{"###", "###", Character.valueOf('#'), Blocks.MOSSY_COBBLESTONE});
      this.a(new ItemStack(Blocks.NETHER_FENCE, 6), new Object[]{"###", "###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.b.a())});
      this.a(new ItemStack(Blocks.JUNGLE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, ayx.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.f.a() - 4)});
      this.a(new ItemStack(Blocks.JUKEBOX, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.WOOD, Character.valueOf('X'), Items.DIAMOND});
      this.a(new ItemStack(Items.cn, 2), new Object[]{"~~ ", "~O ", "  ~", Character.valueOf('~'), Items.STRING, Character.valueOf('O'), Items.aM});
      this.a(new ItemStack(Blocks.NOTE_BLOCK, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.WOOD, Character.valueOf('X'), Items.aC});
      this.a(new ItemStack(Blocks.BOOKSHELF, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Blocks.WOOD, Character.valueOf('X'), Items.aL});
      this.a(new ItemStack(Blocks.SNOW_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aD});
      this.a(new ItemStack(Blocks.SNOW, 6), new Object[]{"###", Character.valueOf('#'), Blocks.SNOW_BLOCK});
      this.a(new ItemStack(Blocks.CLAY, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aI});
      this.a(new ItemStack(Blocks.BRICK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aH});
      this.a(new ItemStack(Blocks.GLOWSTONE, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aT});
      this.a(new ItemStack(Blocks.QUARTZ_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.cg});
      this.a(new ItemStack(Blocks.WOOL, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.STRING});
      this.a(new ItemStack(Blocks.TNT, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Items.SULPHUR, Character.valueOf('#'), Blocks.SAND});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.d.a()), new Object[]{"###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.a.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.STONE, bbb.a.a())});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.b.a()), new Object[]{"###", Character.valueOf('#'), Blocks.SANDSTONE});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.e.a()), new Object[]{"###", Character.valueOf('#'), Blocks.BRICK});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.f.a()), new Object[]{"###", Character.valueOf('#'), Blocks.SMOOTH_BRICK});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.g.a()), new Object[]{"###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.STEP1, 6, bbg.h.a()), new Object[]{"###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK});
      this.a(new ItemStack(Blocks.STEP2, 6, aym.a.a()), new Object[]{"###", Character.valueOf('#'), Blocks.RED_SANDSTONE});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.a.a())});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, ayx.c.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.c.a())});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, ayx.b.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.b.a())});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, ayx.d.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.d.a())});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, 4 + ayx.e.a() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.e.a() - 4)});
      this.a(new ItemStack(Blocks.WOOD_STEP, 6, 4 + ayx.f.a() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.f.a() - 4)});
      this.a(new ItemStack(Blocks.LADDER, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Items.aq, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.a.a())});
      this.a(new ItemStack(Items.ar, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.b.a())});
      this.a(new ItemStack(Items.as, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.c.a())});
      this.a(new ItemStack(Items.at, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.d.a())});
      this.a(new ItemStack(Items.au, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.e.a())});
      this.a(new ItemStack(Items.av, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.f.a())});
      this.a(new ItemStack(Blocks.TRAP_DOOR_WOOD, 2), new Object[]{"###", "###", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Items.aB, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Blocks.TRAP_DOOR_IRON, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.ap, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), Blocks.WOOD, Character.valueOf('X'), Items.STICK});
      this.a(new ItemStack(Items.aZ, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Items.aG, Character.valueOf('B'), Items.aY, Character.valueOf('C'), Items.WHEAT, Character.valueOf('E'), Items.aP});
      this.a(new ItemStack(Items.aY, 1), new Object[]{"#", Character.valueOf('#'), Items.aJ});
      this.a(new ItemStack(Blocks.WOOD, 4, ayx.a.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, ayx.a.a())});
      this.a(new ItemStack(Blocks.WOOD, 4, ayx.b.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, ayx.b.a())});
      this.a(new ItemStack(Blocks.WOOD, 4, ayx.c.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, ayx.c.a())});
      this.a(new ItemStack(Blocks.WOOD, 4, ayx.d.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, ayx.d.a())});
      this.a(new ItemStack(Blocks.WOOD, 4, 4 + ayx.e.a() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, ayx.e.a() - 4)});
      this.a(new ItemStack(Blocks.WOOD, 4, 4 + ayx.f.a() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, ayx.f.a() - 4)});
      this.a(new ItemStack(Items.STICK, 4), new Object[]{"#", "#", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Blocks.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), Items.COAL, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Blocks.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Items.COAL, 1, 1), Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Items.BOWL, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Items.bA, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.GLASS});
      this.a(new ItemStack(Blocks.RAILS, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Blocks.GOLDEN_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.GOLD_INGOT, Character.valueOf('R'), Items.aC, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Blocks.ACTIVATOR_RAIL, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Blocks.REDSTONE_TORCH_ON, Character.valueOf('S'), Items.STICK});
      this.a(new ItemStack(Blocks.DETECTOR_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.aC, Character.valueOf('#'), Blocks.STONE_PLATE});
      this.a(new ItemStack(Items.az, 1), new Object[]{"# #", "###", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bG, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bF, 1), new Object[]{" B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.bv});
      this.a(new ItemStack(Blocks.JACK_O_LANTERN, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.PUMPKIN, Character.valueOf('B'), Blocks.TORCH});
      this.a(new ItemStack(Items.aN, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.CHEST, Character.valueOf('B'), Items.az});
      this.a(new ItemStack(Items.aO, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.FURNACE, Character.valueOf('B'), Items.az});
      this.a(new ItemStack(Items.ch, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.TNT, Character.valueOf('B'), Items.az});
      this.a(new ItemStack(Items.ci, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.HOPPER, Character.valueOf('B'), Items.az});
      this.a(new ItemStack(Items.aE, 1), new Object[]{"# #", "###", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Items.BUCKET, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bQ, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.aH});
      this.b(new ItemStack(Items.FLINT_AND_STEEL, 1), new Object[]{new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.ak, 1)});
      this.a(new ItemStack(Items.BREAD, 1), new Object[]{"###", Character.valueOf('#'), Items.WHEAT});
      this.a(new ItemStack(Blocks.WOOD_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_WOOD_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_WOOD_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.b.a())});
      this.a(new ItemStack(Blocks.JUNGLE_WOOD_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, ayx.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.WOOD, 1, 4 + ayx.f.a() - 4)});
      this.a(new ItemStack(Items.aR, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.STRING});
      this.a(new ItemStack(Items.bY, 1), new Object[]{"# ", " X", Character.valueOf('#'), Items.aR, Character.valueOf('X'), Items.bR}).c();
      this.a(new ItemStack(Blocks.COBBLESTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.BRICK});
      this.a(new ItemStack(Blocks.STONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.SMOOTH_BRICK});
      this.a(new ItemStack(Blocks.NETHER_BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE});
      this.a(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.RED_SANDSTONE});
      this.a(new ItemStack(Blocks.QUARTZ_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK});
      this.a(new ItemStack(Items.an, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Blocks.WOOL});
      this.a(new ItemStack(Items.bP, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.aF});
      this.a(new ItemStack(Items.ao, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.APPLE});
      this.a(new ItemStack(Items.ao, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.GOLD_BLOCK, Character.valueOf('X'), Items.APPLE});
      this.a(new ItemStack(Items.bW, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bx, Character.valueOf('X'), Items.bR});
      this.a(new ItemStack(Items.bI, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bx, Character.valueOf('X'), Items.bf});
      this.a(new ItemStack(Blocks.LEVER, 1), new Object[]{"X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.STICK});
      this.a(new ItemStack(Blocks.TRIPWIRE_HOOK, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), Blocks.WOOD, Character.valueOf('S'), Items.STICK, Character.valueOf('I'), Items.IRON_INGOT});
      this.a(new ItemStack(Blocks.REDSTONE_TORCH_ON, 1), new Object[]{"X", "#", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.aC});
      this.a(new ItemStack(Items.bb, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH_ON, Character.valueOf('X'), Items.aC, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, bbb.a.a())});
      this.a(new ItemStack(Items.ce, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH_ON, Character.valueOf('X'), Items.cg, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, bbb.a.a())});
      this.a(new ItemStack(Items.aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.aC});
      this.a(new ItemStack(Items.aQ, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.IRON_INGOT, Character.valueOf('X'), Items.aC});
      this.a(new ItemStack(Items.bV, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.aK, Character.valueOf('X'), Items.aQ});
      this.a(new ItemStack(Blocks.STONE_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, bbb.a.a())});
      this.a(new ItemStack(Blocks.WOOD_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Blocks.STONE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, bbb.a.a())});
      this.a(new ItemStack(Blocks.WOOD_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Blocks.WOOD});
      this.a(new ItemStack(Blocks.IRON_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Blocks.GOLD_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.GOLD_INGOT});
      this.a(new ItemStack(Blocks.DISPENSER, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.BOW, Character.valueOf('R'), Items.aC});
      this.a(new ItemStack(Blocks.DROPPER, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.aC});
      this.a(new ItemStack(Blocks.PISTON, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.aC, Character.valueOf('T'), Blocks.WOOD});
      this.a(new ItemStack(Blocks.PISTON_STICKEY, 1), new Object[]{"S", "P", Character.valueOf('S'), Items.aM, Character.valueOf('P'), Blocks.PISTON});
      this.a(new ItemStack(Items.ba, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Blocks.WOOL, Character.valueOf('X'), Blocks.WOOD});
      this.a(new ItemStack(Blocks.ENCHANTMENT_TABLE, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('B'), Items.aL, Character.valueOf('D'), Items.DIAMOND});
      this.a(new ItemStack(Blocks.ANVIL, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), Blocks.IRON_BLOCK, Character.valueOf('i'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.aF), new Object[]{"##", "##", Character.valueOf('#'), Items.bs});
      this.b(new ItemStack(Items.bH, 1), new Object[]{Items.bu, Items.bD});
      this.b(new ItemStack(Items.bL, 3), new Object[]{Items.SULPHUR, Items.bD, Items.COAL});
      this.b(new ItemStack(Items.bL, 3), new Object[]{Items.SULPHUR, Items.bD, new ItemStack(Items.COAL, 1, 1)});
      this.a(new ItemStack(Blocks.DAYLIGHT_DETECTOR), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.cg, Character.valueOf('W'), Blocks.WOOD_STEP});
      this.a(new ItemStack(Blocks.HOPPER), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), Items.IRON_INGOT, Character.valueOf('C'), Blocks.CHEST});
      this.a(new ItemStack(Items.cj, 1), new Object[]{"///", " / ", "/_/", Character.valueOf('/'), Items.STICK, Character.valueOf('_'), new ItemStack(Blocks.STEP1, 1, bbg.a.a())});
      Collections.sort(this.recipes, new aoq(this));
   }

   public ShapedRecipes a(ItemStack var1, Object ... var2) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(var2[var4] instanceof String[]) {
         String[] var7 = (String[])((String[])var2[var4++]);

         for(int var8 = 0; var8 < var7.length; ++var8) {
            String var9 = var7[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(var2[var4] instanceof String) {
            String var11 = (String)var2[var4++];
            ++var6;
            var5 = var11.length();
            var3 = var3 + var11;
         }
      }

      HashMap var12;
      for(var12 = Maps.newHashMap(); var4 < var2.length; var4 += 2) {
         Character var13 = (Character)var2[var4];
         ItemStack var14 = null;
         if(var2[var4 + 1] instanceof Item) {
            var14 = new ItemStack((Item)var2[var4 + 1]);
         } else if(var2[var4 + 1] instanceof Block) {
            var14 = new ItemStack((Block)var2[var4 + 1], 1, 32767);
         } else if(var2[var4 + 1] instanceof ItemStack) {
            var14 = (ItemStack)var2[var4 + 1];
         }

         var12.put(var13, var14);
      }

      ItemStack[] var15 = new ItemStack[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).cloneItemStack();
         } else {
            var15[var16] = null;
         }
      }

      ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, var1);
      this.recipes.add(var17);
      return var17;
   }

   public void b(ItemStack var1, Object ... var2) {
      ArrayList var3 = Lists.newArrayList();
      Object[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).cloneItemStack());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.recipes.add(new aot(var1, var3));
   }

   public void a(IRecipe var1) {
      this.recipes.add(var1);
   }

   public ItemStack a(ain var1, World var2) {
      Iterator var3 = this.recipes.iterator();

      IRecipe var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (IRecipe)var3.next();
      } while(!var4.a(var1, var2));

      return var4.a(var1);
   }

   public ItemStack[] b(ain var1, World var2) {
      Iterator var3 = this.recipes.iterator();

      while(var3.hasNext()) {
         IRecipe var4 = (IRecipe)var3.next();
         if(var4.a(var1, var2)) {
            return var4.b(var1);
         }
      }

      ItemStack[] var5 = new ItemStack[var1.n_()];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = var1.a(var6);
      }

      return var5;
   }

   public List getRecipies() {
      return this.recipes;
   }

}
