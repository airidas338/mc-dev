package net.minecraft.server;
import java.io.IOException;


public class EntityPig extends EntityAnimal {

   private final yu bk;


   public EntityPig(World var1) {
      super(var1);
      this.a(0.9F, 0.9F);
      ((aay)this.getNavigation()).save(true);
      this.goalSelector.a(0, new yy(this));
      this.goalSelector.a(1, new zu(this, 1.25D));
      this.goalSelector.a(2, this.bk = new yu(this, 0.3F));
      this.goalSelector.a(3, new yt(this, 1.0D));
      this.goalSelector.a(4, new aag(this, 1.2D, Items.bY, false));
      this.goalSelector.a(4, new aag(this, 1.2D, Items.bR, false));
      this.goalSelector.a(5, new za(this, 1.1D));
      this.goalSelector.a(6, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(7, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(10.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
   }

   public boolean bV() {
      ItemStack var1 = ((EntityHuman)this.l).bz();
      return var1 != null && var1.getItem() == Items.bY;
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setBoolean("Saddle", this.cj());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.l(var1.getBoolean("Saddle"));
   }

   protected String z() {
      return "mob.pig.say";
   }

   protected String bn() {
      return "mob.pig.say";
   }

   protected String bo() {
      return "mob.pig.death";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.pig.step", 0.15F, 1.0F);
   }

   public boolean a(EntityHuman var1) {
      if(super.a(var1)) {
         return true;
      } else if(this.cj() && !this.o.isStatic && (this.l == null || this.l == var1)) {
         var1.a((Entity)this);
         return true;
      } else {
         return false;
      }
   }

   protected Item A() {
      return this.au()?Items.am:Items.al;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(this.au()) {
            this.a(Items.am, 1);
         } else {
            this.a(Items.al, 1);
         }
      }

      if(this.cj()) {
         this.a(Items.aA, 1);
      }

   }

   public boolean cj() {
      return (this.ac.a(16) & 1) != 0;
   }

   public void l(boolean var1) {
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)1));
      } else {
         this.ac.b(16, Byte.valueOf((byte)0));
      }

   }

   public void a(EntityLightning var1) {
      if(!this.o.isStatic) {
         EntityPigZombie var2 = new EntityPigZombie(this.o);
         var2.c(0, new ItemStack(Items.GOLD_SWORD));
         var2.setPositionRotation(this.s, this.t, this.u, this.y, this.z);
         this.o.addEntity((Entity)var2);
         this.J();
      }
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      if(var1 > 5.0F && this.l instanceof EntityHuman) {
         ((EntityHuman)this.l).b((Statistic)AchievementList.u);
      }

   }

   public EntityPig b(EntityAgeable var1) {
      return new EntityPig(this.o);
   }

   public boolean d(ItemStack var1) {
      return var1 != null && var1.getItem() == Items.bR;
   }

   public yu ck() {
      return this.bk;
   }

   // $FF: synthetic method
   public EntityAgeable a(EntityAgeable var1) {
      return this.b(var1);
   }
}
