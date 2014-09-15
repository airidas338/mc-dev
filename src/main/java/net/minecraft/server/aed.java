package net.minecraft.server;
import java.io.IOException;


public abstract class aed extends EntityMinecartAbstract implements vy {

   private ItemStack[] a = new ItemStack[36];
   private boolean b = true;


   public aed(World var1) {
      super(var1);
   }

   public aed(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void a(DamageSource var1) {
      super.a(var1);
      vs.a(this.o, (Entity)this, this);
   }

   public ItemStack a(int var1) {
      return this.a[var1];
   }

   public ItemStack a(int var1, int var2) {
      if(this.a[var1] != null) {
         ItemStack var3;
         if(this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if(this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(this.a[var1] != null) {
         ItemStack var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      this.a[var1] = var2;
      if(var2 != null && var2.b > this.p_()) {
         var2.b = this.p_();
      }

   }

   public void o_() {}

   public boolean a(EntityHuman var1) {
      return this.I?false:var1.h(this) <= 64.0D;
   }

   public void b(EntityHuman var1) {}

   public void c(EntityHuman var1) {}

   public boolean b(int var1, ItemStack var2) {
      return true;
   }

   public String getName() {
      return this.k_()?this.aL():"container.minecart";
   }

   public int p_() {
      return 64;
   }

   public void c(int var1) throws IOException {
      this.b = false;
      super.c(var1);
   }

   public void J() {
      if(this.b) {
         vs.a(this.o, (Entity)this, this);
      }

      super.J();
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if(this.a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var3);
            this.a[var3].b(var4);
            var2.a((NBTBase)var4);
         }
      }

      var1.set("Items", (NBTBase)var2);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.a = new ItemStack[this.n_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         NBTTagCompound var4 = var2.b(var3);
         int var5 = var4.getByte("Slot") & 255;
         if(var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = ItemStack.a(var4);
         }
      }

   }

   public boolean e(EntityHuman var1) {
      if(!this.o.isStatic) {
         var1.a((IInventory)this);
      }

      return true;
   }

   protected void o() {
      int var1 = 15 - aib.b((IInventory)this);
      float var2 = 0.98F + (float)var1 * 0.001F;
      this.v *= (double)var2;
      this.w *= 0.0D;
      this.x *= (double)var2;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {}

   public int g() {
      return 0;
   }

   public boolean q_() {
      return false;
   }

   public void a(vx var1) {}

   public vx i() {
      return vx.a;
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }
}
