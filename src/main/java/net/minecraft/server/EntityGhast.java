package net.minecraft.server;
import java.io.IOException;


public class EntityGhast extends EntityFlying implements IMonster {

   private int a = 1;


   public EntityGhast(World var1) {
      super(var1);
      this.a(4.0F, 4.0F);
      this.ab = true;
      this.b_ = 5;
      this.f = new afc(this);
      this.i.a(5, new afe(this));
      this.i.a(7, new afb(this));
      this.i.a(7, new afd(this));
      this.bg.a(1, new aao(this));
   }

   public void a(boolean var1) {
      this.ac.b(16, Byte.valueOf((byte)(var1?1:0)));
   }

   public int cd() {
      return this.a;
   }

   public void s_() throws IOException {
      super.s_();
      if(!this.o.D && this.o.aa() == EnumDifficulty.PEACEFUL) {
         this.J();
      }

   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if("fireball".equals(var1.p()) && var1.getEntity() instanceof EntityHuman) {
         super.a(var1, 1000.0F);
         ((EntityHuman)var1.getEntity()).b((tq)tl.z);
         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(10.0D);
      this.getAttributeInstance(GenericAttributes.b).a(100.0D);
   }

   protected String z() {
      return "mob.ghast.moan";
   }

   protected String bn() {
      return "mob.ghast.scream";
   }

   protected String bo() {
      return "mob.ghast.death";
   }

   protected Item A() {
      return Items.H;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(2) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.bw, 1);
      }

      var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.H, 1);
      }

   }

   protected float bA() {
      return 10.0F;
   }

   public boolean bQ() {
      return this.V.nextInt(20) == 0 && super.bQ() && this.o.aa() != EnumDifficulty.PEACEFUL;
   }

   public int bU() {
      return 1;
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.a("ExplosionPower", this.a);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.b("ExplosionPower", 99)) {
         this.a = var1.f("ExplosionPower");
      }

   }

   public float aR() {
      return 2.6F;
   }
}
