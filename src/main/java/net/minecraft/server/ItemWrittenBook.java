package net.minecraft.server;

public class ItemWrittenBook extends Item {

   public ItemWrittenBook() {
      this.c(1);
   }

   public static boolean b(NBTTagCompound var0) {
      if(!ItemBookAndQuill.b(var0)) {
         return false;
      } else if(!var0.hasKeyOfType("title", 8)) {
         return false;
      } else {
         String var1 = var0.getString("title");
         return var1 != null && var1.length() <= 32?var0.hasKeyOfType("author", 8):false;
      }
   }

   public static int h(ItemStack var0) {
      return var0.getTag().getInt("generation");
   }

   public String a(ItemStack var1) {
      if(var1.hasTag()) {
         NBTTagCompound var2 = var1.getTag();
         String var3 = var2.getString("title");
         if(!vb.b(var3)) {
            return var3;
         }
      }

      return super.a(var1);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var2.isStatic) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
      return var1;
   }

   private void a(ItemStack var1, EntityHuman var2) {
      if(var1 != null && var1.getTag() != null) {
         NBTTagCompound var3 = var1.getTag();
         if(!var3.getBoolean("resolved")) {
            var3.setBoolean("resolved", true);
            if(b(var3)) {
               NBTTagList var4 = var3.getList("pages", 8);

               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  String var6 = var4.getString(var5);

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
                  ((EntityPlayer)var2).a.sendPacket((Packet)(new PacketPlayOutSetSlot(0, var10.e, var1)));
               }

            }
         }
      }
   }
}
