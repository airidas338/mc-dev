package net.minecraft.server;

import java.io.IOException;


public abstract class EntityAgeable extends EntityCreature {

   protected int a;
   protected int b;
   protected int c;
   private float bk = -1.0F;
   private float bl;


   public EntityAgeable(World var1) {
      super(var1);
   }

   public abstract EntityAgeable a(EntityAgeable var1);

   public boolean a(EntityHuman var1) {
      ItemStack var2 = var1.bg.h();
      if(var2 != null && var2.getItem() == Items.bJ) {
         if(!this.o.isStatic) {
            Class var3 = EntityTypes.a(var2.getData());
            if(var3 != null && this.getClass() == var3) {
               EntityAgeable var4 = this.a(this);
               if(var4 != null) {
                  var4.b(-24000);
                  var4.setPositionRotation(this.s, this.t, this.u, 0.0F, 0.0F);
                  this.o.addEntity((Entity)var4);
                  if(var2.hasName()) {
                     var4.a(var2.getName());
                  }

                  if(!var1.abilities.canInstantlyBuild) {
                     --var2.count;
                     if(var2.count <= 0) {
                        var1.bg.a(var1.bg.c, (ItemStack)null);
                     }
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected void h() {
      super.h();
      this.ac.a(12, Byte.valueOf((byte)0));
   }

   public int l() {
      return this.o.isStatic?this.ac.a(12):this.a;
   }

   public void a(int var1, boolean var2) {
      int var3 = this.l();
      int var4 = var3;
      var3 += var1 * 20;
      if(var3 > 0) {
         var3 = 0;
         if(var4 < 0) {
            this.n();
         }
      }

      int var5 = var3 - var4;
      this.b(var3);
      if(var2) {
         this.b += var5;
         if(this.c == 0) {
            this.c = 40;
         }
      }

      if(this.l() == 0) {
         this.b(this.b);
      }

   }

   public void a(int var1) {
      this.a(var1, false);
   }

   public void b(int var1) {
      this.ac.b(12, Byte.valueOf((byte)MathHelper.a(var1, -1, 1)));
      this.a = var1;
      this.a(this.i_());
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("Age", this.l());
      var1.setInt("ForcedAge", this.b);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.b(var1.getInt("Age"));
      this.b = var1.getInt("ForcedAge");
   }

   public void m() throws IOException {
      super.m();
      if(this.o.isStatic) {
         if(this.c > 0) {
            if(this.c % 4 == 0) {
               this.o.a(EnumParticleEffect.v, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, 0.0D, 0.0D, 0.0D, new int[0]);
            }

            --this.c;
         }

         this.a(this.i_());
      } else {
         int var1 = this.l();
         if(var1 < 0) {
            ++var1;
            this.b(var1);
            if(var1 == 0) {
               this.n();
            }
         } else if(var1 > 0) {
            --var1;
            this.b(var1);
         }
      }

   }

   protected void n() {}

   public boolean i_() {
      return this.l() < 0;
   }

   public void a(boolean var1) {
      this.a(var1?0.5F:1.0F);
   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.bk > 0.0F;
      this.bk = var1;
      this.bl = var2;
      if(!var3) {
         this.a(1.0F);
      }

   }

   protected final void a(float var1) {
      super.a(this.bk * var1, this.bl * var1);
   }
}
