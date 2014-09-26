package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RecipesFurnace {

   private static final RecipesFurnace a = new RecipesFurnace();
   private Map recipes = Maps.newHashMap();
   private Map c = Maps.newHashMap();


   public static RecipesFurnace getInstance() {
      return a;
   }

   private RecipesFurnace() {
      this.registerRecipe(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7F);
      this.registerRecipe(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0F);
      this.registerRecipe(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0F);
      this.registerRecipe((Block)Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1F);
      this.a(Items.al, new ItemStack(Items.am), 0.35F);
      this.a(Items.bi, new ItemStack(Items.bj), 0.35F);
      this.a(Items.bk, new ItemStack(Items.bl), 0.35F);
      this.a(Items.bo, new ItemStack(Items.bp), 0.35F);
      this.a(Items.bm, new ItemStack(Items.bn), 0.35F);
      this.registerRecipe(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1F);
      this.a(new ItemStack(Blocks.SMOOTH_BRICK, 1, BlockSmoothBrick.b), new ItemStack(Blocks.SMOOTH_BRICK, 1, BlockSmoothBrick.N), 0.1F);
      this.a(Items.aI, new ItemStack(Items.aH), 0.3F);
      this.registerRecipe(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35F);
      this.registerRecipe((Block)Blocks.CACTUS, new ItemStack(Items.aW, 1, akv.n.b()), 0.2F);
      this.registerRecipe(Blocks.LOG, new ItemStack(Items.COAL, 1, 1), 0.15F);
      this.registerRecipe(Blocks.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15F);
      this.registerRecipe(Blocks.EMERALD_ORE, new ItemStack(Items.bO), 1.0F);
      this.a(Items.bS, new ItemStack(Items.bT), 0.35F);
      this.registerRecipe(Blocks.NETHERRACK, new ItemStack(Items.cf), 0.1F);
      this.a(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15F);
      EnumFish[] var1 = EnumFish.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumFish var4 = var1[var3];
         if(var4.g()) {
            this.a(new ItemStack(Items.aU, 1, var4.a()), new ItemStack(Items.aV, 1, var4.a()), 0.35F);
         }
      }

      this.registerRecipe(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.1F);
      this.registerRecipe(Blocks.REDSTONE_ORE, new ItemStack(Items.aC), 0.7F);
      this.registerRecipe(Blocks.LAPIS_ORE, new ItemStack(Items.aW, 1, akv.l.b()), 0.2F);
      this.registerRecipe(Blocks.QUARTZ_ORE, new ItemStack(Items.cg), 0.2F);
   }

   public void registerRecipe(Block var1, ItemStack var2, float var3) {
      this.a(Item.getItemOf(var1), var2, var3);
   }

   public void a(Item var1, ItemStack var2, float var3) {
      this.a(new ItemStack(var1, 1, 32767), var2, var3);
   }

   public void a(ItemStack var1, ItemStack var2, float var3) {
      this.recipes.put(var1, var2);
      this.c.put(var2, Float.valueOf(var3));
   }

   public ItemStack getResult(ItemStack var1) {
      Iterator var2 = this.recipes.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (ItemStack)var3.getKey()));

      return (ItemStack)var3.getValue();
   }

   private boolean a(ItemStack var1, ItemStack var2) {
      return var2.getItem() == var1.getItem() && (var2.getData() == 32767 || var2.getData() == var1.getData());
   }

   public Map getRecipes() {
      return this.recipes;
   }

   public float b(ItemStack var1) {
      Iterator var2 = this.c.entrySet().iterator();

      Entry var3;
      do {
         if(!var2.hasNext()) {
            return 0.0F;
         }

         var3 = (Entry)var2.next();
      } while(!this.a(var1, (ItemStack)var3.getKey()));

      return ((Float)var3.getValue()).floatValue();
   }

}
