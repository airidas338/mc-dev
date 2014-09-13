package net.minecraft.server;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class EntityWitch extends EntityMonster implements IRangedEntity {

   private static final UUID b = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   private static final AttributeModifier c = (new AttributeModifier(b, "Drinking speed penalty", -0.25D, 0)).a(false);
   private static final Item[] bk = new Item[]{Items.aT, Items.aY, Items.aC, Items.bB, Items.bA, Items.H, Items.y, Items.y};
   private int bl;


   public EntityWitch(World var1) {
      super(var1);
      this.a(0.6F, 1.95F);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(2, new PathfinderGoalArrowAttack(this, 1.0D, 60, 10.0F));
      this.goalSelector.a(2, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(2, this.a);
      this.goalSelector.a(3, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
      this.targetSelector.a(2, new aaq(this, EntityHuman.class, true));
   }

   protected void h() {
      super.h();
      this.H().a(21, Byte.valueOf((byte)0));
   }

   protected String z() {
      return null;
   }

   protected String bn() {
      return null;
   }

   protected String bo() {
      return null;
   }

   public void a(boolean var1) {
      this.H().b(21, Byte.valueOf((byte)(var1?1:0)));
   }

   public boolean n() {
      return this.H().a(21) == 1;
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(26.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
   }

   public void m() throws IOException {
      if(!this.o.D) {
         if(this.n()) {
            if(this.bl-- <= 0) {
               this.a(false);
               ItemStack var1 = this.bz();
               this.c(0, (ItemStack)null);
               if(var1 != null && var1.b() == Items.bz) {
                  List var2 = Items.bz.h(var1);
                  if(var2 != null) {
                     Iterator var3 = var2.iterator();

                     while(var3.hasNext()) {
                        MobEffect var4 = (MobEffect)var3.next();
                        this.c(new MobEffect(var4));
                     }
                  }
               }

               this.getAttributeInstance(GenericAttributes.d).c(c);
            }
         } else {
            short var5 = -1;
            if(this.V.nextFloat() < 0.15F && this.a(Material.WATER) && !this.a(MobEffectList.o)) {
               var5 = 8237;
            } else if(this.V.nextFloat() < 0.15F && this.au() && !this.a(MobEffectList.n)) {
               var5 = 16307;
            } else if(this.V.nextFloat() < 0.05F && this.bm() < this.bt()) {
               var5 = 16341;
            } else if(this.V.nextFloat() < 0.25F && this.u() != null && !this.a(MobEffectList.c) && this.u().h(this) > 121.0D) {
               var5 = 16274;
            } else if(this.V.nextFloat() < 0.25F && this.u() != null && !this.a(MobEffectList.c) && this.u().h(this) > 121.0D) {
               var5 = 16274;
            }

            if(var5 > -1) {
               this.c(0, new ItemStack(Items.bz, 1, var5));
               this.bl = this.bz().l();
               this.a(true);
               AttributeInstance var6 = this.getAttributeInstance(GenericAttributes.d);
               var6.c(c);
               var6.b(c);
            }
         }

         if(this.V.nextFloat() < 7.5E-4F) {
            this.o.a((Entity)this, (byte)15);
         }
      }

      super.m();
   }

   protected float c(DamageSource var1, float var2) {
      var2 = super.c(var1, var2);
      if(var1.getEntity() == this) {
         var2 = 0.0F;
      }

      if(var1.s()) {
         var2 = (float)((double)var2 * 0.15D);
      }

      return var2;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = this.V.nextInt(3);
         Item var6 = bk[this.V.nextInt(bk.length)];
         if(var2 > 0) {
            var5 += this.V.nextInt(var2 + 1);
         }

         for(int var7 = 0; var7 < var5; ++var7) {
            this.a(var6, 1);
         }
      }

   }

   public void a(EntityLiving var1, float var2) {
      if(!this.n()) {
         EntityPotion var3 = new EntityPotion(this.o, this, 32732);
         double var4 = var1.t + (double)var1.aR() - 1.100000023841858D;
         var3.z -= -20.0F;
         double var6 = var1.s + var1.v - this.s;
         double var8 = var4 - this.t;
         double var10 = var1.u + var1.x - this.u;
         float var12 = MathHelper.sqrt(var6 * var6 + var10 * var10);
         if(var12 >= 8.0F && !var1.a(MobEffectList.d)) {
            var3.a(32698);
         } else if(var1.bm() >= 8.0F && !var1.a(MobEffectList.u)) {
            var3.a(32660);
         } else if(var12 <= 3.0F && !var1.a(MobEffectList.t) && this.V.nextFloat() < 0.25F) {
            var3.a(32696);
         }

         var3.shoot(var6, var8 + (double)(var12 * 0.2F), var10, 0.75F, 8.0F);
         this.o.d((Entity)var3);
      }
   }

   public float aR() {
      return 1.62F;
   }

}
