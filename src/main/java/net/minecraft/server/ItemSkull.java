package net.minecraft.server;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class ItemSkull extends Item {

   private static final String[] a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};


   public ItemSkull() {
      this.a(CreativeModeTab.c);
      this.d(0);
      this.a(true);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var5 == EnumFacing.DOWN) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         Block var10 = var9.c();
         boolean var11 = var10.f(var3, var4);
         if(!var11) {
            if(!var3.getData(var4).c().getMaterial().isBuildable()) {
               return false;
            }

            var4 = var4.a(var5);
         }

         if(!var2.a(var4, var5, var1)) {
            return false;
         } else if(!Blocks.SKULL.canPlace(var3, var4)) {
            return false;
         } else {
            if(!var3.isStatic) {
               var3.setTypeAndData(var4, Blocks.SKULL.P().a(BlockSkull.a, var5), 3);
               int var12 = 0;
               if(var5 == EnumFacing.UP) {
                  var12 = MathHelper.floor((double)(var2.y * 16.0F / 360.0F) + 0.5D) & 15;
               }

               TileEntity var13 = var3.getTileEntity(var4);
               if(var13 instanceof TileEntitySkull) {
                  TileEntitySkull var14 = (TileEntitySkull)var13;
                  if(var1.getData() == 3) {
                     GameProfile var15 = null;
                     if(var1.hasTag()) {
                        NBTTagCompound var16 = var1.getTag();
                        if(var16.hasKeyOfType("SkullOwner", 10)) {
                           var15 = GameProfileSerializer.deserialize(var16.getCompound("SkullOwner"));
                        } else if(var16.hasKeyOfType("SkullOwner", 8) && var16.getString("SkullOwner").length() > 0) {
                           var15 = new GameProfile((UUID)null, var16.getString("SkullOwner"));
                        }
                     }

                     var14.a(var15);
                  } else {
                     var14.a(var1.getData());
                  }

                  var14.b(var12);
                  Blocks.SKULL.a(var3, var4, var14);
               }

               --var1.count;
            }

            return true;
         }
      }
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(ItemStack var1) {
      int var2 = var1.getData();
      if(var2 < 0 || var2 >= a.length) {
         var2 = 0;
      }

      return super.a() + "." + a[var2];
   }

   public String a(ItemStack var1) {
      if(var1.getData() == 3 && var1.hasTag()) {
         if(var1.getTag().hasKeyOfType("SkullOwner", 8)) {
            return LocaleI18n.get("item.skull.player.name", new Object[]{var1.getTag().getString("SkullOwner")});
         }

         if(var1.getTag().hasKeyOfType("SkullOwner", 10)) {
            NBTTagCompound var2 = var1.getTag().getCompound("SkullOwner");
            if(var2.hasKeyOfType("Name", 8)) {
               return LocaleI18n.get("item.skull.player.name", new Object[]{var2.getString("Name")});
            }
         }
      }

      return super.a(var1);
   }

   public boolean a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("SkullOwner", 8) && var1.getString("SkullOwner").length() > 0) {
         GameProfile var2 = new GameProfile((UUID)null, var1.getString("SkullOwner"));
         var2 = TileEntitySkull.b(var2);
         var1.set("SkullOwner", (NBTBase)GameProfileSerializer.serialize(new NBTTagCompound(), var2));
         return true;
      } else {
         return false;
      }
   }

}
