package net.minecraft.server;


public class ItemArmor extends Item {

   private static final int[] k = new int[]{11, 16, 15, 13};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots"};
   private static final IDispenseBehavior l = new ajo();
   public final int b;
   public final int c;
   public final int d;
   private final EnumArmorMaterial m;


   public ItemArmor(EnumArmorMaterial var1, int var2, int var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.d(var1.a(var3));
      this.maxStackSize = 1;
      this.a(CreativeModeTab.j);
      BlockDispenser.M.a(this, l);
   }

   public int b() {
      return this.m.a();
   }

   public EnumArmorMaterial w_() {
      return this.m;
   }

   public boolean d_(ItemStack var1) {
      return this.m != EnumArmorMaterial.CLOTH?false:(!var1.hasTag()?false:(!var1.getTag().hasKeyOfType("display", 10)?false:var1.getTag().getCompound("display").hasKeyOfType("color", 3)));
   }

   public int b(ItemStack var1) {
      if(this.m != EnumArmorMaterial.CLOTH) {
         return -1;
      } else {
         NBTTagCompound var2 = var1.getTag();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3 != null && var3.hasKeyOfType("color", 3)) {
               return var3.getInt("color");
            }
         }

         return 10511680;
      }
   }

   public void c(ItemStack var1) {
      if(this.m == EnumArmorMaterial.CLOTH) {
         NBTTagCompound var2 = var1.getTag();
         if(var2 != null) {
            NBTTagCompound var3 = var2.getCompound("display");
            if(var3.hasKey("color")) {
               var3.remove("color");
            }

         }
      }
   }

   public void b(ItemStack var1, int var2) {
      if(this.m != EnumArmorMaterial.CLOTH) {
         throw new UnsupportedOperationException("Can\'t dye non-leather!");
      } else {
         NBTTagCompound var3 = var1.getTag();
         if(var3 == null) {
            var3 = new NBTTagCompound();
            var1.setTag(var3);
         }

         NBTTagCompound var4 = var3.getCompound("display");
         if(!var3.hasKeyOfType("display", 10)) {
            var3.set("display", (NBTBase)var4);
         }

         var4.setInt("color", var2);
      }
   }

   public boolean a(ItemStack var1, ItemStack var2) {
      return this.m.b() == var2.getItem()?true:super.a(var1, var2);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      int var4 = EntityInsentient.c(var1) - 1;
      ItemStack var5 = var3.q(var4);
      if(var5 == null) {
         var3.c(var4, var1.cloneItemStack());
         var1.count = 0;
      }

      return var1;
   }

   // $FF: synthetic method
   static int[] d() {
      return k;
   }

}
