package net.minecraft.server;

public class anr extends Item {

   public anr() {
      this.c(1);
   }

   public static boolean b(NBTTagCompound var0) {
      if(!anq.b(var0)) {
         return false;
      } else if(!var0.hasKeyOfType("title", 8)) {
         return false;
      } else {
         String var1 = var0.getString("title");
         return var1 != null && var1.length() <= 32?var0.hasKeyOfType("author", 8):false;
      }
   }

   public static int h(ItemStack var0) {
      return var0.o().getInt("generation");
   }

   public String a(ItemStack var1) {
      if(var1.n()) {
         NBTTagCompound var2 = var1.o();
         String var3 = var2.getString("title");
         if(!vb.b(var3)) {
            return var3;
         }
      }

      return super.a(var1);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var2.D) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(ty.J[Item.b((Item)this)]);
      return var1;
   }

   private void a(ItemStack var1, EntityHuman var2) {
      if(var1 != null && var1.o() != null) {
         NBTTagCompound var3 = var1.o();
         if(!var3.getBoolean("resolved")) {
            var3.setBoolean("resolved", true);
            if(b(var3)) {
               NBTTagList var4 = var3.getList("pages", 8);

               for(int var5 = 0; var5 < var4.c(); ++var5) {
                  String var6 = var4.f(var5);

                  Object var7;
                  try {
                     IChatBaseComponent var11 = hp.a(var6);
                     var7 = hq.a(var2, var11, var2);
                  } catch (Exception var9) {
                     var7 = new ChatComponentText(var6);
                  }

                  var4.a(var5, new NBTTagString(hp.a((IChatBaseComponent)var7)));
               }

               var3.set("pages", (NBTBase)var4);
               if(var2 instanceof EntityPlayer && var2.bY() == var1) {
                  ajk var10 = var2.bi.a((IInventory)var2.bg, var2.bg.c);
                  ((EntityPlayer)var2).a.sendPacket((Packet)(new jh(0, var10.e, var1)));
               }

            }
         }
      }
   }
}
