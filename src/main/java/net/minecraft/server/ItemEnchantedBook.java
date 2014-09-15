package net.minecraft.server;
import java.util.Random;

public class ItemEnchantedBook extends Item {

   public boolean f_(ItemStack var1) {
      return false;
   }

   public amx g(ItemStack var1) {
      return this.h(var1).size() > 0?amx.b:super.g(var1);
   }

   public NBTTagList h(ItemStack var1) {
      NBTTagCompound var2 = var1.o();
      return var2 != null && var2.hasKeyOfType("StoredEnchantments", 9)?(NBTTagList)var2.get("StoredEnchantments"):new NBTTagList();
   }

   public void a(ItemStack var1, apo var2) {
      NBTTagList var3 = this.h(var1);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.size(); ++var5) {
         NBTTagCompound var6 = var3.get(var5);
         if(var6.getShort("id") == var2.b.B) {
            if(var6.getShort("lvl") < var2.c) {
               var6.setShort("lvl", (short)var2.c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         NBTTagCompound var7 = new NBTTagCompound();
         var7.setShort("id", (short)var2.b.B);
         var7.setShort("lvl", (short)var2.c);
         var3.add((NBTBase)var7);
      }

      if(!var1.n()) {
         var1.d(new NBTTagCompound());
      }

      var1.o().set("StoredEnchantments", (NBTBase)var3);
   }

   public ItemStack a(apo var1) {
      ItemStack var2 = new ItemStack(this);
      this.a(var2, var1);
      return var2;
   }

   public StructurePieceTreaasure b(Random var1) {
      return this.a(var1, 1, 1, 1);
   }

   public StructurePieceTreaasure a(Random var1, int var2, int var3, int var4) {
      ItemStack var5 = new ItemStack(Items.aL, 1, 0);
      EnchantmentManager.a(var1, var5, 30);
      return new StructurePieceTreaasure(var5, var2, var3, var4);
   }
}
