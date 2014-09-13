package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class aoi implements aoo {

   private ItemStack a;


   public boolean a(ain var1, World var2) {
      this.a = null;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.n_(); ++var9) {
         ItemStack var10 = var1.a(var9);
         if(var10 != null) {
            if(var10.b() == Items.H) {
               ++var4;
            } else if(var10.b() == Items.cc) {
               ++var6;
            } else if(var10.b() == Items.aW) {
               ++var5;
            } else if(var10.b() == Items.aK) {
               ++var3;
            } else if(var10.b() == Items.aT) {
               ++var7;
            } else if(var10.b() == Items.i) {
               ++var7;
            } else if(var10.b() == Items.bL) {
               ++var8;
            } else if(var10.b() == Items.G) {
               ++var8;
            } else if(var10.b() == Items.bx) {
               ++var8;
            } else {
               if(var10.b() != Items.bX) {
                  return false;
               }

               ++var8;
            }
         }
      }

      var7 += var5 + var8;
      if(var4 <= 3 && var3 <= 1) {
         NBTTagCompound var15;
         NBTTagCompound var18;
         if(var4 >= 1 && var3 == 1 && var7 == 0) {
            this.a = new ItemStack(Items.cb);
            if(var6 > 0) {
               var15 = new NBTTagCompound();
               var18 = new NBTTagCompound();
               NBTTagList var25 = new NBTTagList();

               for(int var22 = 0; var22 < var1.n_(); ++var22) {
                  ItemStack var26 = var1.a(var22);
                  if(var26 != null && var26.b() == Items.cc && var26.n() && var26.o().b("Explosion", 10)) {
                     var25.a((NBTBase)var26.o().getCompound("Explosion"));
                  }
               }

               var18.set("Explosions", (NBTBase)var25);
               var18.setByte("Flight", (byte)var4);
               var15.set("Fireworks", (NBTBase)var18);
               this.a.d(var15);
            }

            return true;
         } else if(var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
            this.a = new ItemStack(Items.cc);
            var15 = new NBTTagCompound();
            var18 = new NBTTagCompound();
            byte var21 = 0;
            ArrayList var12 = Lists.newArrayList();

            for(int var13 = 0; var13 < var1.n_(); ++var13) {
               ItemStack var14 = var1.a(var13);
               if(var14 != null) {
                  if(var14.b() == Items.aW) {
                     var12.add(Integer.valueOf(akw.a[var14.i() & 15]));
                  } else if(var14.b() == Items.aT) {
                     var18.setBoolean("Flicker", true);
                  } else if(var14.b() == Items.i) {
                     var18.setBoolean("Trail", true);
                  } else if(var14.b() == Items.bL) {
                     var21 = 1;
                  } else if(var14.b() == Items.G) {
                     var21 = 4;
                  } else if(var14.b() == Items.bx) {
                     var21 = 2;
                  } else if(var14.b() == Items.bX) {
                     var21 = 3;
                  }
               }
            }

            int[] var24 = new int[var12.size()];

            for(int var27 = 0; var27 < var24.length; ++var27) {
               var24[var27] = ((Integer)var12.get(var27)).intValue();
            }

            var18.setIntArray("Colors", var24);
            var18.setByte("Type", var21);
            var15.set("Explosion", (NBTBase)var18);
            this.a.d(var15);
            return true;
         } else if(var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
            ArrayList var16 = Lists.newArrayList();

            for(int var20 = 0; var20 < var1.n_(); ++var20) {
               ItemStack var11 = var1.a(var20);
               if(var11 != null) {
                  if(var11.b() == Items.aW) {
                     var16.add(Integer.valueOf(akw.a[var11.i() & 15]));
                  } else if(var11.b() == Items.cc) {
                     this.a = var11.k();
                     this.a.b = 1;
                  }
               }
            }

            int[] var17 = new int[var16.size()];

            for(int var19 = 0; var19 < var17.length; ++var19) {
               var17[var19] = ((Integer)var16.get(var19)).intValue();
            }

            if(this.a != null && this.a.n()) {
               NBTTagCompound var23 = this.a.o().getCompound("Explosion");
               if(var23 == null) {
                  return false;
               } else {
                  var23.setIntArray("FadeColors", var17);
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public ItemStack a(ain var1) {
      return this.a.k();
   }

   public int a() {
      return 10;
   }

   public ItemStack b() {
      return this.a;
   }

   public ItemStack[] b(ain var1) {
      ItemStack[] var2 = new ItemStack[var1.n_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.a(var3);
         if(var4 != null && var4.b().r()) {
            var2[var3] = new ItemStack(var4.b().q());
         }
      }

      return var2;
   }
}
