package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class EntityLeash extends EntityHanging {

   public EntityLeash(World var1) {
      super(var1);
   }

   public EntityLeash(World var1, Location var2) {
      super(var1, var2);
      this.b((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D);
      float var3 = 0.125F;
      float var4 = 0.1875F;
      float var5 = 0.25F;
      this.a(new AxisAlignedBB(this.s - 0.1875D, this.t - 0.25D + 0.125D, this.u - 0.1875D, this.s + 0.1875D, this.t + 0.25D + 0.125D, this.u + 0.1875D));
   }

   protected void h() {
      super.h();
   }

   public void a(ej var1) {}

   public int l() {
      return 9;
   }

   public int m() {
      return 9;
   }

   public float aR() {
      return -0.0625F;
   }

   public void b(Entity var1) {}

   public boolean d(NBTTagCompound var1) {
      return false;
   }

   public void b(NBTTagCompound var1) {}

   public void a(NBTTagCompound var1) {}

   public boolean e(EntityHuman var1) {
      amj var2 = var1.bz();
      boolean var3 = false;
      double var4;
      List var6;
      Iterator var7;
      EntityInsentient var8;
      if(var2 != null && var2.b() == Items.cn && !this.o.D) {
         var4 = 7.0D;
         var6 = this.o.a(EntityInsentient.class, new AxisAlignedBB(this.s - var4, this.t - var4, this.u - var4, this.s + var4, this.t + var4, this.u + var4));
         var7 = var6.iterator();

         while(var7.hasNext()) {
            var8 = (EntityInsentient)var7.next();
            if(var8.cb() && var8.cc() == var1) {
               var8.a(this, true);
               var3 = true;
            }
         }
      }

      if(!this.o.D && !var3) {
         this.J();
         if(var1.by.d) {
            var4 = 7.0D;
            var6 = this.o.a(EntityInsentient.class, new AxisAlignedBB(this.s - var4, this.t - var4, this.u - var4, this.s + var4, this.t + var4, this.u + var4));
            var7 = var6.iterator();

            while(var7.hasNext()) {
               var8 = (EntityInsentient)var7.next();
               if(var8.cb() && var8.cc() == this) {
                  var8.a(true, false);
               }
            }
         }
      }

      return true;
   }

   public boolean j() {
      return this.o.getData(this.a).c() instanceof BlockFence;
   }

   public static EntityLeash a(World var0, Location var1) {
      EntityLeash var2 = new EntityLeash(var0, var1);
      var2.n = true;
      var0.d((Entity)var2);
      return var2;
   }

   public static EntityLeash b(World var0, Location var1) {
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      List var5 = var0.a(EntityLeash.class, new AxisAlignedBB((double)var2 - 1.0D, (double)var3 - 1.0D, (double)var4 - 1.0D, (double)var2 + 1.0D, (double)var3 + 1.0D, (double)var4 + 1.0D));
      Iterator var6 = var5.iterator();

      EntityLeash var7;
      do {
         if(!var6.hasNext()) {
            return null;
         }

         var7 = (EntityLeash)var6.next();
      } while(!var7.n().equals(var1));

      return var7;
   }
}
