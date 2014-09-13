package net.minecraft.server;


public class ItemArmor extends Item {

   private static final int[] k = new int[]{11, 16, 15, 13};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots"};
   private static final IDispenseBehavior l = new ajo();
   public final int b;
   public final int c;
   public final int d;
   private final ajp m;


   public ItemArmor(ajp var1, int var2, int var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.d(var1.a(var3));
      this.h = 1;
      this.a(CreativeModeTab.j);
      BlockDispenser.M.a(this, l);
   }

   public int b() {
      return this.m.a();
   }

   public ajp w_() {
      return this.m;
   }

   public boolean d_(ItemStack var1) {
      return this.m != ajp.a?false:(!var1.n()?false:(!var1.o().b("display", 10)?false:var1.o().getCompound("display").b("color", 3)));
   }

   public int b(ItemStack var1) {
      if(this.m != ajp.a) {
         return -1;
      } else {
         NBTTagCompound var2 = var1.o();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3 != null && var3.b("color", 3)) {
               return var3.getInt("color");
            }
         }

         return 10511680;
      }
   }

   public void c(ItemStack var1) {
      if(this.m == ajp.a) {
         NBTTagCompound var2 = var1.o();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3.c("color")) {
               var3.o("color");
            }

         }
      }
   }

   public void b(ItemStack var1, int var2) {
      if(this.m != ajp.a) {
         throw new UnsupportedOperationException("Can\'t dye non-leather!");
      } else {
         NBTTagCompound var3 = var1.o();
         if(var3 == null) {
            var3 = new NBTTagCompound();
            var1.d(var3);
         }

         NBTTagCompound var4 = var3.getCompound("display");
         if(!var3.b("display", 10)) {
            var3.set("display", (NBTBase)var4);
         }

         var4.setInt("color", var2);
      }
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return this.m.b() == var2.b()?true:super.a(var1, var2);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      int var4 = EntityInsentient.c(var1) - 1;
      ItemStack var5 = var3.q(var4);
      if(var5 == null) {
         var3.c(var4, var1.k());
         var1.b = 0;
      }

      return var1;
   }

   // $FF: synthetic method
   static int[] d() {
      return k;
   }

}
