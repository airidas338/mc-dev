package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class aib {

   public List b = Lists.newArrayList();
   public List c = Lists.newArrayList();
   public int d;
   private int f = -1;
   private int g;
   private final Set h = Sets.newHashSet();
   protected List e = Lists.newArrayList();
   private Set i = Sets.newHashSet();


   protected ajk a(ajk var1) {
      var1.e = this.c.size();
      this.c.add(var1);
      this.b.add((Object)null);
      return var1;
   }

   public void a(ail var1) {
      if(this.e.contains(var1)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.e.add(var1);
         var1.a(this, this.a());
         this.b();
      }
   }

   public List a() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         var1.add(((ajk)this.c.get(var2)).d());
      }

      return var1;
   }

   public void b() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         ItemStack var2 = ((ajk)this.c.get(var1)).d();
         ItemStack var3 = (ItemStack)this.b.get(var1);
         if(!ItemStack.matches(var3, var2)) {
            var3 = var2 == null?null:var2.cloneItemStack();
            this.b.set(var1, var3);

            for(int var4 = 0; var4 < this.e.size(); ++var4) {
               ((ail)this.e.get(var4)).a(this, var1, var3);
            }
         }
      }

   }

   public boolean a(EntityHuman var1, int var2) {
      return false;
   }

   public ajk a(IInventory var1, int var2) {
      for(int var3 = 0; var3 < this.c.size(); ++var3) {
         ajk var4 = (ajk)this.c.get(var3);
         if(var4.a(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   public ajk a(int var1) {
      return (ajk)this.c.get(var1);
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ajk var3 = (ajk)this.c.get(var2);
      return var3 != null?var3.d():null;
   }

   public ItemStack a(int var1, int var2, int var3, EntityHuman var4) {
      ItemStack var5 = null;
      ahb var6 = var4.bg;
      int var9;
      ItemStack var17;
      if(var3 == 5) {
         int var7 = this.g;
         this.g = c(var2);
         if((var7 != 1 || this.g != 2) && var7 != this.g) {
            this.d();
         } else if(var6.p() == null) {
            this.d();
         } else if(this.g == 0) {
            this.f = b(var2);
            if(a(this.f, var4)) {
               this.g = 1;
               this.h.clear();
            } else {
               this.d();
            }
         } else if(this.g == 1) {
            ajk var8 = (ajk)this.c.get(var1);
            if(var8 != null && a(var8, var6.p(), true) && var8.a(var6.p()) && var6.p().count > this.h.size() && this.b(var8)) {
               this.h.add(var8);
            }
         } else if(this.g == 2) {
            if(!this.h.isEmpty()) {
               var17 = var6.p().cloneItemStack();
               var9 = var6.p().count;
               Iterator var10 = this.h.iterator();

               while(var10.hasNext()) {
                  ajk var11 = (ajk)var10.next();
                  if(var11 != null && a(var11, var6.p(), true) && var11.a(var6.p()) && var6.p().count >= this.h.size() && this.b(var11)) {
                     ItemStack var12 = var17.cloneItemStack();
                     int var13 = var11.e()?var11.d().count:0;
                     a(this.h, this.f, var12, var13);
                     if(var12.count > var12.getMaxStackSize()) {
                        var12.count = var12.getMaxStackSize();
                     }

                     if(var12.count > var11.b(var12)) {
                        var12.count = var11.b(var12);
                     }

                     var9 -= var12.count - var13;
                     var11.d(var12);
                  }
               }

               var17.count = var9;
               if(var17.count <= 0) {
                  var17 = null;
               }

               var6.b(var17);
            }

            this.d();
         } else {
            this.d();
         }
      } else if(this.g != 0) {
         this.d();
      } else {
         ajk var16;
         int var22;
         ItemStack var24;
         if((var3 == 0 || var3 == 1) && (var2 == 0 || var2 == 1)) {
            if(var1 == -999) {
               if(var6.p() != null) {
                  if(var2 == 0) {
                     var4.a(var6.p(), true);
                     var6.b((ItemStack)null);
                  }

                  if(var2 == 1) {
                     var4.a(var6.p().a(1), true);
                     if(var6.p().count == 0) {
                        var6.b((ItemStack)null);
                     }
                  }
               }
            } else if(var3 == 1) {
               if(var1 < 0) {
                  return null;
               }

               var16 = (ajk)this.c.get(var1);
               if(var16 != null && var16.a(var4)) {
                  var17 = this.b(var4, var1);
                  if(var17 != null) {
                     Item var19 = var17.getItem();
                     var5 = var17.cloneItemStack();
                     if(var16.d() != null && var16.d().getItem() == var19) {
                        this.a(var1, var2, true, var4);
                     }
                  }
               }
            } else {
               if(var1 < 0) {
                  return null;
               }

               var16 = (ajk)this.c.get(var1);
               if(var16 != null) {
                  var17 = var16.d();
                  ItemStack var20 = var6.p();
                  if(var17 != null) {
                     var5 = var17.cloneItemStack();
                  }

                  if(var17 == null) {
                     if(var20 != null && var16.a(var20)) {
                        var22 = var2 == 0?var20.count:1;
                        if(var22 > var16.b(var20)) {
                           var22 = var16.b(var20);
                        }

                        if(var20.count >= var22) {
                           var16.d(var20.a(var22));
                        }

                        if(var20.count == 0) {
                           var6.b((ItemStack)null);
                        }
                     }
                  } else if(var16.a(var4)) {
                     if(var20 == null) {
                        var22 = var2 == 0?var17.count:(var17.count + 1) / 2;
                        var24 = var16.a(var22);
                        var6.b(var24);
                        if(var17.count == 0) {
                           var16.d((ItemStack)null);
                        }

                        var16.a(var4, var6.p());
                     } else if(var16.a(var20)) {
                        if(var17.getItem() == var20.getItem() && var17.getData() == var20.getData() && ItemStack.equals(var17, var20)) {
                           var22 = var2 == 0?var20.count:1;
                           if(var22 > var16.b(var20) - var17.count) {
                              var22 = var16.b(var20) - var17.count;
                           }

                           if(var22 > var20.getMaxStackSize() - var17.count) {
                              var22 = var20.getMaxStackSize() - var17.count;
                           }

                           var20.a(var22);
                           if(var20.count == 0) {
                              var6.b((ItemStack)null);
                           }

                           var17.count += var22;
                        } else if(var20.count <= var16.b(var20)) {
                           var16.d(var20);
                           var6.b(var17);
                        }
                     } else if(var17.getItem() == var20.getItem() && var20.getMaxStackSize() > 1 && (!var17.usesData() || var17.getData() == var20.getData()) && ItemStack.equals(var17, var20)) {
                        var22 = var17.count;
                        if(var22 > 0 && var22 + var20.count <= var20.getMaxStackSize()) {
                           var20.count += var22;
                           var17 = var16.a(var22);
                           if(var17.count == 0) {
                              var16.d((ItemStack)null);
                           }

                           var16.a(var4, var6.p());
                        }
                     }
                  }

                  var16.f();
               }
            }
         } else if(var3 == 2 && var2 >= 0 && var2 < 9) {
            var16 = (ajk)this.c.get(var1);
            if(var16.a(var4)) {
               var17 = var6.a(var2);
               boolean var18 = var17 == null || var16.d == var6 && var16.a(var17);
               var22 = -1;
               if(!var18) {
                  var22 = var6.j();
                  var18 |= var22 > -1;
               }

               if(var16.e() && var18) {
                  var24 = var16.d();
                  var6.a(var2, var24.cloneItemStack());
                  if((var16.d != var6 || !var16.a(var17)) && var17 != null) {
                     if(var22 > -1) {
                        var6.a(var17);
                        var16.a(var24.count);
                        var16.d((ItemStack)null);
                        var16.a(var4, var24);
                     }
                  } else {
                     var16.a(var24.count);
                     var16.d(var17);
                     var16.a(var4, var24);
                  }
               } else if(!var16.e() && var17 != null && var16.a(var17)) {
                  var6.a(var2, (ItemStack)null);
                  var16.d(var17);
               }
            }
         } else if(var3 == 3 && var4.abilities.canInstantlyBuild && var6.p() == null && var1 >= 0) {
            var16 = (ajk)this.c.get(var1);
            if(var16 != null && var16.e()) {
               var17 = var16.d().cloneItemStack();
               var17.count = var17.getMaxStackSize();
               var6.b(var17);
            }
         } else if(var3 == 4 && var6.p() == null && var1 >= 0) {
            var16 = (ajk)this.c.get(var1);
            if(var16 != null && var16.e() && var16.a(var4)) {
               var17 = var16.a(var2 == 0?1:var16.d().count);
               var16.a(var4, var17);
               var4.a(var17, true);
            }
         } else if(var3 == 6 && var1 >= 0) {
            var16 = (ajk)this.c.get(var1);
            var17 = var6.p();
            if(var17 != null && (var16 == null || !var16.e() || !var16.a(var4))) {
               var9 = var2 == 0?0:this.c.size() - 1;
               var22 = var2 == 0?1:-1;

               for(int var21 = 0; var21 < 2; ++var21) {
                  for(int var23 = var9; var23 >= 0 && var23 < this.c.size() && var17.count < var17.getMaxStackSize(); var23 += var22) {
                     ajk var25 = (ajk)this.c.get(var23);
                     if(var25.e() && a(var25, var17, true) && var25.a(var4) && this.a(var17, var25) && (var21 != 0 || var25.d().count != var25.d().getMaxStackSize())) {
                        int var14 = Math.min(var17.getMaxStackSize() - var17.count, var25.d().count);
                        ItemStack var15 = var25.a(var14);
                        var17.count += var14;
                        if(var15.count <= 0) {
                           var25.d((ItemStack)null);
                        }

                        var25.a(var4, var15);
                     }
                  }
               }
            }

            this.b();
         }
      }

      return var5;
   }

   public boolean a(ItemStack var1, ajk var2) {
      return true;
   }

   protected void a(int var1, int var2, boolean var3, EntityHuman var4) {
      this.a(var1, var2, 1, var4);
   }

   public void b(EntityHuman var1) {
      ahb var2 = var1.bg;
      if(var2.p() != null) {
         var1.a(var2.p(), false);
         var2.b((ItemStack)null);
      }

   }

   public void a(IInventory var1) {
      this.b();
   }

   public void a(int var1, ItemStack var2) {
      this.a(var1).d(var2);
   }

   public boolean c(EntityHuman var1) {
      return !this.i.contains(var1);
   }

   public void a(EntityHuman var1, boolean var2) {
      if(var2) {
         this.i.remove(var1);
      } else {
         this.i.add(var1);
      }

   }

   public abstract boolean a(EntityHuman var1);

   protected boolean a(ItemStack var1, int var2, int var3, boolean var4) {
      boolean var5 = false;
      int var6 = var2;
      if(var4) {
         var6 = var3 - 1;
      }

      ajk var7;
      ItemStack var8;
      if(var1.isStackable()) {
         while(var1.count > 0 && (!var4 && var6 < var3 || var4 && var6 >= var2)) {
            var7 = (ajk)this.c.get(var6);
            var8 = var7.d();
            if(var8 != null && var8.getItem() == var1.getItem() && (!var1.usesData() || var1.getData() == var8.getData()) && ItemStack.equals(var1, var8)) {
               int var9 = var8.count + var1.count;
               if(var9 <= var1.getMaxStackSize()) {
                  var1.count = 0;
                  var8.count = var9;
                  var7.f();
                  var5 = true;
               } else if(var8.count < var1.getMaxStackSize()) {
                  var1.count -= var1.getMaxStackSize() - var8.count;
                  var8.count = var1.getMaxStackSize();
                  var7.f();
                  var5 = true;
               }
            }

            if(var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if(var1.count > 0) {
         if(var4) {
            var6 = var3 - 1;
         } else {
            var6 = var2;
         }

         while(!var4 && var6 < var3 || var4 && var6 >= var2) {
            var7 = (ajk)this.c.get(var6);
            var8 = var7.d();
            if(var8 == null) {
               var7.d(var1.cloneItemStack());
               var7.f();
               var1.count = 0;
               var5 = true;
               break;
            }

            if(var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }

   public static int b(int var0) {
      return var0 >> 2 & 3;
   }

   public static int c(int var0) {
      return var0 & 3;
   }

   public static boolean a(int var0, EntityHuman var1) {
      return var0 == 0?true:(var0 == 1?true:var0 == 2 && var1.abilities.canInstantlyBuild);
   }

   protected void d() {
      this.g = 0;
      this.h.clear();
   }

   public static boolean a(ajk var0, ItemStack var1, boolean var2) {
      boolean var3 = var0 == null || !var0.e();
      if(var0 != null && var0.e() && var1 != null && var1.a(var0.d()) && ItemStack.equals(var0.d(), var1)) {
         int var10002 = var2?0:var1.count;
         var3 |= var0.d().count + var10002 <= var1.getMaxStackSize();
      }

      return var3;
   }

   public static void a(Set var0, int var1, ItemStack var2, int var3) {
      switch(var1) {
      case 0:
         var2.count = MathHelper.d((float)var2.count / (float)var0.size());
         break;
      case 1:
         var2.count = 1;
         break;
      case 2:
         var2.count = var2.getItem().getMaxStackSize();
      }

      var2.count += var3;
   }

   public boolean b(ajk var1) {
      return true;
   }

   public static int a(TileEntity var0) {
      return var0 instanceof IInventory?b((IInventory)var0):0;
   }

   public static int b(IInventory var0) {
      if(var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         float var2 = 0.0F;

         for(int var3 = 0; var3 < var0.n_(); ++var3) {
            ItemStack var4 = var0.a(var3);
            if(var4 != null) {
               var2 += (float)var4.count / (float)Math.min(var0.p_(), var4.getMaxStackSize());
               ++var1;
            }
         }

         var2 /= (float)var0.n_();
         return MathHelper.d(var2 * 14.0F) + (var1 > 0?1:0);
      }
   }
}
