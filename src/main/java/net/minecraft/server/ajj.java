package net.minecraft.server;

public class ajj extends ajk {

   private final ain a;
   private final EntityHuman b;
   private int c;


   public ajj(EntityHuman var1, ain var2, IInventory var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.b = var1;
      this.a = var2;
   }

   public boolean a(ItemStack var1) {
      return false;
   }

   public ItemStack a(int var1) {
      if(this.e()) {
         this.c += Math.min(var1, this.d().count);
      }

      return super.a(var1);
   }

   protected void a(ItemStack var1, int var2) {
      this.c += var2;
      this.c(var1);
   }

   protected void c(ItemStack var1) {
      if(this.c > 0) {
         var1.a(this.b.o, this.b, this.c);
      }

      this.c = 0;
      if(var1.getItem() == Item.getItemOf(Blocks.CRAFTING_TABLE)) {
         this.b.b((Statistic)AchievementList.h);
      }

      if(var1.getItem() instanceof ItemPickaxe) {
         this.b.b((Statistic)AchievementList.i);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.FURNACE)) {
         this.b.b((Statistic)AchievementList.j);
      }

      if(var1.getItem() instanceof ItemHoe) {
         this.b.b((Statistic)AchievementList.l);
      }

      if(var1.getItem() == Items.BREAD) {
         this.b.b((Statistic)AchievementList.m);
      }

      if(var1.getItem() == Items.aZ) {
         this.b.b((Statistic)AchievementList.n);
      }

      if(var1.getItem() instanceof ItemPickaxe && ((ItemPickaxe)var1.getItem()).g() != EnumToolMaterial.WOOD) {
         this.b.b((Statistic)AchievementList.o);
      }

      if(var1.getItem() instanceof ItemSword) {
         this.b.b((Statistic)AchievementList.r);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.ENCHANTMENT_TABLE)) {
         this.b.b((Statistic)AchievementList.E);
      }

      if(var1.getItem() == Item.getItemOf(Blocks.BOOKSHELF)) {
         this.b.b((Statistic)AchievementList.G);
      }

      if(var1.getItem() == Items.ao && var1.getData() == 1) {
         this.b.b((Statistic)AchievementList.M);
      }

   }

   public void a(EntityHuman var1, ItemStack var2) {
      this.c(var2);
      ItemStack[] var3 = CraftingManager.getInstance().b(this.a, var1.o);

      for(int var4 = 0; var4 < var3.length; ++var4) {
         ItemStack var5 = this.a.a(var4);
         ItemStack var6 = var3[var4];
         if(var5 != null) {
            this.a.a(var4, 1);
         }

         if(var6 != null) {
            if(this.a.a(var4) == null) {
               this.a.a(var4, var6);
            } else if(!this.b.bg.a(var6)) {
               this.b.a(var6, false);
            }
         }
      }

   }
}
