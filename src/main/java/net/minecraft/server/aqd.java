package net.minecraft.server;
import java.io.IOException;
import java.util.ArrayList;

public class aqd extends ArrayList {

   public aqd() {}

   public aqd(NBTTagCompound var1) {
      this.a(var1);
   }

   public aqc a(ItemStack var1, ItemStack var2, int var3) {
      if(var3 > 0 && var3 < this.size()) {
         aqc var6 = (aqc)this.get(var3);
         return ItemStack.doMaterialsMatch(var1, var6.a()) && (var2 == null && !var6.c() || var6.c() && ItemStack.doMaterialsMatch(var2, var6.b())) && var1.count >= var6.a().count && (!var6.c() || var2.count >= var6.b().count)?var6:null;
      } else {
         for(int var4 = 0; var4 < this.size(); ++var4) {
            aqc var5 = (aqc)this.get(var4);
            if(ItemStack.doMaterialsMatch(var1, var5.a()) && var1.count >= var5.a().count && (!var5.c() && var2 == null || var5.c() && ItemStack.doMaterialsMatch(var2, var5.b()) && var2.count >= var5.b().count)) {
               return var5;
            }
         }

         return null;
      }
   }

   public void a(PacketDataSerializer var1) throws IOException {
      var1.writeByte((byte)(this.size() & 255));

      for(int var2 = 0; var2 < this.size(); ++var2) {
         aqc var3 = (aqc)this.get(var2);
         var1.a(var3.a());
         var1.a(var3.d());
         ItemStack var4 = var3.b();
         var1.writeBoolean(var4 != null);
         if(var4 != null) {
            var1.a(var4);
         }

         var1.writeBoolean(var3.h());
         var1.writeInt(var3.e());
         var1.writeInt(var3.f());
      }

   }

   public void a(NBTTagCompound var1) {
      NBTTagList var2 = var1.getList("Recipes", 10);

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         NBTTagCompound var4 = var2.get(var3);
         this.add(new aqc(var4));
      }

   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.size(); ++var3) {
         aqc var4 = (aqc)this.get(var3);
         var2.add((NBTBase)var4.k());
      }

      var1.set("Recipes", (NBTBase)var2);
      return var1;
   }
}
