package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EnchantmentManager {

   private static final Random a = new Random();
   private static final apn b = new apn((api)null);
   private static final apm c = new apm((api)null);
   private static final apk d = new apk((api)null);
   private static final apj e = new apj((api)null);


   public static int a(int var0, ItemStack var1) {
      if(var1 == null) {
         return 0;
      } else {
         NBTTagList var2 = var1.p();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               short var4 = var2.b(var3).getShort("id");
               short var5 = var2.b(var3).getShort("lvl");
               if(var4 == var0) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   public static Map a(ItemStack var0) {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      NBTTagList var2 = var0.b() == Items.cd?Items.cd.h(var0):var0.p();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.c(); ++var3) {
            short var4 = var2.b(var3).getShort("id");
            short var5 = var2.b(var3).getShort("lvl");
            var1.put(Integer.valueOf(var4), Integer.valueOf(var5));
         }
      }

      return var1;
   }

   public static void a(Map var0, ItemStack var1) {
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         int var4 = ((Integer)var3.next()).intValue();
         Enchantment var5 = Enchantment.c(var4);
         if(var5 != null) {
            NBTTagCompound var6 = new NBTTagCompound();
            var6.setShort("id", (short)var4);
            var6.setShort("lvl", (short)((Integer)var0.get(Integer.valueOf(var4))).intValue());
            var2.a((NBTBase)var6);
            if(var1.b() == Items.cd) {
               Items.cd.a(var1, new apo(var5, ((Integer)var0.get(Integer.valueOf(var4))).intValue()));
            }
         }
      }

      if(var2.c() > 0) {
         if(var1.b() != Items.cd) {
            var1.a("ench", (NBTBase)var2);
         }
      } else if(var1.n()) {
         var1.o().o("ench");
      }

   }

   public static int a(int var0, ItemStack[] var1) {
      if(var1 == null) {
         return 0;
      } else {
         int var2 = 0;
         ItemStack[] var3 = var1;
         int var4 = var1.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ItemStack var6 = var3[var5];
            int var7 = a(var0, var6);
            if(var7 > var2) {
               var2 = var7;
            }
         }

         return var2;
      }
   }

   private static void a(apl var0, ItemStack var1) {
      if(var1 != null) {
         NBTTagList var2 = var1.p();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               short var4 = var2.b(var3).getShort("id");
               short var5 = var2.b(var3).getShort("lvl");
               if(Enchantment.c(var4) != null) {
                  var0.a(Enchantment.c(var4), var5);
               }
            }

         }
      }
   }

   private static void a(apl var0, ItemStack[] var1) {
      ItemStack[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         a(var0, var5);
      }

   }

   public static int a(ItemStack[] var0, DamageSource var1) {
      b.a = 0;
      b.b = var1;
      a((apl)b, var0);
      if(b.a > 25) {
         b.a = 25;
      }

      return (b.a + 1 >> 1) + a.nextInt((b.a >> 1) + 1);
   }

   public static float a(ItemStack var0, xs var1) {
      c.a = 0.0F;
      c.b = var1;
      a((apl)c, var0);
      return c.a;
   }

   public static void a(EntityLiving var0, Entity var1) {
      d.b = var1;
      d.a = var0;
      if(var0 != null) {
         a((apl)d, var0.at());
      }

      if(var1 instanceof EntityHuman) {
         a((apl)d, var0.bz());
      }

   }

   public static void b(EntityLiving var0, Entity var1) {
      e.a = var0;
      e.b = var1;
      if(var0 != null) {
         a((apl)e, var0.at());
      }

      if(var0 instanceof EntityHuman) {
         a((apl)e, var0.bz());
      }

   }

   public static int a(EntityLiving var0) {
      return a(Enchantment.KNOCKBACK.B, var0.bz());
   }

   public static int getFireAspectEnchantmentLevel(EntityLiving var0) {
      return a(Enchantment.FIRE_ASPECT.B, var0.bz());
   }

   public static int a(Entity var0) {
      return a(Enchantment.OXYGEN.B, var0.at());
   }

   public static int b(Entity var0) {
      return a(Enchantment.DEPTH_STRIDER.B, var0.at());
   }

   public static int c(EntityLiving var0) {
      return a(Enchantment.DIG_SPEED.B, var0.bz());
   }

   public static boolean e(EntityLiving var0) {
      return a(Enchantment.DURABILITY.B, var0.bz()) > 0;
   }

   public static int f(EntityLiving var0) {
      return a(Enchantment.LOOT_BONUS_BLOCKS.B, var0.bz());
   }

   public static int g(EntityLiving var0) {
      return a(Enchantment.LUCK.B, var0.bz());
   }

   public static int h(EntityLiving var0) {
      return a(Enchantment.LURE.B, var0.bz());
   }

   public static int i(EntityLiving var0) {
      return a(Enchantment.LOOT_BONUS_MOBS.B, var0.bz());
   }

   public static boolean j(EntityLiving var0) {
      return a(Enchantment.WATER_WORKER.B, var0.at()) > 0;
   }

   public static ItemStack a(Enchantment var0, EntityLiving var1) {
      ItemStack[] var2 = var1.at();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         if(var5 != null && a(var0.B, var5) > 0) {
            return var5;
         }
      }

      return null;
   }

   public static int a(Random var0, int var1, int var2, ItemStack var3) {
      Item var4 = var3.b();
      int var5 = var4.b();
      if(var5 <= 0) {
         return 0;
      } else {
         if(var2 > 15) {
            var2 = 15;
         }

         int var6 = var0.nextInt(8) + 1 + (var2 >> 1) + var0.nextInt(var2 + 1);
         return var1 == 0?Math.max(var6 / 3, 1):(var1 == 1?var6 * 2 / 3 + 1:Math.max(var6, var2 * 2));
      }
   }

   public static ItemStack a(Random var0, ItemStack var1, int var2) {
      List var3 = b(var0, var1, var2);
      boolean var4 = var1.b() == Items.aL;
      if(var4) {
         var1.a((Item)Items.cd);
      }

      if(var3 != null) {
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            apo var6 = (apo)var5.next();
            if(var4) {
               Items.cd.a(var1, var6);
            } else {
               var1.a(var6.b, var6.c);
            }
         }
      }

      return var1;
   }

   public static List b(Random var0, ItemStack var1, int var2) {
      Item var3 = var1.b();
      int var4 = var3.b();
      if(var4 <= 0) {
         return null;
      } else {
         var4 /= 2;
         var4 = 1 + var0.nextInt((var4 >> 1) + 1) + var0.nextInt((var4 >> 1) + 1);
         int var5 = var4 + var2;
         float var6 = (var0.nextFloat() + var0.nextFloat() - 1.0F) * 0.15F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         if(var7 < 1) {
            var7 = 1;
         }

         ArrayList var8 = null;
         Map var9 = b(var7, var1);
         if(var9 != null && !var9.isEmpty()) {
            apo var10 = (apo)WeightedRandom.a(var0, var9.values());
            if(var10 != null) {
               var8 = Lists.newArrayList();
               var8.add(var10);

               for(int var11 = var7; var0.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(true) {
                        if(var15.hasNext()) {
                           apo var16 = (apo)var15.next();
                           if(var16.b.a(Enchantment.c(var13.intValue()))) {
                              continue;
                           }

                           var14 = false;
                        }

                        if(!var14) {
                           var12.remove();
                        }
                        break;
                     }
                  }

                  if(!var9.isEmpty()) {
                     apo var17 = (apo)WeightedRandom.a(var0, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map b(int var0, ItemStack var1) {
      Item var2 = var1.b();
      HashMap var3 = null;
      boolean var4 = var1.b() == Items.aL;
      Enchantment[] var5 = Enchantment.b;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Enchantment var8 = var5[var7];
         if(var8 != null && (var8.C.a(var2) || var4)) {
            for(int var9 = var8.e(); var9 <= var8.b(); ++var9) {
               if(var0 >= var8.a(var9) && var0 <= var8.b(var9)) {
                  if(var3 == null) {
                     var3 = Maps.newHashMap();
                  }

                  var3.put(Integer.valueOf(var8.B), new apo(var8, var9));
               }
            }
         }
      }

      return var3;
   }

}
