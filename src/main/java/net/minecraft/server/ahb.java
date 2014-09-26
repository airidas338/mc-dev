package net.minecraft.server;
import java.util.concurrent.Callable;

public class ahb implements IInventory {

   public ItemStack[] a = new ItemStack[36];
   public ItemStack[] b = new ItemStack[4];
   public int c;
   public EntityHuman d;
   private ItemStack f;
   public boolean e;


   public ahb(EntityHuman var1) {
      this.d = var1;
   }

   public ItemStack h() {
      return this.c < 9 && this.c >= 0?this.a[this.c]:null;
   }

   public static int i() {
      return 9;
   }

   private int c(Item var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null && this.a[var2].getItem() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int d(ItemStack var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null && this.a[var2].getItem() == var1.getItem() && this.a[var2].isStackable() && this.a[var2].count < this.a[var2].getMaxStackSize() && this.a[var2].count < this.p_() && (!this.a[var2].usesData() || this.a[var2].getData() == var1.getData()) && ItemStack.equals(this.a[var2], var1)) {
            return var2;
         }
      }

      return -1;
   }

   public int j() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if(this.a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public int a(Item var1, int var2, int var3, NBTTagCompound var4) {
      int var5 = 0;

      int var6;
      ItemStack var7;
      int var8;
      for(var6 = 0; var6 < this.a.length; ++var6) {
         var7 = this.a[var6];
         if(var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getData() == var2) && (var4 == null || CommandTestForBlock.a(var4, var7.getTag(), true))) {
            var8 = var3 <= 0?var7.count:Math.min(var3 - var5, var7.count);
            var5 += var8;
            if(var3 != 0) {
               this.a[var6].count -= var8;
               if(this.a[var6].count == 0) {
                  this.a[var6] = null;
               }

               if(var3 > 0 && var5 >= var3) {
                  return var5;
               }
            }
         }
      }

      for(var6 = 0; var6 < this.b.length; ++var6) {
         var7 = this.b[var6];
         if(var7 != null && (var1 == null || var7.getItem() == var1) && (var2 <= -1 || var7.getData() == var2) && (var4 == null || CommandTestForBlock.a(var4, var7.getTag(), false))) {
            var8 = var3 <= 0?var7.count:Math.min(var3 - var5, var7.count);
            var5 += var8;
            if(var3 != 0) {
               this.b[var6].count -= var8;
               if(this.b[var6].count == 0) {
                  this.b[var6] = null;
               }

               if(var3 > 0 && var5 >= var3) {
                  return var5;
               }
            }
         }
      }

      if(this.f != null) {
         if(var1 != null && this.f.getItem() != var1) {
            return var5;
         }

         if(var2 > -1 && this.f.getData() != var2) {
            return var5;
         }

         if(var4 != null && !CommandTestForBlock.a(var4, this.f.getTag(), false)) {
            return var5;
         }

         var6 = var3 <= 0?this.f.count:Math.min(var3 - var5, this.f.count);
         var5 += var6;
         if(var3 != 0) {
            this.f.count -= var6;
            if(this.f.count == 0) {
               this.f = null;
            }

            if(var3 > 0 && var5 >= var3) {
               return var5;
            }
         }
      }

      return var5;
   }

   private int e(ItemStack var1) {
      Item var2 = var1.getItem();
      int var3 = var1.count;
      int var4 = this.d(var1);
      if(var4 < 0) {
         var4 = this.j();
      }

      if(var4 < 0) {
         return var3;
      } else {
         if(this.a[var4] == null) {
            this.a[var4] = new ItemStack(var2, 0, var1.getData());
            if(var1.hasTag()) {
               this.a[var4].setTag((NBTTagCompound)var1.getTag().clone());
            }
         }

         int var5 = var3;
         if(var3 > this.a[var4].getMaxStackSize() - this.a[var4].count) {
            var5 = this.a[var4].getMaxStackSize() - this.a[var4].count;
         }

         if(var5 > this.p_() - this.a[var4].count) {
            var5 = this.p_() - this.a[var4].count;
         }

         if(var5 == 0) {
            return var3;
         } else {
            var3 -= var5;
            this.a[var4].count += var5;
            this.a[var4].c = 5;
            return var3;
         }
      }
   }

   public void k() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if(this.a[var1] != null) {
            this.a[var1].a(this.d.o, this.d, var1, this.c == var1);
         }
      }

   }

   public boolean a(Item var1) {
      int var2 = this.c(var1);
      if(var2 < 0) {
         return false;
      } else {
         if(--this.a[var2].count <= 0) {
            this.a[var2] = null;
         }

         return true;
      }
   }

   public boolean b(Item var1) {
      int var2 = this.c(var1);
      return var2 >= 0;
   }

   public boolean a(ItemStack var1) {
      if(var1 != null && var1.count != 0 && var1.getItem() != null) {
         try {
            int var2;
            if(var1.g()) {
               var2 = this.j();
               if(var2 >= 0) {
                  this.a[var2] = ItemStack.b(var1);
                  this.a[var2].c = 5;
                  var1.count = 0;
                  return true;
               } else if(this.d.abilities.canInstantlyBuild) {
                  var1.count = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  var2 = var1.count;
                  var1.count = this.e(var1);
               } while(var1.count > 0 && var1.count < var2);

               if(var1.count == var2 && this.d.abilities.canInstantlyBuild) {
                  var1.count = 0;
                  return true;
               } else {
                  return var1.count < var2;
               }
            }
         } catch (Throwable var5) {
            CrashReport var3 = CrashReport.a(var5, "Adding item to inventory");
            CrashReportSystemDetails var4 = var3.a("Item being added");
            var4.a("Item ID", (Object)Integer.valueOf(Item.getId(var1.getItem())));
            var4.a("Item data", (Object)Integer.valueOf(var1.getData()));
            var4.a("Item name", (Callable)(new ahc(this, var1)));
            throw new ReportedException(var3);
         }
      } else {
         return false;
      }
   }

   public ItemStack a(int var1, int var2) {
      ItemStack[] var3 = this.a;
      if(var1 >= this.a.length) {
         var3 = this.b;
         var1 -= this.a.length;
      }

      if(var3[var1] != null) {
         ItemStack var4;
         if(var3[var1].count <= var2) {
            var4 = var3[var1];
            var3[var1] = null;
            return var4;
         } else {
            var4 = var3[var1].a(var2);
            if(var3[var1].count == 0) {
               var3[var1] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      ItemStack[] var2 = this.a;
      if(var1 >= this.a.length) {
         var2 = this.b;
         var1 -= this.a.length;
      }

      if(var2[var1] != null) {
         ItemStack var3 = var2[var1];
         var2[var1] = null;
         return var3;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      ItemStack[] var3 = this.a;
      if(var1 >= var3.length) {
         var1 -= var3.length;
         var3 = this.b;
      }

      var3[var1] = var2;
   }

   public float a(Block var1) {
      float var2 = 1.0F;
      if(this.a[this.c] != null) {
         var2 *= this.a[this.c].a(var1);
      }

      return var2;
   }

   public NBTTagList a(NBTTagList var1) {
      int var2;
      NBTTagCompound var3;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null) {
            var3 = new NBTTagCompound();
            var3.setByte("Slot", (byte)var2);
            this.a[var2].save(var3);
            var1.add((NBTBase)var3);
         }
      }

      for(var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null) {
            var3 = new NBTTagCompound();
            var3.setByte("Slot", (byte)(var2 + 100));
            this.b[var2].save(var3);
            var1.add((NBTBase)var3);
         }
      }

      return var1;
   }

   public void b(NBTTagList var1) {
      this.a = new ItemStack[36];
      this.b = new ItemStack[4];

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         NBTTagCompound var3 = var1.get(var2);
         int var4 = var3.getByte("Slot") & 255;
         ItemStack var5 = ItemStack.createStack(var3);
         if(var5 != null) {
            if(var4 >= 0 && var4 < this.a.length) {
               this.a[var4] = var5;
            }

            if(var4 >= 100 && var4 < this.b.length + 100) {
               this.b[var4 - 100] = var5;
            }
         }
      }

   }

   public int n_() {
      return this.a.length + 4;
   }

   public ItemStack a(int var1) {
      ItemStack[] var2 = this.a;
      if(var1 >= var2.length) {
         var1 -= var2.length;
         var2 = this.b;
      }

      return var2[var1];
   }

   public String getName() {
      return "container.inventory";
   }

   public boolean k_() {
      return false;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return (IChatBaseComponent)(this.k_()?new ChatComponentText(this.getName()):new ChatMessage(this.getName(), new Object[0]));
   }

   public int p_() {
      return 64;
   }

   public boolean b(Block var1) {
      if(var1.getMaterial().l()) {
         return true;
      } else {
         ItemStack var2 = this.a(this.c);
         return var2 != null?var2.b(var1):false;
      }
   }

   public ItemStack e(int var1) {
      return this.b[var1];
   }

   public int m() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null && this.b[var2].getItem() instanceof ItemArmor) {
            int var3 = ((ItemArmor)this.b[var2].getItem()).c;
            var1 += var3;
         }
      }

      return var1;
   }

   public void a(float var1) {
      var1 /= 4.0F;
      if(var1 < 1.0F) {
         var1 = 1.0F;
      }

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null && this.b[var2].getItem() instanceof ItemArmor) {
            this.b[var2].damage((int)var1, (EntityLiving)this.d);
            if(this.b[var2].count == 0) {
               this.b[var2] = null;
            }
         }
      }

   }

   public void n() {
      int var1;
      for(var1 = 0; var1 < this.a.length; ++var1) {
         if(this.a[var1] != null) {
            this.d.a(this.a[var1], true, false);
            this.a[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.b.length; ++var1) {
         if(this.b[var1] != null) {
            this.d.a(this.b[var1], true, false);
            this.b[var1] = null;
         }
      }

   }

   public void o_() {
      this.e = true;
   }

   public void b(ItemStack var1) {
      this.f = var1;
   }

   public ItemStack p() {
      return this.f;
   }

   public boolean a(EntityHuman var1) {
      return this.d.I?false:var1.h(this.d) <= 64.0D;
   }

   public boolean c(ItemStack var1) {
      int var2;
      for(var2 = 0; var2 < this.b.length; ++var2) {
         if(this.b[var2] != null && this.b[var2].a(var1)) {
            return true;
         }
      }

      for(var2 = 0; var2 < this.a.length; ++var2) {
         if(this.a[var2] != null && this.a[var2].a(var1)) {
            return true;
         }
      }

      return false;
   }

   public void b(EntityHuman var1) {}

   public void c(EntityHuman var1) {}

   public boolean b(int var1, ItemStack var2) {
      return true;
   }

   public void b(ahb var1) {
      int var2;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = ItemStack.b(var1.a[var2]);
      }

      for(var2 = 0; var2 < this.b.length; ++var2) {
         this.b[var2] = ItemStack.b(var1.b[var2]);
      }

      this.c = var1.c;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {}

   public int g() {
      return 0;
   }

   public void l() {
      int var1;
      for(var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

      for(var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = null;
      }

   }
}
