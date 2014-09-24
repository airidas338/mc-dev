package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class EntityPotion extends EntityProjectile {

   private ItemStack c;


   public EntityPotion(World var1) {
      super(var1);
   }

   public EntityPotion(World var1, EntityLiving var2, int var3) {
      this(var1, var2, new ItemStack(Items.POTION, 1, var3));
   }

   public EntityPotion(World var1, EntityLiving var2, ItemStack var3) {
      super(var1, var2);
      this.c = var3;
   }

   public EntityPotion(World var1, double var2, double var4, double var6, ItemStack var8) {
      super(var1, var2, var4, var6);
      this.c = var8;
   }

   protected float m() {
      return 0.05F;
   }

   protected float j() {
      return 0.5F;
   }

   protected float l() {
      return -20.0F;
   }

   public void a(int var1) {
      if(this.c == null) {
         this.c = new ItemStack(Items.POTION, 1, 0);
      }

      this.c.b(var1);
   }

   public int o() {
      if(this.c == null) {
         this.c = new ItemStack(Items.POTION, 1, 0);
      }

      return this.c.i();
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.isStatic) {
         List var2 = Items.POTION.h(this.c);
         if(var2 != null && !var2.isEmpty()) {
            AxisAlignedBB var3 = this.aQ().b(4.0D, 2.0D, 4.0D);
            List var4 = this.o.getEntities(EntityLiving.class, var3);
            if(!var4.isEmpty()) {
               Iterator var5 = var4.iterator();

               while(var5.hasNext()) {
                  EntityLiving var6 = (EntityLiving)var5.next();
                  double var7 = this.h(var6);
                  if(var7 < 16.0D) {
                     double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
                     if(var6 == var1.d) {
                        var9 = 1.0D;
                     }

                     Iterator var11 = var2.iterator();

                     while(var11.hasNext()) {
                        MobEffect var12 = (MobEffect)var11.next();
                        int var13 = var12.getEffectId();
                        if(MobEffectList.a[var13].b()) {
                           MobEffectList.a[var13].a(this, this.n(), var6, var12.getAmplifier(), var9);
                        } else {
                           int var14 = (int)(var9 * (double)var12.getDuration() + 0.5D);
                           if(var14 > 20) {
                              var6.c(new MobEffect(var13, var14, var12.getAmplifier()));
                           }
                        }
                     }
                  }
               }
            }
         }

         this.o.triggerEffect(2002, new Location(this), this.o());
         this.J();
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("Potion", 10)) {
         this.c = ItemStack.a(var1.getCompound("Potion"));
      } else {
         this.a(var1.getInt("potionValue"));
      }

      if(this.c == null) {
         this.J();
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.c != null) {
         var1.set("Potion", (NBTBase)this.c.b(new NBTTagCompound()));
      }

   }
}
